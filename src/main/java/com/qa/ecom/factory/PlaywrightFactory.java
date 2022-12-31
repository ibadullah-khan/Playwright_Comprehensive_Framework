package com.qa.ecom.factory;

import com.microsoft.playwright.*;

import java.io.FileInputStream;
import java.util.Properties;

public class PlaywrightFactory {

    Playwright playwright;
    Browser browser;
    BrowserContext browserContext;
    Page page;
    Properties properties;

    public Page initBrowser(Properties properties){

        String browserName = properties.getProperty("browser").trim();
        Boolean mode = Boolean.valueOf(properties.getProperty("headless"));

        System.out.println("The initiated browser is " + browserName);

        playwright = Playwright.create();

        switch (browserName.toLowerCase()){
            case "chromium":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(mode));
                break;
            case "firefox":
                browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(mode));
                break;
            case "safari":
                browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(mode));
                break;
            case "chrome":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(mode));
                break;
            default:
                System.out.println("Kindly pass the correct browser name");
                break;
        }

        browserContext = browser.newContext();
        page=browserContext.newPage();
        page.navigate(properties.getProperty("url").trim());

        return page;

    }
    //initialize properties from config file
    public Properties init_properties(){

        try{
            FileInputStream inputStream = new FileInputStream("./src/test/resources/config/config.properties");
            properties = new Properties();
            properties.load(inputStream);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return properties;

    }
}
