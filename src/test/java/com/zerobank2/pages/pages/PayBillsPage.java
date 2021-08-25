package com.zerobank2.pages.pages;

import com.zerobank2.utilities.BrowserUtils;
import com.zerobank2.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class PayBillsPage extends BasePage {

    @FindBy(id = "pay_bills_tab")
    public WebElement paybillsTitle;

    @FindBy(id = "sp_payee")
    public WebElement payeeDropDown;

    public void getselectDropdown() {
        Select select = new Select(payeeDropDown);
        select.selectByVisibleText("Bank of America");
        String expectedOption="Bank of America";
       String actualOption=select.getFirstSelectedOption().getText();
        Assert.assertEquals(expectedOption,expectedOption,"verify first selected ");
    }
    @FindBy(id = "sp_account")
    public WebElement accountDropdown;
    public void accountDropdownMet() {
        Select select = new Select(payeeDropDown);
        select.selectByVisibleText("Saving");
        String expectedOption="Saving";
        String actualOption=select.getFirstSelectedOption().getText();
        Assert.assertEquals(expectedOption,expectedOption,"verify first selected ");
    }

    @FindBy(id = "sp_amount")
    public WebElement amountBox;
    public void setAmountBox(){
        amountBox.sendKeys("45");
    }



    @FindBy(id = "sp_date")
    public WebElement dateBox;
    public void senDateMet() {
        dateBox.sendKeys("12-12-2021");
    }

    @FindBy(id ="sp_description")
    public WebElement descriptionBox;
    public void sendDescription() {
        descriptionBox.sendKeys("ok");

    }
    @FindBy(id="pay_saved_payees")
    public WebElement payButton;
    public void clickPayButton(){
        payButton.click();
    }

    @FindBy(id="//div/span[text()='The payment was successfully submitted.']")
    public WebElement Message;
    public void getMessage(String message) {
        String actualMessage=Message.getText();
        Assert.assertEquals("verify the message",actualMessage,message);

    }


    }


