<template>
	<div class="j8c9Y1D7">
		<h1>操作</h1>
		<div class="NIouemuh">
			<ul>
				<li><button type="button" @click="onLogin">登录</button></li>
				<li><button type="button" @click="onFetchData">获取数据</button></li>
				<li><button type="button" @click="onRenewToken">刷新令牌</button></li>
				<li><button type="button" @click="onLogout">登出</button></li>
			</ul>
		</div>
		<h1>用户</h1>
		<div class="N4k1chfOd">
			<pre v-if="currentUser" class="json-display">{{ formattedData }}</pre>
			<span v-else>用户未登录</span>
		</div>
		<h1>数据</h1>
		<div class="N4k1chfOd">
			<pre v-if="data" class="json-display">{{ data }}</pre>
			<span v-else>没有数据</span>
		</div>
	</div>
</template>

<script setup lang="ts">
	import { computed, onMounted, ref } from 'vue';
	import authService from '@/service/auth';
	import type { User } from 'oidc-client-ts';
	import { request } from '@/service/request';

	const message = ref('暂时还没有消息');
	const data = ref();
	const currentUser = ref<User | null>(null);
	const formattedData = computed(() => {
		return JSON.stringify(currentUser.value, null, 2);
	});

	onMounted(async () => {
		try {
			const user = await authService.getUser();
			if (user) {
				message.value = '用户已经登录';
				currentUser.value = user;
			} else {
				message.value = '用户未登录';
			}
		} catch (error) {
			message.value = error instanceof Error ? error.message : (error as string);
		}
	});
	const onLogin = async () => {
		try {
			await authService.login();
			const user = await authService.getUser();
			if (user) {
				currentUser.value = user;
			}
		} catch (error) {
			message.value = error instanceof Error ? error.message : (error as string);
		}
	};
	const onLogout = async () => {
		try {
			await authService.logout();
			currentUser.value = null;
		} catch (error) {
			message.value = error instanceof Error ? error.message : (error as string);
		}
	};
	const onRenewToken = async () => {
		try {
			const user = await authService.renewToken();
			currentUser.value = user;
		} catch (error) {
			message.value = error instanceof Error ? error.message : (error as string);
		}
	};
	const onFetchData = async () => {
		try {
			const response = await request('http://localhost:8080/users/username');
			if (response.code == 0) {
				data.value = response.data;
			} else {
				data.value = response.message;
			}
		} catch (error) {
			console.error(error);
		}
	};
</script>

<style scoped>
	.j8c9Y1D7 {
		display: flex;
		flex-direction: column;
		align-items: center;
	}
	.NIouemuh {
		display: inline-block;
		list-style: none;
		padding: 0;
		margin: 0;
	}
	.NIouemuh li {
		display: inline-block;
		margin-right: 15px;
	}
	.N4k1chfOd {
		max-width: 80%;
	}
	.json-display {
		padding: 10px;
		background-color: #f8f8f8;
		border: 1px solid #ddd;
		border-radius: 4px;
		font-family: monospace;
		white-space: pre-wrap;
		word-wrap: break-word;
	}
</style>
