package io.github.accessun.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

public class HttpRequest {

    private static final List<String> SUPPORTED_METHODS = Arrays.asList("GET", "POST", "PUT", "DELETE");

    public static String send(String urlStr, String method) throws IOException {
        if (method == null || !SUPPORTED_METHODS.contains(method.toUpperCase())) {
            return null;
        }
        method = method.toUpperCase();

        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod(method);

        StringBuilder strBuilder = new StringBuilder();

        try (InputStreamReader isReader = new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8);
                BufferedReader reader = new BufferedReader(isReader)) {

            String line;
            while ((line = reader.readLine()) != null) {
                strBuilder.append(line);
            }

        }

        return strBuilder.toString();
    }

}