package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.BrowserSetup;

public class TestHomePage extends BrowserSetup {
    HomePage homepage = new HomePage();
    @Test(description = "Testing HomePage of Wafilife")
    public void TestHomePageUrl() throws InterruptedException {
        getBrowser().get(homepage.url);
        homepage.addScreenshotToReport("After Entering the Website Home Page");
        Assert.assertEquals(getBrowser().getCurrentUrl(),"https://www.wafilife.com/");
        Assert.assertEquals(getBrowser().getTitle(),"Buy Islamic Books - Online Book Shop in Bangladesh | Wafilife");
        homepage.clickOnElement(homepage.myAcc);
        Thread.sleep(2000);
        homepage.addScreenshotToReport("After Enter Register or Login Page");
    }
}
