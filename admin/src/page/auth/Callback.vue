<template>
	<div class="DhFl7ydTf">
		<span>正在登录...</span>
	</div>
</template>
<script setup lang="ts">
	import { onMounted } from 'vue';
	import authservice from '@/service/auth';
	import { useRouter } from 'vue-router';
	const router = useRouter();
	onMounted(async () => {
		await authservice.userManager.signinCallback();
		router.push({
			name: 'TEST',
		});
	});
</script>
<style lang="css" scoped>
	.DhFl7ydTf {
		display: flex;
		justify-content: center;
		align-items: center;
		min-height: 90vh;
	}
</style>
