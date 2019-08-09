package pageObjects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

    @FindBy(how = How.NAME, using = "uid")
    WebElement uid;
    
    @FindBy(how = How.NAME, using = "password")
    WebElement pwd;
    
    @FindBy(how = How.NAME, using = "btnLogin")
    WebElement loginbtn;

    @FindBy(how = How.NAME, using = "title")
    WebElement titleText;
    
    @FindBy(how = How.ID, using = "message23")
    WebElement idMsg;
    
    @FindBy(how = How.ID, using = "message18")
    WebElement pwdMsg;
 

    
    public void setUid(String strTxt) {
        uid.sendKeys(strTxt);;
    }
    
    public void setPwd(String strTxt) {
        pwd.sendKeys(strTxt);
    }
    
    public void clickLoginButton() {
        loginbtn.click();
    }
    
    public String getTitle() {
        return titleText.getText();
    }
    
    public String getIdMsg() {
        return idMsg.getText();
    }
    
    public String getPwdMsg() {
        return pwdMsg.getText();
    }
    
    public void clickId() {
        uid.click();
    }
    
    public void clickPwd() {
        pwd.click();
    }
    
}
