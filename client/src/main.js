import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import {get } from './access/http';
import Element from 'element-plus';
import Urls from './access/urls';
import { getCookie } from './utils/cookier';
import 'element-plus/lib/theme-chalk/index.css';
import './assets/selfstyle.css'

router.beforeEach((to, from, next) => {
    if (to.meta.limit == true) {
        let token = getCookie("token");
        if (token != null)
            get(Urls.CHECK_TOKEN_PREFIX + `${token}`)
            .then(
                succeedResponse => { // response: boolean
                    if (succeedResponse.data == true) {
                        store.state.token = token;
                        next();
                    } else {
                        next({ path: "/login" });
                    }
                },
                () => {
                    next({ path: "/login" });
                }
            );
        else
            next({ path: "/login" });

    } else {
        next();
    }
});

createApp(App)
    .use(Element)
    .use(store)
    .use(router)
    .mount('#app')