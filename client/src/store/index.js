import { createStore } from 'vuex'

export default createStore({
    state: {
        loginResult: "", // 登录结果, 成功 | 账户名错误 | 密码错误 ...
        information: { username: '', snap: '', name: '' }, // 个人信息
        token: "",
        currentSession: { username: '', alias: '', snap: '', name: '' },
        friends: [], // friend: { username, alias, snap, name }
        messages: [], // message:{ src, dst, message }
        inputting: ''
    },
    mutations: {
        setLoginResult(state, value) {
            state.loginResult = value;
        },
        setInformation(state, information) {
            state.information = information;
        },
        setToken(state, token) {
            state.token = token;
        },
        setSession(state, friend) {
            state.currentSession = friend;
        },
        pushToFriends(state, friend) {
            state.friends.push(friend);
        },
        pushMessage(state, dst, src, message) {
            for (let index = 0; index < state.friends.length; index++) {
                const e = state.friends[index];
                if (e.username == dst) {
                    e.messages.push({ src: src, message: message });
                }
            }
        },
        fillInput(state, text) {
            state.inputting = text;
        }
    },
    actions: {}, // 异步方法
    modules: {}, // 模块
})