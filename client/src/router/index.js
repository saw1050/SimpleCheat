import { createRouter, createWebHistory } from 'vue-router'
import ComponentLogin from '../components/login.vue';
import ComponentRegister from '../components/register.vue';
import ComponentCheat from '../components/cheat.vue';
import ComponentNotFound from '../components/notfound.vue';
import test from '../components/test.vue';

const routes = [
    { path: "/", redirect: "/login" },
    { path: "/login", component: ComponentLogin },
    { path: "/register", component: ComponentRegister },
    { path: "/cheat", component: ComponentCheat, meta: { limit: true } },
    { path: "/:catchAll(.*)", component: ComponentNotFound },
    { path: "/test", component: test }
]

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes
})

export default router