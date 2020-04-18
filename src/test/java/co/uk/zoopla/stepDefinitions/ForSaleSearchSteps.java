package co.uk.zoopla.stepDefinitions;

import co.uk.zoopla.pages.BasePage;
import co.uk.zoopla.pages.HomePage;
import co.uk.zoopla.pages.ProductDetailsPage;
import co.uk.zoopla.pages.SearchResultPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;

public class ForSaleSearchSteps extends BasePage {

    HomePage homePage = PageFactory.initElements(driver, HomePage.class);
    SearchResultPage searchResultPage = PageFactory.initElements(driver, SearchResultPage.class);
    ProductDetailsPage productDetailsPage = PageFactory.initElements(driver, ProductDetailsPage.class);

    @Given("I navigate to zoopla homepage")
    public void i_navigate_to_zoopla_homepage() {
        launchUrl();
    }

    @When("I enter a {string} in the search text box")
    public void i_enter_a_in_the_search_text_box(String location) {
        homePage.enterLocation(location);
    }

    @When("I select {string} from Min price dropdown")
    public void i_select_from_Min_price_dropdown(String minPrice) {
        homePage.selectMinimumPrice(minPrice);
    }

    @When("I select {string} from Max price dropdown")
    public void i_select_from_Max_price_dropdown(String maxPrice) {
        homePage.selectMaximumPrice(maxPrice);
    }

    @When("I select {string} from Property type dropdown")
    public void i_select_from_Property_type_dropdown(String string) {

    }

    @When("I select {string} from Bedrooms dropdown")
    public void i_select_from_Bedrooms_dropdown(String string) {

    }

    @When("I click on Search button")
    public void i_click_on_Search_button() {
        searchResultPage = homePage.clickOnSearchButton();
    }

    @Then("a list of {string} in {string} are displayed")
    public void a_list_of_in_are_displayed(String property, String location) {
        searchResultPage.isPropertyDisplayed(property, location);
    }

    //And I click on one of the results links
    @Then("I click on one of the results links")
    public void iClickOnOneOfTheResultsLinks() {
            productDetailsPage = searchResultPage.clickOnOneOfTheResults();
    }
}
