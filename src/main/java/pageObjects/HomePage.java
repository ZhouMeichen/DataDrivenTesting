package pageObjects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class HomePage {
    
    @FindBy(how = How.XPATH, using = "//a[@href='addcustomerpage.php']")
    WebElement newCustomerLink;
    
    @FindBy(how = How.XPATH, using = "//a[@href='EditCustomer.php']")
    WebElement editCustomerLink;
    
    @FindBy(how = How.XPATH, using = "//a[@href='DeleteCustomerInput.php']")
    WebElement deleteCustomerLink;
    
    @FindBy(how = How.XPATH, using = "//a[@href='Logout.php']")
    WebElement logoutLink;

    public void clickNewCustomerLink() {
        newCustomerLink.click();
    }
    
    public void clickEditCustomerLink() {
        editCustomerLink.click();
    }
    
    public void clickDeleteCustomerLink() {
        deleteCustomerLink.click();
    }
    
    
    public void clickLogoutLink() {
        logoutLink.click();
    }
    
    public String getLogoutTxt() {
        return logoutLink.getText();
    }
}
