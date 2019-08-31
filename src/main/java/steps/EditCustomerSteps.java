package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


import pageObjects.CustomerUpdateMsgPage;
import pageObjects.EditCustomerEnterIDPage;
import pageObjects.EditCustomerPage;
import pageObjects.HomePage;
import util.AlertClass;

public class EditCustomerSteps {
    
    EditCustomerEnterIDPage objEditCustomerEnterID;
    EditCustomerPage objEditCustomer;
    CustomerUpdateMsgPage ObjCustomerUpdateMsg;
    HomePage objHome;
    
    public EditCustomerSteps(WebDriver driver) {
        objHome = PageFactory.initElements(driver, HomePage.class);
        objEditCustomerEnterID = PageFactory.initElements(driver, EditCustomerEnterIDPage.class);
        objEditCustomer = PageFactory.initElements(driver, EditCustomerPage.class);
        ObjCustomerUpdateMsg = PageFactory.initElements(driver, CustomerUpdateMsgPage.class);
    }
    
    public void access(String customerId) {
        
        objHome.clickEditCustomerLink();
        
        
        objEditCustomerEnterID.setId(customerId);
        objEditCustomerEnterID.submitBtnClick();
    }
    
    public void submit(String addr, String city, String state, String pin, String mobile, String email) {
         

        objEditCustomer.setAddr(addr);
        objEditCustomer.clickNameLabel();
        
        objEditCustomer.setCity(city);
        objEditCustomer.clickNameLabel();
        
        objEditCustomer.setState(state);
        objEditCustomer.clickNameLabel();
        
        objEditCustomer.setPin(pin);
        objEditCustomer.clickNameLabel();
        
        objEditCustomer.setMobile(mobile);
        objEditCustomer.clickNameLabel();
        
        objEditCustomer.setEmail(email);
        objEditCustomer.clickNameLabel();
        
        objEditCustomer.submitBtnClick();
        
    }
    
    public void submit() {
        
        objEditCustomer.submitBtnClick();
    }

            
    public String[] getInvalidDataMsg() {
        
        return new String[] { objEditCustomer.getAddrMsg(), objEditCustomer.getCityMsg(), objEditCustomer.getStateMsg(), objEditCustomer.getPinMsg(), objEditCustomer.getMobileMsg(), objEditCustomer.getEmailMsg()};
    
    }
        
    public String[] getResultTable() {
        
        return new String[] {ObjCustomerUpdateMsg.getMsg(), ObjCustomerUpdateMsg.getAddress(), ObjCustomerUpdateMsg.getCity(), ObjCustomerUpdateMsg.getState(), ObjCustomerUpdateMsg.getPin(), ObjCustomerUpdateMsg.getMobile(), ObjCustomerUpdateMsg.getEmail()};
        
    }
    
    public String getAlertMsg(WebDriver driver) {
        return AlertClass.getMsgAccept(driver);
    }
}
