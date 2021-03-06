package com.javadi.websitecrawler.content;

import com.javadi.websitecrawler.utils.UrlUtils;

import java.io.IOException;
import java.net.HttpURLConnection;

/**
 * handles only and html resource
 */
public class HtmlContentHandler implements SpecificContentHandler {

    private final UrlUtils urlUtils;
    private final ContentReader contentReader;
    private final ContentWriter contentWriter;

    public HtmlContentHandler(UrlUtils urlUtils, ContentReader contentReader, ContentWriter contentWriter) {
        this.urlUtils = urlUtils;
        this.contentReader = contentReader;
        this.contentWriter = contentWriter;
    }

    @Override
    public String handle(String url, HttpURLConnection connection, String fileExtension) throws IOException {
        String parentPath = urlUtils.getParentPath(url);
        String fileName = urlUtils.getFileNameWithExtension(url, fileExtension);
        String output = contentWriter.write(connection, parentPath, fileName);
        return contentReader.readAsString(output);
    }

}
