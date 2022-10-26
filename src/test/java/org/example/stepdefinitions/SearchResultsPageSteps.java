package org.example.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pageobject.modules.WebElementsList;
import org.example.pageobject.pages.HomePage;

import static org.example.stepdefinitions.BaseSteps.webDriver;
import static org.example.utils.TypesOfData.VALID_INPUT;
import static org.example.utils.TypesOfData.WRONG_INPUT;
import static org.testng.Assert.assertTrue;

public class SearchResultsPageSteps {
    HomePage homepage = new HomePage(webDriver);
    WebElementsList itemsList = new WebElementsList(webDriver);
    boolean validInput;
    boolean invalidInput;

    //invalid input test
    @When("User enters an invalid input in search field")
    public void userEntersAnInvalidInputInSearchField() {
        homepage.fillInSearchField(WRONG_INPUT);
    }

    @Then("User gets an error message")
    public void userGetsAnErrorMessage() {
        invalidInput = homepage.searchBtn().errorMessage();
    }

    @And("The searched items are not returned")
    public void theSearchedItemsAreNotReturned() {
        assertTrue(invalidInput, "This is not the expected result");
    }

    //valid input test
    @When("User enters a valid input in search field")
    public void userEntersAValidInputInSearchField() {
        homepage.fillInSearchField(VALID_INPUT);
    }

    @Then("User gets the searched items")
    public void userGetsTheSearchedItems() {
        validInput = homepage.searchBtn().checkPresentInput();
    }

    @And("The inserted data is present within the text showing the number of results found")
    public void theInsertedDataIsPresentWithinTheTextShowingTheNumberOfResultsFound() {
        assertTrue(validInput, "The searched word does not appear!");
    }

    //search keyword test
    @Then("User gets a list of items by the search input")
    public void userGetsAListOfItemsByTheSearchInput() {
        validInput = homepage.searchBtn().checkIfKeywordIsPresent(itemsList);
    }

    @And("At least one item should contain the search input")
    public void atLeastOneItemShouldContainTheSearchInput() {
        assertTrue(validInput, "One or more elements does not contain the input from the search field!");
    }
}
