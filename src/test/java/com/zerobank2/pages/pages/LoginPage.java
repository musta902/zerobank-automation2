package com.zerobank2.pages.pages;

import com.zerobank2.utilities.BrowserUtils;
import com.zerobank2.utilities.ConfigurationReader;
import com.zerobank2.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {


    public LoginPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "signin_button")
    public WebElement signButton;

    @FindBy(id = "user_login")
    public WebElement userNameBox;

    @FindBy(id = "user_password")
    public WebElement passwordBox;

    @FindBy(name = "submit")
    public WebElement submitButton;

    @FindBy(css = ".alert.alert-error")
    public WebElement invalidErrorMessage;

    //It takes 2 string as username and password and tries to log in
    public void login(String username, String password){
        BrowserUtils.waitForClickablility(userNameBox,5);
        userNameBox.sendKeys(username);
        passwordBox.sendKeys(password);
        submitButton.click();
        System.out.println("You were on the login page");
        BrowserUtils.waitFor(2);
    }

    //It logs in with the valid credentials from configuration.properties
    public void login() {

        login(ConfigurationReader.get("username"),ConfigurationReader.get("password"));


    }
}
