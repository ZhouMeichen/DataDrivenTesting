package steps;

import org.openqa.selenium.support.PageFactory;

import pageObjects.AddCustomerPage;
import pageObjects.CustomerRegMsgPage;
import pageObjects.HomePage;
import util.AlertClass;
import util.DriverManager;

public class AddCustomerSteps {
    public void access() {
        HomePage hp = PageFactory.initElements(DriverManager.driver, HomePage.class);
        hp.clickNewCustomerLink();
    }
    
    public void submit(String name, String gender, String birth, String addr, String city, String state, String pin, String mobile, String email, String pwd) {
        AddCustomerPage acp = PageFactory.initElements(DriverManager.driver, AddCustomerPage.class); 
        acp.setName(name);
        acp.setGender(gender);
        acp.setBirth(birth);
        acp.setAddr(addr);
        acp.setCity(city);
        acp.setState(state);
        acp.setPin(pin);
        acp.setMobile(mobile);
        acp.setEmail(email);
        acp.setPwd(pwd);
        
        acp.submitBtnClick();
        
    }
    
    public void clickWithData(String name, String addr, String city, String state, String pin, String mobile, String email) {
        AddCustomerPage acp = PageFactory.initElements(DriverManager.driver, AddCustomerPage.class); 
        acp.setName(name);
        acp.clickName();
//        acp.setGender(gender);
//        acp.setBirth(birth);
        acp.setAddr(addr);
        acp.clickAddr();
        
        acp.setCity(city);
        acp.clickCity();
        
        acp.setState(state);
        acp.clickState();
        
        acp.setPin(pin);
        acp.clickPin();
        
        acp.setMobile(mobile);
        acp.clickMobile();
        
        acp.setEmail(email);
        acp.clickEmail();
//        acp.setPwd(pwd);
        
        acp.clickName();
    }
    
    public void click() {
        AddCustomerPage acp = PageFactory.initElements(DriverManager.driver, AddCustomerPage.class);
        acp.clickName();
        acp.clickBirth();
        acp.clickAddr();
        acp.clickCity();
        acp.clickState();
        acp.clickPin();
        acp.clickMobile();
        acp.clickEmail();
        acp.clickPwd();
        acp.clickName();
    }
    
    public String[] getInvalidDataMsg() {
        AddCustomerPage acp = PageFactory.initElements(DriverManager.driver, AddCustomerPage.class);
        return new String[] {acp.getNameMsg(), acp.getAddrMsg(), acp.getCityMsg(), acp.getStateMsg(), acp.getPinMsg(), acp.getMobileMsg(), acp.getEmailMsg()};
    
    }
    
    public String[] getBlankMsg() {
        AddCustomerPage acp = PageFactory.initElements(DriverManager.driver, AddCustomerPage.class);
        return new String[] {acp.getNameMsg(), acp.getBirthMsg(), acp.getAddrMsg(), acp.getCityMsg(), acp.getStateMsg(), acp.getPinMsg(), acp.getMobileMsg(), acp.getEmailMsg(), acp.getPwdMsg()};
    }
    
    public String[] getResultTable() {
        CustomerRegMsgPage crmp = PageFactory.initElements(DriverManager.driver, CustomerRegMsgPage.class);
        return new String[] {crmp.getMsg(), crmp.getId(), crmp.getName(), crmp.getGender(), crmp.getBirth(), crmp.getAddress(), crmp.getCity(), crmp.getState(), crmp.getPin(), crmp.getMobile(), crmp.getEmail()};
        
    }
    
    public String getAlertMsg() {
        return (AlertClass.getMsg(DriverManager.driver));
    }
}
