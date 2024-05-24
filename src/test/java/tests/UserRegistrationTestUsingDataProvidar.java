package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTestUsingDataProvidar extends TestBase {
    HomePage homeObject;
    UserRegistrationPage registrationObject;

    LoginPage loginObject;


    @DataProvider(name = "testData")

    public static Object[][] userData() {
        return new Object[][]{
                {"Ahmed", "Khamis",
                        "test1121@gmail.com", "MisoCompany",
                        "12345678", "20", "December", "1997"},
                {"MOHAMED", "ali",
                        "test212@gmail.com", "MisoCompany",
                        "12345678", "10", "December", "2000"}
        };
    }

    @Test(priority = 1 , dataProvider = "testData")
    public void UserCanRegisterSuccessfully(String fName ,String lName,String email,String companyName ,String password ,String dayOfBirth ,String monthOfBirth ,String yearOfBirth) {
        homeObject = new HomePage(driver);
        homeObject.openRegistrationPage();

        registrationObject = new UserRegistrationPage(driver);
        registrationObject.userRegistration(fName , lName,email ,companyName , password , dayOfBirth , monthOfBirth , yearOfBirth);

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



    @Test(dependsOnMethods = "RegisteredUserCanLogout",enabled = false)
    public void UserCanLoginSuccessfully() {
        homeObject.loginPage();
        loginObject = new LoginPage(driver);
        loginObject.UserLogin("asjsdazbbhfudr5sxd074tu@gmail.com", "12345678");
        System.out.println(registrationObject.logoutBtn.getText());
        Assert.assertTrue(registrationObject.logoutBtn.getText().contains("Log out"));
        registrationObject.userLogout();

    }


}
