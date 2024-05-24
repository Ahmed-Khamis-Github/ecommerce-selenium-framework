package tests;

import data.LoadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTestUsingPorpertiesFile extends TestBase {

    HomePage homeObject;
    UserRegistrationPage registrationObject;

    LoginPage loginObject;

    String firstName = LoadProperties.userData.getProperty("fname");
    String lastName = LoadProperties.userData.getProperty("lname");
    String email = LoadProperties.userData.getProperty("email");
    String companyName = LoadProperties.userData.getProperty("company");
    String password = LoadProperties.userData.getProperty("password");
    String dayOfBirth = LoadProperties.userData.getProperty("dayOfBirth");
    String monthOfBirth = LoadProperties.userData.getProperty("monthOfBirth");
    String yearOfBirth = LoadProperties.userData.getProperty("yearOfBirth");


    @Test(priority = 1)
    public void UserCanRegisterSuccessfully() {
        homeObject = new HomePage(driver);
        homeObject.openRegistrationPage();

        registrationObject = new UserRegistrationPage(driver);
        registrationObject.userRegistration(firstName, lastName, email, companyName, password, dayOfBirth, monthOfBirth, yearOfBirth);

        System.out.println(registrationObject.successMsg.getText());
        Assert.assertTrue(registrationObject.successMsg.getText().contains("registration completed"));
        registrationObject.userLogout();
        homeObject.loginPage();
        loginObject = new LoginPage(driver);
        loginObject.UserLogin(email, password);
        System.out.println(registrationObject.logoutBtn.getText());
        Assert.assertTrue(registrationObject.logoutBtn.getText().contains("Log out"));
        registrationObject.userLogout();

    }
 

}
