import type { R } from '@/type/response';
import authService from '@/service/auth';
import type { User } from 'oidc-client-ts';

export async function request<T>(url: string, options: RequestInit = {}): Promise<R<T>> {
	const user: User | null = await authService.userManager.getUser();
	if (!user || !user.access_token) {
		throw new Error('No valid access token found');
	}
	const headers = new Headers(options.headers || {});
	headers.set('Authorization', `Bearer ${user.access_token}`);
	if (!headers.has('Content-Type') && !(options.body instanceof FormData)) {
		headers.set('Content-Type', 'application/json');
	}
	const requestOptions: RequestInit = {
		...options,
		headers: headers,
	};

	const response = await fetch(url, requestOptions);
	if (!response.ok) {
		throw new Error(`HTTP error! Status: ${response.status}`);
	}
	const result = await response.json();
	return result as R<T>;
}
