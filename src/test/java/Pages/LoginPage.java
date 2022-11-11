package Pages;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class LoginPage {
    WebDriver driver;

    By username = By.xpath("//input[@name='Email']");
    By loginPassword = By.xpath("//input[@class='password']");
    By loginButton = By.xpath("//button[@type='submit']");
    By homePageVerify = By.xpath("(//div[contains(@class, 'header')])[1]");
    By menu = By.xpath("//input[@name='Email']");
    List<WebElement> menuItems;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login() throws IOException {
        String path = System.getProperty("user.dir") + "//src//test//java//TestData//nopCommLogin.xlsx";
        FileInputStream prop1 = null;
        try {
            prop1 = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        XSSFWorkbook wb = new XSSFWorkbook(prop1);
        XSSFSheet sheet = wb.getSheet("Sheet1");
        String email = sheet.getRow(1).getCell(0).getStringCellValue();
        String password = sheet.getRow(1).getCell(1).getStringCellValue();
        driver.findElement(username).clear();
        driver.findElement(loginPassword).clear();
        driver.findElement(username).sendKeys(email);
        driver.findElement(loginPassword).sendKeys(password);
        driver.findElement(loginButton).click();
        boolean isResultDisplayed = driver.findElement(homePageVerify).isDisplayed();
        org.testng.Assert.assertTrue(isResultDisplayed, "Login error");

        menuItems = driver.findElements(menu);
        for(WebElement allElements:menuItems)
        {
            String StrLinkText=allElements.getText();
            System.out.println(StrLinkText);
        }
    }
}