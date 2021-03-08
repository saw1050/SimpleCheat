import {get } from './http';
import { GET_FRIEND_LIST_PREFIX, GET_OFFLINE_MESSAGES_PREFIX } from './urls';
import store from '../store';
export function requestFriendList(token) {
    get(GET_FRIEND_LIST_PREFIX + token)
        .then(
            /**
             * response:
             *  {
             *      result: boolean,
             *      friends: [friend...]
             *  }
             * friend:
             *  {
             *      username,
             *      snap,
             *      name,
             *      messages:[ {src, message} ]
             *  }
             */
            response => {
                if (response.data.result == true) {
                    let friends = response.data.friends
                    store.state.friends = friends;
                }
            }
        )
}

export function requestOfflineMessages(token) {
    get(GET_OFFLINE_MESSAGES_PREFIX + token)
        .then(
            response => {
                let username = store.state.information.username;
                let records = JSON.parse(localStorage.getItem(username));
                if (response.data.result == true) {
                    if (records != null && response.data.messages.length != 0) {
                        records.push(response.data.messages);
                    } else if (records == null) {
                        records = response.data.messages;
                    }
                    store.state.messages = records;
                    localStorage.setItem(username, JSON.stringify(records));
                    console.log(store.state.messages);
                }
            }
        )
}