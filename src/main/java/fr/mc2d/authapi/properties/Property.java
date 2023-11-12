package fr.mc2d.authapi.properties;

import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.Base64;

public class Property {

    private final String name;
    private final String value;

    public Property(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }
}
