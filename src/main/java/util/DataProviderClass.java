package util;


import java.util.ArrayList;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
    static int num;
    
    @DataProvider(name = "LoginWithValidData")
    public static Object[][] getLoginValidData() {
        ExcelHandler handler = new ExcelHandler("TestData.xlsx","account");
        ArrayList<ArrayList<String>> list = handler.readData();
        Object[][] data = new Object[list.size()][];
        for (int i=0;i<list.size();i++) {
            data[i] = list.get(i).toArray();
        }

        return data;
    }
    
    @DataProvider(name = "LoginWithInvalidData")
    public static Object[][] getLoginInvalidData() {
            return new Object[][] {
                {"123","123"},
                {"mngr213347","123"},
                {"123","ytatArY"}
            };
    }
    
    @DataProvider(name = "NewCustomerValidData")
    public static Object[][] getNewCustomerValidData() {
        num = (int)(Math.random() * 50 + 1);
        String email="robot"+num+"@robot.com";
            return new Object[][] {
                {"Mike","female","28/10/2001","1 Queen St","LA","CA","123456","0215208881",email,"123","Customer Registered Successfully"}
            };
    }
    
    @DataProvider(name = "NewCustomerExistData")
    public static Object[][] getNewCustomerExistData() {
        String email="robot"+num+"@robot.com";
            return new Object[][] {
                {"Mike","female","28/10/2001","1 Queen St","LA","CA","123456","0215208881",email,"123","Email Address Already Exist"}
            };
    }
    
    
    @DataProvider(name = "NewCustomerInvalidData")
    public static Object[][] getNewCustomerInvalidData() {
            return new Object[][] {
                {"","","","","","","","","","","please fill all fields","must not be blank","", "must not be blank", "must not be blank", "must not be blank","must not be blank","must not be blank","must not be blank","must not be blank","must not be blank"},
                {"#","#","#","#","#","#","#","#","#","#","please fill all fields","Special characters are not allowed","","","Special characters are not allowed","Special characters are not allowed","Special characters are not allowed", "Special characters are not allowed","Special characters are not allowed","Email-ID is not valid",""},
                {"1","1","1","1","1","1","1","1","1","1","please fill all fields","Numbers are not allowed","", "must not be blank","", "Numbers are not allowed","Numbers are not allowed","PIN Code must have 6 Digits","","Email-ID is not valid",""}
            };
    }
    
    @DataProvider(name = "EditCustomerValidData")
    public static Object[][] getEditCustomerValidData() {
        num = (int)(Math.random() * 50 + 1);
        String email="change"+num+"@robot.com";
            return new Object[][] {
                {"73582", "2 King St","NY","NY","654321","0225208888",email,"Customer details updated Successfully"}
            };
    }
    
    
    @DataProvider(name = "EditCustomerInvalidData")
    public static Object[][] getEditCustomerInvalidData() {
            return new Object[][] {
                {"73582","","","","","","","Please fill all fields","must not be blank","must not be blank", "must not be blank","must not be blank","must not be blank","must not be blank"},
                {"73582","#","#","#","#","#","#","Please fill all fields","Special characters are not allowed","Special characters are not allowed", "Special characters are not allowed", "Special characters are not allowed", "Special characters are not allowed","Email-ID is not valid"},
                {"73582","1","1","1","1","1","1","","Please fill all fields","Numbers are not allowed","Numbers are not allowed", "PIN Code must have 6 Digits","","Email-ID is not valid"}
            };
    }
    
    @DataProvider(name = "EditCustomerWithoutChangeData")
    public static Object[][] getEditCustomerWithoutChangeData() {
            return new Object[][] {
                {"73582","No Changes made to Customer records"}
            };
    }
    
    @DataProvider(name = "DeleteCustomerValidData")
    public static Object[][] getDeleteCustomerValidData() {
            return new Object[][] {
                {"86791","Do you really want to delete this Customer","Customer deleted Successfully"}
                
            };
    }
    
    @DataProvider(name = "DeleteCustomerNotExistData")
    public static Object[][] getDeleteCustomerNotExistData() {
            return new Object[][] {
                {"1234567890","Do you really want to delete this Customer","Customer does not exist"}
                
            };
    }
    
    
    @DataProvider(name = "DeleteCustomerInvalidData")
    public static Object[][] getDeleteCustomerInvalidData() {
            return new Object[][] {
                {"","Please fill all fields","Customer ID is required"},
                {"#","Please fill all fields","Special characters are not allowed"},
                {"robot","Please fill all fields","Characters are not allowed"},
            };
    }
    
    @DataProvider(name = "NewAccountValidData")
    public static Object[][] getNewAccountValidData() {
            return new Object[][] {
                {"73582","Current","500","Account Generated Successfully"},
                {"73582","Savings","501","Account Generated Successfully"}
            };
    }
    
    @DataProvider(name = "NewAccountInvalidData")
    public static Object[][] getNewAccountInvalidData() {
            return new Object[][] {
                {"","Current","","Please fill all fields","is required","must not be blank"},
                {"73582","Current","499","Intial deposite must be Rs. 500 or more","",""},
                {"1234567890","Current","500","Customer does not exist","",""},
                {"#","Current","#","Please fill all fields","Special characters are not allowed","Special characters are not allowed"} 
            };
    }
    
    @DataProvider(name = "DepositValidData")
    public static Object[][] getDepositValidData() {
            return new Object[][] {
                {"66956","1","1","513","Transaction details of Deposit for Account 66956"}
            };
    }
    
    @DataProvider(name = "DepositInvalidData")
    public static Object[][] getDepositInvalidData() {
            return new Object[][] {
                {"","","","Please fill all fields","must not be blank","must not be blank","can not be blank"},                
                {"1234567890","1","1","Account does not exist","","",""},
                {"#","#","#","Please fill all fields","Special characters are not allowed","Special characters are not allowed",""} 
            };
    }
    
    @DataProvider(name = "WithdrawalValidData")
    public static Object[][] getWithdrawalValidData() {
            return new Object[][] {
                {"66956","1","1","508","Transaction details of Withdrawal for Account 66956"}
            };
    }
    
    @DataProvider(name = "WithdrawalInvalidData")
    public static Object[][] getWithdrawalInvalidData() {
            return new Object[][] {
                {"","","","Please fill all fields","must not be blank","must not be blank","can not be blank"},                
                {"1234567890","1","1","Account does not exist","","",""},
                {"#","#","#","Please fill all fields","Special characters are not allowed","Special characters are not allowed",""} 
            };
    }
    
    @DataProvider(name = "BalEnquiryValidData")
    public static Object[][] getBalEnquiryValidData() {
            return new Object[][] {
                {"66961","Savings","1000","Balance Details for Account 66961"}
            };
    }
    
    @DataProvider(name = "BalEnquiryInvalidData")
    public static Object[][] getBalEnquiryInvalidData() {
            return new Object[][] {
                {"","Please fill all fields","must not be blank"},                
                {"1234567890","Account does not exist",""},
                {"#","Please fill all fields","Special characters are not allowed"} 
            };
    }
    
    @DataProvider(name = "MiniStatementValidData")
    public static Object[][] getMiniStatementValidData() {
            return new Object[][] {
                {"66956","121090","1","w","2019-08-11","1"},                
                {"66956","121089","1","w","2019-08-11","1"},
                {"66956","121708","12","d","2019-08-18","12"} 
            };
    }

}
