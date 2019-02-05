package tests;

import drivers.Driver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageObjects.AllSearchResultsPage;
import pageObjects.MainSearchPage;

import static config.PropertyReader.getData;


public class GoogleSearchTest {
    protected WebDriver driver;

    @Before
    public void initDriverAndOpenMainPage(){
        driver = Driver.initChromeDriver();
    }

    @Test
    public void updateClientTest() {
        driver.get("https://www.google.com");
        AllSearchResultsPage allSearchResultsPage = new MainSearchPage(driver).searchByText(getData("MainSearchPage.testText"));
        String title = allSearchResultsPage.getTitle();
        Assert.assertTrue(title.contains(getData("MainSearchPage.testText")));
    }

    @After
    public void closeDriver() {
        driver.close();
    }

}
