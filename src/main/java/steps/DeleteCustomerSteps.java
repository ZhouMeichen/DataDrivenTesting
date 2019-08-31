package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import pageObjects.DeleteCustomerInputPage;
import pageObjects.HomePage;
import util.AlertClass;

public class DeleteCustomerSteps {
    DeleteCustomerInputPage objDeleteCustomer;
    HomePage objHome;
    
    public DeleteCustomerSteps(WebDriver driver) {
        objDeleteCustomer = PageFactory.initElements(driver, DeleteCustomerInputPage.class);
        objHome = PageFactory.initElements(driver, HomePage.class);
    }
    
    public void access() {
        
        objHome.clickDeleteCustomerLink();
        
    }
    
    public void submit(String str) {
        objDeleteCustomer.setId(str);
        objDeleteCustomer.clickIdLable();
        objDeleteCustomer.submitBtnClick();
    }
    
    public String getInvalidDataMsg() {
        return objDeleteCustomer.getIdMsg();
    }
    
    public String getAlertMsg(WebDriver driver) {
        return AlertClass.getMsgAccept(driver);        
    }
    
}
