package com.ea.test.Pages;

import com.ea.framework.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(how= How.NAME,using = "loginname")
    public WebElement username;
    @FindBy(how= How.NAME,using = "password")
    public WebElement password;
    @FindBy(how= How.XPATH,using = "//button[@title='Login']")
    public WebElement loginButton;
    public void Login(String user, String pass)
    {
        username.sendKeys(user);
        password.sendKeys(pass);
        loginButton.click();
    }
}
