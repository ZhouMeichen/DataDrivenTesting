package com.test;



import org.testng.Assert;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import steps.LoginSteps;
import steps.WithdrawalSteps;
import util.ConfigProperties;
import util.DataProviderClass;
import util.DriverManager;
@Listeners(util.Listener.class)
public class TC_Withdrawal {
    DriverManager dm;
    
    @BeforeClass
    public void beforeClass() {
        System.out.println("BeforeClass");   
        dm = new DriverManager(ConfigProperties.get("defaultBrowser"),ConfigProperties.get("url"));
        LoginSteps ls = new LoginSteps();
        ls.login(ConfigProperties.get("username"), ConfigProperties.get("password"));

    }

    
    @AfterClass
    public void afterClass() {
        System.out.println("AfterClass");
        dm.quit();
        
    }
    
    @Test(dataProvider="WithdrawalValidData",dataProviderClass=DataProviderClass.class, priority = 1)
    public void verifySubmitValidData(String account, String amount, String desc, String balance, String expMsg) {
        WithdrawalSteps ws = new WithdrawalSteps();
        ws.access();
        
        ws.submit(account, amount, desc);
        try {
            Assert.assertTrue(ws.getResultTable()[0].contains(expMsg));
        }catch(Exception e) {
            System.out.println(e);
        }
        
        try {
            Assert.assertTrue(ws.getResultTable()[2].contains(account));
        }catch(Exception e) {
            System.out.println(e);
        } 
        
        try {
            Assert.assertTrue(ws.getResultTable()[3].contains(amount));
        }catch(Exception e) {
            System.out.println(e);
        } 
        
        try {
            Assert.assertTrue(ws.getResultTable()[4].contains("Withdrawal"));
        }catch(Exception e) {
            System.out.println(e);
        } 
        
        try {
            Assert.assertTrue(ws.getResultTable()[5].contains(desc));
        }catch(Exception e) {
            System.out.println(e);
        } 
        
        try {
            Assert.assertTrue(ws.getResultTable()[6].contains(balance));
        }catch(Exception e) {
            System.out.println(e);
        } 
    
    }
    
    
    @Test(dataProvider="WithdrawalInvalidData", dataProviderClass=DataProviderClass.class,priority = 2)
    public void verifySubmitInvalidData(String account, String amount, String desc, String expMsg1, String expMsg2, String expMsg3, String expMsg4) {
        WithdrawalSteps ws = new WithdrawalSteps();
        ws.access();
        
        ws.submit(account, amount, desc);

        String str = ws.getAlertMsg();
        try {
            Assert.assertTrue(str.contains(expMsg1));
        }catch(Exception e) {
            System.out.println(e);
        } 
        
        try {
            Assert.assertTrue(ws.getInvalidDataMsg()[0].contains(expMsg2));
        }catch(Exception e) {
            System.out.println(e);
        } 
        
        try {
            Assert.assertTrue(ws.getInvalidDataMsg()[1].contains(expMsg3));
        }catch(Exception e) {
            System.out.println(e);
        } 
        
        try {
            Assert.assertTrue(ws.getInvalidDataMsg()[2].contains(expMsg4));
        }catch(Exception e) {
            System.out.println(e);
        } 
        
    }
    

}
