package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import pageObjects.DepositInputPage;
import pageObjects.DepositPage;
import pageObjects.HomePage;
import util.AlertClass;


public class DepositSteps {
    DepositInputPage objDepositInput;
    HomePage objHome;
    DepositPage objDeposit;
    
    public DepositSteps(WebDriver driver) {
        objDepositInput = PageFactory.initElements(driver, DepositInputPage.class);
        objHome = PageFactory.initElements(driver, HomePage.class);
        objDeposit = PageFactory.initElements(driver, DepositPage.class);
    }
    
    public void access() {
        objHome.clickDepositLink();
    }
    
    public void submit(String account, String amount, String desc) {
        objDepositInput.setAccount(account);
        objDepositInput.clickAccountLabel();
        
        objDepositInput.setAmount(amount);
        objDepositInput.clickAccountLabel();
        
        objDepositInput.setDesc(desc);
        objDepositInput.clickAccountLabel();
        
        objDepositInput.submitBtnClick();
    }
    
    public String[] getResultTable() {
        return new String[] {objDeposit.getMsg(), objDeposit.getTransId(), objDeposit.getAccount(), objDeposit.getAmount(),objDeposit.getType(),objDeposit.getDesc(),objDeposit.getBalance()};
    }
    
    public String[] getInvalidDataMsg() {
        return new String[] {objDepositInput.getAccountMsg(), objDepositInput.getAmountMsg(), objDepositInput.getDescMsg()};
    }
    
    public String getAlertMsg(WebDriver driver) {
        return AlertClass.getMsgAccept(driver);
    }
    
}
