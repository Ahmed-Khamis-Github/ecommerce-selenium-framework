package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchDetailsPage extends PageBase{


    public SearchDetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "current-item")
   public WebElement breadcrumbSearchedProductName ;

    @FindBy(css = ".email-a-friend-button")
    WebElement emailFriendBtn ;

    @FindBy(id = "price-value-1")
    public  WebElement priceLabel ;

    @FindBy(linkText = "Add your review")
    WebElement addYourReviewLink ;

    @FindBy(id = "add-to-wishlist-button-18")
    WebElement addToWishListBtn ;

    @FindBy(className = "content")
   public WebElement addedSuccessfullyAlert ;

    @FindBy(linkText = "wishlist")
    WebElement wishListlink ;

    @FindBy(className = "add-to-compare-list-button")
    WebElement compareProductsBtn ;

    @FindBy(linkText = "product comparison")
    WebElement compareLink ;

    @FindBy(id = "add-to-cart-button-4")
    WebElement addToCartBtn ;

    @FindBy(linkText = "shopping cart")
    WebElement addToCartLink ;

    @FindBy(id = "termsofservice")
    WebElement termsCheckBox ;

    @FindBy(css = ".checkout-button")
    WebElement checkoutBtn ;

    public  void  openEmailFriendPage()
    {
        clickButton(emailFriendBtn);
    }

    public  void  openReviewForm()
    {
        clickButton(addYourReviewLink);
    }

    public void openComparePage()
    {
        clickButton(compareLink);
    }


    public  void  addToWishList()
    {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement addToWishListButton = wait.until(ExpectedConditions.elementToBeClickable(addToWishListBtn));

        clickButton(addToWishListButton);
    }

    public void openWishListPage()
    {
        clickButton(wishListlink);

    }

    public void addToCompareProducts()
    {
        clickButton(compareProductsBtn);

    }

    public void addToCart()
    {
        clickButton(addToCartBtn);

    }

    public  void openAddToCartPage()
    {
        clickButton(addToCartLink);

    }

    public  void openCheckOutPage()
    {
        clickButton(termsCheckBox);
        clickButton(checkoutBtn);

    }


}
