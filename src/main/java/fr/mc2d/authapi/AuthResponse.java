package fr.mc2d.authapi;

import fr.mc2d.authapi.utils.AuthProfile;

public class AuthResponse {

    private final AuthProfile selectedProfile;
    private final String accessToken;
    private final String clientToken;

    public AuthResponse(AuthProfile authProfile, String accessToken, String clientToken) {
        this.selectedProfile = authProfile;
        this.accessToken = accessToken;
        this.clientToken = clientToken;
    }

    public AuthProfile getSelectedProfile() {
        return this.selectedProfile;
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public String getClientToken() {
        return this.clientToken;
    }
}
