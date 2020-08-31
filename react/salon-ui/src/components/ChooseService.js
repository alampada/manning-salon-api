import React, { Component } from 'react';
import { CardColumns } from 'react-bootstrap';

import Service from './Service';
import * as API from '../backend/http'
import loadingIndicator from '../components/loader/loading-indicator'
import appNotification from '../components/app-notification/app-notification'

class ChooseService extends Component {

    constructor(props) {
        super(props);

        this.state = {
            "services": []
        };
    }

    componentDidMount() {
        this.downloadServices()
    }

    downloadServices() {
        loadingIndicator.show()

        API.fetchServices()
        .then(res => res.json()).then(results => this.onReceiveData(results))
        .catch(errorObject => this.onError(errorObject));
    }

    onReceiveData(services) {
        loadingIndicator.hide();

        this.setState({services: services});
    }

    onError(error) {
        loadingIndicator.hide();
        appNotification.showError("unable to retrieve spa services " + error)
    }
    
    render() {
        return (
            <CardColumns>{this.state.services.map(service => <Service key={service.id} service={service}/>)}</CardColumns>
    )}
}

export default ChooseService;