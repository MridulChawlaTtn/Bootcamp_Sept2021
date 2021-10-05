package com.ttn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage extends BasePage {

    WebDriver driver;

    //Constructor
    public LoginPage(WebDriver driver){
        this.driver=driver;
        //Initialise Elements
        PageFactory.initElements(driver, this);
    }

    //Page Elements
    @FindBys({@FindBy(xpath="//h4[@class='subheader']/em")})
    List<WebElement> userNameAndPassValues_em;
    @FindBys({@FindBy(id = "username")})
    List<WebElement> userNameList_input;
    @FindBys({@FindBy(id = "password")})
    List<WebElement> passwordList_input;
    @FindBys({@FindBy(xpath = "//button[@type='submit']")})
    List<WebElement> submitButtonList_input;
    @FindBy(id = "username")
    WebElement userName_input;
    @FindBy(id = "password")
    WebElement password_input;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitButton;

    //Page Text
    @FindBy(xpath = "//h4[@class='subheader']/em[1]")
    WebElement userNameText_em;
    @FindBy(xpath = "//h4[@class='subheader']/em[2]")
    WebElement passwordText_em;

    public void enterValidCredentials(){
        String userNameValue = userNameText_em.getText();
        String passwordValue = passwordText_em.getText();
        userName_input.sendKeys(userNameValue);
        password_input.sendKeys(passwordValue);
    }

    public void enterValidCredentials_SingleElement(){
        String userNameValue = userNameAndPassValues_em.get(0).getText();
        String passwordValue = userNameAndPassValues_em.get(1).getText();
        userName_input.sendKeys(userNameValue);
        password_input.sendKeys(passwordValue);
    }

    public void enterInvalidUserNameCredentials(){
        //String userNameValue = userNameAndPassValues_em.get(0).getText();
        String userNameValue = "test";
        String passwordValue = passwordText_em.getText();
        userName_input.sendKeys(userNameValue);
        password_input.sendKeys(passwordValue);
    }
    public void enterInvalidPasswordCredentials(){
        String userNameValue = userNameText_em.getText();
        String passwordValue = "test";
        userName_input.sendKeys(userNameValue);
        password_input.sendKeys(passwordValue);
    }

    public void submitLoginPage(){
        submitButton.click();
    }

    public boolean isUserNamePresent(){
        return !userNameList_input.isEmpty();
    }
    public boolean isPasswordPresent(){return !passwordList_input.isEmpty();}
    public boolean isSubmitButtonPresent(){return !submitButtonList_input.isEmpty();}

}
