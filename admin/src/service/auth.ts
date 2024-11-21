import { User, UserManager, type OidcClientSettings } from 'oidc-client-ts';
export class AuthService {
	userManager: UserManager;
	constructor() {
		const setting: OidcClientSettings = {
			authority: import.meta.env.VITE_AUTHORITY_URL,
			client_id: import.meta.env.VITE_CLIENT_ID,
			redirect_uri: import.meta.env.VITE_REDIRECT_URI,
			response_type: import.meta.env.VITE_RESPONSE_TYPE,
			scope: import.meta.env.VITE_SCOPE,
			post_logout_redirect_uri: import.meta.env.VITE_LOGOUT_REDIRECT_URI,
		};
		this.userManager = new UserManager(setting);
	}
	async getUser(): Promise<User | null> {
		return this.userManager.getUser();
	}

	async login(): Promise<void> {
		return this.userManager.signinRedirect();
	}

	async renewToken(): Promise<User | null> {
		return this.userManager.signinSilent();
	}

	async logout(): Promise<void> {
		return this.userManager.signoutRedirect();
	}
}
export default new AuthService();
