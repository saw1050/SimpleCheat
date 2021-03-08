import axios from 'axios';

/**
 * 
 * @param {String} url 
 * @param {Object} params 
 */
export function get(url, params) {
    return new Promise((resolve, reject) => {
        axios.get(url, params).then(succeedData => {
                resolve(succeedData);
            },
            failedData => {
                reject(failedData);
            });
    });
}

export function post(url, params) {
    return new Promise((resolve, reject) => {
        axios.post(url, params).then(succeedData => {
                resolve(succeedData);
            },
            failedData => {
                reject(failedData);
            });
    });
}