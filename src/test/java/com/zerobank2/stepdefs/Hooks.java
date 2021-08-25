package com.zerobank2.stepdefs;

import com.zerobank2.pages.pages.LoginPage;
import com.zerobank2.utilities.ConfigurationReader;
import com.zerobank2.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before
    public void setUp(){


        String url = ConfigurationReader.get("url");
        //WebDriver driver = Driver.get();

        Driver.get().get(url);
        Driver.get().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        new LoginPage().signButton.click();


    }

    @After
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","screenshot");
        }

        Driver.closeDriver();

    }
//
//    @Before("@abc")
//    public void setUpdb(){
//        System.out.println("\tconnecting to database...");
//    }
//
//    @After("@abc")
//    public void closeDb(){
//        System.out.println("\tdisconnecting to database...");
//
//    }



}