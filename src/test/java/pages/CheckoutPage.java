package pages;

import org.openqa.selenium.By;

public class CheckoutPage extends BasePage{
    public  String checkoutUrl = "https://www.wafilife.com/checkout";
    public String pageTitle = "Checkout";
    public By alternatePhone = By.xpath("//input[@id='billing_alternative_phone']");
    public By zilla = By.cssSelector("#select2-billing_state-container");
    public By upazilla = By.xpath("//select[@id='billing_area']");
    public By addressField = By.cssSelector("#billing_address_1");
    public By placeOrderBtn = By.xpath("//button[@id='place_order']");
    public By myAcc = By.xpath("//div[@class='login-links']//a[@title='আমার অ্যাকাউন্ট'][contains(text(),'আমার অ্যাকাউন্ট')]");

}
