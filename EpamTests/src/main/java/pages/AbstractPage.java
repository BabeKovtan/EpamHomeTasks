package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AbstractPage {
    private static WebDriver driver;

    private AbstractPage() {
    }

    public static WebDriver initWebBrowser(String browserName) {
        if (null == driver) {
            if (browserName.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", "D://ChromeDriver/chromedriver.exe");
                driver = new ChromeDriver();
            } else if (browserName.equalsIgnoreCase("Firefox")) {
                System.setProperty("webdriver.gecko.driver", "F:\\Photon_Workspace\\SingletonPracticeProject\\Drivers\\geckodriver.exe");
                driver = new FirefoxDriver();
            } else if (browserName.equalsIgnoreCase("IE")) {
                System.setProperty("webdriver.edge.driver", "F:\\Photon_Workspace\\SingletonPracticeProject\\Drivers\\MicrosoftWebDriver.exe");
                driver = new EdgeDriver();
            }
        }
        return driver;

    }


    public void openUrl(String URL) {
        driver.get(URL);
    }


    public void closeWebBrowser() {
        if (null != driver) {
            driver.quit();
        }
        driver = null;
    }
}
