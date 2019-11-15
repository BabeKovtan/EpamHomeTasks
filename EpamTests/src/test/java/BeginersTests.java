import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.ConstantVariable;
import pages.HomePage;
import pages.NewsPage;
import pages.TrainingListPage;
import pages.pagesBO.AutorizationBO;
import pages.pagesBO.HomeBO;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BeginersTests extends BaseTest {

    BaseTest baseTest;

    public BaseTest getBaseTest() {
        return baseTest;
    }

    //    @Test
//    public void successLogInningByGoogle(){
//        WebDriverWait wait=new WebDriverWait(driver, 20);
//        WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='header-auth__signin']//span")));
//        WebElement mailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.reg-footer-social-item.reg-footer-social-item--google")));
//        WebElement userMail = driver.findElement(By.cssSelector("div.user-info__name"));
//        loginButton.click();
//        mailInput.click();
//        String expected="Beata Kovtan";
//        Assert.assertEquals(userMail.getText(),expected);
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        WebElement logOutButton = driver.findElement(By.xpath("//div[@class=\"user-info__name\"]//parent::a[@class=\"user-info dropdown-toggle\"]"));
//        logOutButton.click();
//        WebElement logOut = driver.findElement(By.xpath("//div[@id='user-info-dropdown-menu']//a[contains(text(),\"Sign out\")]"));
//        logOut.click();
//    }

    @Test
    public void successLogInning() {
        String actual = new HomePage()
                .signIntoSystem()
                .inputMail(ConstantVariable.email)
                .inputPassword(ConstantVariable.password)
                .submitLogIn()
                .getAutorizedUser();
        Assert.assertEquals(actual, "beatka99", String.format("User mail is at top-right corner."));
        new HomePage().getOut();
    }

    @Test
    public void unsuccessLogInning() {
        String actual = new HomePage()
                .signIntoSystem()
                .inputMail(ConstantVariable.wrongEmail)
                .inputPassword(ConstantVariable.password)
                .submitUnsuccessfulLogIn()
                .getAlert();
        String expected = "Login failed. Please try again.";
        Assert.assertEquals(actual, expected, String.format("Alert is shown, user don't logined"));
        new HomePage().getOut();
    }

    @Test
    public void testNewsPage() {
        List<String> tabLinks = new HomePage()
                .signIntoSystem()
                .inputMail(ConstantVariable.email)
                .inputPassword(ConstantVariable.password)
                .submitLogIn()
                .selectNews()
                .chooseMaterials()
                .getListOfTabLinks();
        List<String> linksExpected = new ArrayList<String>();
        linksExpected.add("news");
        linksExpected.add("success stories");
        linksExpected.add("materials");
        linksExpected.add("videos");
        Assert.assertEquals(tabLinks, linksExpected);
        List<String> materialLinksActual = new NewsPage().getMaterialLinks();
        Assert.assertTrue(materialLinksActual.toString().contains("materials"));
        new HomePage().getOut();
    }

    @Test
    public void trainingsSearchField() {

       List<WebElement> javaTrainings= new HomePage()
                .selectEnglish()
                .signIntoSystem()
                .inputMail(ConstantVariable.email)
                .inputPassword(ConstantVariable.password)
                .submitLogIn()
                .selectTrainingsTab()
                .searchBySkills()
                .chooseJavaCheckBox()
                .closeSearch()
                .getListOfTrainings();
        javaTrainings.forEach(element-> Assert.assertTrue(element.getText().contains("JAVA"),String.format("Element %s does not contain 'Java' word.",element)));
        List<WebElement> dataTrainings= new TrainingListPage()
                .searchBySkills()
                .chooseDataCheckBox()
                .getListOfTrainings();
        dataTrainings.forEach(element-> Assert.assertTrue(element.getText().contains("DATA"),String.format("Element %s does not contain 'Data' word.",element)));
        int listSizeOfPascalTrainings= new TrainingListPage()
                .searchBySkills()
                .searchTrainingLike(ConstantVariable.pascal)
                .getListOfTrainings().size();
        Assert.assertEquals(listSizeOfPascalTrainings,0,String.format("There are some pascal trainings."));

//        //TODO wait
//        Actions actions = new Actions(driver);
//        //actions.sendKeys(Keys.ARROW_DOWN).perform();
//
//        //actions.moveToElement(trainingListSearch).perform();
//        WebElement collapseSkillsArrow = driver.findElement(By.xpath("//div[@class='filter-toggle__arrow-icon arrow-icon-rotate']"));
//        actions.moveToElement(driver.findElement(By.className("our-skills"))).perform();//TODO


   }


        @Test
        public void trainingsLocation () {
            List<String> trainingSituation = new HomePage()
                    .selectEnglish()
                    .signIntoSystem()
                    .inputMail(ConstantVariable.email)
                    .inputPassword(ConstantVariable.password)
                    .submitLogIn()
                    .selectTrainingsTab()
                    .searchTraining()
                    .selectUkraine()
                    .selectLviv()
                    .closeSearch()
                    .getListOfTrainingLocations();
            String actual = "Lviv, Ukraine";
            trainingSituation.forEach(element -> Assert.assertTrue(element.contains(actual),
                    String.format("Element %s does not contain 'Lviv, Ukraine' word.", element)));
            new HomePage().getOut();
        }
    @Test
    public void verifyFAQContent () {
        List<WebElement> detailInformation = new HomePage()
                .selectEnglish()
                .signIntoSystem()
                .inputMail(ConstantVariable.email)
                .inputPassword(ConstantVariable.password)
                .submitLogIn()
                .selectFAQ()
                .getDetails()
                .verifyInfo();
        detailInformation.forEach(element -> Assert.assertTrue(element.getText().toUpperCase().contains("EPAM"), String.format("Element %s does not contain 'Epam' word.", element)));

    }
    @Test
    public void verifyAmountOfTheCities () {
        List<Integer> citiesAmount = new HomePage()
                .selectEnglish()
                .signIntoSystem()
                .inputMail(ConstantVariable.email)
                .inputPassword(ConstantVariable.password)
                .submitLogIn()
                .selectAbout()
                .getCitiesCount();
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(6);
        expected.add(2);
        expected.add(10);
        expected.add(5);
        Assert.assertEquals(citiesAmount,expected,String.format("Some Country has not correct amount of cities with Epam offices"));
    }

}
