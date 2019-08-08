package com.test;



import org.testng.Assert;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import steps.AddCustomerSteps;
import steps.LoginSteps;
import util.DataProviderClass;
import util.DriverManager;

public class TC_NewCustomer {
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
    
    @Test(dataProvider="NewCustomerSubmitValidData",dataProviderClass=DataProviderClass.class, priority = 1)
    public void verifySubmitValidData(String name, String gender, String birth, String addr, String city, String state, String pin, String mobile, String email, String pwd, String expMsg) {
        AddCustomerSteps acs = new AddCustomerSteps();
        acs.access();
        acs.submit(name, gender, birth, addr, city, state, pin, mobile, email, pwd);

        Assert.assertTrue(acs.getResultTable()[0].contains(expMsg));
        Assert.assertTrue(acs.getResultTable()[2].contains(name));
        Assert.assertTrue(acs.getResultTable()[3].contains(gender));
//        Assert.assertTrue(acs.getResultTable()[4].contains(birth));
        Assert.assertTrue(acs.getResultTable()[5].contains(addr));
        Assert.assertTrue(acs.getResultTable()[6].contains(city));
        Assert.assertTrue(acs.getResultTable()[7].contains(state));
        Assert.assertTrue(acs.getResultTable()[8].contains(pin));
        Assert.assertTrue(acs.getResultTable()[9].contains(mobile));
        Assert.assertTrue(acs.getResultTable()[10].contains(email));
        
    }
    
    @Test(dataProvider="NewCustomerSubmitExistData", dataProviderClass=DataProviderClass.class, priority = 2)
    public void verifySubmitExistData(String name, String gender, String birth, String addr, String city, String state, String pin, String mobile, String email, String pwd, String expMsg) {
        AddCustomerSteps acs = new AddCustomerSteps();
        acs.access();
        acs.submit(name, gender, birth, addr, city, state, pin, mobile, email, pwd);

        String str = acs.getAlertMsg();
        Assert.assertTrue(str.contains(expMsg));
        
    }
    
    @Test(dataProvider="NewCustomerSubmitBlankData", dataProviderClass=DataProviderClass.class, priority = 3)
    public void verifySubmitBlankData(String name, String gender, String birth, String addr, String city, String state, String pin, String mobile, String email, String pwd, String expMsg) {
        AddCustomerSteps acs = new AddCustomerSteps();
        acs.access();
        acs.submit(name, gender, birth, addr, city, state, pin, mobile, email, pwd);

        String str = acs.getAlertMsg();
        Assert.assertTrue(str.contains(expMsg));
        
    }
    
    @Test(priority = 4)
    public void verifyFrontEndBlankMsg() {
        AddCustomerSteps acs = new AddCustomerSteps();
        acs.access();
        acs.click();

        for (int i =0;i<acs.getBlankMsg().length;i++) {
            Assert.assertTrue(acs.getBlankMsg()[i].contains("must not be blank"));
        }
        
        
    }
    
    @Test(dataProvider="NewCustomerInputOtherInvalidData", dataProviderClass=DataProviderClass.class, priority = 5)
    public void verifyFrontEndOtherMsg(String name, String gender, String birth, String addr, String city, String state, String pin, String mobile, String email, String pwd, String expMsg1, String expMsg2, String expMsg3, String expMsg4, String expMsg5) {
      AddCustomerSteps acs = new AddCustomerSteps();
      acs.access();
      acs.clickWithData(name, addr, city, state, pin, mobile, email);

      Assert.assertTrue(acs.getInvalidDataMsg()[0].contains(expMsg1));
      Assert.assertTrue(acs.getInvalidDataMsg()[1].contains(expMsg2));
      Assert.assertTrue(acs.getInvalidDataMsg()[2].contains(expMsg1));
      Assert.assertTrue(acs.getInvalidDataMsg()[3].contains(expMsg1));
      Assert.assertTrue(acs.getInvalidDataMsg()[4].contains(expMsg3));
      Assert.assertTrue(acs.getInvalidDataMsg()[5].contains(expMsg4));
      Assert.assertTrue(acs.getInvalidDataMsg()[6].contains(expMsg5));
          
  }
    

}
