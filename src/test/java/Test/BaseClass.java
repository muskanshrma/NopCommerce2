package Test;

import Pages.PageFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseClass {
    protected static PageFactory pageFactory;
    static WebDriver driver;

    @Parameters("browserName")
    @BeforeClass
    public static void setup(String browserName) throws MalformedURLException {
        if (browserName.equalsIgnoreCase("chrome")) {
            driver = WebDriverManager.chromedriver().create();
            driver.manage().window().maximize();
            driver.navigate().to("https://admin-demo.nopcommerce.com");
            pageFactory = new PageFactory(driver);

        }
//        else if (browserName.equalsIgnoreCase("firefox")) {
//            driver = WebDriverManager.firefoxdriver().create();
//            driver.manage().window().maximize();
//            driver.navigate().to("https://admin-demo.nopcommerce.com");
//            pageFactory = new PageFactory(driver);
//        }
    }
    public void failed() {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(srcFile, new File("C:\\Users\\MuskanSharma\\IdeaProjects\\NopComm\\src\\test\\java\\Failure_Screenshots\\Test"+Math.random()+".jpg"));

            System.out.println("ss taken");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public static void close() {
        driver.close();
    }
}