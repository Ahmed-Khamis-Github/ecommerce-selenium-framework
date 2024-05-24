package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderDetails extends PageBase{
    public OrderDetails(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "PDF Invoice")
    WebElement pdfInvoiceBtn ;


    public void downloadInvoice()
    {
        clickButton(pdfInvoiceBtn);
        pdfInvoiceBtn.sendKeys(Keys.RETURN);

    }
}
