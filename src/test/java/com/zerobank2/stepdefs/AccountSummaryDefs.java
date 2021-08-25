package com.zerobank2.stepdefs;

import com.zerobank2.pages.pages.AccountActivityPage;
import com.zerobank2.pages.pages.AccountSummaryPage;
import com.zerobank2.pages.pages.LoginPage;
import com.zerobank2.pages.pages.MenuPage;
import com.zerobank2.utilities.BrowserUtils;
import com.zerobank2.utilities.ConfigurationReader;
import com.zerobank2.utilities.Driver;
import io.cucumber.java.en.*;
import io.cucumber.java.en_old.Ac;
import org.junit.Assert;
import org.openqa.selenium.By;

import javax.swing.*;
import java.util.List;

public class AccountSummaryDefs {




    @Given("the user enters successful as {string} {string}")
    public void the_user_enters_successful_as(String client_username, String client_password) {
        String username1 = ConfigurationReader.get(client_username);
        String password1 = ConfigurationReader.get(client_password);


        new LoginPage().login(username1, password1);

    }

    @Given("the user is on the {string} page")
    public void the_user_is_on_the_page(String string) {

        BrowserUtils.waitForVisibility(new MenuPage().accountSummary,10);
        Assert.assertEquals("Verify that user is on the Account Summary page",
                "Zero - Account Summary", Driver.get().getTitle());


    }

    @Then("{string} Page should have title {string}")
    public void page_should_have_title(String pageName, String title) {
        MenuPage menuPage = new MenuPage();
        menuPage.checkPageTitle(pageName,title);

    }

    @Then("Account summary page should have the following account types")
    public void account_summary_page_should_have_the_following_account_types(List<String> expectedList) {
        BrowserUtils.waitFor(7);

        List<String >actualList = BrowserUtils.getElementsText(new AccountSummaryPage().accountTypes);

        Assert.assertEquals("Verify that account types list is correct",expectedList,actualList);
    }

    @Then("{string} table should have the following columns")
    public void table_should_have_the_following_columns(String accountType, List<String>expectedTypeList) {
       // BrowserUtils.waitFor(7);
      //  List<String>actualTypeList=BrowserUtils.getElementsText(new AccountSummaryPage().creditHeaders);
        //Assert.assertEquals("Verify that table columns on the" + accountType+"is correct",expectedTypeList,actualTypeList);

        new AccountActivityPage().gettransactionHeader(accountType,expectedTypeList);


    }

    @When("the user clicks on {string} link on the Account Summary page")
    public void the_user_clicks_on_link_on_the_Account_Summary_page(String accountType) {
        String dynamicPath = "//tr/td/a[contains(text(),'" + accountType + "')]";
        BrowserUtils.waitForClickablility(Driver.get().findElement(By.xpath(dynamicPath)),5);
        BrowserUtils.waitFor(1);
        Driver.get().findElement(By.xpath(dynamicPath)).click();
        System.out.println("You clicked on the " + accountType + " account");
    }

    @Then("{string} should be selected on the Account Activity page")
    public void should_be_selected_on_the_Account_Activity_page(String string) {
        Assert.assertTrue("verify that displayed account activity",new AccountActivityPage().accountActivity.isDisplayed());

    }


}
