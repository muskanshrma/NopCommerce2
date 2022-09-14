package Test;

import org.testng.annotations.Test;
import java.io.IOException;

public class LoginPageTest extends BaseClass {

    @Test
    public void login() throws IOException {
        pageFactory.getLoginPage().login();
    }
}