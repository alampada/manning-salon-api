import React from 'react';
import {
  BrowserRouter as Router,
  Switch,
  Route,
} from "react-router-dom";
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';


import ChooseService from './components/ChooseService'
import ChooseSlot from './components/ChooseSlot'
import AppNotificationComponent from './components/app-notification/app-notification-component'
import LoadingIndicatorComponent from './components/loader/loading-indicator-component';

function App() {
  return (
    <Router>
      <div>
      <LoadingIndicatorComponent></LoadingIndicatorComponent>
      <nav className="navbar navbar-light bg-dark navbar-expand-md">
          <a className="navbar-brand text-light" href="/">AR Salon and Day Spa Services</a>
        </nav>
        <main role="main" className="container">
            <div className="padding-container">
              <Switch>
                <Route path="/chooseslot/:serviceId/:serviceName" component={ChooseSlot}/>
                <Route path="/" component={ChooseService}/>
              </Switch>
            </div>
          </main>
          <AppNotificationComponent></AppNotificationComponent>
      </div>
    </Router>);
}

export default App;
