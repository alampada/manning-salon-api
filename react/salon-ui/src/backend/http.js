import fetch from 'cross-fetch'

export function fetchServices() {
    return fetch('http://localhost:8080/api/services/retrieveAvailableSalonServices')
}