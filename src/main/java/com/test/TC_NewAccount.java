package com.test;



import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import steps.AddAccountSteps;
import steps.LoginSteps;
import util.ConfigProperties;
import util.DataProviderClass;
import util.DriverManager;

@Listeners(util.Listener.class)
public class TC_NewAccount {
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
    
    @Test(dataProvider="NewAccountValidData",dataProviderClass=DataProviderClass.class, priority = 1)
    public void verifySubmitValidData(String cusId, String type, String amount, String expMsg) {
        AddAccountSteps aas = new AddAccountSteps(dm.driver);
        aas.access();
        
        aas.submit(cusId, type, amount);
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(aas.getResultTable()[0].contains(expMsg));

        
        softAssert.assertTrue(aas.getResultTable()[2].contains(cusId));


        softAssert.assertTrue(aas.getResultTable()[5].contains(type));

        
        softAssert.assertTrue(aas.getResultTable()[7].contains(amount));
        
        softAssert.assertAll();

    
    }
    
    
    @Test(dataProvider="NewAccountInvalidData", dataProviderClass=DataProviderClass.class,priority = 2)
    public void verifySubmitInvalidData(String id, String type, String amount, String expMsg1, String expMsg2, String expMsg3) {
        AddAccountSteps aas = new AddAccountSteps(dm.driver);
        aas.access();
        aas.submit(id, type, amount);

        String str = aas.getAlertMsg(dm.driver);
        
        SoftAssert softAssert = new SoftAssert();
        
        softAssert.assertTrue(str.contains(expMsg1));
 
        softAssert.assertTrue(aas.getInvalidDataMsg()[0].contains(expMsg2));

        softAssert.assertTrue(aas.getInvalidDataMsg()[1].contains(expMsg3));
        
        softAssert.assertAll();
        
    }
    

}
