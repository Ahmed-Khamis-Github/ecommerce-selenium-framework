package tests;

import data.ExcelReader;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

import java.io.IOException;

public class UserRegistrationTestUsingExcelFile extends TestBase {

    HomePage homeObject;
    UserRegistrationPage registrationObject;

    LoginPage loginObject;


    @DataProvider(name = "excelData")

    public static Object[][] excelData() throws IOException {
        ExcelReader ER = new ExcelReader();
        System.out.println(ER.getExcelData());
        return ER.getExcelData();
    }

    @Test(priority = 1, dataProvider = "excelData")
    public void UserCanRegisterSuccessfully(String firstName, String lastName, String dayOfBirth, String monthOfBirth, String yearOfBirth, String email, String companyName, String password) {
        homeObject = new HomePage(driver);
        homeObject.openRegistrationPage();

        registrationObject = new UserRegistrationPage(driver);
        System.out.println(String.format("Day of Birth: %s, Month of Birth: %s, Year of Birth: %s, Email: %s, Company Name: %s, Password: %s",
                dayOfBirth, monthOfBirth, yearOfBirth, email, companyName, password));
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
