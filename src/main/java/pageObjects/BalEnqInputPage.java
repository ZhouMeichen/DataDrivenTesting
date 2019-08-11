package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BalEnqInputPage {
    @FindBy(how = How.NAME, using = "accountno")
    WebElement account;
    
    @FindBy(how = How.NAME, using = "AccSubmit")
    WebElement submitBtn;
    
    @FindBy(how = How.NAME, using = "res")
    WebElement resetBtn;
    
    @FindBy(how = How.XPATH, using = "//table[@class=\"layout\"]//table/tbody/tr[6]/td[1]")
    WebElement accountLabel;
    
    @FindBy(how = How.ID, using = "message2")
    WebElement accountMsg;
    
    public void setAccount(String str) {
        account.clear();
        account.sendKeys(str);
    }
    
    public String getAccountMsg() {
        return accountMsg.getText();
    }
    
    public void clickAccountLabel() {
        accountLabel.click();
    }
    
    public void submitBtnClick() {
        submitBtn.click();
    }
    
    public void resetBtnClick() {
        resetBtn.click();
    }
}
