package fr.mc2d.authapi;

import org.json.simple.JSONObject;

import java.util.UUID;

public class Authenticator {

    public static final String MC2D_AUTH_URL = "https://kyosu.fr/mc2d/auth/auth.php";

    private String authURL;

    public Authenticator(String authURL) {
        this.authURL = authURL;
    }

    public AuthResponse authenticate(String email, String password) throws AuthenticationException {
        JSONObject object = AuthLib.getDataInAuthentication(email, password);

        if (object.containsKey("error")) throw new AuthenticationException((String) object.get("error"));
        else return new AuthResponse((String) object.get("username"), (String) object.get("uuid"), (String) object.get("accessToken"), Integer.parseInt((String) object.get("demo")) != 0);
    }

    @Deprecated
    public AuthResponse authenticate(String username) throws AuthenticationException {
        JSONObject object = AuthLib.getDataFromUsername(username);

        if (object.containsKey("error")) return new AuthResponse(username, UUID.randomUUID().toString(), "0", true);
        else throw new AuthenticationException("In offline mode, you must choose an unused username");
    }
}
