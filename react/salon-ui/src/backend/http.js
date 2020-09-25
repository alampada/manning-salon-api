import fetch from 'cross-fetch'

import API_URL from '../common/configuration'

export function fetchServices() {
    return fetch(API_URL + '/api/services/retrieveAvailableSalonServices')
}

export function fetchSlots(serviceId, slotDate) {
    return fetch(API_URL + '/api/services/retrieveAvailableSlots/' + serviceId + '/' + slotDate);
}