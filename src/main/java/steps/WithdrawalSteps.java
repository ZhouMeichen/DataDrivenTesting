package steps;

import org.openqa.selenium.support.PageFactory;


import pageObjects.HomePage;
import pageObjects.WithdrawalInputPage;
import pageObjects.WithdrawalPage;
import util.AlertClass;
import util.DriverManager;

public class WithdrawalSteps {
    WithdrawalInputPage objWithdrawalInput;
    HomePage objHome;
    WithdrawalPage objWithdrawal;
    
    public WithdrawalSteps() {
        objWithdrawalInput = PageFactory.initElements(DriverManager.driver, WithdrawalInputPage.class);
        objHome = PageFactory.initElements(DriverManager.driver, HomePage.class);
        objWithdrawal = PageFactory.initElements(DriverManager.driver, WithdrawalPage.class);
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
    
    public String getAlertMsg() {
        return AlertClass.getMsgAccept(DriverManager.driver);
    }
    
}
