package com.qa.ecom.base;

import com.microsoft.playwright.Page;
import com.qa.ecom.factory.PlaywrightFactory;
import com.qa.ecom.pages.HomePage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.Properties;

public class BaseTest {
    PlaywrightFactory pf;
    Page page;
    protected Properties properties;
    protected HomePage homePage;

    @BeforeTest
    public void setUp(){
        pf = new PlaywrightFactory();
        properties = pf.init_properties();
        page = pf.initBrowser(properties);
        homePage = new HomePage(page);
    }

    @AfterTest
    public void tearDown(){
        page.context().browser().close();
    }
}
