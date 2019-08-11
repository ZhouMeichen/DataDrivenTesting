package steps;

import org.openqa.selenium.support.PageFactory;

import pageObjects.DeleteCustomerInputPage;
import pageObjects.HomePage;
import util.AlertClass;
import util.DriverManager;

public class DeleteCustomerSteps {
    DeleteCustomerInputPage objDeleteCustomer;
    HomePage objHome;
    
    public DeleteCustomerSteps() {
        objDeleteCustomer = PageFactory.initElements(DriverManager.driver, DeleteCustomerInputPage.class);
        objHome = PageFactory.initElements(DriverManager.driver, HomePage.class);
    }
    
    public void access() {
        
        objHome.clickDeleteCustomerLink();
        
    }
    
    public void submit(String str) {
        objDeleteCustomer.setId(str);
        objDeleteCustomer.clickIdLable();
        objDeleteCustomer.submitBtnClick();
    }
    
//    public void submit() {
//        objDeleteCustomer.submitBtnClick();
//    }
    
//    public void clickWithData(String str) {
//        objDeleteCustomer.setId(str);
//        objDeleteCustomer.clickIdLable();
//    }
    
    public String getInvalidDataMsg() {
        return objDeleteCustomer.getIdMsg();
    }
    
    public String getAlertMsg() {
        return AlertClass.getMsgAccept(DriverManager.driver);        
    }
    
}
