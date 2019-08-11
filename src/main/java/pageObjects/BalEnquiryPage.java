package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BalEnquiryPage {
    @FindBy(how = How.XPATH, using = "//*[@id=\"balenquiry\"]/tbody/tr[1]/td/p")
    WebElement msg;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"balenquiry\"]/tbody/tr[6]/td[2]")
    WebElement account;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"balenquiry\"]/tbody/tr[11]/td[2]")
    WebElement type;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"balenquiry\"]/tbody/tr[16]/td[2]")
    WebElement balance;
    
    public String getMsg() {
        return msg.getText();
    }
    
    public String getAccount() {
        return account.getText();
    }
    
    public String getType() {
        return type.getText();
    }
    
    public String getBalance() {
        return balance.getText();
    }
}
