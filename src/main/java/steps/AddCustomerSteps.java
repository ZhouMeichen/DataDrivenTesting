package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import pageObjects.AddCustomerPage;
import pageObjects.CustomerRegMsgPage;
import pageObjects.HomePage;
import util.AlertClass;

public class AddCustomerSteps {
    AddCustomerPage objAddCustomer;
    HomePage objHome;
    CustomerRegMsgPage objCustomerRegMsg;
    
    public AddCustomerSteps(WebDriver driver) {
        objHome = PageFactory.initElements(driver, HomePage.class);
        objAddCustomer = PageFactory.initElements(driver, AddCustomerPage.class);
        objCustomerRegMsg = PageFactory.initElements(driver, CustomerRegMsgPage.class);
    }
    
    public void access() {
        objHome.clickNewCustomerLink();
    }
    
    public void submit(String name, String gender, String birth, String addr, String city, String state, String pin, String mobile, String email, String pwd) {
              
        objAddCustomer.setName(name);
        objAddCustomer.clickNameLabel();
        
        objAddCustomer.setGender(gender);
        
        objAddCustomer.setBirth(birth);
        objAddCustomer.clickNameLabel();

        objAddCustomer.setAddr(addr);
        objAddCustomer.clickNameLabel();
        
        objAddCustomer.setCity(city);
        objAddCustomer.clickNameLabel();
        
        objAddCustomer.setState(state);
        objAddCustomer.clickNameLabel();
        
        objAddCustomer.setPin(pin);
        objAddCustomer.clickNameLabel();
        
        objAddCustomer.setMobile(mobile);
        objAddCustomer.clickNameLabel();
        
        objAddCustomer.setEmail(email);
        objAddCustomer.clickNameLabel();
        
        objAddCustomer.setPwd(pwd);
        objAddCustomer.clickNameLabel();
        
        objAddCustomer.submitBtnClick();
        
    }
    
    public void submit() {
        objAddCustomer.submitBtnClick();
    }
    

    public String[] getInvalidDataMsg() {
        
        return new String[] {objAddCustomer.getNameMsg(), "", objAddCustomer.getBirthMsg(), objAddCustomer.getAddrMsg(), objAddCustomer.getCityMsg(), objAddCustomer.getStateMsg(), objAddCustomer.getPinMsg(), objAddCustomer.getMobileMsg(), objAddCustomer.getEmailMsg(), objAddCustomer.getPwdMsg()};
    
    }
    
    public String[] getResultTable() {
        
        return new String[] {objCustomerRegMsg.getMsg(), objCustomerRegMsg.getId(), objCustomerRegMsg.getName(), objCustomerRegMsg.getGender(), objCustomerRegMsg.getBirth(), objCustomerRegMsg.getAddress(), objCustomerRegMsg.getCity(), objCustomerRegMsg.getState(), objCustomerRegMsg.getPin(), objCustomerRegMsg.getMobile(), objCustomerRegMsg.getEmail()};
        
    }
    
    public String getAlertMsg(WebDriver driver) {
        return AlertClass.getMsgAccept(driver);
    }
}
