package org.example.stepdefinitions;

import io.cucumber.java.en.Given;
import org.example.pageobject.pages.HomePage;

import static org.example.stepdefinitions.BaseSteps.webDriver;

public class HomePageSteps {
    HomePage homepage = new HomePage(webDriver);
    @Given("User is on Home Page")
    public void userIsOnHomePage() {
        homepage.openPage();
    }
}
