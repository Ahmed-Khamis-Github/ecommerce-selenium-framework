package tests;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegistrationPage;

public class MyAccountTest extends TestBase {
    HomePage homeObject;
    MyAccountPage myAccountObject;

    UserRegistrationPage registrationObject;
    LoginPage loginObject;

    private static final Faker faker = new Faker();
    private final String firstName = faker.name().firstName();
    private final String lastName = faker.name().lastName();
    private final String email = faker.internet().emailAddress();
    private final String companyName = faker.company().name();
    private final String oldPassword = faker.internet().password();
    private final String dayOfBirth = Integer.toString(faker.number().numberBetween(1, 28));
    private final int monthOfBirthInt = faker.number().numberBetween(1, 13);
    private final String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    private final String monthOfBirth = months[monthOfBirthInt - 1];
    private final String yearOfBirth = Integer.toString(faker.number().numberBetween(1950, 2000));


    private final String newPassword = faker.internet().password();


    @Test(priority = 1)

    public void UserCanRegisterSuccessfully() {
        homeObject = new HomePage(driver);
        homeObject.openRegistrationPage();

        registrationObject = new UserRegistrationPage(driver);
        registrationObject.userRegistration(firstName,
                lastName,
                email,
                companyName,
                oldPassword,
                dayOfBirth,
                monthOfBirth,
                yearOfBirth );

        System.out.println(registrationObject.successMsg.getText());
        Assert.assertTrue(registrationObject.successMsg.getText().contains("registration completed"));
    }


    @Test(priority = 2)

    public void RegisteredUserOpenMyAccountPage() {
        registrationObject.openMyAccountPage();
    }

    @Test(priority = 3)

    public void RegisteredUserChangeHisPasswordSuccessfully() {

        myAccountObject = new MyAccountPage(driver);
        myAccountObject.UserChangePassword(oldPassword, newPassword);
        Assert.assertTrue(myAccountObject.alertPasswordChangedSuccessfully.getText().contains("Password was changed"));
        myAccountObject.closeAlert();
        myAccountObject.logout();

    }



    @Test(priority = 4)

    public void UserCanLoginSuccessfully() {
        homeObject.loginPage();
        loginObject = new LoginPage(driver);
        loginObject.UserLogin(email, newPassword);
        System.out.println(registrationObject.logoutBtn.getText());
        Assert.assertTrue(registrationObject.logoutBtn.getText().contains("Log out"));
        registrationObject.userLogout();
    }


}
