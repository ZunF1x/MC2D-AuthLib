package fr.mc2d.authapi;

import fr.mc2d.authapi.utils.AuthProfile;
import org.json.simple.JSONObject;

public class Authenticator {

    public static final String MC2D_AUTH_URL = "https://kyosu.fr/mc2d/auth/auth.php";

    private final String authURL;

    public Authenticator(String authURL) {
        this.authURL = authURL;
    }

    public AuthResponse authenticate(String email, String password) throws AuthenticationException {
        JSONObject object = AuthLib.getDataInAuthentication(this.authURL, email, password);

        if (object.containsKey("error")) throw new AuthenticationException((String) object.get("error"));
        else {
            AuthProfile selectedProfile = new AuthProfile((String) object.get("username"), (String) object.get("uuid"), Integer.parseInt((String) object.get("demo")) != 0);

            return new AuthResponse(selectedProfile, (String) object.get("accessToken"), (String) object.get("clientToken"));
        }
    }

    public AuthResponse authenticate(String clientToken) throws AuthenticationException {
        JSONObject object = AuthLib.getDataInAuthentication(this.authURL, clientToken);

        if (object.containsKey("error")) throw new AuthenticationException((String) object.get("error"));
        else {
            AuthProfile selectedProfile = new AuthProfile((String) object.get("username"), (String) object.get("uuid"), false);

            return new AuthResponse(selectedProfile, (String) object.get("accessToken"), (String) object.get("clientToken"));
        }
    }
}
