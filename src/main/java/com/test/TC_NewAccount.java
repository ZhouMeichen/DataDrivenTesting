package com.test;



import org.testng.Assert;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import steps.AddAccountSteps;
import steps.LoginSteps;
import util.ConfigProperties;
import util.DataProviderClass;
import util.DriverManager;
@Listeners(util.Listener.class)
public class TC_NewAccount {
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
    
    @Test(dataProvider="NewAccountValidData",dataProviderClass=DataProviderClass.class, priority = 1)
    public void verifySubmitValidData(String cusId, String type, String amount, String expMsg) {
        AddAccountSteps aas = new AddAccountSteps();
        aas.access();
        
        aas.submit(cusId, type, amount);

        Assert.assertTrue(aas.getResultTable()[0].contains(expMsg));
        Assert.assertTrue(aas.getResultTable()[2].contains(cusId));
        Assert.assertTrue(aas.getResultTable()[5].contains(type));
        Assert.assertTrue(aas.getResultTable()[7].contains(amount));
    
    }
    
    
    @Test(dataProvider="NewAccountInvalidData", dataProviderClass=DataProviderClass.class,priority = 2)
    public void verifySubmitInvalidData(String id, String type, String amount, String expMsg1, String expMsg2, String expMsg3) {
        AddAccountSteps aas = new AddAccountSteps();
        aas.access();
        aas.submit(id, type, amount);

        String str = aas.getAlertMsg();
        Assert.assertTrue(str.contains(expMsg1));
        
      Assert.assertTrue(aas.getInvalidDataMsg()[0].contains(expMsg2));
      Assert.assertTrue(aas.getInvalidDataMsg()[1].contains(expMsg3));
        
    }
    

}
