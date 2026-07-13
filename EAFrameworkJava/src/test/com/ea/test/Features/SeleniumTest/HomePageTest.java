package com.ea.test.Features.SeleniumTest;

import com.ea.test.Pages.Homepage;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HomePageTest {
    private WebDriver _driver=null;

    @Before
    public void Inialize()
    {
        System.setProperty("webdriver.gecko.driver", "D:\\drivers\\webdrivers\\geckodriver\\geckodriver.exe");
        _driver=new FirefoxDriver();
        _driver.navigate().to("https://automationteststore.com/index.php");
    }
    @Test
    public void HomePageTest1()
    {
        Homepage page=new Homepage(_driver);
        String title=_driver.getTitle();
        System.out.println("Title of the page is: "+title);
        page.HomePageValidation();
    }
}
