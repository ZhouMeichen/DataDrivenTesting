package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import pageObjects.BalEnqInputPage;
import pageObjects.BalEnquiryPage;
import pageObjects.HomePage;

import util.AlertClass;

public class BalEnquirySteps {
    BalEnqInputPage objBalEnqInput;
    HomePage objHome;
    BalEnquiryPage objBalEnquiry;
    
    public BalEnquirySteps(WebDriver driver) {
        objBalEnqInput = PageFactory.initElements(driver, BalEnqInputPage.class);
        objHome = PageFactory.initElements(driver, HomePage.class);
        objBalEnquiry = PageFactory.initElements(driver, BalEnquiryPage.class);
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
    
    public String getAlertMsg(WebDriver driver) {
        return AlertClass.getMsgAccept(driver);
    }
    
}
