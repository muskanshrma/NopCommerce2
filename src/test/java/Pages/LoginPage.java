package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
        WebDriver driver;

        By submit = By.xpath("//button[@type='submit']");

        public LoginPage(WebDriver driver) {
            this.driver = driver;
        }

        public void login() {
            driver.manage().window().maximize();
            driver.findElement(submit).click();
        }
}
