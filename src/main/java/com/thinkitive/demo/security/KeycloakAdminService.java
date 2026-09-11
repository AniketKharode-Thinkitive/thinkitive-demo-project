package com.thinkitive.demo.security;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import tools.jackson.databind.JsonNode;

@Service
public class KeycloakAdminService {

	@Value("${keycloak.admin.server-url}")
	private String serverUrl;

	@Value("${keycloak.admin.realm}")
	private String realm;

	@Value("${keycloak.admin.client-id}")
	private String clientId;

	@Value("${keycloak.admin.client-secret}")
	private String clientSecret;

	private final RestClient restClient = RestClient.create();

	public String getAdminAccessToken() {

		String tokenUrl = serverUrl + "/realms/" + realm + "/protocol/openid-connect/token";

		String body = "client_id=" + clientId + "&client_secret=" + clientSecret + "&grant_type=client_credentials";

		JsonNode response = restClient.post().uri(tokenUrl).contentType(MediaType.APPLICATION_FORM_URLENCODED)
				.body(body).retrieve().body(JsonNode.class);

		return response.get("access_token").asText();
	}


	public String createUser(String username, String password, String firstName, String lastName, String email) {

		String token = getAdminAccessToken();

		String url = serverUrl + "/admin/realms/" + realm + "/users";

		KeyCloakUserRequest request = new KeyCloakUserRequest();

		request.setUsername(username);
		request.setEnabled(true);
		request.setFirstName(firstName);
		request.setLastName(lastName);
		request.setEmail(email);
		request.setEmailVerified(false);

		Credential credential = new Credential("password", password, false);

		request.setCredentials(Collections.singletonList(credential));

		ResponseEntity<Void> response = restClient.post().uri(url).header(HttpHeaders.AUTHORIZATION, "Bearer " + token)
				.contentType(MediaType.APPLICATION_JSON).body(request).retrieve().toBodilessEntity();

		String location = response.getHeaders().getFirst(HttpHeaders.LOCATION);

		return location.substring(location.lastIndexOf("/") + 1);
	}

	public void assignRealmRole(String userId, String roleName) {

		String token = getAdminAccessToken();

		System.out.println("Assigning role: " + roleName);

		System.out.println("User ID: " + userId);

		String roleUrl = serverUrl + "/admin/realms/" + realm + "/roles/" + roleName;

		System.out.println("Role URL: " + roleUrl);

		JsonNode role = restClient.get().uri(roleUrl).header(HttpHeaders.AUTHORIZATION, "Bearer " + token).retrieve()
				.body(JsonNode.class);

		System.out.println("Role response: " + role);

		String mappingUrl = serverUrl + "/admin/realms/" + realm + "/users/" + userId + "/role-mappings/realm";

		System.out.println("Mapping URL: " + mappingUrl);

		restClient.post().uri(mappingUrl).header(HttpHeaders.AUTHORIZATION, "Bearer " + token)
				.contentType(MediaType.APPLICATION_JSON).body(Collections.singletonList(role)).retrieve()
				.toBodilessEntity();

		System.out.println("Role assigned successfully");
	}
}