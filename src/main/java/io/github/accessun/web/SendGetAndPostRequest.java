package io.github.accessun.web;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class SendGetAndPostRequest {
    public static String sendGet(String url) throws IOException {
        StringBuilder sb = new StringBuilder();
        URLConnection urlConn = null;
        InputStreamReader in = null;
        URL urlObj = new URL(url);
        urlConn = urlObj.openConnection();

        if (urlConn != null) {
            urlConn.setReadTimeout(60 * 1000);
        }

        if (urlConn != null && urlConn.getInputStream() != null) {
            in = new InputStreamReader(urlConn.getInputStream(), Charset.defaultCharset());
            BufferedReader bufferedReader = new BufferedReader(in);
            if (bufferedReader != null) {
                int cp;
                while ((cp = bufferedReader.read()) != -1) {
                    sb.append((char) cp);
                }
                bufferedReader.close();
            }
        }
        in.close();
        return sb.toString();
    }

    public static String sendPost(String url, String queryParam) throws IOException {
        StringBuilder sb = new StringBuilder();
        HttpURLConnection urlConn = null;
        InputStreamReader in = null;
        URL urlObj = new URL(url);
        urlConn = (HttpURLConnection) urlObj.openConnection();

        if (urlConn != null) {
            byte[] postData = queryParam.getBytes(StandardCharsets.UTF_8);
            int postDataLength = postData.length;
            urlConn.setDoOutput(true);
            urlConn.setInstanceFollowRedirects(false);
            urlConn.setRequestMethod("POST");
            urlConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            urlConn.setRequestProperty("charset", "utf-8");
            urlConn.setRequestProperty("Content-Length", Integer.toString(postDataLength));
            urlConn.setUseCaches(false);
            urlConn.setReadTimeout(60 * 1000);

            DataOutputStream wr = new DataOutputStream(urlConn.getOutputStream());
            wr.write(postData);
        }

        if (urlConn != null && urlConn.getInputStream() != null) {
            in = new InputStreamReader(urlConn.getInputStream(), Charset.defaultCharset());
            BufferedReader bufferedReader = new BufferedReader(in);
            if (bufferedReader != null) {
                int cp;
                while ((cp = bufferedReader.read()) != -1) {
                    sb.append((char) cp);
                }
                bufferedReader.close();
            }
        }
        in.close();
        return sb.toString();
    }
}
