package Pages;

import org.openqa.selenium.WebDriver;

public class PageFactory {
    WebDriver driver;
    private LoginPage loginPage;
    private DiscountsPage discountsPage;

    public PageFactory(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage(driver);
        }
        return loginPage;
    }
    public DiscountsPage getDiscountsPage() {
        if (discountsPage == null) {
            discountsPage = new DiscountsPage(driver);
        }
        return discountsPage;
    }
}
