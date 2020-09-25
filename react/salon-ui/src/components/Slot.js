import React, { Component } from 'react';
import { Button, Card } from 'react-bootstrap';

import * as DateUtil from '../common/dates'

export class Slot extends Component {
    
    render() {
        return (
            <Card className="text-center">
                <Card.Header>{this.props.serviceName}</Card.Header>
                <Card.Body>
                    <Card.Title className="font-weight-bold">{this.props.slot.stylistName}</Card.Title>
                    <Card.Text>Slot Time {DateUtil.showHours(this.props.slot.slotFor)}</Card.Text>
                    <Button variant="primary">Book this slot</Button>
                </Card.Body>
            </Card>
        )
    }
}

export default Slot;