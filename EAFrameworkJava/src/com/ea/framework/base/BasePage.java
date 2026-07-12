package com.ea.framework.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
public abstract class BasePage {
    //alt+insert --- to generate constructor
    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
