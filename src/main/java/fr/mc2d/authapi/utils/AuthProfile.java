package fr.mc2d.authapi.utils;

public class AuthProfile {

    private final String username;
    private final String id;
    private final boolean demoEnabled;

    public AuthProfile(String username, String id, boolean demoEnabled) {
        this.username = username;
        this.id = id;
        this.demoEnabled = demoEnabled;
    }

    public String getUsername() {
        return this.username;
    }

    public String getId() {
        return this.id;
    }

    public boolean isDemoEnabled() {
        return this.demoEnabled;
    }
}
