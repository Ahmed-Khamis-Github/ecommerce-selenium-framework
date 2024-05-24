package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddToCart extends PageBase {
    public AddToCart(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "qty-input")
    WebElement quantityTxtBox;

    @FindBy(className = "remove-btn")
    WebElement removeBtn;

    @FindBy(className = "product-subtotal")
    public WebElement subTotal;

    @FindBy(className = "no-data")
    public WebElement noDataAlert;


    public void UpdateCartQuantity() {
        quantityTxtBox.click();

        quantityTxtBox.sendKeys(Keys.CONTROL + "a");

        setTextElementText(quantityTxtBox, "5");
        quantityTxtBox.sendKeys(Keys.RETURN);


    }

    public void RemoveFromCart() {
        clickButton(removeBtn);
    }

}
