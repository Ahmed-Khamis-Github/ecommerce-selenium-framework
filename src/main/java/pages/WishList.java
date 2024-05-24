package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WishList extends PageBase{

    public WishList(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "input[type='checkbox'][name='addtocart'][value='11276']")
    WebElement checkBox ;

    @FindBy(className = "remove-btn")
    WebElement removeFromWishListButton ;

    @FindBy(className = "no-data")
  public   WebElement noDATAiNWishListAlert ;

    public void removeFromWishList ()
    {
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        WebElement removeButtonElement = wait.until(ExpectedConditions.elementToBeClickable(removeFromWishListButton));

        removeButtonElement.click();
    }


}
