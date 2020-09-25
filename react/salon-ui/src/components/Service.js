import React, { Component } from 'react';
import { Button, Card } from 'react-bootstrap';


export class Service extends Component {
    constructor(props) {
        super(props)
        this.state = {
            'service': this.props.service
        }
    }
    render() {
        return (
        <Card className="text-center">
            <Card.Header>{this.state.service.name}</Card.Header>
            <Card.Body>
                <Card.Title className="font-weight-bold">${this.state.service.price}</Card.Title>
                <Card.Subtitle>{this.state.service.description}</Card.Subtitle>
                <Card.Text>{this.state.service.time_in_minutes} minutes</Card.Text>
                <Button variant="primary" href={"/chooseslot/" + this.state.service.id + "/" + this.state.service.name}>Book now</Button>
            </Card.Body>
        
        </Card>
            );
    }
}

export default Service;