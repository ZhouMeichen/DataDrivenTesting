package com.test;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import steps.DeleteCustomerSteps;
import steps.LoginSteps;
import util.ConfigProperties;
import util.DataProviderClass;
import util.DriverManager;

@Listeners(util.Listener.class)
public class TC_DeleteCustomer {
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
    
    @Test(dataProvider="DeleteCustomerValidData",dataProviderClass=DataProviderClass.class, priority = 1)
    public void verifySubmitValidData(String id, String expMsg1, String expMsg2) {
        DeleteCustomerSteps dcs = new DeleteCustomerSteps(dm.driver);
        dcs.access();
        dcs.submit(id);
        String str = dcs.getAlertMsg(dm.driver);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(str.contains(expMsg1));

        
        str = dcs.getAlertMsg(dm.driver);

        softAssert.assertTrue(str.contains(expMsg2));
        softAssert.assertAll();


    }
    
    @Test(dataProvider="DeleteCustomerNotExistData",dataProviderClass=DataProviderClass.class, priority = 2)
    public void verifySubmitNotExistData(String id, String expMsg1, String expMsg2) {
        DeleteCustomerSteps dcs = new DeleteCustomerSteps(dm.driver);
        dcs.access();
        
        dcs.submit(id);
        
        String str = dcs.getAlertMsg(dm.driver);
        SoftAssert softAssert = new SoftAssert();

            softAssert.assertTrue(str.contains(expMsg1));

        str = dcs.getAlertMsg(dm.driver);

            softAssert.assertTrue(str.contains(expMsg2));
            softAssert.assertAll();
    }
    
    
   
    
    @Test(dataProvider="DeleteCustomerInvalidData", dataProviderClass=DataProviderClass.class, priority = 3)
    public void verifySubmitInvalidData(String id, String expMsg1, String expMsg2) {
        DeleteCustomerSteps dcs = new DeleteCustomerSteps(dm.driver);
        dcs.access();
        dcs.submit(id);
        SoftAssert softAssert = new SoftAssert();
        String str = dcs.getAlertMsg(dm.driver);

        softAssert.assertTrue(str.contains(expMsg1));

        softAssert.assertTrue(dcs.getInvalidDataMsg().contains(expMsg2));

          
  }

}
