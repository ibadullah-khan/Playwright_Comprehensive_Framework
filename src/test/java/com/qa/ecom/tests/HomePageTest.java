package com.qa.ecom.tests;

import com.qa.ecom.base.BaseTest;
import com.qa.ecom.constants.AppConstants;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {
    @Test
    public void homePageTitleTest(){
        String actual = homePage.getTitle();
        Assert.assertEquals(actual, AppConstants.PAGE_TITLE);
    }

    @Test(dataProvider = "getCredentials")
    public void homePageLoginTest(String username, String password){
        homePage.login(username,password);
    }

    @DataProvider
    public Object[][] getCredentials(){
        return new Object[][] {
            {properties.getProperty("username"),properties.getProperty("password")}
        };
    }



}
