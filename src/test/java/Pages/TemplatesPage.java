package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class TemplatesPage {
    WebDriver driver;
    WebDriverWait wait;

    String mail = "victoria_victoria@nopCommerce.com";
    String templateName = "template name";
    String path = "template path";

    By system = By.xpath("(//p[contains(text(), 'System')])[1]");
    By submenuTemplates = By.xpath("(//a[contains(@class,'nav-link')]//p[contains(text(),'Templates')])[1]");
    By name = By.xpath("//input[@name='AddCategoryTemplate.Name']");
    By viewPath = By.xpath("///input[@name='AddCategoryTemplate.ViewPath']");
    By addButton = By.xpath("(//button[contains(text(), 'Add new')])[1]");
    By deleteButton = By.xpath("(//a[contains(text(), 'Delete')])[1]");
    By logoutButton = By.xpath("//a[contains(text(), 'Logout')]");



    public TemplatesPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void templates() {
        driver.findElement(system).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(submenuTemplates));
        driver.findElement(submenuTemplates).click();
        driver.findElement(name).sendKeys(templateName);
        driver.findElement(viewPath).sendKeys(path);
        driver.findElement(addButton).click();
        driver.findElement(deleteButton).click();
        driver.switchTo().alert().accept();

        driver.findElement(logoutButton).click();
    }
}