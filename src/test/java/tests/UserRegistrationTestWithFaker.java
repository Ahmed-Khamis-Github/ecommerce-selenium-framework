package tests;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTestWithFaker extends TestBase {

    HomePage homeObject;
    UserRegistrationPage registrationObject;

    LoginPage loginObject ;

    private static final Faker faker = new Faker();
    private final String firstName = faker.name().firstName();
    private final String lastName = faker.name().lastName();
    private final String email = faker.internet().emailAddress();
    private final String companyName = faker.company().name();
    private final String password = faker.internet().password();
    private final String dayOfBirth = Integer.toString(faker.number().numberBetween(1, 28));
    private final int monthOfBirthInt = faker.number().numberBetween(1, 13);
    private final String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    private final String monthOfBirth = months[monthOfBirthInt - 1];
    private final String yearOfBirth = Integer.toString(faker.number().numberBetween(1950, 2000));


@Test(priority =1)
    public void UserCanRegisterSuccessfully() {
        homeObject = new HomePage(driver);
        homeObject.openRegistrationPage();

        registrationObject = new UserRegistrationPage(driver);
        registrationObject.userRegistration( firstName,
                lastName,
                email,
                companyName,
                password,
                dayOfBirth,
                monthOfBirth,
                yearOfBirth);

    System.out.println(registrationObject.successMsg.getText());
        Assert.assertTrue(registrationObject.successMsg.getText().contains("registration completed"));
    }

@Test(dependsOnMethods = "UserCanRegisterSuccessfully")
    public void RegisteredUserCanLogout()
    {
        registrationObject.userLogout();

    }
@Test(dependsOnMethods="RegisteredUserCanLogout")
    public  void  UserCanLoginSuccessfully()
    {
        homeObject.loginPage();
        loginObject = new LoginPage(driver) ;
        loginObject.UserLogin(email,password);
        System.out.println(registrationObject.logoutBtn.getText());
         Assert.assertTrue(registrationObject.logoutBtn.getText().contains("Log out"));
        registrationObject.userLogout();

    }





}
