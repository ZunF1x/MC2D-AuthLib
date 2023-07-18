package fr.mc2d.authapi.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class HttpUtil {

    public static String sendPostRequest(String link, String... args) {
        String response;

        try {
            URL url = new URL(link);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setDoOutput(true);
            StringBuilder postData = new StringBuilder();
            for (String arg : args) {
                postData.append(arg).append("&");
            }
            byte[] postDataBytes = postData.toString().getBytes(StandardCharsets.UTF_8);
            OutputStream outputStream = connection.getOutputStream();
            Throwable var8 = null;

            try {
                outputStream.write(postDataBytes);
                outputStream.flush();
            } catch (Throwable var22) {
                var8 = var22;

                response = "{" + '"' + "error" + '"' + ":" + '"' + var22.getMessage() + '"' + "}";
            } finally {
                if (outputStream != null) {
                    if (var8 != null) {
                        try {
                            outputStream.close();
                        } catch (Throwable var21) {
                            var8.addSuppressed(var21);
                        }
                    } else {
                        outputStream.close();
                    }
                }
            }

            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder resp = new StringBuilder();

                String line;
                while ((line = reader.readLine()) != null) {
                    resp.append(line);
                }

                reader.close();

                response = resp.toString();
            } else {
                response = "{" + '"' + "error" + '"' + ":" + '"' + "HTTP Error : " + responseCode + '"' + "}";
            }
        } catch (Exception e) {
            response = "{" + '"' + "error" + '"' + ":" + '"' + e.getMessage() + '"' + "}";
        }

        return response;
    }

    public static String sendGetRequest(String link, String... args) {
        String response;

        try {
            StringBuilder getData = new StringBuilder();
            getData.append("?");
            for (String arg : args) {
                getData.append(arg).append("&");
            }
            URL url = new URL(link + getData);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setDoOutput(true);

            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder resp = new StringBuilder();

                String line;
                while ((line = reader.readLine()) != null) {
                    resp.append(line);
                }

                reader.close();

                response = resp.toString();
            } else {
                response = "{" + '"' + "error" + '"' + ":" + '"' + "HTTP Error : " + responseCode + '"' + "}";
            }
        } catch (Exception e) {
            response = "{" + '"' + "error" + '"' + ":" + '"' + e.getMessage() + '"' + "}";
        }

        return response;
    }
}
