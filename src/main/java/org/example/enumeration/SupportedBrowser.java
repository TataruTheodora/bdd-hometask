package org.example.enumeration;

import org.example.invoker.WebDriverInvoker;
import org.example.invoker.implementation.LocalChromeInvoker;
import org.openqa.selenium.WebDriver;

public enum SupportedBrowser {
    LOCAL_CHROME(new LocalChromeInvoker());

    private final WebDriverInvoker webDriverInvoker;

    SupportedBrowser(WebDriverInvoker webDriverInvoker) {
        this.webDriverInvoker = webDriverInvoker;
    }

    public WebDriver getWebDriver(){
        return webDriverInvoker.invokeWebDriver();
    }
}
