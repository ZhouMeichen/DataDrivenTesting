package com.test;



import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import steps.EditCustomerSteps;
import steps.LoginSteps;
import util.ConfigProperties;
import util.DataProviderClass;
import util.DriverManager;

@Listeners(util.Listener.class)
public class TC_EditCustomer {
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
    
    @Test(dataProvider="EditCustomerValidData",dataProviderClass=DataProviderClass.class, priority = 1)
    public void verifySubmitValidData(String id, String addr, String city, String state, String pin, String mobile, String email, String expMsg) {
        EditCustomerSteps ecs = new EditCustomerSteps(dm.driver);
        ecs.access(id);

        ecs.submit(addr, city, state, pin, mobile, email);
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(ecs.getResultTable()[0].contains(expMsg));
        
        softAssert.assertTrue(ecs.getResultTable()[1].contains(addr));
        
        softAssert.assertTrue(ecs.getResultTable()[2].contains(city));

        softAssert.assertTrue(ecs.getResultTable()[3].contains(state));

        softAssert.assertTrue(ecs.getResultTable()[4].contains(pin));

        softAssert.assertTrue(ecs.getResultTable()[5].contains(mobile));
       
        softAssert.assertTrue(ecs.getResultTable()[6].contains(email));
        
        softAssert.assertAll();

        
    }
    
   
    
    @Test(dataProvider="EditCustomerInvalidData", dataProviderClass=DataProviderClass.class, priority = 2)
    public void verifySubmitInvalidData(String id, String addr, String city, String state, String pin, String mobile, String email, String expMsg, String expMsg1, String expMsg2, String expMsg3, String expMsg4, String expMsg5, String expMsg6) {
        EditCustomerSteps ecs = new EditCustomerSteps(dm.driver);
        ecs.access(id);
        ecs.submit(addr, city, state, pin, mobile, email);

        String str = ecs.getAlertMsg(dm.driver);
        SoftAssert softAssert = new SoftAssert();
        
        softAssert.assertTrue(str.contains(expMsg));
 
        softAssert.assertTrue(ecs.getInvalidDataMsg()[0].contains(expMsg1));

        softAssert.assertTrue(ecs.getInvalidDataMsg()[1].contains(expMsg2));
        
        softAssert.assertTrue(ecs.getInvalidDataMsg()[2].contains(expMsg3));

        softAssert.assertTrue(ecs.getInvalidDataMsg()[3].contains(expMsg4));

        softAssert.assertTrue(ecs.getInvalidDataMsg()[4].contains(expMsg5));
       
        softAssert.assertTrue(ecs.getInvalidDataMsg()[5].contains(expMsg6));

        softAssert.assertAll();
          
  }
    
    @Test(dataProvider="EditCustomerWithoutChangeData", dataProviderClass=DataProviderClass.class, priority = 3)
    public void verifySubmitWithoutChange(String id, String expMsg) {
        EditCustomerSteps ecs = new EditCustomerSteps(dm.driver);
        ecs.access(id);
        ecs.submit();

        String str = ecs.getAlertMsg(dm.driver);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(str.contains(expMsg));
        softAssert.assertAll();
          
  }

}
