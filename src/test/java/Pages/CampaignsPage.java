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

    String newCampaignName = "campaign 1";
    String campaignSubject = "campaign 1 subject";
    String campaignBody = "campaign 1 body";

    By promotions = By.xpath("//p[contains(text(), 'Promotions')]");
    By campaigns = By.xpath("//a[contains(@class,'nav-link')]//p[contains(text(),'Campaigns')]");
    By addNew = By.xpath("//a[contains(@class, 'btn-primary')]");
    By name = By.xpath("//input[@name='Name']");
    By subject = By.xpath("//input[@name='Subject']");
    By body = By.xpath("//textarea[@name='Body']");
//    By saveButton = By.xpath("//button[@name='save']");
    By saveButton = By.xpath("//button");
    By verifyCampaign = By.xpath("//td[contains(text(),'campaign 1')]");
    By logoutButton = By.xpath("//a[contains(text(), 'Logout')]");

    public CampaignsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void campaigns() {
        driver.findElement(promotions).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(campaigns));
        driver.findElement(campaigns).click();
        driver.findElement(addNew).click();
        driver.findElement(name).sendKeys(newCampaignName);
        driver.findElement(subject).sendKeys(campaignSubject);
        driver.findElement(body).sendKeys(campaignBody);
        driver.findElement(saveButton).click();
        boolean isResultDisplayed = driver.findElement(verifyCampaign).isDisplayed();
        Assert.assertTrue(isResultDisplayed, "Campaign is not added");
        driver.findElement(logoutButton).click();
    }
}