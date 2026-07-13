package com.ea.test.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.ea.framework.base.BasePage;

public class Homepage extends BasePage {
    public Homepage() {
    }
    @FindBy(how=How.LINK_TEXT,using ="View Employees")
    private WebElement lnkEmployeesList;
    @FindBy(how=How.LINK_TEXT,using="Login")
    private WebElement lnkLogin;
    public void clickLogin()
    {
        lnkLogin.click();
    }
}
