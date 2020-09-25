import React, { Component } from 'react';
import { Button, CardColumns, Col, Form, Row } from 'react-bootstrap';

import loadingIndicator from '../components/loader/loading-indicator'
import appNotification from '../components/app-notification/app-notification'
import * as API from '../backend/http'
import * as DateUtil from '../common/dates'
import Slot from '../components/Slot'


class ChooseSlot extends Component {
    constructor(props) {
        super(props);
        this.state = {
            slots: []
        }
        this.handleUpdate = this.handleUpdate.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
        
    }

    handleUpdate(event) {
        this.setState({date: event.target.value});
    }

    validateDate(date) {
        return DateUtil.validateDateFormat(date)
    }

    handleSubmit(event) {
        event.preventDefault();
        console.log('Submit');
        console.log(event.target);
        console.log(this.state.date);
        if (!this.validateDate(this.state.date)) {
            appNotification.showError('Invalid date: ' + this.state.date);
            return;
        }
        loadingIndicator.show();
        API.fetchSlots(this.props.match.params.serviceId, this.state.date)
            .then(res => res.json()).then(results => this.onReceiveData(results))
    }


    onReceiveData(slots) {
        loadingIndicator.hide();
        this.setState({slots: slots, slotDate: this.state.date})
    }

    render() {
        const {slots, slotDate} = this.state;
        return (
            <div>
            <Form>
                <Row>
                    <Col>
                        <Form.Label>Choose a Date for {this.props.match.params.serviceName}</Form.Label>
                    </Col>
                    <Col>
                        <Form.Control as="input" value={this.state.date} onChange={this.handleUpdate}></Form.Control>
                    </Col>
                    <Col>
                        <Button type="submit" onClick={this.handleSubmit}>Show Slots</Button>
                    </Col>
                </Row>
            </Form>
           
            {slots.length > 0 && <h3>Available slots on {slotDate}</h3>}

            <CardColumns>{this.state.slots.map(slot => <Slot slot={slot} serviceName={this.props.match.params.serviceName}/>)} </CardColumns>
            
            </div>
        )
    }
}

export default ChooseSlot;