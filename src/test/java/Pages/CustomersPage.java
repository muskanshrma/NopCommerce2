package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class CustomersPage {
    WebDriver driver;
    WebDriverWait wait;

    String mail = "victoria_victoria@nopCommerce.com";

    By customers = By.xpath("(//p[contains(text(), 'Customers')])[1]");
    By customerDropdown = By.xpath("(//a[contains(@class,'nav-link')]//p[contains(text(),' Customers')])[1]");
    By email = By.xpath("//input[@name='SearchEmail']");
    By searchButton = By.xpath("//button[contains(@class, 'btn-search')]");
    By logoutButton = By.xpath("//a[contains(text(), 'Logout')]");
    By verifySearch = By.xpath("//td[contains(text(),'victoria_victoria@nopCommerce.com')]");

    public CustomersPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void customers() {
        driver.findElement(customers).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(customerDropdown));
        driver.findElement(customerDropdown).click();
        driver.findElement(email).sendKeys(mail);
        driver.findElement(searchButton).click();

        boolean isResultDisplayed = driver.findElement(verifySearch).isDisplayed();
        Assert.assertTrue(isResultDisplayed, "Unable to search customers");

        driver.findElement(logoutButton).click();
    }
}