package com.zerobank2.pages.pages;

import com.zerobank2.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AccountSummaryPage extends BasePage {

    @FindBy(xpath = "//h2[@class='board-header']")
    public List<WebElement> accountTypes;


    @FindBy(xpath="(//div[@class='board-content'])[3]/table/thead/tr/th")
    public List<WebElement> creditHeaders;

public void getHeader(String header){
    Driver.get().findElement(By.xpath("(//div[@class='board-content'])[3]/table/thead/tr/th[text()='"+header+"']"));

}





}
