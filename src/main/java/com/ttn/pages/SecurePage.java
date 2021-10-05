package com.ttn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SecurePage extends BasePage {

    WebDriver driver;

    //Constructor
    public SecurePage(WebDriver driver){
        this.driver=driver;
        //Initialise Elements
        PageFactory.initElements(driver, this);
    }

}
