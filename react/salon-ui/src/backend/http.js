import fetch from 'cross-fetch';

import {API_URL} from '../common/configuration';

export function fetchServices() {
    return fetch(API_URL + '/api/services/retrieveAvailableSalonServices')
}

export function fetchSlots(serviceId, slotDate) {
    return fetch(API_URL + '/api/services/retrieveAvailableSlots/' + serviceId + '/' + slotDate);
}

export function initiatePayment(slotId, serviceId, firstname, lastName, phone, email) {
    return fetch(API_URL + '/api/services/api/payments/initiate', 
        { 
            method: "post",
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(
                {
                    'email' : email,
                    'firstName' : firstname,
                    'lastName' : lastName,
                    'phoneNumber': phone,
                    'selectedSalonServiceDetailId': serviceId,
                    'slotId' : slotId
                }
            )
        }
    )
}