package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static config.PropertyReader.getLocator;

public class MainSearchPage {
    private WebDriver driver;
    private By searchField = getLocator("MainSearchPage.searchField");
    private By searchBtn = getLocator("MainSearchPage.searchBtn");

    public MainSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public AllSearchResultsPage searchByText(String text){
        driver.findElement(searchField).clear();
        driver.findElement(searchField).sendKeys(text);
        driver.findElement(searchBtn).click();

        return new AllSearchResultsPage(driver);
    }

}
