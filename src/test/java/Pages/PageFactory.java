package Pages;

import org.openqa.selenium.WebDriver;

public class PageFactory {
    WebDriver driver;

    private LoginPage loginPage;
    private DiscountsPage discountsPage;
    private CampaignsPage campaignsPage;
    private CustomersPage customersPage;
    private VendorsPage vendorsPage;
    private TemplatesPage templatesPage;

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

    public CampaignsPage getCampaignsPage() {
        if (campaignsPage == null) {
            campaignsPage = new CampaignsPage(driver);
        }
        return campaignsPage;
    }

    public CustomersPage getCustomersPage() {
        if (customersPage == null) {
            customersPage = new CustomersPage(driver);
        }
        return customersPage;
    }

    public VendorsPage getVendorsPage() {
        if (vendorsPage == null) {
            vendorsPage = new VendorsPage(driver);
        }
        return vendorsPage;
    }
    public TemplatesPage getTemplatesPage() {
        if (templatesPage == null) {
            templatesPage = new TemplatesPage(driver);
        }
        return templatesPage;
    }
}