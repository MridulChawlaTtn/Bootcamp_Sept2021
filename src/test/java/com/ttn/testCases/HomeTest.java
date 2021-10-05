package com.ttn.testCases;

import com.ttn.pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HomeTest {

    WebDriver driver;

    @Test
    public void checkPageURL(){
        String urlValue = driver.getCurrentUrl();
        Assert.assertEquals(urlValue,"https://the-internet.herokuapp.com/");
    }

    @Test
    public void checkPageTitle(){
        String titleValue = driver.getTitle();
        Assert.assertEquals(titleValue,"The Internet");
    }

    @Test
    public void checkLoginPageLink(){
        HomePage homePage = new HomePage(driver);
        boolean isLoginPageLinkPresentValue = homePage.isLoginPageLinkPresent();
        Assert.assertEquals(isLoginPageLinkPresentValue,true);
    }

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
