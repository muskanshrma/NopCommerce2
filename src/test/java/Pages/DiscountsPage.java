package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class DiscountsPage {
    WebDriver driver;
    WebDriverWait wait;

    String newDiscount = "Discount1";

    By promotions = By.xpath("//p[contains(text(), 'Promotions')]");
    By discounts = By.xpath("//a[contains(@class,'nav-link')]//p[contains(text(),'Discounts')]");
    By addNew = By.xpath("//a[contains(@class, 'btn-primary')]");
    By name = By.xpath("//input[@name='Name']");
    By saveButton = By.xpath("//button[@name='save']");
    By logoutButton = By.xpath("//a[contains(text(), 'Logout')]");

    public DiscountsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void discounts() {
        driver.findElement(promotions).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(discounts));
        driver.findElement(discounts).click();
        driver.findElement(addNew).click();
        driver.findElement(name).sendKeys(newDiscount);
        driver.findElement(saveButton).click();
        driver.findElement(logoutButton).click();
    }
}