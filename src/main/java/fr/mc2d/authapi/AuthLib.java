package fr.mc2d.authapi;

import fr.mc2d.authapi.utils.HttpUtil;
import fr.mc2d.authapi.utils.Util;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.util.UUID;

public class AuthLib {

    public static JSONObject getDataInAuthentication(String authURL, String email, String password) {
        String jsonData = HttpUtil.sendPostRequest(Authenticator.MC2D_AUTH_URL, Util.makeArgGroup("email", email), Util.makeArgGroup("password", password));
        JSONObject object;

        try {
            object = (JSONObject) new JSONParser().parse(jsonData);
        } catch (Exception e) {
            object = new JSONObject();
            object.put("error", e.getMessage());
        }

        return object;
    }

    public static JSONObject getDataInAuthentication(String authURL, String clientToken) {
        String jsonData = HttpUtil.sendPostRequest(authURL, Util.makeArgGroup("clientToken", clientToken));
        JSONObject object;

        try {
            object = (JSONObject) new JSONParser().parse(jsonData);
        } catch (Exception e) {
            object = new JSONObject();
            object.put("error", e.getMessage());
        }

        return object;
    }

    public static JSONObject getDataFromUsername(String username) {
        String jsonData = HttpUtil.sendPostRequest(Authenticator.MC2D_AUTH_URL, Util.makeArgGroup("username", username));
        JSONObject object;

        try {
            object = (JSONObject) new JSONParser().parse(jsonData);
        } catch (Exception e) {
            object = new JSONObject();
            object.put("error", e.getMessage());
        }

        return object;
    }

    public static JSONObject getDataFromUUID(UUID uuid) {
        String jsonData = HttpUtil.sendPostRequest(Authenticator.MC2D_AUTH_URL, Util.makeArgGroup("uuid", uuid.toString()));
        JSONObject object;

        try {
            object = (JSONObject) new JSONParser().parse(jsonData);
        } catch (Exception e) {
            object = new JSONObject();
            object.put("error", e.getMessage());
        }

        return object;
    }

    public static JSONObject getDataFromUUID(String uuid) {
        return AuthLib.getDataFromUUID(UUID.fromString(uuid));
    }

    @Deprecated
    public static JSONObject getDataFromAccessToken(String token) {
        String jsonData = HttpUtil.sendPostRequest(Authenticator.MC2D_AUTH_URL, Util.makeArgGroup("accessToken", token));
        JSONObject object;

        try {
            object = (JSONObject) new JSONParser().parse(jsonData);
        } catch (Exception e) {
            object = new JSONObject();
            object.put("error", e.getMessage());
        }

        return object;
    }
}
