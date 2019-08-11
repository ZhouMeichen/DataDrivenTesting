package com.test;



import org.testng.Assert;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import steps.DepositSteps;
import steps.LoginSteps;
import util.DataProviderClass;
import util.DriverManager;

public class TC_Deposit {
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
    
    @Test(dataProvider="DepositValidData",dataProviderClass=DataProviderClass.class, priority = 1)
    public void verifySubmitValidData(String account, String amount, String desc, String balance, String expMsg) {
        DepositSteps ds = new DepositSteps();
        ds.access();
        
        ds.submit(account, amount, desc);

        Assert.assertTrue(ds.getResultTable()[0].contains(expMsg));
        Assert.assertTrue(ds.getResultTable()[2].contains(account));
        Assert.assertTrue(ds.getResultTable()[3].contains(amount));
        Assert.assertTrue(ds.getResultTable()[4].contains("Deposit"));
        Assert.assertTrue(ds.getResultTable()[5].contains(desc));
        Assert.assertTrue(ds.getResultTable()[6].contains(balance));
    
    }
    
    
    @Test(dataProvider="DepositInvalidData", dataProviderClass=DataProviderClass.class,priority = 2)
    public void verifySubmitInvalidData(String account, String amount, String desc, String expMsg1, String expMsg2, String expMsg3, String expMsg4) {
        DepositSteps ds = new DepositSteps();
        ds.access();
        
        ds.submit(account, amount, desc);

        String str = ds.getAlertMsg();
        Assert.assertTrue(str.contains(expMsg1));
        
      Assert.assertTrue(ds.getInvalidDataMsg()[0].contains(expMsg2));
      Assert.assertTrue(ds.getInvalidDataMsg()[1].contains(expMsg3));
      Assert.assertTrue(ds.getInvalidDataMsg()[2].contains(expMsg4));
        
    }
    

}
