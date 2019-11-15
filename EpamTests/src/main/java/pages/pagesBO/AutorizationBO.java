package pages.pagesBO;

import org.testng.Assert;
import pages.AbstractPage;
import pages.AutorizationPage;
import pages.ConstantVariable;
import pages.HomePage;

import java.util.ConcurrentModificationException;

public class AutorizationBO  {
    AutorizationPage autorizationPage;
    HomePage homePage ;
    public void successfulLogIn(){
        autorizationPage.inputMail(ConstantVariable.email);
        autorizationPage.inputPassword(ConstantVariable.password);
        autorizationPage.submitLogIn();
        homePage.getAutorizedUser();
        Assert.assertEquals(homePage.getAutorizedUser(),"beatka99",String.format("User mail is at top-right corner."));
    }

    public void unsuccessfulLogIn(){
        autorizationPage.inputMail(ConstantVariable.wrongEmail);
        autorizationPage.inputPassword(ConstantVariable.password);
        autorizationPage.submitLogIn();
        autorizationPage.getAlert();
        //Assert.assertEquals();
    }
}
