package fr.mc2d.authapi;

import fr.mc2d.authapi.utils.AuthProfile;

public class Test {

    public static void main(String[] args) throws AuthenticationException {
        Authenticator authenticator = new Authenticator(Authenticator.MC2D_AUTH_URL);
        AuthResponse res = authenticator.authenticate("MFnj1R3l5NtiBVe63NYREyWg3o440jj6t2KN2eq4aTJ2BYRVqjr0cHc2Ho4xfSih");
        System.out.println(res.getSelectedProfile().isComplete());
    }
}
