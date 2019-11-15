import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pages.AbstractPage;
import pages.ConstantVariable;

import static pages.AbstractPage.initWebBrowser;

public class BaseTest {

    private WebDriver driver;
    @BeforeSuite
    public void setup(){
    ;
        driver=initWebBrowser(ConstantVariable.browserName);
        driver.manage().window().maximize();
        driver.get(ConstantVariable.URl);
    }

    @AfterSuite
    public void tearDown() {
        if(driver!=null)
        driver.quit();
    }
}
