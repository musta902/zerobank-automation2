package com.zerobank2.stepdefs;

import com.zerobank2.pages.pages.AccountActivityPage;
import com.zerobank2.pages.pages.AccountSummaryPage;
import com.zerobank2.pages.pages.LoginPage;
import com.zerobank2.pages.pages.MenuPage;
import com.zerobank2.utilities.BrowserUtils;
import com.zerobank2.utilities.ConfigurationReader;
import com.zerobank2.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class AccountActivityDefs {




    @Then("Account drop down  should have the following options")
    public void account_drop_down_should_have_the_following_options(List<String> expectedoptionlist) {
        BrowserUtils.waitFor(7);


        Select select = new Select(new AccountActivityPage().getDropdownoptions);

      List<WebElement> AccountOptions = select.getOptions();
       List<String > actualoptionlist = new ArrayList<>();
        for (WebElement  AccountOption :AccountOptions) {
            actualoptionlist.add(AccountOption.getText());
        }
        System.out.println("actualoptionlist = " + actualoptionlist);
        System.out.println("BrowserUtils.getElementsText(AccountOptions) = " + BrowserUtils.getElementsText(AccountOptions));

       Assert.assertEquals(expectedoptionlist,BrowserUtils.getElementsText(AccountOptions));

    }







    @When("User click on {string}")
    public void user_click_on(String string) {
        new AccountActivityPage().accountActivity.click();

    }

}
