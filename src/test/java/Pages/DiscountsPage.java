package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DiscountsPage {
    WebDriver driver;
    WebDriverWait wait;
    By promotions = By.xpath("//*[contains(text(), 'Promotions')]");
    By addNew = By.xpath("//div[@class='float-right']");
    By name = By.xpath("//input[@name='Name']");
    By saveButton = By.xpath("(//button[@type='submit'])[2]");
    By logoutButton = By.xpath("//*[contains(text(), 'Logout')]");

    public DiscountsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void discounts() {
        driver.findElement(promotions).click();
        driver.findElement(By.xpath("//*[contains(text(), 'Discounts')]")).click();
        driver.findElement(addNew).click();
        driver.findElement(name).sendKeys("test");
        driver.findElement(saveButton).click();
        driver.findElement(logoutButton).click();
    }

}

