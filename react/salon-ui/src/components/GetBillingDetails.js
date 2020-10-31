import React, { Component } from 'react';
import { Button, Form } from 'react-bootstrap';

import * as API from '../backend/http'



class GetBillingDetails extends Component {
    constructor(props) {
        super(props);
        this.state = {}
        this.handleSubmit = this.handleSubmit.bind(this);
        this.handleUpdate = this.handleUpdate.bind(this);
        console.log(this.props);
    }

    handleSubmit(event) {
        event.preventDefault();
        console.log(event);
        console.log(this.state);
        API.initiatePayment(
            this.props.slotId,
            this.props.serviceId,
            this.state.formFirstName,
            this.state.formLastName,
            this.state.formPhone,
            this.state.formEmail
        )
        
    }

    handleUpdate(event) {
        this.setState({[event.target.id] : event.target.value });
        console.log(this.state);
    }

    render() {
        return (
            <div>
                <h2>Enter Billing Details</h2>
                <Form onSubmit={this.handleSubmit}>
                    <Form.Group controlId="formFirstName">
                        <Form.Label>First Name</Form.Label>
                        <Form.Control value={this.state.firstName} onChange={this.handleUpdate}></Form.Control>
                    </Form.Group>
                    <Form.Group controlId="formLastName">
                        <Form.Label>Last Name</Form.Label>
                        <Form.Control value={this.state.lastName} onChange={this.handleUpdate}></Form.Control>
                    </Form.Group>
                    <Form.Group controlId="formEmail">
                        <Form.Label>Email</Form.Label>
                        <Form.Control value={this.state.email} onChange={this.handleUpdate} type="email"></Form.Control>
                    </Form.Group>
                    <Form.Group controlId="formPhone">
                        <Form.Label>Phone</Form.Label>
                        <Form.Control value={this.state.phone} onChange={this.handleUpdate}></Form.Control>
                    </Form.Group>
                    <Button type="submit">Make Payment</Button>
                </Form>

            </div>
        )
    }
}

export default GetBillingDetails;