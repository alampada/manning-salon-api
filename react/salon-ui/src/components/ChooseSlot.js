import React, { Component } from 'react';
import { Button, Col, Form, Row } from 'react-bootstrap';
import { connectableObservableDescriptor } from 'rxjs/internal/observable/ConnectableObservable';


class ChooseSlot extends Component {
    constructor(props) {
        super(props);
        this.state = {
            slots: []
        }
        
    }

    render() {
        return (
            <Form>
                <Row>
                    <Col>
                        <Form.Label>Choose a Date for {this.props.match.params.serviceName}</Form.Label>
                    </Col>
                    <Col>
                        <Form.Control as="input"></Form.Control>
                    </Col>
                    <Col>
                        <Button type="submit">Show Slots</Button>
                    </Col>
                </Row>
            </Form>
        )
    }
}

export default ChooseSlot;