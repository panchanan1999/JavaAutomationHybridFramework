package com.ea.test.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.ea.framework.base.BasePage;

public class Homepage extends BasePage {
    public Homepage(WebDriver driver) {
        super(driver);
    }
    @FindBy(how=How.XPATH,using="//a[normalize-space()='Login or register']")
    private WebElement LoginOrRegisterLink;
    @FindBy(how= How.XPATH,using ="//button[normalize-space()='Continue']")
    private WebElement ContinueButton;
    public void HomePageValidation()
    {
        LoginOrRegisterLink.click();
        //ContinueButton.click();
    }

}
