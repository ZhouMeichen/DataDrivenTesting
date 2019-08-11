package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AccCreateMsgPage {
    @FindBy(how = How.XPATH, using = "//*[@id=\"account\"]/tbody/tr[1]/td/p")
    WebElement msg;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"account\"]/tbody/tr[4]/td[2]")
    WebElement accId;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"account\"]/tbody/tr[5]/td[2]")
    WebElement cusId;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"account\"]/tbody/tr[6]/td[2]")
    WebElement name;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"account\"]/tbody/tr[7]/td[2]")
    WebElement email;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"account\"]/tbody/tr[8]/td[2]")
    WebElement type;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"account\"]/tbody/tr[9]/td[2]")
    WebElement date;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"account\"]/tbody/tr[10]/td[2]")
    WebElement amount;
    
    public String getMsg() {
        return msg.getText();
    }
    
    public String getAccId() {
        System.out.println("Account ID: "+accId.getText());
        return accId.getText();
    }
    
    public String getCusId() {
        return cusId.getText();
    }
    
    public String getName() {
        return name.getText();
    }
    
    public String getEmail() {
        return email.getText();
    }
    
    public String getType() {
        return type.getText();
    }
    
    public String getDate() {
        return date.getText();
    }
    
    public String getAmount() {
        return amount.getText();
    }
}
