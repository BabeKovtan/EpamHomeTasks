package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static pages.AbstractPage.initWebBrowser;

public class HomePage {

    WebDriver driver =initWebBrowser(ConstantVariable.browserName);
    WebElement localization = driver.findElement(By.cssSelector("div.location-selector__globe"));
    WebElement signIn = driver.findElement(By.xpath("//p[@class=\"header-auth__signin\"]//span"));
    WebElement ukrainian = driver.findElement(By.xpath("//a[contains(text(),\"English\")]"));
    WebElement trainingList = driver.findElement(By.xpath("ul.main-nav__list a.topNavItem.training.click.hover"));
    WebElement logOutButton = driver.findElement(By.xpath("//div[@class=\"user-info__name\"]//parent::a[@class=\"user-info dropdown-toggle\"]"));
    WebElement logOut = driver.findElement(By.xpath("//div[@id='user-info-dropdown-menu']//a[contains(text(),\"Sign out\")]"));
    WebElement news= driver.findElement(By.cssSelector("a.topNavItem.news.click.hover"));
    WebElement userMail = driver.findElement(By.cssSelector("div.user-info__name"));
    WebElement fAQ = driver.findElement(By.cssSelector("ul.main-nav__list a.topNavItem.faq.click.hover"));
    WebElement about = driver.findElement(By.cssSelector("ul.main-nav__list a.topNavItem.about.click.hover"));
    public HomePage selectEnglish(){
        localization.click();
        ukrainian.click();
        return this;
    }

    public AutorizationPage signIntoSystem(){
        signIn.click();
        return new AutorizationPage();
    }

    public String getAutorizedUser(){
        return userMail.getText();
    }
    public AutorizationPage getOut(){
        logOutButton.click();
        logOut.click();
        return new AutorizationPage();
    }

    public NewsPage selectNews(){
        news.click();
        return new NewsPage();
    }
    public TrainingListPage selectTrainingsTab(){
        trainingList.click();
        return new TrainingListPage();
    }
    public AboutPage selectAbout(){
        about.click();
        return new AboutPage();
    }
    public FAQPage selectFAQ(){
        fAQ.click();
        return new FAQPage();
    }
}
