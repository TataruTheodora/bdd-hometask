package org.example.pageobject.pages;

import org.example.pageobject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(id = "twotabsearchtextbox")
    protected WebElement searchBar;

    @FindBy(id = "nav-search-submit-text")
    protected WebElement searchButton;

    public HomePage openPage() {
        webDriver.get("https://www.amazon.com/");

        String wrongPageID = "//a[@id='nav-bb-logo']";
        if (!webDriver.findElements(By.xpath(wrongPageID)).isEmpty())
        {
            webDriver.navigate().refresh();
        }
        return this;
    }

    public HomePage fillInSearchField(String input) {
        searchBar.click();
        searchBar.sendKeys(input);
        return this;
    }

    public SearchResultsPage searchBtn(){
        searchButton.click();
        return new SearchResultsPage(webDriver);
    }
}
