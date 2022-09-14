package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class VendorsPage {
    WebDriver driver;
    WebDriverWait wait;

    String name = "Vendor 1";
    String mail = "vendor1email@gmail.com";

    By customers = By.xpath("(//p[contains(text(), 'Customers')])[1]");
    By vendor = By.xpath("//ul[contains(@class,'nav-treeview')]//p[contains(text(),'Vendors')]");
    By vendorName = By.xpath("//input[@name='SearchName']");
    By email = By.xpath("//input[@name='SearchEmail']");
    By searchButton = By.xpath("//button[contains(@class, 'btn-search')]");
    By logoutButton = By.xpath("//a[contains(text(), 'Logout')]");
    By verifySearch = By.xpath("//td[contains(text(),'Vendor 1')]");

    public VendorsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void vendors() {
        driver.findElement(customers).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(vendor));
        driver.findElement(vendor).click();
        driver.findElement(vendorName).sendKeys(name);
        driver.findElement(email).sendKeys(mail);
        driver.findElement(searchButton).click();
        boolean isResultDisplayed = driver.findElement(verifySearch).isDisplayed();
        Assert.assertTrue(isResultDisplayed, "Unable to search customers");
        driver.findElement(logoutButton).click();
    }
}