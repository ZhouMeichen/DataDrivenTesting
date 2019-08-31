package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import pageObjects.HomePage;
import pageObjects.MiniStatementInputPage;
import pageObjects.MiniStatementPage;
import util.AlertClass;


public class MiniStatementSteps {
    MiniStatementInputPage objMiniStatementInput;
    MiniStatementPage objMiniStatement;
    HomePage objHome;
    
    public MiniStatementSteps(WebDriver driver) {
        objHome = PageFactory.initElements(driver, HomePage.class);
        objMiniStatementInput = PageFactory.initElements(driver, MiniStatementInputPage.class);
        objMiniStatement = PageFactory.initElements(driver, MiniStatementPage.class);
    }
    
    public void access() {
        objHome.clickMiniStatementLink();
    }
    
    public void submit(String str) {
        objMiniStatementInput.setAccount(str);
        objMiniStatementInput.clickAccountLable();
        objMiniStatementInput.submitBtnClick();
    }
    
    public String getInvalidDataMsg() {
        return objMiniStatementInput.getAccountMsg();
    }
    
    public String getAlertMsg(WebDriver driver) {
        return AlertClass.getMsgAccept(driver);        
    }
    
    public String[] getResult(String transactionId) {
        return objMiniStatement.getTableRow(transactionId);
    }
}
