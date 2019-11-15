package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static pages.AbstractPage.initWebBrowser;

public class AboutPage extends HomePage {

    WebDriver driver = initWebBrowser(ConstantVariable.browserName);
    List<WebElement> epamsCountries= driver.findElements(By.cssSelector("ul.countries-list"));
    List<WebElement> epamsCities= driver.findElements(By.cssSelector("ul.cities-list"));
    public   List<Integer> getCitiesCount(){
        List<Integer> amountOfCities= new ArrayList<>();
        for(int i=0; i<epamsCountries.size(); i++) {
            epamsCountries.get(i).click();
            amountOfCities.add(epamsCities.size());
        }

        return amountOfCities;
    }
}
