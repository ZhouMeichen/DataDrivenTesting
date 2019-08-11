package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class EditCustomerPage {
    @FindBy(how = How.NAME, using = "name")
    WebElement name;
    
    @FindBy(how = How.NAME, using = "gender")
    WebElement gender;
    
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
    
    @FindBy(how = How.XPATH, using = "//table[@class=\"layout\"]//table/tbody/tr[4]/td[1]")
    WebElement nameLabel;
    
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
    
    @FindBy(how = How.NAME, using = "sub")
    WebElement submitBtn;
    
    @FindBy(how = How.NAME, using = "res")
    WebElement resetBtn;
    
    public boolean getNameDisability() {
        return name.getAttribute("disabled").equalsIgnoreCase("on");
    }
    
    public boolean getGenderDisability() {
        return gender.getAttribute("disabled").equalsIgnoreCase("on");
    }
    
    public boolean getBirthDisability() {
        return birth.getAttribute("disabled").equalsIgnoreCase("on");
    }
    
    public void setAddr(String str) {
        address.clear();
        address.sendKeys(str);
    }
    
    public void setCity(String str) {
        city.clear();
        city.sendKeys(str);
    }
    
    public void setState(String str) {
        state.clear();
        state.sendKeys(str);
    }
    
    public void setPin(String str) {
        pin.clear();
        pin.sendKeys(str);
    }
    
    public void setMobile(String str) {
        mobile.clear();
        mobile.sendKeys(str);
    }
    
    public void setEmail(String str) {
        email.clear();
        email.sendKeys(str);
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
    
    public void submitBtnClick() {
        submitBtn.click();
    }
    
    public void resetBtnClick() {
        resetBtn.click();
    }
    
    public void clickNameLabel() {
        nameLabel.click();
    }
    
    
}
