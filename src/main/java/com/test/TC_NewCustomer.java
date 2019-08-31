package com.test;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import steps.AddCustomerSteps;
import steps.LoginSteps;
import util.ConfigProperties;
import util.DataProviderClass;
import util.DriverManager;

@Listeners(util.Listener.class)
public class TC_NewCustomer {
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
    
    @Test(dataProvider="NewCustomerValidData",dataProviderClass=DataProviderClass.class, priority = 1)
    public void verifySubmitValidData(String name, String gender, String birth, String addr, String city, String state, String pin, String mobile, String email, String pwd, String expMsg) {
        AddCustomerSteps acs = new AddCustomerSteps(dm.driver);
        acs.access();
        
        acs.submit(name, gender, birth, addr, city, state, pin, mobile, email, pwd);
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(acs.getResultTable()[0].contains(expMsg));
//        acs.getResultTable()[1] //customer id      
        softAssert.assertTrue(acs.getResultTable()[2].contains(name));
        
        softAssert.assertTrue(acs.getResultTable()[3].contains(gender));
        
//        softAssert.assertTrue(acs.getResultTable()[4].contains(birth)); //format change
        softAssert.assertTrue(acs.getResultTable()[5].contains(addr));
        
        softAssert.assertTrue(acs.getResultTable()[6].contains(city));
        
        softAssert.assertTrue(acs.getResultTable()[7].contains(state));
        
        softAssert.assertTrue(acs.getResultTable()[8].contains(pin));
        
        softAssert.assertTrue(acs.getResultTable()[9].contains(mobile));
        
        softAssert.assertTrue(acs.getResultTable()[10].contains(email));
        
        softAssert.assertAll();
        
    }
    
    @Test(dataProvider="NewCustomerExistData", dataProviderClass=DataProviderClass.class, priority = 2)
    public void verifySubmitExistData(String name, String gender, String birth, String addr, String city, String state, String pin, String mobile, String email, String pwd, String expMsg) {
        AddCustomerSteps acs = new AddCustomerSteps(dm.driver);
        acs.access();
        acs.submit(name, gender, birth, addr, city, state, pin, mobile, email, pwd);

        String str = acs.getAlertMsg(dm.driver);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(str.contains(expMsg));
        softAssert.assertAll();
        
    }
    
    
    @Test(dataProvider="NewCustomerInvalidData", dataProviderClass=DataProviderClass.class, priority = 3)
    public void verifySubmitInvalidData(String name, String gender, String birth, String addr, String city, String state, String pin, String mobile, String email, String pwd, String expMsg, String expMsg1, String expMsg2, String expMsg3, String expMsg4, String expMsg5, String expMsg6, String expMsg7, String expMsg8, String expMsg9, String expMsg10) {
        AddCustomerSteps acs = new AddCustomerSteps(dm.driver);
        acs.access();
      acs.submit(name, gender, birth, addr, city, state, pin, mobile, email, pwd);

      String str = acs.getAlertMsg(dm.driver);
      SoftAssert softAssert = new SoftAssert();

          softAssert.assertTrue(str.contains(expMsg));      

          softAssert.assertTrue(acs.getInvalidDataMsg()[0].contains(expMsg1));      

          softAssert.assertTrue(acs.getInvalidDataMsg()[1].contains(expMsg2));    

          softAssert.assertTrue(acs.getInvalidDataMsg()[2].contains(expMsg3));     

          softAssert.assertTrue(acs.getInvalidDataMsg()[3].contains(expMsg4));
      
          softAssert.assertTrue(acs.getInvalidDataMsg()[4].contains(expMsg5));      

          softAssert.assertTrue(acs.getInvalidDataMsg()[5].contains(expMsg6));
      
          softAssert.assertTrue(acs.getInvalidDataMsg()[6].contains(expMsg7));
      
          softAssert.assertTrue(acs.getInvalidDataMsg()[7].contains(expMsg8));
      
          softAssert.assertTrue(acs.getInvalidDataMsg()[8].contains(expMsg9));
      
          softAssert.assertTrue(acs.getInvalidDataMsg()[9].contains(expMsg10));

          softAssert.assertAll();
  }
    

}
