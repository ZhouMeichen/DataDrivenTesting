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
    
    
}
