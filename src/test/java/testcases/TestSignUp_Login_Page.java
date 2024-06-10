package testcases;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SignUp_Login_Page;
import utilities.BrowserSetup;
import utilities.DataSet;

public class TestSignUp_Login_Page extends BrowserSetup {
    HomePage homePage = new HomePage();
    SignUp_Login_Page signUp_login_page = new SignUp_Login_Page();
    @BeforeMethod
    public void navigateToLoginPage(){
        getBrowser().get(signUp_login_page.myAccUrl);
    }
    @Test
    public void testSignup() throws InterruptedException {
        homePage.clickOnElement(homePage.myAcc);
        signUp_login_page.inputElement(signUp_login_page.nameInputField,signUp_login_page.randomFirstName());
        signUp_login_page.inputElement(signUp_login_page.phoneInputField,signUp_login_page.randomPhoneNumber());
        signUp_login_page.inputElement(signUp_login_page.emailInputField,signUp_login_page.randomEmail());
        signUp_login_page.inputElement(signUp_login_page.passInputField,"1234Asd@");
        signUp_login_page.inputElement(signUp_login_page.confirmPassInputField,"1234Asd@");
        Thread.sleep(2000);
        signUp_login_page.addScreenshotToReport("After Fill up Registration data");
        signUp_login_page.clickOnElement(signUp_login_page.registerBtn);
        signUp_login_page.addScreenshotToReport("After Complete Registration Successfully");
        Assert.assertEquals(signUp_login_page.getElementText(signUp_login_page.success),signUp_login_page.successMsg);
        Assert.assertEquals(getBrowser().getTitle(),signUp_login_page.pageTitle);
        Assert.assertTrue(signUp_login_page.isElementVisible(signUp_login_page.success));
//        Thread.sleep(5000);
    }
    @Test(priority = 0, description = "User Login Test With Valid Data")
    @Description ("Testing User Login with valid data")
    @Epic("Web Interface")
    @Feature("Essential Features")
    @Story("Authentication")
    public void loginTestWithValidData() throws InterruptedException {
        signUp_login_page.inputElement(signUp_login_page.unameOrEmailInputForLogin,"jibon@mailto.plus");
        signUp_login_page.inputElement(signUp_login_page.passInputFieldForLogin,"1234Aa@");
        Thread.sleep(2000);
        signUp_login_page.addScreenshotToReport("After Entering valid Login Data");
        signUp_login_page.clickOnElement(signUp_login_page.loginBtn);
        signUp_login_page.addScreenshotToReport("After Login with valid data input");
        Assert.assertEquals(signUp_login_page.getElementText(signUp_login_page.success),signUp_login_page.successMsg);
        Assert.assertEquals(getBrowser().getTitle(),signUp_login_page.pageTitle);
        Assert.assertTrue(signUp_login_page.isElementVisible(signUp_login_page.success));

    }
    @Test(dataProvider = "invalidData", dataProviderClass = DataSet.class, priority = 1, description = "User Login Test with Invalid Data")
    @Description("Testing Login with invalid data")
    public void loginTestWithInvalidData(String username, String password, String errorMsg) throws InterruptedException {
        signUp_login_page.inputElement(signUp_login_page.unameOrEmailInputForLogin,username);
        signUp_login_page.inputElement(signUp_login_page.passInputFieldForLogin,password);
        Thread.sleep(2000);
        signUp_login_page.clickOnElement(signUp_login_page.loginBtn);
        signUp_login_page.addScreenshotToReport("After input Invalid login data");
        Assert.assertEquals(signUp_login_page.getElementText(signUp_login_page.error),errorMsg);
    }

}
