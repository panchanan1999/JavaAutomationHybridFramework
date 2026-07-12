package com.ea.test.Features.SeleniumTest;

import com.ea.test.Pages.LoginPage;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginTest {
    private WebDriver _driver=null;

    @Before
    public void Inialize()
    {
        System.setProperty("webdriver.gecko.driver", "D:\\drivers\\webdrivers\\geckodriver\\geckodriver.exe");
        _driver=new FirefoxDriver();
        _driver.navigate().to("https://automationteststore.com/index.php?rt=account/login");
    }
    @Test
    public void Login()
    {
        LoginPage page=new LoginPage(_driver);
        page.Login("testuser_1", "Test@123");
    }

}
