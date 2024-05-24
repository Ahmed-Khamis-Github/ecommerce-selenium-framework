package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageBase {

    public JavascriptExecutor jsc;

    public Actions action;


    protected WebDriver driver;

    public PageBase(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }

    protected static void clickButton(WebElement button) {
        button.click();
    }

    protected static void setTextElementText(WebElement textElement, String Value) {
        textElement.sendKeys(Value);
    }

    protected static void selectElementByText(WebElement selectElement, String Value) {
        Select dropdown = new Select(selectElement);
        dropdown.selectByVisibleText(Value);

    }

    public void scrollBottom() {
        jsc.executeScript("scrollBy(0,2500)");
    }

    public void ClearTxtBox(WebElement textBox)
    {
        textBox.clear();

    }
}
