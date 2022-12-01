package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    SearchBox searchBox;
    By basketCountLocator = By.id("nav-cart-count");
    By basketContainerLocator = By.id("nav-cart-count-container");
    By acceptCookiesLocator = By.id("sp-cc-accept");

    public HomePage(WebDriver driver) {
        super(driver);
        searchBox = new SearchBox(driver);
    }

    public SearchBox searchBox() {
        return this.searchBox;
    }

    public boolean isProductCountUp() {
        return getBasketCount() > 0;
    }

    public void goToBasket() {
        click(basketContainerLocator);
    }

    private int getBasketCount() {
        String count = find(basketCountLocator).getText();
        return Integer.parseInt(count);
    }

    public boolean isProductCountDown() { return getBasketCount() > 0;
    }

    public void acceptCookies() {
        if (isDisplayed(acceptCookiesLocator)) {
            click(acceptCookiesLocator);
        }
    }
}
