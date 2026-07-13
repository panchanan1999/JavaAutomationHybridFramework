package com.ea.test.Features.SeleniumTest;

import com.ea.test.Pages.Homepage;
import ea.framework.base.DriverContext;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HomePageTest {
    @Before
    public void Inialize()
    {
        System.setProperty("webdriver.gecko.driver", "D:\\drivers\\webdrivers\\geckodriver\\geckodriver.exe");
        DriverContext.Driver =new FirefoxDriver();
        DriverContext.Driver.navigate().to("http://eaapp.somee.com/");
    }
    @Test
    public void HomePageTest1()
    {
        Homepage page=new Homepage();
        String title=DriverContext.Driver.getTitle();
        System.out.println("Title of the page is: "+title);
        //page.HomePageValidation();
    }
}
