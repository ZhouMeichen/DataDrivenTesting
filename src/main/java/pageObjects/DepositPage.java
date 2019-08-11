package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DepositPage {
    @FindBy(how = How.XPATH, using = "//*[@id=\"deposit\"]/tbody/tr[1]/td/p")
    WebElement msg;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"deposit\"]/tbody/tr[6]/td[2]")
    WebElement transId;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"deposit\"]/tbody/tr[7]/td[2]")
    WebElement account;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"deposit\"]/tbody/tr[12]/td[2]")
    WebElement amount;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"deposit\"]/tbody/tr[16]/td[2]")
    WebElement type;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"deposit\"]/tbody/tr[20]/td[2]")
    WebElement desc;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"deposit\"]/tbody/tr[23]/td[2]")
    WebElement balance;
    
    public String getMsg() {
        return msg.getText();
    }
    
    public String getTransId() {
        return transId.getText();
    }
    
    public String getAccount() {
        return account.getText();
    }
    
    public String getAmount() {
        return amount.getText();
    }
    
    public String getType() {
        return type.getText();
    }
    
    public String getDesc() {
        return desc.getText();
    }
    
    public String getBalance() {
        return balance.getText();
    }
}
