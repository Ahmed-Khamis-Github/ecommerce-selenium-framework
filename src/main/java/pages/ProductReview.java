package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductReview extends PageBase{
    public ProductReview(WebDriver driver) {
        super(driver);
    }

    @FindBy(id ="AddProductReview_Title")
    WebElement reviewTitleTxtBox ;

    @FindBy(id = "AddProductReview_ReviewText")
    WebElement reviewContentTxtBox ;

    @FindBy(id = "addproductrating_4")
    WebElement ratingCheck ;

    @FindBy(id="add-review")
    WebElement submitReviewBtn ;

    @FindBy(className = "content")
    public  WebElement alertSuccessNotification ;

    @FindBy(className = "close")
    WebElement closeAlertSuccessMsg;

    public void ProductReview(String reviewTitle , String reviewContent)
    {
        setTextElementText(reviewTitleTxtBox, reviewTitle);
        setTextElementText(reviewContentTxtBox, reviewContent);
        clickButton(ratingCheck);
        clickButton(submitReviewBtn);


    }

    public void closeAlert() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(closeAlertSuccessMsg));
        wait.until(ExpectedConditions.elementToBeClickable(closeAlertSuccessMsg));
        try {
            clickButton(closeAlertSuccessMsg);
        } catch (org.openqa.selenium.ElementClickInterceptedException e) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", closeAlertSuccessMsg);
        }
    }
}
