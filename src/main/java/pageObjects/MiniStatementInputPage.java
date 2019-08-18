package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MiniStatementInputPage {
    @FindBy(how = How.NAME, using = "accountno")
    WebElement account;
    
    @FindBy(how = How.NAME, using = "AccSubmit")
    WebElement submitBtn;
    
    @FindBy(how = How.XPATH, using = "//table[@class=\"layout\"]//table/tbody/tr[6]/td[1]")
    WebElement accountLabel;
    
    @FindBy(how = How.ID, using = "message2")
    WebElement accountMsg;
    
    public void setAccount(String str) {
        account.clear();
        account.sendKeys(str);
    }
    
    public void submitBtnClick() {
        submitBtn.click();
    }
    
    public void clickAccountLable() {
        accountLabel.click();
    }
    
    public String getAccountMsg() {
        return accountMsg.getText();
    }
}
