package com.test;



import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import steps.DepositSteps;
import steps.LoginSteps;
import util.ConfigProperties;
import util.DataProviderClass;
import util.DriverManager;

@Listeners(util.Listener.class)
public class TC_Deposit {
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
    
    @Test(dataProvider="DepositValidData",dataProviderClass=DataProviderClass.class, priority = 1)
    public void verifySubmitValidData(String account, String amount, String desc, String balance, String expMsg) {
        DepositSteps ds = new DepositSteps(dm.driver);
        ds.access();
        
        ds.submit(account, amount, desc);
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(ds.getResultTable()[0].contains(expMsg));

        softAssert.assertTrue(ds.getResultTable()[2].contains(account));

        
        softAssert.assertTrue(ds.getResultTable()[3].contains(amount));


        softAssert.assertTrue(ds.getResultTable()[4].contains("Deposit"));


        softAssert.assertTrue(ds.getResultTable()[5].contains(desc));


        softAssert.assertTrue(ds.getResultTable()[6].contains(balance));
        
        softAssert.assertAll();

    
    }
    
    
    @Test(dataProvider="DepositInvalidData", dataProviderClass=DataProviderClass.class,priority = 2)
    public void verifySubmitInvalidData(String account, String amount, String desc, String expMsg1, String expMsg2, String expMsg3, String expMsg4) {
        DepositSteps ds = new DepositSteps(dm.driver);
        ds.access();
        
        ds.submit(account, amount, desc);

        String str = ds.getAlertMsg(dm.driver);
        
        SoftAssert softAssert = new SoftAssert();
        
        softAssert.assertTrue(str.contains(expMsg1));
        
        softAssert.assertTrue(ds.getInvalidDataMsg()[0].contains(expMsg2));
        
        softAssert.assertTrue(ds.getInvalidDataMsg()[1].contains(expMsg3));

        softAssert.assertTrue(ds.getInvalidDataMsg()[2].contains(expMsg4));
        
        softAssert.assertAll();

        
    }
    

}
