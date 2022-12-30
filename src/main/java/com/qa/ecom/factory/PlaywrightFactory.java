package com.qa.ecom.factory;

import com.microsoft.playwright.*;

public class PlaywrightFactory {

    Playwright playwright;
    Browser browser;
    BrowserContext browserContext;
    Page page;

    public Page initBrowser(String browserName){

        System.out.println("The initiated browser is " + browserName);
        playwright = Playwright.create();

        switch (browserName.toLowerCase()){
            case "chromium":
                playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "firefox":
                playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "safari":
                playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "chrome":
                playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
                break;
            default:
                System.out.println("Kindly pass the correct browser name");
                break;
        }

        browserContext = browser.newContext();
        page=browserContext.newPage();
        page.navigate("https://demoblaze.com/");

        return page;

    }
}
