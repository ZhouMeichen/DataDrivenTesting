package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DeleteCustomerInputPage {
    @FindBy(how = How.NAME, using = "cusid")
    WebElement id;
    
    @FindBy(how = How.XPATH, using = "//table[@class=\"layout\"]//table/tbody/tr[2]/td[1]")
    WebElement idLable;
    
    @FindBy(how = How.NAME, using = "AccSubmit")
    WebElement submitBtn;
    
    @FindBy(how = How.NAME, using = "res")
    WebElement resetBtn;
    
    @FindBy(how = How.ID, using = "message14")
    WebElement idMsg;
    
    public void setId(String str) {
        id.clear();
        id.sendKeys(str);
    }
    
    public void submitBtnClick() {
        submitBtn.click();
    }
    
    public void resetBtnClick() {
        resetBtn.click();
    }
    
    public void clickId() {
        id.click();
    }
    
    public String getIdMsg() {
        return idMsg.getText();
    }
    
    public void clickIdLable() {
        idLable.click();
    }
    

}
