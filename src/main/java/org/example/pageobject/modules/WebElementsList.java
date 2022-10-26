package org.example.pageobject.modules;

import org.example.pageobject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.example.utils.TypesOfData.VALID_INPUT;

public class WebElementsList extends BasePage {
    public WebElementsList(WebDriver webDriver) {
        super(webDriver);
    }

    public Boolean checkAtLeastOneInput(String xpath) {
        List<WebElement> items = new ArrayList<>(new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath))));

        int counter = 0;
        for (WebElement item : items) {
            if (item.getText().toLowerCase().contains(VALID_INPUT)) {
                counter++;
            }
        }

        return counter > 0;
    }
}
