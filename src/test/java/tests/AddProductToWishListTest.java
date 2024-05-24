package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SearchDetailsPage;
import pages.SearchPage;
import pages.WishList;

public class AddProductToWishListTest extends TestBase{

    SearchPage searchObject ;
    SearchDetailsPage searchDetailsObject ;
    WishList wishListObject ;
    String productName = "HTC One M8 Android L 5.0 Lollipop";

    @Test(priority = 1)
    public void SearchUsingAutocomplete()
    {
        searchObject= new SearchPage(driver) ;
        searchDetailsObject= new SearchDetailsPage(driver) ;
        searchObject.searchUsingAutocomplete("HTC ");
        Assert.assertEquals(searchDetailsObject.breadcrumbSearchedProductName.getText(),productName);
    }

    @Test(priority = 2)
    public  void UserCanAddToWishList()
    {
        searchDetailsObject.addToWishList();
        Assert.assertTrue(searchDetailsObject.addedSuccessfullyAlert.getText().contains("The product has been added to your"));
        searchDetailsObject.openWishListPage();
        Assert.assertTrue(driver.getCurrentUrl().contains("wishlist"));


    }

    @Test(priority = 3)
    public void removeFromWishList()
    {
        wishListObject = new WishList(driver) ;
        wishListObject.removeFromWishList();
        Assert.assertTrue(wishListObject.noDATAiNWishListAlert.getText().contains("The wishlist is empty!"));
    }

}
