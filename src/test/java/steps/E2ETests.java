package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.*;
import tests.TestBase;

public class E2ETests extends TestBase {
    HomePage homeObject;
    UserRegistrationPage registrationObject;

    SearchPage searchObject;
    SearchDetailsPage searchDetailsObject;
    CheckoutForRegisteredUser checkoutForRegisteredUserObject ;
    OrderDetails orderDetailsObject ;



    String productName = "Apple MacBook Pro 13-inch";

    AddToCart addToCartObject ;
    String BillingCompanyName = "Tech Solutions Inc.";
    String countryName = "United States";
    String state = "California";
    String city = "San Francisco";
    String address1 = "123 Market Street";
    String address2 = "Suite 400";
    String zipCode = "94105";
    String phoneNumber = "+1-415-555-1234";
    String faxNumber = "+1-415-555-5678";


    @Given("the user is on the home page")
    public void the_user_is_on_the_home_page() {
        homeObject = new HomePage(driver);
        Assert.assertTrue(driver.getTitle().contains("nopCommerce demo store"));
    }

    @When("the user navigates to the registration page")
    public void the_user_navigates_to_the_registration_page() {
        homeObject.openRegistrationPage();
        Assert.assertTrue(driver.getCurrentUrl().contains("register"));
    }

    @When("the user fills in registration details with {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void the_user_fills_in_registration_details(String firstName, String lastName, String email, String company, String password, String day, String month, String year) {
        registrationObject = new UserRegistrationPage(driver);
        registrationObject.userRegistration(firstName, lastName, email, company, password, day, month, year);
    }


    @Then("the registration is successful")
    public void the_registration_is_successful() {
        Assert.assertTrue(registrationObject.successMsg.getText().contains("registration completed"));
    }

    @When("the user searches for a product by name {string}")
    public void the_user_searches_for_a_product_by_name(String productName) {


        searchObject = new SearchPage(driver);
        searchDetailsObject = new SearchDetailsPage(driver);
        searchObject.searchUsingAutocomplete(productName);
        Assert.assertEquals(searchDetailsObject.breadcrumbSearchedProductName.getText(), "Apple MacBook Pro 13-inch");
    }

    @When("adds the product to the cart")
    public void adds_the_product_to_the_cart() {
        addToCartObject = new AddToCart(driver) ;
        searchDetailsObject.addToCart();
        searchDetailsObject.openAddToCartPage();
        addToCartObject.UpdateCartQuantity();
        Assert.assertEquals(addToCartObject.subTotal.getText(),"$9,000.00");
    }

    @When("proceeds to checkout")
    public void proceeds_to_checkout() {
        searchDetailsObject.openCheckOutPage();
        checkoutForRegisteredUserObject = new CheckoutForRegisteredUser(driver) ;
        Assert.assertTrue(checkoutForRegisteredUserObject.checkoutTitle.getText().contains("Checkout"));
        checkoutForRegisteredUserObject.checkOut(BillingCompanyName, countryName, state, city, address1, address2, zipCode, phoneNumber, faxNumber);
        System.out.println("ahmed"+checkoutForRegisteredUserObject.checkoutAlert.getText());
        Assert.assertTrue(checkoutForRegisteredUserObject.checkoutAlert.getText().contains("Your order has been successfully processed!"));

    }

    @When("downloads the invoice")
    public void downloads_the_invoice() {
        checkoutForRegisteredUserObject.openOrderDetailsPage();
        orderDetailsObject = new OrderDetails(driver) ;

        orderDetailsObject.downloadInvoice();
    }

    @When("logs out")
    public void logs_out() {
        registrationObject.userLogout();

    }

    @Then("the user is successfully logged out")
    public void the_user_is_successfully_logged_out() {
        Assert.assertTrue(driver.getTitle().contains("nopCommerce demo store"));
    }
}
