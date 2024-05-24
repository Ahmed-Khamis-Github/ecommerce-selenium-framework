package tests;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class EmailFriendTest extends  TestBase{


    HomePage homeObject;
    UserRegistrationPage registrationObject;
    SearchPage searchObject ;
    SearchDetailsPage searchDetailsObject ;

    EmailFriend emailFriendObject ;
    String productName = "Apple MacBook Pro 13-inch";

    String friendEmail = "ahmed@gmail.com" ;

    String personalMsg = "hello this is the best product so far  !!!" ;

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

    // registration ;
    @Test(priority =1)
    public void UserCanRegisterSuccessfully() {
        homeObject = new HomePage(driver);
        homeObject.openRegistrationPage();

        registrationObject = new UserRegistrationPage(driver);
        registrationObject.userRegistration(firstName,
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


// search
@Test(priority = 2)
public void SearchUsingAutocomplete()
{
    searchObject= new SearchPage(driver) ;
    searchDetailsObject= new SearchDetailsPage(driver) ;
    searchObject.searchUsingAutocomplete("MacBook");
    Assert.assertEquals(searchDetailsObject.breadcrumbSearchedProductName.getText(),productName);
}

//
@Test(priority = 3)

    public void  userCanEmailFriend()
    {
        searchDetailsObject.openEmailFriendPage();

        emailFriendObject = new EmailFriend(driver) ;

        emailFriendObject.sendEmailNotification(friendEmail,personalMsg);

        Assert.assertTrue(emailFriendObject.successMsgNotification.getText().contains("Your message has been sent"));

    }

    //logout
    @Test(priority = 4)
    public void RegisteredUserCanLogout()
    {
        registrationObject.userLogout();

    }

}
