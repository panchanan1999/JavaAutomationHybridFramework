package com.ea.test.Features.SeleniumTest;

import com.ea.test.Pages.Homepage;
import com.ea.test.Pages.LoginPage;
import ea.framework.base.DriverContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginTest {
    @Before
    public void Inialize()
    {
        System.setProperty("webdriver.gecko.driver", "D:\\drivers\\webdrivers\\geckodriver\\geckodriver.exe");
        DriverContext.Driver =new FirefoxDriver();
        DriverContext.Driver.navigate().to("http://eaapp.somee.com/");
        DriverContext.Driver.manage().window().maximize();
    }
    @Test
    public void Login()
    {
        Homepage page1=new Homepage();
        page1.clickLogin();
        try {
            Thread.sleep(2000); // Wait for 2 seconds to ensure the login page is loaded
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        LoginPage page=new LoginPage();
        page.Login("admin", "password");
    }
    @After
    public void CloseBrowser()
    {
        DriverContext.Driver.quit();
    }

}
