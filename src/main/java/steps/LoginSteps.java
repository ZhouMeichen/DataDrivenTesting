package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import util.AlertClass;

public class LoginSteps {
    LoginPage objLogin;
    HomePage objHome;
    
    public LoginSteps(WebDriver driver) {
        objLogin = PageFactory.initElements(driver, LoginPage.class);
        objHome = PageFactory.initElements(driver, HomePage.class);
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
    
    public String getAlertMsg(WebDriver driver) {
        return AlertClass.getMsgAccept(driver);
    }
    
    public String getLogoutLink() {
        return objHome.getLogoutTxt();
    }
    
    public String[] getBlankMsg() {
        return new String[] {objLogin.getIdMsg(),objLogin.getPwdMsg()};
    }
}
