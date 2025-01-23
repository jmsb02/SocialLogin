import { createRouter, createWebHistory } from 'vue-router';
// import LoginPage from '../components/LoginPage.vue';

const routes = [
    // { path: '/login', component: LoginPage },
    { path: '/', redirect: '/login'}
];

const router = createRouter({
    history: createWebHistory(),
    routes,
});

export default router;
