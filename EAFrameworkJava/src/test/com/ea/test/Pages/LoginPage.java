package com.ea.test.Pages;

import com.ea.framework.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class LoginPage extends BasePage{
    public LoginPage() {

    }
    @FindBy(how=How.NAME,using ="UserName")
    private WebElement txtUserName;
    @FindBy(how=How.NAME,using ="Password")
    private WebElement txtPassword;
    @FindBy(how=How.CSS,using ="button[class=\"btn btn-signin\"]")
    private WebElement btnLogin;
    public void Login(String user, String pass)
    {
        txtUserName.sendKeys(user);
        txtPassword.sendKeys(pass);
        btnLogin.click();
    }
}
