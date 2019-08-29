package com.test;


import org.testng.Assert;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import steps.EditCustomerSteps;
import steps.LoginSteps;
import util.ConfigProperties;
import util.DataProviderClass;
import util.DriverManager;
@Listeners(util.Listener.class)
public class TC_EditCustomer {
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
    
    @Test(dataProvider="EditCustomerValidData",dataProviderClass=DataProviderClass.class, priority = 1)
    public void verifySubmitValidData(String id, String addr, String city, String state, String pin, String mobile, String email, String expMsg) {
        EditCustomerSteps ecs = new EditCustomerSteps();
        ecs.access(id);

        ecs.submit(addr, city, state, pin, mobile, email);

        try {
            Assert.assertTrue(ecs.getResultTable()[0].contains(expMsg));
        }catch(Exception e) {
            System.out.println(e);
        } 
        
        try {
            Assert.assertTrue(ecs.getResultTable()[1].contains(addr));
        }catch(Exception e) {
            System.out.println(e);
        } 
        
        try {
            Assert.assertTrue(ecs.getResultTable()[2].contains(city));
        }catch(Exception e) {
            System.out.println(e);
        } 
        
        try {
            Assert.assertTrue(ecs.getResultTable()[3].contains(state));
        }catch(Exception e) {
            System.out.println(e);
        } 
        
        try {
            Assert.assertTrue(ecs.getResultTable()[4].contains(pin));
        }catch(Exception e) {
            System.out.println(e);
        } 
        
        try {
            Assert.assertTrue(ecs.getResultTable()[5].contains(mobile));
        }catch(Exception e) {
            System.out.println(e);
        } 
        
        try {
            Assert.assertTrue(ecs.getResultTable()[6].contains(email));
        }catch(Exception e) {
            System.out.println(e);
        } 
        
    }
    
   
    
    @Test(dataProvider="EditCustomerInvalidData", dataProviderClass=DataProviderClass.class, priority = 2)
    public void verifySubmitInvalidData(String id, String addr, String city, String state, String pin, String mobile, String email, String expMsg, String expMsg1, String expMsg2, String expMsg3, String expMsg4, String expMsg5, String expMsg6) {
        EditCustomerSteps ecs = new EditCustomerSteps();
        ecs.access(id);
        ecs.submit(addr, city, state, pin, mobile, email);

        String str = ecs.getAlertMsg();
        try {
            Assert.assertTrue(str.contains(expMsg));
        }catch(Exception e) {
            System.out.println(e);
        } 
        
        try {
            Assert.assertTrue(ecs.getInvalidDataMsg()[0].contains(expMsg1));
        }catch(Exception e) {
            System.out.println(e);
        } 
        
        try {
            Assert.assertTrue(ecs.getInvalidDataMsg()[1].contains(expMsg2));
        }catch(Exception e) {
            System.out.println(e);
        } 
        
        try {
            Assert.assertTrue(ecs.getInvalidDataMsg()[2].contains(expMsg3));
        }catch(Exception e) {
            System.out.println(e);
        }
        
        try {
            Assert.assertTrue(ecs.getInvalidDataMsg()[3].contains(expMsg4));
        }catch(Exception e) {
            System.out.println(e);
        } 
        
        try {
            Assert.assertTrue(ecs.getInvalidDataMsg()[4].contains(expMsg5));
        }catch(Exception e) {
            System.out.println(e);
        } 
        
        try {
            Assert.assertTrue(ecs.getInvalidDataMsg()[5].contains(expMsg6));
        }catch(Exception e) {
            System.out.println(e);
        } 
          
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
