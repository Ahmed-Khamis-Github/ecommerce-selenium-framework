package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class HoverMainMenuTest extends  TestBase {

    HomePage homePageObject ;

    @Test

    public void UserCanHoverMainMenu()
    {
        homePageObject = new HomePage(driver) ;
        homePageObject.HoverMainMenu();
        Assert.assertTrue(driver.getCurrentUrl().contains("notebooks"));
    }
}
