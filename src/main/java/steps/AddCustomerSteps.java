package steps;

import org.openqa.selenium.support.PageFactory;

import pageObjects.AddCustomerPage;
import pageObjects.CustomerRegMsgPage;
import pageObjects.HomePage;
import util.AlertClass;
import util.DriverManager;

public class AddCustomerSteps {
    HomePage objHome;
    AddCustomerPage objAddCustomer;
    CustomerRegMsgPage objCustomerRegMsg;
    
    public AddCustomerSteps() {
        objHome = PageFactory.initElements(DriverManager.driver, HomePage.class);
        objAddCustomer = PageFactory.initElements(DriverManager.driver, AddCustomerPage.class);
        objCustomerRegMsg = PageFactory.initElements(DriverManager.driver, CustomerRegMsgPage.class);
    }
    
    public void access() {
        objHome.clickNewCustomerLink();
    }
    
    public void submit(String name, String gender, String birth, String addr, String city, String state, String pin, String mobile, String email, String pwd) {
         
        objAddCustomer.setName(name);
        objAddCustomer.setGender(gender);
        objAddCustomer.setBirth(birth);
        objAddCustomer.setAddr(addr);
        objAddCustomer.setCity(city);
        objAddCustomer.setState(state);
        objAddCustomer.setPin(pin);
        objAddCustomer.setMobile(mobile);
        objAddCustomer.setEmail(email);
        objAddCustomer.setPwd(pwd);
        
        objAddCustomer.submitBtnClick();
        
    }
    
    public void clickWithData(String name, String addr, String city, String state, String pin, String mobile, String email) {
         
        objAddCustomer.setName(name);
        objAddCustomer.clickName();

        objAddCustomer.setAddr(addr);
        objAddCustomer.clickAddr();
        
        objAddCustomer.setCity(city);
        objAddCustomer.clickCity();
        
        objAddCustomer.setState(state);
        objAddCustomer.clickState();
        
        objAddCustomer.setPin(pin);
        objAddCustomer.clickPin();
        
        objAddCustomer.setMobile(mobile);
        objAddCustomer.clickMobile();
        
        objAddCustomer.setEmail(email);
        objAddCustomer.clickEmail();

        
        objAddCustomer.clickName();
    }
    
    public void click() {
        
        objAddCustomer.clickName();
        objAddCustomer.clickBirth();
        objAddCustomer.clickAddr();
        objAddCustomer.clickCity();
        objAddCustomer.clickState();
        objAddCustomer.clickPin();
        objAddCustomer.clickMobile();
        objAddCustomer.clickEmail();
        objAddCustomer.clickPwd();
        objAddCustomer.clickName();
    }
    
    public String[] getInvalidDataMsg() {
        
        return new String[] {objAddCustomer.getNameMsg(), objAddCustomer.getAddrMsg(), objAddCustomer.getCityMsg(), objAddCustomer.getStateMsg(), objAddCustomer.getPinMsg(), objAddCustomer.getMobileMsg(), objAddCustomer.getEmailMsg()};
    
    }
    
    public String[] getBlankMsg() {
        
        return new String[] {objAddCustomer.getNameMsg(), objAddCustomer.getBirthMsg(), objAddCustomer.getAddrMsg(), objAddCustomer.getCityMsg(), objAddCustomer.getStateMsg(), objAddCustomer.getPinMsg(), objAddCustomer.getMobileMsg(), objAddCustomer.getEmailMsg(), objAddCustomer.getPwdMsg()};
    }
    
    public String[] getResultTable() {
        
        return new String[] {objCustomerRegMsg.getMsg(), objCustomerRegMsg.getId(), objCustomerRegMsg.getName(), objCustomerRegMsg.getGender(), objCustomerRegMsg.getBirth(), objCustomerRegMsg.getAddress(), objCustomerRegMsg.getCity(), objCustomerRegMsg.getState(), objCustomerRegMsg.getPin(), objCustomerRegMsg.getMobile(), objCustomerRegMsg.getEmail()};
        
    }
    
    public String getAlertMsg() {
        return (AlertClass.getMsg(DriverManager.driver));
    }
}
