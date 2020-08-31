import fetch from 'cross-fetch'

import API_URL from '../common/configuration'

export function fetchServices() {
    return fetch(API_URL + '/api/services/retrieveAvailableSalonServices')
}