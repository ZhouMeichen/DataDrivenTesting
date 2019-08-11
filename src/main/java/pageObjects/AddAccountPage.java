package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class AddAccountPage {
    @FindBy(how = How.NAME, using = "cusid")
    WebElement id;
    
    @FindBy(how = How.NAME, using = "selaccount")
    WebElement type;
    
    @FindBy(how = How.NAME, using = "inideposit")
    WebElement amount;
    
    @FindBy(how = How.ID, using = "message14")
    WebElement idMsg;
    
    @FindBy(how = How.ID, using = "message19")
    WebElement amountMsg;
    
    @FindBy(how = How.XPATH, using = "//table[@class=\"layout\"]//table/tbody/tr[2]/td[1]")
    WebElement idLabel;
    
    @FindBy(how = How.NAME, using = "button2")
    WebElement submitBtn;
    
    @FindBy(how = How.NAME, using = "reset")
    WebElement resetBtn;
    
    public void setId(String str) {
        id.clear();
        id.sendKeys(str);
    }
    
    public void setType(String str) {
        Select dropdown = new Select(type);
        dropdown.selectByVisibleText(str);
    }
    
    public void setInit(String str) {
        amount.clear();
        amount.sendKeys(str);
    }
    
    public void submitBtnClick() {
        submitBtn.click();
    }
    
    public void resetBtnClick() {
        resetBtn.click();
    }
    
    public void clickIdLabel() {
        idLabel.click();
    }
    
    public String getIdMsg() {
        return idMsg.getText();
    }
    
    public String getAmountMsg() {
        return amountMsg.getText();
    }
}
