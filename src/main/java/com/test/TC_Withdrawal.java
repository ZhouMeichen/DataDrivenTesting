package com.test;



import org.testng.Assert;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import steps.LoginSteps;
import steps.WithdrawalSteps;
import util.DataProviderClass;
import util.DriverManager;

public class TC_Withdrawal {
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
    
    @Test(dataProvider="WithdrawalValidData",dataProviderClass=DataProviderClass.class, priority = 1)
    public void verifySubmitValidData(String account, String amount, String desc, String balance, String expMsg) {
        WithdrawalSteps ws = new WithdrawalSteps();
        ws.access();
        
        ws.submit(account, amount, desc);

        Assert.assertTrue(ws.getResultTable()[0].contains(expMsg));
        Assert.assertTrue(ws.getResultTable()[2].contains(account));
        Assert.assertTrue(ws.getResultTable()[3].contains(amount));
        Assert.assertTrue(ws.getResultTable()[4].contains("Withdrawal"));
        Assert.assertTrue(ws.getResultTable()[5].contains(desc));
        Assert.assertTrue(ws.getResultTable()[6].contains(balance));
    
    }
    
    
    @Test(dataProvider="WithdrawalInvalidData", dataProviderClass=DataProviderClass.class,priority = 2)
    public void verifySubmitInvalidData(String account, String amount, String desc, String expMsg1, String expMsg2, String expMsg3, String expMsg4) {
        WithdrawalSteps ws = new WithdrawalSteps();
        ws.access();
        
        ws.submit(account, amount, desc);

        String str = ws.getAlertMsg();
        Assert.assertTrue(str.contains(expMsg1));
        
      Assert.assertTrue(ws.getInvalidDataMsg()[0].contains(expMsg2));
      Assert.assertTrue(ws.getInvalidDataMsg()[1].contains(expMsg3));
      Assert.assertTrue(ws.getInvalidDataMsg()[2].contains(expMsg4));
        
    }
    

}
