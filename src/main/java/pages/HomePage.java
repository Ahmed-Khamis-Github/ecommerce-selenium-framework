package pages;

 import org.openqa.selenium.JavascriptExecutor;
 import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
 import org.openqa.selenium.interactions.Actions;
 import org.openqa.selenium.support.FindBy;
 import org.openqa.selenium.support.ui.ExpectedConditions;
 import org.openqa.selenium.support.ui.WebDriverWait;

 import java.time.Duration;

public class HomePage extends PageBase {

     public HomePage(WebDriver driver) {

         super(driver);
         jsc = (JavascriptExecutor) driver ;
         action = new Actions(driver) ;
    }

    @FindBy(linkText = "Register")
    WebElement registerLink;

    @FindBy(linkText = "Log in")
    WebElement loginLink;

    @FindBy(linkText = "Contact us")
    WebElement contactUsLink ;

    @FindBy(name = "customerCurrency")
    WebElement changeCurrencyDropdown ;

    @FindBy(linkText = "Computers")
    WebElement computersLink ;

    @FindBy(linkText = "Notebooks")
    WebElement notebooksLink ;


    public void openRegistrationPage() {

        clickButton(registerLink);


    }

    public void loginPage() {
        clickButton(loginLink);
    }


    public  void openContactusPage()
    {
        scrollBottom();
        clickButton(contactUsLink);
    }

    public void changeCurrency()
    {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(changeCurrencyDropdown));
        selectElementByText(dropdown, "Euro");
    }

    public void HoverMainMenu()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(computersLink));
        action.moveToElement(computersLink).perform();
        wait.until(ExpectedConditions.elementToBeClickable(notebooksLink));
        action.moveToElement(notebooksLink).click().build().perform();    }


}
