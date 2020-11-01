import React from 'react';
import { Button, Form } from 'react-bootstrap';

import { useStripe, useElements, CardElement, Elements } from '@stripe/react-stripe-js';


export default function PayWithStripe(props) {
    const stripe = useStripe();
    const elements = useElements();
    console.log(props);
    const secret = props.clientSecret;

    const handleSubmit = async (event) => {
        console.log(event);
        event.preventDefault();

        const result = await stripe.confirmCardPayment(
            secret,
            {
                payment_method: { card: elements.getElement(CardElement) }
            }
        );

        console.log(result);
    };

    return (
        <Form onSubmit={handleSubmit}>
            <label>Card Details</label>
            <CardElement></CardElement>
            <Button type="submit">Confirm Order</Button>
        </Form>

    );
}