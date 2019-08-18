package com.test;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import steps.LoginSteps;
import steps.MiniStatementSteps;
import util.DataProviderClass;
import util.DriverManager;

public class TC_MiniStatement {
    DriverManager dm;
    
    
    @BeforeClass
    public void beforeClass() {
        System.out.println("BeforeClass");   
        dm = new DriverManager("chrome","http://demo.guru99.com/V4");
        LoginSteps ls = new LoginSteps();
        ls.login("mngr213347", "ytatArY");

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
        assertTrue(statement[1].equals(amount));
        assertTrue(statement[2].equals(type));
        assertTrue(statement[3].equals(date));
        assertTrue(statement[4].equals(desc));
    }
}
