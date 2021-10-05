package com.ttn.testCases;

import com.ttn.pages.HomePage;
import com.ttn.pages.LoginPage;
import com.ttn.pages.SecurePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest {

    WebDriver driver;

    @Test
    public void checkPageURL(){
        String urlValue = driver.getCurrentUrl();
        Assert.assertEquals(urlValue,"https://the-internet.herokuapp.com/login");
    }

    @Test
    public void checkAllFieldsPresent(){
        LoginPage loginPage = new LoginPage(driver);
        boolean isUserNamePresentValue = loginPage.isUserNamePresent();
        Assert.assertEquals(isUserNamePresentValue,true);
        boolean isPasswordPresentValue = loginPage.isPasswordPresent();
        Assert.assertEquals(isPasswordPresentValue,true);
        boolean isSubmitButtonPresentValue = loginPage.isSubmitButtonPresent();
        Assert.assertEquals(isSubmitButtonPresentValue,true);
    }

    @Test
    public void checkValidLoginFunctionality(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterValidCredentials();
        loginPage.submitLoginPage();
        SecurePage securePage = new SecurePage(driver);
        String successMessageValue_Full = securePage.getMessageText();
        String successMessageValue = successMessageValue_Full.substring(0, successMessageValue_Full.indexOf("\n"));
        Assert.assertEquals(successMessageValue,"You logged into a secure area!");
    }

    @Test
    public void checkValidLoginFunctionality_SingleElement(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterValidCredentials_SingleElement();
        loginPage.submitLoginPage();
        SecurePage securePage = new SecurePage(driver);
        String successMessageValue_Full = securePage.getMessageText();
        String successMessageValue = successMessageValue_Full.substring(0, successMessageValue_Full.indexOf("\n"));
        Assert.assertEquals(successMessageValue,"You logged into a secure area!");
    }

    @Test
    public void checkInvalidLoginFunctionality_EmptyFields(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.submitLoginPage();
        String failedMessageValue_Full = loginPage.getMessageText();
        String failedMessageValue = failedMessageValue_Full.substring(0, failedMessageValue_Full.indexOf("\n"));
        Assert.assertEquals(failedMessageValue,"Your username is invalid!");
    }

    @Test
    public void checkInvalidLoginFunctionality_UserName(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterInvalidUserNameCredentials();
        loginPage.submitLoginPage();
        String failedMessageValue_Full = loginPage.getMessageText();
        String failedMessageValue = failedMessageValue_Full.substring(0, failedMessageValue_Full.indexOf("\n"));
        Assert.assertEquals(failedMessageValue,"Your username is invalid!");
    }

    @Test
    public void checkInvalidLoginFunctionality_Password(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterInvalidPasswordCredentials();
        loginPage.submitLoginPage();
        String failedMessageValue_Full = loginPage.getMessageText();
        String failedMessageValue = failedMessageValue_Full.substring(0, failedMessageValue_Full.indexOf("\n"));
        Assert.assertEquals(failedMessageValue,"Your password is invalid!");
    }

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/login");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
