package Test;

import org.testng.annotations.Test;

public class VerifyUserCanAddNewCampaign extends BaseClass{
    @Test(priority = 1)
    public void login() {
        pageFactory.getLoginPage().login();
    }

    @Test(priority = 2)
    public void campaigns() {
        pageFactory.getCampaignsPage().campaigns();
    }
}
