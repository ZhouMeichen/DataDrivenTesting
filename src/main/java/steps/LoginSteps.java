package steps;

import org.openqa.selenium.support.PageFactory;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import util.AlertClass;
import util.DriverManager;

public class LoginSteps {
    LoginPage objLogin;
    HomePage objHome;
    
    public LoginSteps() {
        objLogin = PageFactory.initElements(DriverManager.driver, LoginPage.class);
        objHome = PageFactory.initElements(DriverManager.driver, HomePage.class);
    }
    
    public void login(String strTxtUid, String strTxtPwd){

        objLogin.setUid(strTxtUid);
        objLogin.setPwd(strTxtPwd);

        objLogin.clickLoginButton();   
    }
    
    public void click() {
        objLogin.clickId();
        objLogin.clickPwd();
    }
    
    public String getAlertMsg() {
        return AlertClass.getMsgAccept(DriverManager.driver);
    }
    
    public String getLogoutLink() {
        return objHome.getLogoutTxt();
    }
    
    public String[] getBlankMsg() {
        return new String[] {objLogin.getIdMsg(),objLogin.getPwdMsg()};
    }
}
