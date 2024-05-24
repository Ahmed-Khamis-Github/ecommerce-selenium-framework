package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactUs;
import pages.HomePage;

public class ContactUsTest extends  TestBase{

    HomePage homePageObject ;
    ContactUs contactUsObject ;
    String fullName = "Ahmed Ali" ;
    String  email = "ahmesfd@gmail.com" ;
    String enquiry = "this a question for admin !!" ;

    
@Test
    public  void  UserCanContactUs()
    {
        homePageObject = new HomePage(driver) ;
        contactUsObject = new ContactUs(driver) ;

        homePageObject.scrollBottom();
        homePageObject.openContactusPage();
        contactUsObject.userContactAdmin(fullName,email,enquiry);
        Assert.assertTrue(contactUsObject.successAlertMsg.getText().contains("Your enquiry has been successfully sent to the store owner"));
    }
}
