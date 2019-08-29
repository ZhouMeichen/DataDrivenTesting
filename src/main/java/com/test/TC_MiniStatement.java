package com.test;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import steps.LoginSteps;
import steps.MiniStatementSteps;
import util.ConfigProperties;
import util.DataProviderClass;
import util.DriverManager;
@Listeners(util.Listener.class)
public class TC_MiniStatement {
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
    
    @Test(dataProvider="MiniStatementValidData",dataProviderClass=DataProviderClass.class, priority = 1)
    public void verifyValidSubmit(String account, String transactionId, String amount, String type, String date, String desc) {        
        MiniStatementSteps mss = new MiniStatementSteps();
        mss.access();
        mss.submit(account);
        String[] statement = mss.getResult(transactionId);
        try {
            assertTrue(statement[1].equals(amount));
        }catch(Exception e) {
            System.out.println(e);
        } 
        
        try {
            assertTrue(statement[2].equals(type));
        }catch(Exception e) {
            System.out.println(e);
        } 
        
        try {
            assertTrue(statement[3].equals(date));
        }catch(Exception e) {
            System.out.println(e);
        } 
        
        try {
            assertTrue(statement[4].equals(desc));
        }catch(Exception e) {
            System.out.println(e);
        } 
    }
}
