package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage extends BasePage{

    By addToBasketButtonLocator = By.id("add-to-cart-button");
    By reduceToBasketButtonLocator = new By.ByCssSelector("span.a-declarative");

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnProductDetailPage() {
        return isDisplayed(addToBasketButtonLocator);
    }

    public void addToBasket() { click(addToBasketButtonLocator); }

    public void reduceToBasket() { click(reduceToBasketButtonLocator); }

}
