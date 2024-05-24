package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyAccountPage extends PageBase {


    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Change password")
    WebElement changePasswordLink;

    @FindBy(id = "OldPassword")
    WebElement oldPasswordTxtBox;

    @FindBy(id = "NewPassword")
    WebElement newPasswordTxtBox;

    @FindBy(id = "ConfirmNewPassword")
    WebElement confirmationPasswordTxtBox;

    @FindBy(css = ".change-password-button")
    WebElement changePassword;

    @FindBy(className = "content")
    public WebElement alertPasswordChangedSuccessfully;

    @FindBy(className = "close")
    WebElement closeAlertSuccessMsg;

    @FindBy(linkText = "Log out")
    public    WebElement logoutBtn ;

    public void UserChangePassword(String oldPassword, String Password) {
        clickButton(changePasswordLink);
        setTextElementText(oldPasswordTxtBox, oldPassword);
        setTextElementText(newPasswordTxtBox, Password);
        setTextElementText(confirmationPasswordTxtBox, Password);
        clickButton(changePassword);

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

    public void logout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // 10 seconds timeout
        WebElement logoutButton = wait.until(ExpectedConditions.elementToBeClickable(logoutBtn));
        logoutButton.click();
    }
}
