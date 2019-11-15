package pages.pagesBO;

import org.testng.Assert;
import pages.AutorizationPage;
import pages.HomePage;

public class HomeBO extends HomePage {



    public HomePage verifyAutorization(HomePage homePage){

        String expected="beatka99";
        Assert.assertEquals(homePage.getAutorizedUser(),expected,String.format("User mail is at top-right corner."));
        return this;
    }


}
