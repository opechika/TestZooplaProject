package co.uk.zoopla.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "search-input-location")
    private WebElement locationField;
    @FindBy(id = "forsale_price_min")
    private WebElement minPrice;
    @FindBy(name = "price_max")
    private WebElement maxPrice;
    @FindBy(id = "search-submit")
    private WebElement searchButton;
    @FindBy(css = ".ui-button-primary.ui-cookie-accept-all-medium-large")
    private WebElement acceptAllCookie;

    public void enterLocation(String location)
    {

        acceptAll();

        locationField.clear();
        locationField.sendKeys(location);
    }

    public void acceptAll()
    {
        acceptAllCookie.click();

    }

    public void selectMinimumPrice(String miniPrice)
    {
        selectByText(minPrice, miniPrice);
    }

    public void selectMaximumPrice(String priceMax)
    {
        selectByText(maxPrice, priceMax);
    }

    public SearchResultPage clickOnSearchButton()
    {
        searchButton.click();
        return new SearchResultPage(driver);
    }


}
