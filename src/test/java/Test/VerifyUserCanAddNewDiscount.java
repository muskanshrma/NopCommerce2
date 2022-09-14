package Test;

import org.testng.annotations.Test;
import java.io.IOException;

public class VerifyUserCanAddNewDiscount extends BaseClass {
    @Test
    public void login() throws IOException {
        pageFactory.getLoginPage().login();
    }

    @Test(dependsOnMethods = "login")
    public void discounts() {
        pageFactory.getDiscountsPage().discounts();
    }
}