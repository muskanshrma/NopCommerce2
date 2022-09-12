package Test;

import Pages.PageFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
    protected static PageFactory pageFactory;
    static WebDriver driver;

    @Parameters("browserName")
    @BeforeClass
    public static void setup(String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            driver = WebDriverManager.chromedriver().create();
            driver.manage().window().maximize();
            driver.navigate().to("https://admin-demo.nopcommerce.com");
            pageFactory = new PageFactory(driver);
        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver = WebDriverManager.firefoxdriver().create();
            driver.manage().window().maximize();
            driver.navigate().to("https://admin-demo.nopcommerce.com");
            pageFactory = new PageFactory(driver);
        }
    }

    @AfterClass
    public static void close() {
        driver.close();
    }
}

