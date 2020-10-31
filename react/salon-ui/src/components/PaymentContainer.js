import React, { Component } from 'react';

import GetBillingDetails from './GetBillingDetails';
import PayWithStripe from './PayWithStripe';

class PaymentContainer extends Component {
    constructor(props) {
        super(props);
    }
    
    render() {
        return (

            <div>
                <GetBillingDetails serviceId={this.props.match.params.serviceId} slotId={this.props.match.params.slotId}/>
                <PayWithStripe></PayWithStripe>
            </div>
        )
    }
}

export default PaymentContainer;