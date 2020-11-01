import React, { Component } from 'react';
import QRCode  from 'qrcode.react';

import * as API from '../backend/http'
import * as DateUtil from '../common/dates'
import { API_URL } from '../common/configuration';


class ShowConfirmedTicket extends Component {
    constructor(props) {
        super(props);
        this.state = {
        }
    }

    componentDidMount() {
        this.downloadTicket();
    }

    downloadTicket() {
        API.confirmPayment(this.props.paymentId)
            .then(res => res.json())
            .then(result => this.onPaymentConfirmed(result))
    }

    onPaymentConfirmed(confirmation) {
        this.setState({ confirmation: confirmation })
    }

    render() {
        if (!this.state.confirmation) {
            return ( <div/> );
        }
        console.log(this.state);
        const salon = this.state.confirmation.salonDetails;
        const ticket = this.state.confirmation.ticket.payment;
        const ticketURL = API_URL + '/api/services/api/tickets/' + ticket.id;
        return (
            <div>
                <h2>Your Ticket Details</h2>
                <h3>Service Details</h3>
                {ticket.selectedService.name} @ {DateUtil.formatDate(ticket.slot.slotFor)} by {ticket.slot.stylistName}
                <h3>Salon Address Details</h3>
            {salon.name}
            {salon.address}
            {salon.city}
            {salon.state}
            {salon.zipcode}
            {salon.phone}

                <h3>Ticket</h3>
                <QRCode value={ticketURL} />

            </div>
        )
    }
}

export default ShowConfirmedTicket;