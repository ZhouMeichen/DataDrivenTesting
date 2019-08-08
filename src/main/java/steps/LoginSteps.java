package steps;

import org.openqa.selenium.support.PageFactory;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import util.AlertClass;
import util.DriverManager;

public class LoginSteps {
    public void login(String strTxtUid, String strTxtPwd){
        LoginPage objLogin = PageFactory.initElements(DriverManager.driver, LoginPage.class);

        objLogin.setUid(strTxtUid);
        objLogin.setPwd(strTxtPwd);


        objLogin.clickLoginButton();   
    }
    
    public String getAlertMsg() {
        return AlertClass.getMsg(DriverManager.driver);
    }
    
    public String getLogoutLink() {
        HomePage objHome = PageFactory.initElements(DriverManager.driver, HomePage.class);
        return objHome.getLogoutTxt();
    }
}
