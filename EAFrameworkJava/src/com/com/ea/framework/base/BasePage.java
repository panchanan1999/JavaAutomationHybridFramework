package com.ea.framework.base;

import ea.framework.base.DriverContext;
import org.openqa.selenium.support.PageFactory;
public abstract class BasePage {
    //alt+insert --- to generate constructor
    public BasePage() {
        PageFactory.initElements(DriverContext.Driver, this);
    }
}
