package com.qa.ecom.pages;

import com.microsoft.playwright.Page;

public class HomePage {

    private Page page;

    //Object Repository
    private String loginBtn = "a[id='login2']";
    private String signUp = "a[id='signin2']";
    private String usernameInput = "input#loginusername";
    private String passwordInput = "input#loginpassword";
    private String popupLoginBtn = "text=Log in";

    //Page Constructor
    public HomePage(Page page){
        this.page = page;
    }

    public String getTitle(){
        return page.title();
    }

    public void login(String username, String password){

        page.click(loginBtn);
        page.fill(usernameInput,username);
        page.fill(passwordInput,password);
        page.click(popupLoginBtn);

    }
}