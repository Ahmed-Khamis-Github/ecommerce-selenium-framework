package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UserRegistrationPage extends PageBase {


    public UserRegistrationPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(id = "gender-male")
    WebElement genderRdoBtn;


    @FindBy(id = "FirstName")
    WebElement fnTxtBox;

    @FindBy(id = "LastName")
    WebElement lnTxtBox;

    @FindBy(name = "DateOfBirthDay")
    WebElement selectDay;

    @FindBy(name = "DateOfBirthMonth")
    WebElement selectMonth;

    @FindBy(name = "DateOfBirthYear")
    WebElement selectYear;


    @FindBy(id = "Email")
    WebElement emailTxtBox;


    @FindBy(id = "Company")
    WebElement companyTxtBox;

    @FindBy(id = "Password")
    WebElement passwordTxtBox;

    @FindBy(id = "ConfirmPassword")
    WebElement confirmationPasswordTxtBox;

    @FindBy(id = "register-button")
    WebElement registerBtn;

    @FindBy(className = "result")
    public  WebElement successMsg ;

    @FindBy(linkText = "Log out")
 public    WebElement logoutBtn ;

    @FindBy(className = "ico-account")
    WebElement myAccountLink ;





    public void userRegistration(String firstName, String lastName, String email, String companyName, String password, String dayOfBirth, String monthOfBirth, String yearOfBirth) {

        clickButton(genderRdoBtn);


        setTextElementText(fnTxtBox, firstName);


        setTextElementText(lnTxtBox, lastName);


        selectElementByText(selectDay, dayOfBirth);

        selectElementByText(selectMonth, monthOfBirth);

        selectElementByText(selectYear, yearOfBirth);


        setTextElementText(emailTxtBox, email);


        setTextElementText(companyTxtBox, companyName);


        setTextElementText(passwordTxtBox, password);


        setTextElementText(confirmationPasswordTxtBox, password);


        clickButton(registerBtn);


    }


    public void userLogout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // 10 seconds timeout
        WebElement logoutButton = wait.until(ExpectedConditions.elementToBeClickable(logoutBtn));
        logoutButton.click();
    }



    public  void  openMyAccountPage()
    {
        clickButton(myAccountLink);
    }






}
