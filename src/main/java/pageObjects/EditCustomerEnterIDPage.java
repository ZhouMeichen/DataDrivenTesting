package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class EditCustomerEnterIDPage {
    @FindBy(how = How.NAME, using = "cusid")
    WebElement id;
    
    @FindBy(how = How.NAME, using = "AccSubmit")
    WebElement submitBtn;
    
    @FindBy(how = How.NAME, using = "res")
    WebElement resetBtn;
    
    public void setId(String str) {
        id.sendKeys(str);
    }
    
    public void submitBtnClick() {
        submitBtn.click();
    }
    
    public void resetBtnClick() {
        resetBtn.click();
    }
}
