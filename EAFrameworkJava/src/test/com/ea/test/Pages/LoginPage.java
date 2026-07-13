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
    @FindBy(how=How.ID,using ="loginFrm_loginname")
    private WebElement UserName;
    @FindBy(how=How.ID,using ="loginFrm_password")
    private WebElement Password;
    @FindBy(how=How.XPATH,using ="//button[@title='Login']")
    private WebElement LoginButton;
    public void Login(String user, String pass)
    {
        UserName.sendKeys(user);
        Password.sendKeys(pass);
        LoginButton.click();
    }
}
