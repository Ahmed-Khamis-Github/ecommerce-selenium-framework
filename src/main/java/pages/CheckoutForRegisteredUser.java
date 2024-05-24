package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutForRegisteredUser extends PageBase {
    @FindBy(id = "BillingNewAddress_Company")
    WebElement BillingCompanyNameTxtBox;

    @FindBy(name = "BillingNewAddress.CountryId")
    WebElement BillingCountry;

    @FindBy(name = "BillingNewAddress.StateProvinceId")
    WebElement BillingState;

    @FindBy(id = "BillingNewAddress_City")
    WebElement BillingCity;

    @FindBy(id = "BillingNewAddress_Address1")
    WebElement BillingAddress1;

    @FindBy(id = "BillingNewAddress_Address2")
    WebElement BillingAddress2;

    @FindBy(id = "BillingNewAddress_ZipPostalCode")
    WebElement BillingZipCode;

    @FindBy(id = "BillingNewAddress_PhoneNumber")
    WebElement BillingPhoneNumber;

    @FindBy(id = "BillingNewAddress_FaxNumber")
    WebElement BillingFaxNumber;

    @FindBy(className = "new-address-next-step-button")
    WebElement BillingContinueBtn;

    @FindBy(id = "shippingoption_1")
    WebElement ShippingOption1;

    @FindBy(className = "shipping-method-next-step-button")
    WebElement ShippingMethodContinueBtn;

    @FindBy(className = "payment-method-next-step-button")
    WebElement PaymentMethodContinueBtn;

    @FindBy(className = "payment-info-next-step-button")
    WebElement paymentInfoContinueBtn;

    @FindBy(className = "confirm-order-next-step-button")
    WebElement confirmButtonBtn;

    @FindBy(tagName = "h1")
    public  WebElement checkoutTitle ;

    @FindBy(xpath = ("//*[@id=\"main\"]/div/div/div/div[2]/div/div[1]/strong"))
    public WebElement checkoutAlert ;

    @FindBy(linkText = "Click here for order details.")
    WebElement orderDetailsLink ;

    public CheckoutForRegisteredUser(WebDriver driver) {
        super(driver);
    }


    public void checkOut(
            String companyName,
            String countryName,
            String state,
            String city,
            String address1,
            String address2,
            String zipCode,
            String phoneNumber,
            String faxNumber
    ) {
        setTextElementText(BillingCompanyNameTxtBox, companyName);

        selectElementByText(BillingCountry, countryName);
        selectElementByText(BillingState, state);

        setTextElementText(BillingCity, city);
        setTextElementText(BillingAddress1, address1);
        setTextElementText(BillingAddress2, address2);
        setTextElementText(BillingZipCode, zipCode);
        setTextElementText(BillingPhoneNumber, phoneNumber);
        setTextElementText(BillingFaxNumber, faxNumber);
        clickButton(BillingContinueBtn);
        clickButton(ShippingOption1);

        clickButton(ShippingMethodContinueBtn);
        clickButton(PaymentMethodContinueBtn);
        clickButton(paymentInfoContinueBtn);
        clickButton(confirmButtonBtn);


    }

    public void  openOrderDetailsPage()
    {
        clickButton(orderDetailsLink);
    }

}
