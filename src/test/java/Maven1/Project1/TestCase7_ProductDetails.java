package Maven1.Project1;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(ListenersLogic.class)
public class TestCase7_ProductDetails extends BaseClass {
    @Test
    public void verifyProductDetails() {
        HomePage hp = new HomePage(driver);

        hp.searchaprod("Watch");
        hp.clickProduct();
        
      
        ProductPage pp = new ProductPage(driver, Duration.ofSeconds(15));
        switchToNewTab();
        
       
        String price = pp.getProductPrice();
        System.out.println("Price: " + price);

        String reviews = pp.getProductReviews();
        System.out.println("Reviews: " + reviews);

        String title = pp.getProductTitle();
        System.out.println("Title: " + title);

        String desc = pp.getProductDescription();
        System.out.println("Description: " + desc);

       
        Assert.assertFalse(price.isEmpty(), "Price should not be empty");
        Assert.assertFalse(reviews.isEmpty(), "Reviews should not be empty");
        Assert.assertFalse(title.isEmpty(), "Title should not be empty");
        Assert.assertFalse(desc.isEmpty(), "Description should not be empty");
    }
}
