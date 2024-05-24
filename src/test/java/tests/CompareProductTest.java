package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CompareProducts;
import pages.SearchDetailsPage;
import pages.SearchPage;

public class CompareProductTest extends TestBase {

    // search for product 1 then add to compare list
    // search for product 2 then add to compare list
    // go compare page list and make assertions

    SearchPage searchObject;
    SearchDetailsPage searchDetailsObject;

    CompareProducts compareProductsObject ;

    String productName1 = "Apple MacBook Pro 13-inch";
    String productName2 = "HP Envy 6-1180ca 15.6-Inch Sleekbook";

    @Test

    public void compareProducts() {
        searchObject = new SearchPage(driver);
        searchDetailsObject = new SearchDetailsPage(driver);
        searchObject.searchUsingAutocomplete("Apple");
        Assert.assertEquals(searchDetailsObject.breadcrumbSearchedProductName.getText(), productName1);
        searchDetailsObject.addToCompareProducts();
        searchObject.searchUsingAutocomplete("Envy");
        Assert.assertEquals(searchDetailsObject.breadcrumbSearchedProductName.getText(), productName2);
        searchDetailsObject.addToCompareProducts();
       searchDetailsObject.openComparePage();
        compareProductsObject = new CompareProducts(driver) ;
        compareProductsObject.CompareBetweenProducts();
        Assert.assertTrue(driver.getTitle().contains("nopCommerce demo store. Compare Products"));

    }

}
