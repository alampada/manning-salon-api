import {loadStripe} from '@stripe/stripe-js';

import {STRIPE_KEY} from './configuration'

export const STRIPE = loadStripe(STRIPE_KEY);

export default STRIPE;