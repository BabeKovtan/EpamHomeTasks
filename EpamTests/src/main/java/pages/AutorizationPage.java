package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static pages.AbstractPage.initWebBrowser;

public class AutorizationPage{
    WebDriver driver =initWebBrowser(ConstantVariable.browserName);

    WebElement mailInput = driver.findElement(By.id("signInEmail"));
    WebElement passwordInput = driver.findElement(By.id("signInPassword"));
    WebElement signInButton = driver.findElement(By.className("popup-reg-sign-in-form__sign-in"));
    WebElement alert = driver.findElement(By.cssSelector("div.popup__error-message.ng-binding"));

    public AutorizationPage inputMail( String mail)
    {
        mailInput.sendKeys(mail);
        return this;
    }
    public AutorizationPage inputPassword(String password){
        passwordInput.sendKeys(password);
        return this;
    }
    public HomePage submitLogIn(){
        signInButton.click();
        return new HomePage();
    }

    public AutorizationPage submitUnsuccessfulLogIn(){
        signInButton.click();
        return this;
    }

    public String getAlert(){
        return alert.getText();
    }

}
