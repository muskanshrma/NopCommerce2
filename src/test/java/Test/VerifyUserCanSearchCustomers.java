package Test;

import org.testng.annotations.Test;
import java.io.IOException;

public class VerifyUserCanSearchCustomers extends BaseClass{
    @Test
    public void login() throws IOException {
        pageFactory.getLoginPage().login();
    }

    @Test(dependsOnMethods = "login")
    public void customers() {
        pageFactory.getCustomersPage().customers();
    }
}