package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUs extends  PageBase{
    public ContactUs(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "FullName")
    WebElement fullnameTxtBox ;

    @FindBy(id = "Email")
    WebElement emailTxtBox ;

    @FindBy(id = "Enquiry")
    WebElement enquiryTxtBox ;

    @FindBy(name = "send-email")
    WebElement sendEmailBtn ;

    @FindBy(className = "result")
     public  WebElement successAlertMsg ;


    public void userContactAdmin(String fullName , String email , String enquiry)
    {
        setTextElementText(fullnameTxtBox,fullName);
        setTextElementText(emailTxtBox,email);
        setTextElementText(enquiryTxtBox,enquiry);
        clickButton(sendEmailBtn);

    }
}
