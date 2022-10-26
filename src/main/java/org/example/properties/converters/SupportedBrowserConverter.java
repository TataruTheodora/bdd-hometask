package org.example.properties.converters;

import org.example.enumeration.SupportedBrowser;

public class SupportedBrowserConverter {
    public static SupportedBrowser valueOfWebBrowser(String webBrowser) {
        return switch (webBrowser) {
            case "local_chrome" -> SupportedBrowser.LOCAL_CHROME;
            default -> throw new IllegalArgumentException("No appropriate browser found");
        };
    }
}
