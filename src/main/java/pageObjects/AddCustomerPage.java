package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddCustomerPage {
    
    @FindBy(how = How.NAME, using = "name")
    WebElement name;

    @FindBy(how = How.XPATH, using = "//input[@value='m']")
    WebElement male;
    
    @FindBy(how = How.XPATH, using = "//input[@value='f']")
    WebElement female;

    @FindBy(how = How.NAME, using = "dob")
    WebElement birth;

    @FindBy(how = How.NAME, using = "addr")
    WebElement address;

    @FindBy(how = How.NAME, using = "city")
    WebElement city;

    @FindBy(how = How.NAME, using = "state")
    WebElement state;
    
    @FindBy(how = How.NAME, using = "pinno")
    WebElement pin;

    @FindBy(how = How.NAME, using = "telephoneno")
    WebElement mobile;

    @FindBy(how = How.NAME, using = "emailid")
    WebElement email;

    @FindBy(how = How.NAME, using = "password")
    WebElement pwd;

    @FindBy(how = How.NAME, using = "sub")
    WebElement submitBtn;
    
    @FindBy(how = How.NAME, using = "res")
    WebElement resetBtn;

    @FindBy(how = How.ID, using = "message")
    WebElement nameMsg;
    
    @FindBy(how = How.ID, using = "message24")
    WebElement birthMsg;
    
    @FindBy(how = How.ID, using = "message3")
    WebElement addrMsg;
    
    @FindBy(how = How.ID, using = "message4")
    WebElement cityMsg;
    
    @FindBy(how = How.ID, using = "message5")
    WebElement stateMsg;
    
    @FindBy(how = How.ID, using = "message6")
    WebElement pinMsg;
    
    @FindBy(how = How.ID, using = "message7")
    WebElement mobileMsg;
    
    @FindBy(how = How.ID, using = "message9")
    WebElement emailMsg;
    
    @FindBy(how = How.ID, using = "message18")
    WebElement pwdMsg;
    
    public void setName(String str) {
        name.sendKeys(str);
    }
    
    public void setGender(String str) {
        if (str.equals("female")) {
            female.click();
        }else {
            male.click();
        }
    }
    
    public void setBirth(String str) {
        birth.sendKeys(str);
    }
    
    public void setAddr(String str) {
        address.sendKeys(str);
    }
    
    public void setCity(String str) {
        city.sendKeys(str);
    }
    
    public void setState(String str) {
        state.sendKeys(str);
    }
    
    public void setPin(String str) {
        pin.sendKeys(str);
    }
    
    public void setMobile(String str) {
        mobile.sendKeys(str);
    }
    
    public void setEmail(String str) {
        email.sendKeys(str);
    }
    
    public void setPwd(String str) {
        pwd.sendKeys(str);
    }
    
    public void submitBtnClick() {
        submitBtn.click();
    }
    
    public void resetBtnClick() {
        resetBtn.click();
    }

    public String getNameMsg() {
        return nameMsg.getText();
    }
    
    public String getBirthMsg() {
        return birthMsg.getText();
    }
    
    public String getAddrMsg() {
        return addrMsg.getText();
    }
    
    public String getCityMsg() {
        return cityMsg.getText();
    }
    
    public String getStateMsg() {
        return stateMsg.getText();
    }
    
    public String getPinMsg() {
        return pinMsg.getText();
    }
    
    public String getMobileMsg() {
        return mobileMsg.getText();
    }
    
    public String getEmailMsg() {
        return emailMsg.getText();
    }
    
    public String getPwdMsg() {
        return pwdMsg.getText();
    }
    
    public void clickName() {
        name.click();
    }
    
    public void clickBirth() {
        birth.click();
    }
    
    public void clickAddr() {
        address.click();
    }
    
    public void clickCity() {
        city.click();
    }
    
    public void clickState() {
        state.click();
    }
    
    public void clickPin() {
        pin.click();
    }
    
    public void clickMobile() {
        mobile.click();
    }
    
    public void clickEmail() {
        email.click();
    }
    
    public void clickPwd() {
        pwd.click();
    }
    
}
