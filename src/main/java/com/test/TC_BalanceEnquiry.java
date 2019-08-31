package com.test;



import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import steps.BalEnquirySteps;
import steps.LoginSteps;
import util.ConfigProperties;
import util.DataProviderClass;
import util.DriverManager;

@Listeners(util.Listener.class)
public class TC_BalanceEnquiry {
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
    
    @Test(dataProvider="BalEnquiryValidData",dataProviderClass=DataProviderClass.class, priority = 1)
    public void verifySubmitValidData(String account, String type, String balance, String expMsg) {
        BalEnquirySteps bs = new BalEnquirySteps(dm.driver);
        bs.access();
        
        bs.submit(account);
        SoftAssert softAssert = new SoftAssert();
            softAssert.assertTrue(bs.getResultTable()[0].contains(expMsg));

            softAssert.assertTrue(bs.getResultTable()[1].contains(account));

     
            softAssert.assertTrue(bs.getResultTable()[2].contains(type));


            softAssert.assertTrue(bs.getResultTable()[3].contains(balance));
            
            softAssert.assertAll();

    }
    
    
    @Test(dataProvider="BalEnquiryInvalidData", dataProviderClass=DataProviderClass.class,priority = 2)
    public void verifySubmitInvalidData(String account,String expMsg1, String expMsg2) {
        BalEnquirySteps bs = new BalEnquirySteps(dm.driver);
        bs.access();
        
        bs.submit(account);

        String str = bs.getAlertMsg(dm.driver);
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(str.contains(expMsg1));

        

        softAssert.assertTrue(bs.getInvalidDataMsg()[0].contains(expMsg2));
        
        softAssert.assertAll();

        
    }
    

}
