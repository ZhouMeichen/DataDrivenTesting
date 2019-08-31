package com.test;


import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import steps.LoginSteps;
import steps.MiniStatementSteps;
import util.ConfigProperties;
import util.DataProviderClass;
import util.DriverManager;

@Listeners(util.Listener.class)
public class TC_MiniStatement {
    DriverManager dm;
    
    
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("BeforeMethod");   
        dm = new DriverManager();
        dm.init(ConfigProperties.get("defaultBrowser"),ConfigProperties.get("url"));
        LoginSteps ls = new LoginSteps(dm.driver);
        ls.login(ConfigProperties.get("username"), ConfigProperties.get("password"));

    }

    
    @AfterMethod
    public void afterMethod() {
        System.out.println("AfterMethod");
        dm.quit();        
    }
    
    @Test(dataProvider="MiniStatementValidData",dataProviderClass=DataProviderClass.class, priority = 1)
    public void verifyValidSubmit(String account, String transactionId, String amount, String type, String date, String desc) {        
        MiniStatementSteps mss = new MiniStatementSteps(dm.driver);
        mss.access();
        mss.submit(account);
        String[] statement = mss.getResult(transactionId);
        
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(statement[1].equals(amount));

        softAssert.assertTrue(statement[2].equals(type));

        softAssert.assertTrue(statement[3].equals(date));

        softAssert.assertTrue(statement[4].equals(desc));
        
        softAssert.assertAll();

    }
}
