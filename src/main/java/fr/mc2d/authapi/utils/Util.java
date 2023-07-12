package fr.mc2d.authapi.utils;

import fr.mc2d.authapi.Authenticator;

import java.io.IOException;

public class Util {

    public static String makeArgGroup(String arg, String val) {
        return arg + "=" + val;
    }

    public static void main(String[] args) {
        System.out.println(HttpUtil.sendPostRequest(Authenticator.MC2D_AUTH_URL, makeArgGroup("username", "_JaaJ_ZunF1x")));
    }
}
