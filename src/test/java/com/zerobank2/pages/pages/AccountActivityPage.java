package com.zerobank2.pages.pages;

import com.zerobank2.utilities.BrowserUtils;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AccountActivityPage extends BasePage{

    @FindBy(xpath = "//ul/li/a[text()='Account Activity']")
    public WebElement accountActivity;

    @FindBy(xpath = "//table/thead/tr/th")
    public List<WebElement> transactionHeader;

    @FindBy(id = "aa_accountId")
    public WebElement getDropdownoptions;




}
