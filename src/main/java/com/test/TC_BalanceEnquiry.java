package com.test;



import org.testng.Assert;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import steps.BalEnquirySteps;
import steps.LoginSteps;
import util.ConfigProperties;
import util.DataProviderClass;
import util.DriverManager;

@Listeners(util.Listener.class)

public class TC_BalanceEnquiry {
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
    
    @Test(dataProvider="BalEnquiryValidData",dataProviderClass=DataProviderClass.class, priority = 1)
    public void verifySubmitValidData(String account, String type, String balance, String expMsg) {
        BalEnquirySteps bs = new BalEnquirySteps();
        bs.access();
        
        bs.submit(account);

        Assert.assertTrue(bs.getResultTable()[0].contains(expMsg));
        Assert.assertTrue(bs.getResultTable()[1].contains(account));
        Assert.assertTrue(bs.getResultTable()[2].contains(type));
        Assert.assertTrue(bs.getResultTable()[3].contains(balance));
    
    }
    
    
    @Test(dataProvider="BalEnquiryInvalidData", dataProviderClass=DataProviderClass.class,priority = 2)
    public void verifySubmitInvalidData(String account,String expMsg1, String expMsg2) {
        BalEnquirySteps bs = new BalEnquirySteps();
        bs.access();
        
        bs.submit(account);

        String str = bs.getAlertMsg();
        Assert.assertTrue(str.contains(expMsg1));
        
      Assert.assertTrue(bs.getInvalidDataMsg()[0].contains(expMsg2));
        
    }
    

}
