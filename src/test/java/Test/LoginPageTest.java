package Test;

import org.testng.annotations.Test;

public class LoginPageTest extends BaseClass {

    @Test(priority = 1)
    public void login() {
        pageFactory.getLoginPage().login();
    }
}
