package steps;

import org.openqa.selenium.support.PageFactory;

import pageObjects.BalEnqInputPage;
import pageObjects.BalEnquiryPage;
import pageObjects.HomePage;

import util.AlertClass;
import util.DriverManager;

public class BalEnquirySteps {
    BalEnqInputPage objBalEnqInput;
    HomePage objHome;
    BalEnquiryPage objBalEnquiry;
    
    public BalEnquirySteps() {
        objBalEnqInput = PageFactory.initElements(DriverManager.driver, BalEnqInputPage.class);
        objHome = PageFactory.initElements(DriverManager.driver, HomePage.class);
        objBalEnquiry = PageFactory.initElements(DriverManager.driver, BalEnquiryPage.class);
    }
    
    public void access() {
        objHome.clickBalEnquiryLink();
    }
    
    public void submit(String account) {
        objBalEnqInput.setAccount(account);
        objBalEnqInput.clickAccountLabel();
        
        
        
        objBalEnqInput.submitBtnClick();
    }
    
    public String[] getResultTable() {
        return new String[] {objBalEnquiry.getMsg(), objBalEnquiry.getAccount(),objBalEnquiry.getType(),objBalEnquiry.getBalance()};
    }
    
    public String[] getInvalidDataMsg() {
        return new String[] {objBalEnqInput.getAccountMsg()};
    }
    
    public String getAlertMsg() {
        return AlertClass.getMsgAccept(DriverManager.driver);
    }
    
}
