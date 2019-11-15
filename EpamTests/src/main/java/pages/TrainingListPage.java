package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static pages.AbstractPage.initWebBrowser;

public class TrainingListPage extends  HomePage{

    WebDriver driver =initWebBrowser(ConstantVariable.browserName);
    WebDriverWait wait=new WebDriverWait(driver, 20);
    WebElement trainingListSearch = driver.findElement(By.name("training-filter-input"));
    WebElement ukraine = driver.findElement(By.cssSelector("div.location__not-active-label.city-name.ng-binding.location__location-active-label.location__location-active-label-country"));
    WebElement lviv = driver.findElement(By.xpath("//li[@class=\"cities ng-scope\"][last()-1]//label//span//preceding-sibling::input[not(contains(@class, 'our-skills'))]"));
    WebElement arrow = driver.findElement(By.cssSelector("div.filter-toggle__arrow-icon.arrow-icon-rotate"));
    List<WebElement> trainingsLocations = driver.findElements(By.xpath("//div[@class='training-list__container training-list__desktop']//div[@class=\"training-item__location ng-binding\"][contains(text(),'Lviv, Ukraine')]"));
    WebElement bySkillsButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'By skills')]")));
    WebElement javaCheckbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(.,'Java')]//span")));
    List<WebElement> skillsSearchResultsList = driver.findElements(By.xpath("//div[@class='training-list__container training-list__desktop']//a"));
    WebElement clearSkill = driver.findElement(By.cssSelector("span.filter-field__input-item-close-icon.filter-field__input-item-close-icon--common"));
    List<WebElement> dataCheckbox = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//label[contains(.,'Data')]//input[contains(@class,\"our-skills\")]//following-sibling::span")));
    WebElement expandSkillsArrow = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("filter-toggle__arrow-icon")));

    public TrainingListPage searchTraining(){
        trainingListSearch.click();
        return this;
    }

    public TrainingListPage searchTrainingLike(String value){
        trainingListSearch.sendKeys(value);
        return this;
    }
    public TrainingListPage selectUkraine(){
        ukraine.click();
        return this;
    }

    public TrainingListPage selectLviv(){
        lviv.click();
        return this;
    }
    public TrainingListPage closeSearch(){
        arrow.click();
        return this;
    }
    public List<String> getListOfTrainingLocations (){
        List<String> tabs= new ArrayList<>();
        for(int i=0; i<trainingsLocations.size(); i++) {
            tabs.add( trainingsLocations.get(i).getText());
        }
        return tabs;
    }
    public TrainingListPage searchBySkills(){
        bySkillsButton.click();
        return this;
    }
    public TrainingListPage chooseJavaCheckBox(){
        javaCheckbox.click();
        return this;
    }

    public List<WebElement> getListOfTrainings (){
        List<WebElement> tabs= new ArrayList<>();
        for(int i=0; i<skillsSearchResultsList.size(); i++) {
            tabs.add( skillsSearchResultsList.get(i));
        }
        return tabs;
    }

    public   TrainingListPage chooseDataCheckBox(){
        dataCheckbox.forEach(WebElement::click);
        return this;
    }


}
