package tests;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class CheckoutForRegisteredUserTest extends  TestBase{

    UserRegistrationPage registrationObject;
    HomePage homeObject;

    AddToCart addToCartObject ;

    CheckoutForRegisteredUser checkoutForRegisteredUserObject ;

    OrderDetails orderDetailsObject ;


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

    SearchPage searchObject ;
    SearchDetailsPage searchDetailsObject ;
    String productName = "Apple MacBook Pro 13-inch";

    String BillingCompanyName = "Tech Solutions Inc.";
    String countryName = "United States";
    String state = "California";
    String city = "San Francisco";
    String address1 = "123 Market Street";
    String address2 = "Suite 400";
    String zipCode = "94105";
    String phoneNumber = "+1-415-555-1234";
    String faxNumber = "+1-415-555-5678";


    @Test(priority = 1)

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

    @Test(priority = 2)
    public void SearchUsingAutocomplete()
    {
        searchObject= new SearchPage(driver) ;
        searchDetailsObject= new SearchDetailsPage(driver) ;
        searchObject.searchUsingAutocomplete("Apple");
        Assert.assertEquals(searchDetailsObject.breadcrumbSearchedProductName.getText(),productName);
    }

    @Test(priority = 3)

    public void addToCart()
    {
        addToCartObject = new AddToCart(driver) ;
        searchDetailsObject.addToCart();
        searchDetailsObject.openAddToCartPage();
        addToCartObject.UpdateCartQuantity();
        Assert.assertEquals(addToCartObject.subTotal.getText(),"$9,000.00");

    }

    @Test(priority = 4)
    public  void openCheckoutPage ()
    {
        searchDetailsObject.openCheckOutPage();
        checkoutForRegisteredUserObject = new CheckoutForRegisteredUser(driver) ;
        Assert.assertTrue(checkoutForRegisteredUserObject.checkoutTitle.getText().contains("Checkout"));
    }

    @Test(priority = 5)
    public void registeredUserCanCheckout()
    {
        checkoutForRegisteredUserObject.checkOut(BillingCompanyName, countryName, state, city, address1, address2, zipCode, phoneNumber, faxNumber);
        System.out.println("ahmed"+checkoutForRegisteredUserObject.checkoutAlert.getText());
         Assert.assertTrue(checkoutForRegisteredUserObject.checkoutAlert.getText().contains("Your order has been successfully processed!"));
         checkoutForRegisteredUserObject.openOrderDetailsPage();
        orderDetailsObject = new OrderDetails(driver) ;

        orderDetailsObject.downloadInvoice();

    }

    @Test(priority = 6)


    public void RegisteredUserCanLogout() {
        registrationObject.userLogout();

    }


}
