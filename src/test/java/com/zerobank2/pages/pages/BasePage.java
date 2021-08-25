package com.zerobank2.pages.pages;

import com.zerobank2.utilities.BrowserUtils;
import com.zerobank2.utilities.Driver;
import com.zerobank2.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class  BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "account_summary_tab")
    public WebElement accountSummary;

    @FindBy(xpath = "//div/h2[text()='Cash Accounts']")
    public WebElement cashAccounts;


    @FindBy(xpath = "//div/h2[text()='Investment Accounts']")
    public WebElement investmentAccounts;


    @FindBy(xpath = "//div/h2[text()='Credit Accounts']")
    public WebElement creditAccounts;

    @FindBy(xpath = "//div/h2[text()='Loan Accounts']")
    public WebElement loanAccounts;

   // @FindBy(xpath = "(//div[@class='board-content'])[3]/table/thead/tr/th")
  //  public List<WebElement> creditHeaders;




    public String isAccountSummary(){
        BrowserUtils.waitForVisibility(accountSummary, 5);

        return accountSummary.getText();

    }
    public void checkPageTitle(String pageName, String title) {
        BrowserUtils.waitForPageToLoad(5);

        Assert.assertEquals("Verify that the page title is correct",
               title, Driver.get().getTitle());
        System.out.println(pageName + " page title was checked");

    }
    public void gettransactionHeader(String activityHeaderType, List<String> expectedTypeList){
        BrowserUtils.waitFor(7);
        List<String>actualTypeList=BrowserUtils.getElementsText(new AccountActivityPage().transactionHeader);
        Assert.assertEquals("Verify that table columns on the" + activityHeaderType+"is correct",expectedTypeList,actualTypeList);
    }







}
