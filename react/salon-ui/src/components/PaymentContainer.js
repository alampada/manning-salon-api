import React, { Component } from 'react';
import {Elements} from '@stripe/react-stripe-js';

import GetBillingDetails from './GetBillingDetails';
import PayWithStripe from './PayWithStripe';
import ShowConfirmedTicket from './ShowConfirmedTicket';

import STRIPE from '../common/stripe'


class PaymentContainer extends Component {
    constructor(props) {
        super(props);
        this.state = {}
        this.handlePaymentInit = this.handlePaymentInit.bind(this);
        this.handleStripePayment = this.handleStripePayment.bind(this);
    }

    handlePaymentInit(paymentId, secret) {
        this.setState(
            {
                clientSecret: secret,
                paymentId: paymentId
            }
        );
    }

    handleStripePayment(paymentStatus) {
        this.setState(
            {
                paymentStatus: paymentStatus,
            }
        );
    }
    
    render() {
        return (
            <Elements stripe={STRIPE}>
                {!this.state.clientSecret && !this.state.paymentStatus && <GetBillingDetails paymentInitCallback={this.handlePaymentInit} serviceId={this.props.match.params.serviceId} slotId={this.props.match.params.slotId}/>}
                {this.state.clientSecret && !this.state.paymentStatus && <PayWithStripe paymentDoneCallback={this.handleStripePayment} clientSecret={this.state.clientSecret}></PayWithStripe>}
                {this.state.paymentStatus && <ShowConfirmedTicket paymentId={this.state.paymentId}/>}
            </Elements>
        )
    }
}

export default PaymentContainer;