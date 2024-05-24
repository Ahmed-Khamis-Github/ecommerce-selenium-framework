package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SearchDetailsPage;
import pages.SearchPage;

public class SearchTest extends  TestBase{
    SearchPage searchObject ;
    SearchDetailsPage searchDetailsObject ;
    String productName = "Apple MacBook Pro 13-inch";

@Test
    public void searchForProduct()
    {
        searchObject = new SearchPage(driver) ;
        searchDetailsObject= new SearchDetailsPage(driver) ;
        searchObject.searchForProduct(productName);
        searchObject.openPageResult();
        Assert.assertEquals(searchDetailsObject.breadcrumbSearchedProductName.getText(),productName);

    }
}
