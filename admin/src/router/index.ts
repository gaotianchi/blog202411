import { createRouter, createWebHistory } from 'vue-router';

const router = createRouter({
	history: createWebHistory(import.meta.env.BASE_URL),
	routes: [
		{
			name: 'TEST',
			path: '/',
			component: () => import('@/page/Test.vue'),
		},
		{
			name: 'CALLBACK',
			path: '/callback',
			component: () => import('@/page/auth/Callback.vue'),
		},
		{
			name: 'EDITOR',
			path: '/editor/:id',
			component: () => import('@/page/Editor.vue'),
		},
	],
});

export default router;
