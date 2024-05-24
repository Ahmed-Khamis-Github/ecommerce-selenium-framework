package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CompareProducts extends  PageBase{

    public CompareProducts(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "clear-list")
    WebElement clearList ;

    @FindBy(className = "compare-products-table")
    WebElement table ;

    @FindBy(tagName = "tr")
    List<WebElement> allRows ;

    @FindBy(tagName = "td")
    List<WebElement> allCols ;



    public void CompareBetweenProducts() {
        for (WebElement row : allRows) {
            for (WebElement column : allCols) {
                System.out.println(column.getText());
            }
        }
    }



}
