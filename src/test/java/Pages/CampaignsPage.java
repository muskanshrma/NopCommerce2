package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class CampaignsPage {
    WebDriver driver;
    WebDriverWait wait;
    By promotions = By.xpath("//*[contains(text(), 'Promotions')]");
    By addNew = By.xpath("//div[@class='float-right']");
    By name = By.xpath("//input[@name='Name']");
    By subject = By.xpath("//input[@name='Subject']");
    By body = By.xpath("//textarea[@name='Body']");
    By saveButton = By.xpath("(//button[@type='submit'])[2]");
    By logoutButton = By.xpath("//*[contains(text(), 'Logout')]");

    public CampaignsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void campaigns() {
        driver.findElement(promotions).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Campaigns')]")));
        driver.findElement(By.xpath("//*[contains(text(), 'Campaigns')]")).click();
        driver.findElement(addNew).click();
        driver.findElement(name).sendKeys("test name");
        driver.findElement(subject).sendKeys("test subject");
        driver.findElement(body).sendKeys("test body");
        driver.findElement(saveButton).click();

        boolean isResultDisplayed = driver.findElement(By.xpath(("//*[contains(text(),'test name')]"))).isDisplayed();
        Assert.assertTrue(isResultDisplayed, "Campaign is not added");

        driver.findElement(logoutButton).click();
    }

}
