import React, { Component } from 'react';

import GetBillingDetails from './GetBillingDetails';

class PaymentContainer extends Component {
    constructor(props) {
        super(props);
    }
    
    render() {
        return (
            <GetBillingDetails serviceId={this.props.match.params.serviceId} slotId={this.props.match.params.slotId}/>
        )
    }
}

export default PaymentContainer;