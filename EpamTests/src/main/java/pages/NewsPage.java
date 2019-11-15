package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static pages.AbstractPage.initWebBrowser;

public class NewsPage extends HomePage {

    WebDriver driver = initWebBrowser(ConstantVariable.browserName);
    WebElement materials = driver.findElement(By.xpath("//span[contains(text(),\"Materials\")]"));
    List<WebElement> tabsLinksActual= driver.findElements(By.cssSelector("div.tab-nav__item.ng-scope>span.ng-binding"));
    List<WebElement> materialLinksActual= driver.findElements(By.cssSelector("div.news-page-item__title>a.ng-binding"));
    public NewsPage chooseMaterials(){
        materials.click();
        return this;
    }
    public List<String> getListOfTabLinks (){
        List<String> tabs= new ArrayList<>();
        for(int i=0; i<tabsLinksActual.size(); i++) {
            tabs.add( tabsLinksActual.get(i).getText());
        }
       return tabs;
    }

    public List<String> getMaterialLinks (){
        List<String> mater= new ArrayList<>();
        for(int i=0; i<materialLinksActual.size(); i++) {
            mater.add( materialLinksActual.get(i).getText());
        }
        return mater;
    }


}
