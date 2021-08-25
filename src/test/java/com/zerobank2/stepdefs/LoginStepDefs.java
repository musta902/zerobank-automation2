package com.zerobank2.stepdefs;

import com.zerobank2.pages.pages.LoginPage;
import com.zerobank2.pages.pages.MenuPage;
import com.zerobank2.utilities.BrowserUtils;
import com.zerobank2.utilities.ConfigurationReader;
import com.zerobank2.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class LoginStepDefs {
    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
      String urlCurrent= Driver.get().getCurrentUrl();
        System.out.println(urlCurrent);


    }

    @When("the user enters the valid credentials as {string} {string}")
    public void the_user_enters_the_valid_credentials_as(String client_username, String client_password) {
        BrowserUtils.waitFor(10);
        String username1 = ConfigurationReader.get(client_username);
        String password1 = ConfigurationReader.get(client_password);


        new LoginPage().login(username1, password1);
    }


    @Then("the user should be able to login")
    public void the_user_should_be_able_to_login() {
        BrowserUtils.waitFor(3);

        MenuPage menuPage = new MenuPage();
        Assert.assertEquals(true,menuPage.accountSummary.isDisplayed());

    }

    @Then("the title {string}")
    public void the_title(String title) {
        BrowserUtils.waitFor(3);
        String actualTitle = Driver.get().getTitle();
        String expectedTitle=title;
        Assert.assertEquals("verify the title Account Summary",expectedTitle,actualTitle);


    }

    @Given("Given the user is on the login page")
    public void given_the_user_is_on_the_login_page() {

    }

    @When("the user enters the invalid credentials as {string} {string}")
    public void the_user_enters_the_invalid_credentials_as(String client_username1, String client_password1) {

        String username2 = ConfigurationReader.get(client_username1);
        String password2 = ConfigurationReader.get(client_password1);


        new LoginPage().login(username2, password2);

    }

    @Then("the user should not be able to login")
    public void the_user_should_not_be_able_to_login() {
        BrowserUtils.waitFor(3);


        String currentUrl = Driver.get().getCurrentUrl();

        Assert.assertEquals(currentUrl,"http://zero.webappsecurity.com/login.html?login_error=true");
    }


    @Then("error message Login and or password are wrong should be displayed.")
    public void error_message_Login_and_or_password_are_wrong_should_be_displayed() {
        BrowserUtils.waitFor(3);
        LoginPage loginPage = new LoginPage();
        String expectedText = "Login and/or password are wrong.";
        String text = loginPage.invalidErrorMessage.getText();
        Assert.assertEquals(expectedText,text);

    }



}
