package fr.mc2d.authapi.utils;

import fr.mc2d.authapi.AuthLib;
import fr.mc2d.authapi.properties.PropertyMap;
import org.json.simple.JSONObject;

public class AuthProfile {

    private final String username;
    private final String id;
    private final PropertyMap properties = new PropertyMap();
    private final boolean demoEnabled;

    public AuthProfile(String username, String id, boolean demoEnabled) {
        this.username = username;
        this.id = id;
        this.demoEnabled = demoEnabled;
    }

    public PropertyMap getProperties() {
        return this.properties;
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

    public boolean isComplete() {
        JSONObject obj = AuthLib.getDataFromUUID(this.id);
        return !obj.containsKey("error") && username != null && !username.isEmpty();
    }
}
