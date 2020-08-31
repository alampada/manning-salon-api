import React from 'react';
import './App.css';
import { Alert, Container } from 'react-bootstrap';

import ServicesBox from './components/ServicesBox'
import messageService from './service/MessageService'
import * as API from './backend/http'

import 'bootstrap/dist/css/bootstrap.min.css';

class App extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      message: ""
    };
  }

  componentDidMount() {
    this.subscription = messageService.getMessage().subscribe(message => {
      this.setState({message: message});
    })
    this.fetchServices();
  }

  componentWillUnmount() {
    this.subscription.unsubscribe();
  }

  fetchServices() {
    API.fetchServices()
    .then(res => res.json().then(services => this.setState(() => ({services: services}))));
  }

  render() {
    const message = this.state.message
    let toast;
    if (message) {
      toast = <Alert variant="primary">foo</Alert>
    }
    return (
      <div className="App">
        <nav className="navbar navbar-light bg-dark navbar-expand-md">
          <a className="navbar-brand text-light" href="/">AR Salon and Day Spa Services</a>
        </nav>
        {toast}
        <Container fluid="lg">
          {this.state.services && (<ServicesBox services={this.state.services}/>)}
        </Container>
        
      </div>
    );
  }
}

export default App;
