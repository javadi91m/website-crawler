package com.javadi.websitecrawler.crawler;

import java.io.IOException;
import java.net.HttpURLConnection;

public interface ContentReader {

    String readAsString(HttpURLConnection connection) throws IOException;

    HttpURLConnection makeConnection(String stringUrl) throws IOException;

    String getFileExtension(HttpURLConnection connection);

}
