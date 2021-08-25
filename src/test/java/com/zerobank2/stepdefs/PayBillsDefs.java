package com.zerobank2.stepdefs;

import com.zerobank2.pages.pages.PayBillsPage;
import io.cucumber.java.en.*;

public class PayBillsDefs {

    @Then("click on the pay Bills tab")
    public void click_on_the_pay_Bills_tab() {
       new PayBillsPage().paybillsTitle.click();
    }


    @Then("select Payee drop down Bank of America box {string}")
    public void select_Payee_drop_down_Bank_of_America_box(String string) {
       new PayBillsPage().getselectDropdown();
    }

    @Then("select Account type Saving {string}")
    public void select_Account_type_Saving(String string) {
       new PayBillsPage().accountDropdownMet();
    }

    @Then("Fill out Amount")
    public void fill_out_Amount() {
        new PayBillsPage().setAmountBox();


    }

    @Then("Write date box any date")
    public void write_date_box_any_date() {
        new PayBillsPage().senDateMet();
    }

    @Then("Fill out description")
    public void fill_out_description() {
        new PayBillsPage().sendDescription();
    }

    @Then("Click pay button")
    public void click_pay_button() {
        new PayBillsPage().clickPayButton();
    }

    @When("date box is blank")
    public void date_box_is_blank() {
        new PayBillsPage().dateBox.sendKeys("");


    }

    @Then("get {string}")
    public void get(String message) {
       new PayBillsPage().getMessage(message);

    }
}
