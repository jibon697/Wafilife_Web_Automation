package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BrowserSetup {
    private static final String browserName = System.getProperty("browser", "Chrome");
    private static final ThreadLocal<WebDriver> LOCAL_BROWSER = new ThreadLocal<>();

    public static void setBrowser(WebDriver driver) {
        BrowserSetup.LOCAL_BROWSER.set(driver);
    }

    public static WebDriver getBrowser() {
        return LOCAL_BROWSER.get();
    }

    public static WebDriver getBrowser(String browserName) {
        if (browserName.equalsIgnoreCase("Chrome")) {
            return new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("Firefox")) {
            return new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("Edge")) {
            return new EdgeDriver();
        } else {
            throw new RuntimeException("Browser not found with this given browser name: " + browserName);
        }
    }
    @BeforeMethod
    public static synchronized void startBrowser(){
        WebDriver browser = getBrowser(browserName);
        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        browser.manage().window().maximize();
        setBrowser(browser);
    }
    @AfterMethod
    public static synchronized void quitBrowser(){
        getBrowser().quit();
    }
}

