package Test;

import org.testng.annotations.Test;
import java.io.IOException;

public class VerifyUserCanSearchVendors extends BaseClass{
    @Test
    public void login() throws IOException {
        pageFactory.getLoginPage().login();
    }

    @Test(dependsOnMethods = "login")
    public void vendors() {
        pageFactory.getVendorsPage().vendors();
    }
}