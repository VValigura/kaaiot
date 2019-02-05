package pageObjects;

import org.openqa.selenium.WebDriver;

public class AllSearchResultsPage {
    private WebDriver driver;

    public AllSearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle(){
        return driver.getTitle();
    }



}
