package com.ttn.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class BasePage {

    @FindBy(id ="flash")
    WebElement message_div;

    public String getMessageText(){
        String messageText = message_div.getText();
        return messageText;
    }

}
