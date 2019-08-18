package steps;

import org.openqa.selenium.support.PageFactory;

import pageObjects.HomePage;
import pageObjects.MiniStatementInputPage;
import pageObjects.MiniStatementPage;
import util.AlertClass;
import util.DriverManager;

public class MiniStatementSteps {
    MiniStatementInputPage objMiniStatementInput;
    MiniStatementPage objMiniStatement;
    HomePage objHome;
    
    public MiniStatementSteps() {
        objHome = PageFactory.initElements(DriverManager.driver, HomePage.class);
        objMiniStatementInput = PageFactory.initElements(DriverManager.driver, MiniStatementInputPage.class);
        objMiniStatement = PageFactory.initElements(DriverManager.driver, MiniStatementPage.class);
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
    
    public String getAlertMsg() {
        return AlertClass.getMsgAccept(DriverManager.driver);        
    }
    
    public String[] getResult(String transactionId) {
        return objMiniStatement.getTableRow(transactionId);
    }
}
