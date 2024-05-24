package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchDetailsPage;
import pages.SearchPage;

public class ChangeCurrencyTest extends TestBase {

    HomePage homePageObject;
    SearchPage searchObject;
    SearchDetailsPage searchDetailsObject;
     String productName = "Build your own computer";


    @Test(priority = 1)

     public void userChangeCurrency()
     {
         homePageObject = new HomePage(driver);

         homePageObject.changeCurrency();

     }

    @Test(priority = 2)
    public void searchForProduct()
    {
        searchObject = new SearchPage(driver) ;
        searchDetailsObject= new SearchDetailsPage(driver) ;

        searchObject.searchForProduct(productName);
        searchObject.openPageResult();
        Assert.assertEquals(searchDetailsObject.breadcrumbSearchedProductName.getText(),productName);
        Assert.assertTrue(searchDetailsObject.priceLabel.getText().contains("€"));


    }


}
