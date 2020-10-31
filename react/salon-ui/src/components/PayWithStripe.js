import React, { Component } from 'react';
import { Button, Form } from 'react-bootstrap';

import {CardElement, Elements} from '@stripe/react-stripe-js';

import STRIPE from '../common/stripe'

class PayWithStripe extends Component {
    constructor(props) {
        super(props);
        this.handleSubmit = this.handleSubmit.bind(this);
    }



    handleSubmit(event) {
        console.log(event);
    }

    render() {
        return (
            <Elements stripe={STRIPE}>
                <h2>Enter Card Details</h2>
                <Form onSubmit={this.handleSubmit}>
                    <CardElement></CardElement>
                    <Button type="submit">Confirm Order</Button>
                </Form>
            </Elements>

        )
    }
}

export default PayWithStripe;