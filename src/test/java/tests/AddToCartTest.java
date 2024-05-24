package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddToCart;
import pages.SearchDetailsPage;
import pages.SearchPage;

public class AddToCartTest extends  TestBase{

    SearchPage searchObject ;
    SearchDetailsPage searchDetailsObject ;

    AddToCart addToCartObject ;
    String productName = "Apple MacBook Pro 13-inch";

    @Test(priority = 1)
    public void SearchUsingAutocomplete()
    {
        searchObject= new SearchPage(driver) ;
        searchDetailsObject= new SearchDetailsPage(driver) ;
        searchObject.searchUsingAutocomplete("Apple");
        Assert.assertEquals(searchDetailsObject.breadcrumbSearchedProductName.getText(),productName);
    }

    @Test(priority = 2)

    public void addToCart()
    {
        addToCartObject = new AddToCart(driver) ;
        searchDetailsObject.addToCart();
        searchDetailsObject.openAddToCartPage();
        addToCartObject.UpdateCartQuantity();
        Assert.assertEquals(addToCartObject.subTotal.getText(),"$9,000.00");

    }

    @Test(priority = 3)

    public  void removeFromCart()
    {
        addToCartObject.RemoveFromCart();
        Assert.assertTrue(addToCartObject.noDataAlert.getText().contains("Your Shopping Cart is empty!"));
    }
}
