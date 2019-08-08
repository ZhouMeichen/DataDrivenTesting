package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CustomerUpdateMsgPage {
    @FindBy(how = How.XPATH, using = "//*[@id=\"customer\"]/tbody/tr[1]/td/p")
    WebElement msg;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"customer\"]/tbody/tr[4]/td[2]")
    WebElement id;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"customer\"]/tbody/tr[5]/td[2]")
    WebElement name;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"customer\"]/tbody/tr[6]/td[2]")
    WebElement gender;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"customer\"]/tbody/tr[7]/td[2]")
    WebElement birth;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"customer\"]/tbody/tr[8]/td[2]")
    WebElement addr;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"customer\"]/tbody/tr[9]/td[2]")
    WebElement city;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"customer\"]/tbody/tr[10]/td[2]")
    WebElement state;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"customer\"]/tbody/tr[11]/td[2]")
    WebElement pin;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"customer\"]/tbody/tr[12]/td[2]")
    WebElement mobile;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"customer\"]/tbody/tr[13]/td[2]")
    WebElement email;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"customer\"]/tbody/tr[14]/td/a")
    WebElement continueLink;
    
    @FindBy(how = How.XPATH, using = "/html/body/p/a")
    WebElement homeLink;
    
    public String getMsg() {
        return msg.getText();
    }
    
    public String getId() {
        System.out.println(id.getText());
        return id.getText();
    }
    
    public String getName() {
        return name.getText();
    }
    
    public String getGender() {
        return gender.getText();
    }
    
    public String getBirth() {
        return birth.getText();
    }
    
    public String getAddress() {
        return addr.getText();
    }
    
    public String getCity() {
        return city.getText();
    }
    
    public String getState() {
        return state.getText();
    }
    
    public String getPin() {
        return pin.getText();
    }
    
    public String getMobile() {
        return mobile.getText();
    }
    
    public String getEmail() {
        System.out.println(email.getText());
        return email.getText();
    }
    
    public void clickContinueLink() {
        continueLink.click();
    }
    
    public void clickHomeLink() {
        homeLink.click();
    }
}
