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
    
    @FindBy(how = How.XPATH, using = "//a[@href='addAccount.php']")
    WebElement newAccountLink;
    
    @FindBy(how = How.XPATH, using = "//a[@href='editAccount.php']")
    WebElement editAccountLink;
    
    @FindBy(how = How.XPATH, using = "//a[@href='deleteAccountInput.php']")
    WebElement deleteAccountLink;
    
    @FindBy(how = How.XPATH, using = "//a[@href='DepositInput.php']")
    WebElement depositLink;
    
    @FindBy(how = How.XPATH, using = "//a[@href='WithdrawalInput.php']")
    WebElement withdrawalLink;
    
    @FindBy(how = How.XPATH, using = "//a[@href='BalEnqInput.php']")
    WebElement balEnquiryLink;
    
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
    
    public void clickNewAccountLink() {
        newAccountLink.click();
    }
    
    public void clickEditAccountLink() {
        editAccountLink.click();
    }
    
    public void clickDeleteAccountLink() {
        deleteAccountLink.click();
    }
    
    public void clickDepositLink() {
        depositLink.click();
    }
    
    public void clickWithdrawalLink() {
        withdrawalLink.click();
    }
    
    public void clickBalEnquiryLink() {
        balEnquiryLink.click();
    }
    
    
    
    public void clickLogoutLink() {
        logoutLink.click();
    }
    
    public String getLogoutTxt() {
        return logoutLink.getText();
    }
}
