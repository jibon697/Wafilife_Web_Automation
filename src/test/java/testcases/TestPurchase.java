package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import utilities.BrowserSetup;

public class TestPurchase extends BrowserSetup {
    HomePage homePage = new HomePage();
    SignUp_Login_Page signUp_login_page = new SignUp_Login_Page();
    ProductPage productPage = new ProductPage();
    RajibulIslam_author_page rajibulIslam_author_page = new RajibulIslam_author_page();
    AuthorPage authorPage = new AuthorPage();
    CheckoutPage checkoutPage = new CheckoutPage();

    @BeforeMethod
    @Test
    public void navigateToHomepage(){
        getBrowser().get(homePage.url);
        homePage.clickOnElement(homePage.myAcc);
        signUp_login_page.makeLogin("jibon@mailto.plus","1234Aa@");
    }
    @Test
    public void testPurchaseBook() throws InterruptedException {
        signUp_login_page.clickOnElement(homePage.author);
        authorPage.addScreenshotToReport("After Enter Author Page");
        Assert.assertEquals(getBrowser().getCurrentUrl(),authorPage.authorPageUrl);
        Assert.assertEquals(getBrowser().getTitle(),authorPage.authorPageTittle);
        Thread.sleep(3000);
        authorPage.clickOnElement(authorPage.nextPageBtn);
        authorPage.addScreenshotToReport("After click on NextPage Button");
        Thread.sleep(3000);
        authorPage.scrollToElement(authorPage.rajibulIslam);
        Thread.sleep(3000);
        authorPage.clickOnElement(authorPage.rajibulIslam);
        rajibulIslam_author_page.addScreenshotToReport("After Enter to Rajibul Islam Page");
        Assert.assertEquals(getBrowser().getCurrentUrl(),rajibulIslam_author_page.pageUrl);
        Assert.assertEquals(getBrowser().getTitle(),rajibulIslam_author_page.pageTitle);
        Thread.sleep(3000);
        rajibulIslam_author_page.clickOnElement(rajibulIslam_author_page.product);
        productPage.addScreenshotToReport("After click on product (Book)");
        Thread.sleep(3000);
        productPage.clickOnElement(productPage.orderBtn);
        productPage.addScreenshotToReport("After click on Order Button");
        Thread.sleep(3000);
        productPage.clickOnElement(productPage.checkoutBtn);
        checkoutPage.addScreenshotToReport("After Enter Checkout Page");
        Assert.assertEquals(getBrowser().getCurrentUrl(),checkoutPage.checkoutUrl);
        Assert.assertEquals(getBrowser().getTitle(),checkoutPage.pageTitle);
        checkoutPage.inputElement(checkoutPage.alternatePhone, "11223344550");
        try {
            checkoutPage.selectWithVisibleText(checkoutPage.upazilla, "ধানমন্ডি");
        } catch (StaleElementReferenceException st){
            checkoutPage.selectWithVisibleText(By.xpath("//select[@id='billing_area']"), "ধানমন্ডি");
        }
        checkoutPage.inputElement(checkoutPage.addressField, "27, 8/9 Road");
        Thread.sleep(3000);
        checkoutPage.addScreenshotToReport("After fill up checkout form");
        checkoutPage.clickOnElement(checkoutPage.myAcc);
        Thread.sleep(2000);
        signUp_login_page.clickOnElement(signUp_login_page.logOutBtn);
        signUp_login_page.addScreenshotToReport("After click on Logout button");
        Assert.assertEquals(getBrowser().getCurrentUrl(),signUp_login_page.myAccUrl);
        Assert.assertEquals(getBrowser().getTitle(),signUp_login_page.pageTitle);


    }
}
