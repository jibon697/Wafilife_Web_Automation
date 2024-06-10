package pages;

import com.github.javafaker.Faker;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BrowserSetup;

import java.io.ByteArrayInputStream;
import java.time.Duration;
import java.util.Locale;

public class BasePage extends BrowserSetup {
    public WebDriverWait wait;
    public WebElement getElement(By locator) {
        return waitForElementPresence(locator);
    }
    public void inputElement(By locator, String text) {
        getElement(locator).clear();
        getElement(locator).sendKeys(text);
    }
    public void clickOnElement(By locator){
        getElement(locator).click();
    }
    public String getElementText(By locator) {
        return getElement(locator).getText();
    }
    public boolean isElementVisible(By locator) {
        try {
            return getElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public WebElement waitForElementPresence(By locator) {
        wait = new WebDriverWait(getBrowser(), Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));

    }
    public void waitForElementClickable(By locator) {
        wait = new WebDriverWait(getBrowser(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(locator));

    }
    public void selectWithVisibleText(By selectlocator, String visibleText) {
        Select select = new Select(getElement(selectlocator));
        select.selectByVisibleText(visibleText);
    }
    public void selectWithValue(By locator,String value){
        Select select=new Select(getElement(locator));
        select.selectByValue(value);
    }
    public void selectByIndex(By locator,int index){
        Select select=new Select(getElement(locator));
        select.selectByIndex(index);
    }
    public void scrollToElement(By locator) {
        Actions actions = new Actions(getBrowser());
        waitForElementClickable(locator);
        actions.scrollToElement(getElement(locator)).build().perform();
    }
    public void scrollByAmount(int x,int y){
        Actions actions=new Actions(getBrowser());
        actions.scrollByAmount(x,y);
    }

    public void hover(By locator) {
        Actions actions = new Actions(getBrowser());
        actions.clickAndHold(getElement(locator)).build().perform();
    }
    public void addScreenshotToReport(String name) {
        Allure.addAttachment(name, new ByteArrayInputStream(((TakesScreenshot) getBrowser()).getScreenshotAs(OutputType.BYTES)));
    }
    public void back(){
        getBrowser().navigate().back();
    }
    public void refresh(){
        getBrowser().navigate().refresh();
    }
    public Faker faker = new Faker(new Locale("en-US"));

    public String randomEmail() {
        return faker.bothify("demo_?????##@gmai.com");
    }
    public String randomPhoneNumber() {
        return faker.numerify("01100000###");
    }

    public String randomFirstName() {
        return faker.name().fullName();
    }

}
