package fr.mc2d.authapi;

public class AuthResponse {

    private String username;
    private String uuid;
    private String accessToken;
    private boolean demoEnabled;

    public AuthResponse(String username, String uuid, String accessToken, boolean demoEnabled) {
        this.username = username;
        this.uuid = uuid;
        this.accessToken = accessToken;
        this.demoEnabled = demoEnabled;
    }

    public String getUsername() {
        return username;
    }

    public String getUUID() {
        return uuid;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public boolean isDemoEnabled() {
        return demoEnabled;
    }
}
