package com.test;


import org.testng.Assert;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import steps.EditCustomerSteps;
import steps.LoginSteps;
import util.DataProviderClass;
import util.DriverManager;
@Listeners(util.Listener.class)
public class TC_EditCustomer {
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
    
    @Test(dataProvider="EditCustomerValidData",dataProviderClass=DataProviderClass.class, priority = 1)
    public void verifySubmitValidData(String id, String addr, String city, String state, String pin, String mobile, String email, String expMsg) {
        EditCustomerSteps ecs = new EditCustomerSteps();
        ecs.access(id);

        ecs.submit(addr, city, state, pin, mobile, email);

        Assert.assertTrue(ecs.getResultTable()[0].contains(expMsg));
        Assert.assertTrue(ecs.getResultTable()[1].contains(addr));
        Assert.assertTrue(ecs.getResultTable()[2].contains(city));
        Assert.assertTrue(ecs.getResultTable()[3].contains(state));
        Assert.assertTrue(ecs.getResultTable()[4].contains(pin));
        Assert.assertTrue(ecs.getResultTable()[5].contains(mobile));
        Assert.assertTrue(ecs.getResultTable()[6].contains(email));
        
    }
    
   
    
    @Test(dataProvider="EditCustomerInvalidData", dataProviderClass=DataProviderClass.class, priority = 2)
    public void verifySubmitInvalidData(String id, String addr, String city, String state, String pin, String mobile, String email, String expMsg, String expMsg1, String expMsg2, String expMsg3, String expMsg4, String expMsg5, String expMsg6) {
        EditCustomerSteps ecs = new EditCustomerSteps();
        ecs.access(id);
        ecs.submit(addr, city, state, pin, mobile, email);

        String str = ecs.getAlertMsg();
        Assert.assertTrue(str.contains(expMsg));
        
      Assert.assertTrue(ecs.getInvalidDataMsg()[0].contains(expMsg1));
      Assert.assertTrue(ecs.getInvalidDataMsg()[1].contains(expMsg2));
      Assert.assertTrue(ecs.getInvalidDataMsg()[2].contains(expMsg3));
      Assert.assertTrue(ecs.getInvalidDataMsg()[3].contains(expMsg4));
      Assert.assertTrue(ecs.getInvalidDataMsg()[4].contains(expMsg5));
      Assert.assertTrue(ecs.getInvalidDataMsg()[5].contains(expMsg6));
          
  }
    
    @Test(dataProvider="EditCustomerWithoutChangeData", dataProviderClass=DataProviderClass.class, priority = 3)
    public void verifySubmitWithoutChange(String id, String expMsg) {
        EditCustomerSteps ecs = new EditCustomerSteps();
        ecs.access(id);
        ecs.submit();

        String str = ecs.getAlertMsg();
        Assert.assertTrue(str.contains(expMsg));
          
  }

}
