import { createRouter, createWebHistory } from 'vue-router';
import LoginPage from '../components/LoginPage.vue';
import OAuth2RedirectHandler from '../components/OAuth2RedirectHandler.vue';
import ProtectedPage from '../components/ProtectedPage.vue';

const routes = [
    { path: '/', component: LoginPage },
    { path: '/oauth2/redirect', component: OAuth2RedirectHandler },
    { path: '/protected', component: ProtectedPage },
];

const router = createRouter({
    history: createWebHistory(),
    routes,
});

export default router;
