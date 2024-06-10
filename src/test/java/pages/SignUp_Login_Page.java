package pages;

import org.openqa.selenium.By;

public class SignUp_Login_Page extends BasePage{

    public String myAccUrl = "https://www.wafilife.com/my-account";
    public String pageTitle = "আমার অ্যাকাউন্ট";

    // SignUp //
    public By nameInputField = By.xpath("//input[@id='reg_billing_first_name']");
    public By phoneInputField = By.xpath("//input[@id='reg_billing_phone']");
    public By emailInputField = By.xpath("//input[@id='reg_email']");
    public By passInputField = By.xpath("//input[@id='reg_password']");
    public By confirmPassInputField = By.xpath("//input[@id='reg_confirm_password']");
    public By registerBtn = By.xpath("//input[@name='register']");

    // Login //
    public By unameOrEmailInputForLogin = By.cssSelector("#username");
    public By passInputFieldForLogin = By.xpath("//input[@id='password']");
    public By loginBtn = By.xpath("//input[@name='login']");

    // others //
    public By success=By.xpath("//div[@id='template-wrapper']//p[2]");
    public String  successMsg= "From your account dashboard you can view your recent orders, manage your shipping and billing addresses, and edit your password and account details.";

    public By error = By.xpath("//ul[@class='woocommerce-error']");
    public By author = By.xpath("//span[contains(text(),'লেখক')]");
    public By logOutBtn=By.xpath("//a[contains(text(),'লগআউট')]");

    public void makeLogin (String username, String password){
        inputElement(unameOrEmailInputForLogin,username);
        inputElement(passInputFieldForLogin,password);
        clickOnElement(loginBtn);
    }
}
