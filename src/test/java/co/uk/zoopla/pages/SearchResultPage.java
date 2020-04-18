package co.uk.zoopla.pages;

import javafx.scene.web.WebEngine;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class SearchResultPage extends BasePage
{

    public SearchResultPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(tagName = "h1")
    private WebElement title;
    @FindBy(css = ".listing-results-price.text-price")
    private List<WebElement> results;

    public void isPropertyDisplayed(String property, String location)
    {
        String titleText = title.getText();
        Assert.assertTrue(titleText.contains(property));
        Assert.assertTrue(titleText.contains(location));
    }

    public ProductDetailsPage clickOnOneOfTheResults()
    {
        Random ran = new Random();
        int resultSize = results.size();
        int randomisedNumber = ran.nextInt(resultSize-1);

        results.get(randomisedNumber).click();
        return new ProductDetailsPage(driver);
    }


}
