package org.example.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.example.utils.TypesOfData.*;

public abstract class BasePage {
    protected WebDriver webDriver;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    protected WebElement getElementBy(String byType, String name, int time) {
        return switch (byType) {
            case ID ->
                    new WebDriverWait(webDriver, Duration.ofSeconds(time)).until(ExpectedConditions.visibilityOfElementLocated(By.id(name)));
            case NAME ->
                    new WebDriverWait(webDriver, Duration.ofSeconds(time)).until(ExpectedConditions.visibilityOfElementLocated(By.name(name)));
            case XPATH ->
                    new WebDriverWait(webDriver, Duration.ofSeconds(time)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(name)));
            default -> null;
        };
    }
}
