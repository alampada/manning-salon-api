import React, { Component } from 'react';
import {Elements} from '@stripe/react-stripe-js';

import GetBillingDetails from './GetBillingDetails';
import PayWithStripe from './PayWithStripe';

import STRIPE from '../common/stripe'


class PaymentContainer extends Component {
    constructor(props) {
        super(props);
        this.state = {}
        this.handleClientSecret = this.handleClientSecret.bind(this);
    }

    handleClientSecret(secret) {
        this.setState({clientSecret: secret});
    }
    
    render() {
        return (
            <Elements stripe={STRIPE}>
                {!this.state.clientSecret && <GetBillingDetails secretCallback={this.handleClientSecret} serviceId={this.props.match.params.serviceId} slotId={this.props.match.params.slotId}/>}
                {this.state.clientSecret && <PayWithStripe clientSecret={this.state.clientSecret}></PayWithStripe>}
            </Elements>
        )
    }
}

export default PaymentContainer;