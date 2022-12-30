package com.qa.ecom.tests;

import com.microsoft.playwright.Page;
import com.qa.ecom.factory.PlaywrightFactory;
import com.qa.ecom.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePageTest {

    PlaywrightFactory pf;
    Page page;
    HomePage homePage;

    @BeforeTest
    public void setUp(){
        pf = new PlaywrightFactory();
        page = pf.initBrowser("chrome");
        homePage = new HomePage(page);
    }

    @Test
    public void homePageTitleTest(){
        String actual = homePage.getTitle();
        Assert.assertEquals(actual,"STORE");
    }

    @Test
    public void homePageLoginTest(){
        homePage.login("test123","test123");
    }


    @AfterTest
    public void tearDown(){
        page.context().browser().close();
    }
}
