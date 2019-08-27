package com.test;


import org.testng.Assert;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import steps.DeleteCustomerSteps;
import steps.LoginSteps;
import util.DataProviderClass;
import util.DriverManager;
@Listeners(util.Listener.class)
public class TC_DeleteCustomer {
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
    
    @Test(dataProvider="DeleteCustomerValidData",dataProviderClass=DataProviderClass.class, priority = 1)
    public void verifySubmitValidData(String id, String expMsg1, String expMsg2) {
        DeleteCustomerSteps dcs = new DeleteCustomerSteps();
        dcs.access();
        dcs.submit(id);
        String str = dcs.getAlertMsg();
        Assert.assertTrue(str.contains(expMsg1));
        str = dcs.getAlertMsg();
        Assert.assertTrue(str.contains(expMsg2));

    }
    
    @Test(dataProvider="DeleteCustomerNotExistData",dataProviderClass=DataProviderClass.class, priority = 2)
    public void verifySubmitNotExistData(String id, String expMsg1, String expMsg2) {
        DeleteCustomerSteps dcs = new DeleteCustomerSteps();
        dcs.access();
        
        dcs.submit(id);
        
        String str = dcs.getAlertMsg();
        Assert.assertTrue(str.contains(expMsg1));
        str = dcs.getAlertMsg();
        Assert.assertTrue(str.contains(expMsg2));

    }
    
    
   
    
    @Test(dataProvider="DeleteCustomerInvalidData", dataProviderClass=DataProviderClass.class, priority = 3)
    public void verifySubmitInvalidData(String id, String expMsg1, String expMsg2) {
        DeleteCustomerSteps dcs = new DeleteCustomerSteps();
        dcs.access();
        dcs.submit(id);

        String str = dcs.getAlertMsg();
        Assert.assertTrue(str.contains(expMsg1));
        Assert.assertTrue(dcs.getInvalidDataMsg().contains(expMsg2));
          
  }

}
