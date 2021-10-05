package com.ttn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {

    WebDriver driver;

    //Constructor
    public HomePage(WebDriver driver){
        this.driver=driver;
        //Initialise Elements
        PageFactory.initElements(driver, this);
    }

    //Page Elements
    @FindBys(@FindBy(xpath = ".//a[text()='Form Authentication']"))
    List<WebElement> loginPageLinkList_a;

    public boolean isLoginPageLinkPresent(){
        return !loginPageLinkList_a.isEmpty();
    }




}
