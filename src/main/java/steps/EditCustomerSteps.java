package steps;

import org.openqa.selenium.support.PageFactory;

import pageObjects.AddCustomerPage;
import pageObjects.CustomerRegMsgPage;
import pageObjects.CustomerUpdateMsgPage;
import pageObjects.EditCustomerEnterIDPage;
import pageObjects.EditCustomerPage;
import pageObjects.HomePage;
import util.AlertClass;
import util.DriverManager;

public class EditCustomerSteps {
    HomePage objHome;
    EditCustomerEnterIDPage objEditCustomerEnterID;
    EditCustomerPage objEditCustomer;
    CustomerUpdateMsgPage ObjCustomerUpdateMsg;
    
    public EditCustomerSteps() {
        objHome = PageFactory.initElements(DriverManager.driver, HomePage.class);
        objEditCustomerEnterID = PageFactory.initElements(DriverManager.driver, EditCustomerEnterIDPage.class);
        objEditCustomer = PageFactory.initElements(DriverManager.driver, EditCustomerPage.class);
        ObjCustomerUpdateMsg = PageFactory.initElements(DriverManager.driver, CustomerUpdateMsgPage.class);
    }
    
    public void access(String customerId) {
        
        objHome.clickEditCustomerLink();
        
        
        objEditCustomerEnterID.setId(customerId);
        objEditCustomerEnterID.submitBtnClick();
    }
    
    public void submit(String addr, String city, String state, String pin, String mobile, String email) {
         

        objEditCustomer.setAddr(addr);
        objEditCustomer.setCity(city);
        objEditCustomer.setState(state);
        objEditCustomer.setPin(pin);
        objEditCustomer.setMobile(mobile);
        objEditCustomer.setEmail(email);
        
        objEditCustomer.submitBtnClick();
        
    }
    
    public void submit() {
        
        objEditCustomer.submitBtnClick();
    }
    
    public void clickWithData(String addr, String city, String state, String pin, String mobile, String email) {
         

        objEditCustomer.setAddr(addr);
        objEditCustomer.clickAddr();
        
        objEditCustomer.setCity(city);
        objEditCustomer.clickCity();
        
        objEditCustomer.setState(state);
        objEditCustomer.clickState();
        
        objEditCustomer.setPin(pin);
        objEditCustomer.clickPin();
        
        objEditCustomer.setMobile(mobile);
        objEditCustomer.clickMobile();
        
        objEditCustomer.setEmail(email);
        objEditCustomer.clickEmail();

        
        objEditCustomer.clickAddr();
    }
    
    
    
    public String[] getInvalidDataMsg() {
        
        return new String[] { objEditCustomer.getAddrMsg(), objEditCustomer.getCityMsg(), objEditCustomer.getStateMsg(), objEditCustomer.getPinMsg(), objEditCustomer.getMobileMsg(), objEditCustomer.getEmailMsg()};
    
    }
    
    
    public String[] getResultTable() {
        
        return new String[] {ObjCustomerUpdateMsg.getMsg(), ObjCustomerUpdateMsg.getAddress(), ObjCustomerUpdateMsg.getCity(), ObjCustomerUpdateMsg.getState(), ObjCustomerUpdateMsg.getPin(), ObjCustomerUpdateMsg.getMobile(), ObjCustomerUpdateMsg.getEmail()};
        
    }
    
    public String getAlertMsg() {
        return (AlertClass.getMsg(DriverManager.driver));
    }
}
