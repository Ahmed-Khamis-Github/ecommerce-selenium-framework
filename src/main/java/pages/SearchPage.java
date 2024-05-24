package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchPage extends PageBase{

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "small-searchterms")
    WebElement searchTxtBox ;

    @FindBy(css = ".search-box-button")
    WebElement submitSearch ;


    @FindBy(css = ".ui-autocomplete")
    List<WebElement>  autocompleteList ;

    @FindBy(xpath = "//h2[@class='product-title']/a")
    WebElement searchResult ;

    public void searchForProduct(String productName)
    {
        setTextElementText(searchTxtBox,productName);
        clickButton(submitSearch);

    }

    public  void openPageResult()
    {
        clickButton(searchResult);

    }


    public void searchUsingAutocomplete(String productName)
    {
        setTextElementText(searchTxtBox,productName);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitFor(2); // Wait for 2 seconds (adjust as needed)

        // Send a space character to trigger the autocomplete
        searchTxtBox.sendKeys(" ");
        WebElement firstAutocompleteItem = wait.until(ExpectedConditions.elementToBeClickable(autocompleteList.get(0)));
        firstAutocompleteItem.click();

    }
    private void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
