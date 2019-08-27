# Introduction
The project uses TestNG, Selenium WebDriver, POM, PageFactory, DataProvider, Apache POI to implement a data-driven testing framework to test an online banking system.

# Framework structure
## 1. com.test
There are TestNG classes in this folder. @Test Annotation can be used to identify the test case.

## 2. steps
Step classes define the methods which can be used in the test cases like submit, getResult 

## 3. pageObjects
PageFactory class which is the inbuilt POM of Selenium WebDriver helps to init web elements.

In the page class, web elements are identified by @FindBy Annotation. Also, all the manipulations of web elements are identified in the class of each web page, which can be used in the step class.

## 4. util
In the util package, there are Data provider class, Driver manager, Excel handler, Alert class. If the project needs another utilities such as popup window handler, it can be added into this package.

## 5. test-output
The test results are demonstrated in the HTML format and generated under test-output folder.

## 6. testng.xml
To run test cases in a group by defining test suites, tests, packages, classes, or methods in the testng.xml.

# Application under test
### Login functionality
Login page has two textboxes (UserID, Password) and two buttons (Login, Reset).

### Home page
Home page has a navigator bar and a welcome message.

### New customer functionality
There are two web pages for this part, NewCustomer page and CustomerRegMsg page. In the NewCustomer page, there is a form with ten fields (1 dropdown list, 1 date picker and 8 textboxes) and two buttons. The CustomerRegMsg page is to show the detail of the customer after creating sucessfully.

### Edit customer functionality
The first web page is to input the customer ID, then the editCustomer page will be shown with nine fields and two buttons.

### Delete customer functionality
The DeleteCustomerInput page is to input the customer ID, and after clicking submit button the customer can be deleted.

### New account functionality
There are two web pages for this part, AddAccount page and AccCreateMsg page. In the AddAccount page, customer ID, Account type and initial deposit need to be input. After submitting, the message of this account will be shown in AccCreateMsg page.

### Deposit functionality
There are two web pages for this part, DepositInput page and Deposit page. After submitting account number, amount, and description, the table of confirmation information will be shown in the Deposit page.

### Withdrawal functionality
There are two web pages for this part, WithdrawalInput page and Withdrawal page. After submitting account number, amount, and description, the table of confirmation information will be shown in the Withdrawal page.

### Balance Enquiry functionality
After submitting account number in the BalEnqInput page, the detailed information of this account including type of account and balance will be shown in the BalEnquiry page.

### Mini Statement functionality
After submitting account number in the MiniStatementInput page, the table of bank statements will be shown in the MiniStatement page.
