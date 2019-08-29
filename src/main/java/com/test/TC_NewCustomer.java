package com.test;



import org.testng.Assert;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import steps.AddCustomerSteps;
import steps.LoginSteps;
import util.ConfigProperties;
import util.DataProviderClass;
import util.DriverManager;
@Listeners(util.Listener.class)
public class TC_NewCustomer {
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
    
    @Test(dataProvider="NewCustomerValidData",dataProviderClass=DataProviderClass.class, priority = 1)
    public void verifySubmitValidData(String name, String gender, String birth, String addr, String city, String state, String pin, String mobile, String email, String pwd, String expMsg) {
        AddCustomerSteps acs = new AddCustomerSteps();
        acs.access();
        
        acs.submit(name, gender, birth, addr, city, state, pin, mobile, email, pwd);

        Assert.assertTrue(acs.getResultTable()[0].contains(expMsg));
//        acs.getResultTable()[1] //customer id
        Assert.assertTrue(acs.getResultTable()[2].contains(name));
        Assert.assertTrue(acs.getResultTable()[3].contains(gender));
//        Assert.assertTrue(acs.getResultTable()[4].contains(birth)); //format change
        Assert.assertTrue(acs.getResultTable()[5].contains(addr));
        Assert.assertTrue(acs.getResultTable()[6].contains(city));
        Assert.assertTrue(acs.getResultTable()[7].contains(state));
        Assert.assertTrue(acs.getResultTable()[8].contains(pin));
        Assert.assertTrue(acs.getResultTable()[9].contains(mobile));
        Assert.assertTrue(acs.getResultTable()[10].contains(email));
        
    }
    
    @Test(dataProvider="NewCustomerExistData", dataProviderClass=DataProviderClass.class, priority = 2)
    public void verifySubmitExistData(String name, String gender, String birth, String addr, String city, String state, String pin, String mobile, String email, String pwd, String expMsg) {
        AddCustomerSteps acs = new AddCustomerSteps();
        acs.access();
        acs.submit(name, gender, birth, addr, city, state, pin, mobile, email, pwd);

        String str = acs.getAlertMsg();
        Assert.assertTrue(str.contains(expMsg));
        
    }
    
    
    @Test(dataProvider="NewCustomerInvalidData", dataProviderClass=DataProviderClass.class, priority = 3)
    public void verifySubmitInvalidData(String name, String gender, String birth, String addr, String city, String state, String pin, String mobile, String email, String pwd, String expMsg, String expMsg1, String expMsg2, String expMsg3, String expMsg4, String expMsg5, String expMsg6, String expMsg7, String expMsg8, String expMsg9, String expMsg10) {
        AddCustomerSteps acs = new AddCustomerSteps();
        acs.access();
      acs.submit(name, gender, birth, addr, city, state, pin, mobile, email, pwd);

      String str = acs.getAlertMsg();
      Assert.assertTrue(str.contains(expMsg));
      
      Assert.assertTrue(acs.getInvalidDataMsg()[0].contains(expMsg1));
      Assert.assertTrue(acs.getInvalidDataMsg()[1].contains(expMsg2));
      Assert.assertTrue(acs.getInvalidDataMsg()[2].contains(expMsg3));
      Assert.assertTrue(acs.getInvalidDataMsg()[3].contains(expMsg4));
      Assert.assertTrue(acs.getInvalidDataMsg()[4].contains(expMsg5));
      Assert.assertTrue(acs.getInvalidDataMsg()[5].contains(expMsg6));
      Assert.assertTrue(acs.getInvalidDataMsg()[6].contains(expMsg7));
      Assert.assertTrue(acs.getInvalidDataMsg()[7].contains(expMsg8));
      Assert.assertTrue(acs.getInvalidDataMsg()[8].contains(expMsg9));
      Assert.assertTrue(acs.getInvalidDataMsg()[9].contains(expMsg10));
          
  }
    

}
