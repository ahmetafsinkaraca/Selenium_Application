package testlogger;

import Pages.BasketPage;
import Pages.HomePage;
import Pages.ProductDetailPage;
import Pages.ProductsPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class test_product_process extends basetest{

    HomePage homePage ;
    ProductsPage productsPage ;
    ProductDetailPage productDetailPage ;
    BasketPage basketPage ;

    @Test
    @Order(1)
//    @Disabled("Due to BUG-123 disabled")
    public void search_a_product(){
        homePage = new HomePage(driver);
        homePage.acceptCookies();
        productsPage = new ProductsPage(driver);
        homePage.searchBox().search("jacket");
        Assertions.assertTrue(productsPage.isOnProductPage() ,
                "Not on products page!");
    }

    @Test
    @Order(2)
    public void select_a_product(){
        productDetailPage = new ProductDetailPage(driver);
        productsPage.selectProduct(1);
        Assertions.assertTrue(productDetailPage.isOnProductDetailPage(),
                "Not on product detail page!");
    }

    @Test
    @Order(3)
    public void add_product(){
        productDetailPage.addToBasket();
        Assertions.assertTrue(homePage.isProductCountUp(),
                "Product count did not increase!");
    }

    @Test
    @Order(4)
    public void go_basket(){
        basketPage = new BasketPage(driver);
        homePage.goToBasket();
        Assertions.assertFalse(basketPage.checkIfProductAdded() ,
                "Product was not added to cart!");
    }

    @Test
    @Order(5)
    public void reduce_product(){
        productDetailPage.reduceToBasket();
        Assertions.assertTrue(homePage.isProductCountDown(),
                "Product count did not decrease!");
    }


}
