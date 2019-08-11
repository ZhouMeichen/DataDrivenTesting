package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DepositInputPage {
    @FindBy(how = How.NAME, using = "accountno")
    WebElement account;
    
    @FindBy(how = How.NAME, using = "ammount")
    WebElement amount;
    
    @FindBy(how = How.NAME, using = "desc")
    WebElement desc;
    
    @FindBy(how = How.NAME, using = "AccSubmit")
    WebElement submitBtn;
    
    @FindBy(how = How.NAME, using = "res")
    WebElement resetBtn;
    
    @FindBy(how = How.XPATH, using = "//table[@class=\"layout\"]//table/tbody/tr[6]/td[1]")
    WebElement accountLabel;
    
    @FindBy(how = How.ID, using = "message2")
    WebElement accountMsg;
    
    @FindBy(how = How.ID, using = "message1")
    WebElement amountMsg;
    
    @FindBy(how = How.ID, using = "message17")
    WebElement descMsg;
    
    public void setAccount(String str) {
        account.clear();
        account.sendKeys(str);
    }
    
    public void setAmount(String str) {
        amount.clear();
        amount.sendKeys(str);
    }
    
    public void setDesc(String str) {
        desc.clear();
        desc.sendKeys(str);
    }
    
    public String getAccountMsg() {
        return accountMsg.getText();
    }
    
    public String getAmountMsg() {
        return amountMsg.getText();
    }
    
    public String getDescMsg() {
        return descMsg.getText();
    }
    
    public void submitBtnClick() {
        submitBtn.click();
    }
    
    public void resetBtnClick() {
        resetBtn.click();
    }
    
    public void clickAccountLabel() {
        accountLabel.click();
    }
}
