package com.test;


import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import steps.LoginSteps;
import util.ConfigProperties;
import util.DataProviderClass;
import util.DriverManager;

@Listeners(util.Listener.class)
public class TC_Login {
    
    DriverManager dm;

    
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("BeforeMethod");
        dm = new DriverManager();
        dm.init(ConfigProperties.get("defaultBrowser"),ConfigProperties.get("url"));
    }
    
    @AfterMethod
    public void afterMethod() {
        System.out.println("AfterMethod");
        dm.quit();
    }
    
    
    @Test(dataProvider="LoginWithValidData",dataProviderClass=DataProviderClass.class, priority = 1)
    public void verifyValidLogin(String uid, String pwd) {        
        LoginSteps ls = new LoginSteps(dm.driver);
        ls.login(uid, pwd);
        
        String str = ls.getLogoutLink();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(str.contains("Log out"));
        softAssert.assertAll();

    }
    
    @Test(dataProvider="LoginWithInvalidData",dataProviderClass=DataProviderClass.class, priority = 2)
    public void verifyInvalidLogin(String uid, String pwd) {
        LoginSteps ls = new LoginSteps(dm.driver);
        ls.login(uid, pwd);
        
        String msg = ls.getAlertMsg(dm.driver);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(msg.contains("User or Password is not valid"));
        softAssert.assertAll();
    }
    
}
