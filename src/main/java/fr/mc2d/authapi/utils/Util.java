package fr.mc2d.authapi.utils;

import fr.mc2d.authapi.AuthResponse;
import fr.mc2d.authapi.AuthenticationException;
import fr.mc2d.authapi.Authenticator;

import java.io.IOException;

public class Util {

    public static String makeArgGroup(String arg, String val) {
        return arg + "=" + val;
    }

    public static boolean isEmptyString(String string) {
        return string == null || string.length() == 0;
    }
}
