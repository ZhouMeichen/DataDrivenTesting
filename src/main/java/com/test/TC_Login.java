package com.test;


import org.testng.Assert;
import org.testng.annotations.*;


import steps.LoginSteps;

import util.DataProviderClass;
import util.DriverManager;

@Listeners(util.Listener.class)

public class TC_Login {
    
    DriverManager dm;

    
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("BeforeMethod");
        dm = new DriverManager("firefox","http://demo.guru99.com/V4");
        
    }
    
    @AfterMethod
    public void afterMethod() {
        System.out.println("AfterMethod");
        dm.quit();
    }
    
    
    @Test(dataProvider="LoginWithValidData",dataProviderClass=DataProviderClass.class, priority = 1)
    public void verifyValidLogin(String uid, String pwd) {        
        LoginSteps ls = new LoginSteps();
        ls.login(uid, pwd);
        
        String str = ls.getLogoutLink();
        Assert.assertTrue(str.contains("Log out"));
    }
    
    @Test(dataProvider="LoginWithInvalidData",dataProviderClass=DataProviderClass.class, priority = 2)
    public void verifyInvalidLogin(String uid, String pwd) {
        LoginSteps ls = new LoginSteps();
        ls.login(uid, pwd);
        
        String msg = ls.getAlertMsg();
        
        Assert.assertTrue(msg.contains("User or Password is not valid"));
    }
    
}
