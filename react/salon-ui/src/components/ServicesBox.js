import React from 'react';
import Service from './Service'
import { CardColumns } from 'react-bootstrap';

export function Services(props) {
    return (
    <CardColumns>{props.services.map(service => <Service key={service.id} service={service}/>)}</CardColumns>
    );
}

export default Services;