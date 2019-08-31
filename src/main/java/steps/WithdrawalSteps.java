package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


import pageObjects.HomePage;
import pageObjects.WithdrawalInputPage;
import pageObjects.WithdrawalPage;
import util.AlertClass;


public class WithdrawalSteps {
    WithdrawalInputPage objWithdrawalInput;
    HomePage objHome;
    WithdrawalPage objWithdrawal;
    
    public WithdrawalSteps(WebDriver driver) {
        objWithdrawalInput = PageFactory.initElements(driver, WithdrawalInputPage.class);
        objHome = PageFactory.initElements(driver, HomePage.class);
        objWithdrawal = PageFactory.initElements(driver, WithdrawalPage.class);
    }
    
    public void access() {
        objHome.clickWithdrawalLink();
    }
    
    public void submit(String account, String amount, String desc) {
        objWithdrawalInput.setAccount(account);
        objWithdrawalInput.clickAccountLabel();
        
        objWithdrawalInput.setAmount(amount);
        objWithdrawalInput.clickAccountLabel();
        
        objWithdrawalInput.setDesc(desc);
        objWithdrawalInput.clickAccountLabel();
        
        objWithdrawalInput.submitBtnClick();
    }
    
    public String[] getResultTable() {
        return new String[] {objWithdrawal.getMsg(), objWithdrawal.getTransId(), objWithdrawal.getAccount(), objWithdrawal.getAmount(),objWithdrawal.getType(),objWithdrawal.getDesc(),objWithdrawal.getBalance()};
    }
    
    public String[] getInvalidDataMsg() {
        return new String[] {objWithdrawalInput.getAccountMsg(), objWithdrawalInput.getAmountMsg(), objWithdrawalInput.getDescMsg()};
    }
    
    public String getAlertMsg(WebDriver driver) {
        return AlertClass.getMsgAccept(driver);
    }
    
}
