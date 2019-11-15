package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

import static pages.AbstractPage.initWebBrowser;

public class FAQPage extends HomePage {

    WebDriver driver =initWebBrowser(ConstantVariable.browserName);
    List<WebElement> openerList = driver.findElements(By.cssSelector("div.accordion-item__opener"));
    List<WebElement> detailInformation = driver.findElements(By.cssSelector("article.accordion-item__answer.ng-binding"));
    public FAQPage getDetails() {
        openerList.forEach(WebElement::click);
        return this;
    }
    public List<WebElement> verifyInfo() {
        return detailInformation;
    }

}
