package com.zerobank2.stepdefs;

import com.zerobank2.pages.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class InvalidLoginDefs {

    @Then("the user should NOT be able to login with invalid credentials {string} {string}")
    public void the_user_should_NOT_be_able_to_login_with_invalid_credentials(String username, String password) {
        if (username.contains("blank")) {
            username = "";
        }
        if (password.contains("blank")) {
            password = "";
        }
        LoginPage loginPage= new LoginPage();
        loginPage.login(username, password);
        Assert.assertTrue("Verify invalid credentials message is displayed", loginPage.invalidErrorMessage.isDisplayed());
        System.out.println("Your negative login test was successful");

    }

}
