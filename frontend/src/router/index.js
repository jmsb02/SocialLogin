import { createRouter, createWebHistory } from 'vue-router';

const routes = [
    { path: '/', redirect: '/login'}
];

const router = createRouter({
    history: createWebHistory(),
    routes,
});

export default router;
