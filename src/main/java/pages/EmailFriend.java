package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailFriend extends PageBase{

    public EmailFriend(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "FriendEmail")
    WebElement friendEmailTxtBox ;

    @FindBy(id = "PersonalMessage")
    WebElement personalMsgTxtBox ;

    @FindBy(name = "send-email")
    WebElement sendEmailBtn ;

    @FindBy(className = "result")
   public WebElement successMsgNotification ;


    public void sendEmailNotification(String friendEmail , String personalMsg)
    {
        setTextElementText(friendEmailTxtBox,friendEmail);
        setTextElementText(personalMsgTxtBox,personalMsg);
        clickButton(sendEmailBtn);



    }
}
