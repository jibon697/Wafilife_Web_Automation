package pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage{
    public String url = "https://www.wafilife.com/";
    public String pageTitle = "Buy Islamic Books - Online Book Shop in Bangladesh | Wafilife";
    public By myAcc = By.xpath("//a[@title='আমার অ্যাকাউন্ট']");
    public By author = By.xpath("//span[@class='menu-label-level-0'][contains(text(),'লেখক')]");
}
