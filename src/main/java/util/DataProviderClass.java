package util;


import java.util.ArrayList;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
    static int num;
    
    @DataProvider(name = "LoginWithValidData")
    public static Object[][] getLoginValidData() {
        ExcelHandler handler = new ExcelHandler("TestData.xlsx","account");
        ArrayList<ArrayList<String>> list = handler.readData();
        return list.stream().map(a -> a.toArray()).toArray(s -> new Object[s][]);
    }
    
    @DataProvider(name = "LoginWithInvalidData")
    public static Object[][] getLoginInvalidData() {
            return new Object[][] {
                {"123","123"},
                {"mngr213347","123"},
                {"123","ytatArY"}
            };
    }
    
    @DataProvider(name = "NewCustomerSubmitValidData")
    public static Object[][] getNewCustomerValidData() {
        num = (int)(Math.random() * 50 + 1);
        String email="robot"+num+"@robot.com";
            return new Object[][] {
                {"Mike","female","28/10/2001","1 Queen St","LA","CA","123456","0215208881",email,"123","Customer Registered Successfully"}
            };
    }
    
    @DataProvider(name = "NewCustomerSubmitExistData")
    public static Object[][] getNewCustomerExistData() {
        String email="robot"+num+"@robot.com";
            return new Object[][] {
                {"Mike","female","28/10/2001","1 Queen St","LA","CA","123456","0215208881",email,"123","Email Address Already Exist"}
            };
    }
    
    @DataProvider(name = "NewCustomerSubmitBlankData")
    public static Object[][] getNewCustomerSubmitBlankData() {
            return new Object[][] {
                {"","","","","","","","","","","please fill all fields"},
            };
    }
    
    @DataProvider(name = "NewCustomerInputOtherInvalidData")
    public static Object[][] getNewCustomerOtherInvalidData() {
            return new Object[][] {
                
                {"#","#","#","#","#","#","#","#","#","#","Special characters are not allowed","Special characters are not allowed", "Special characters are not allowed","Special characters are not allowed","Email-ID is not valid"},
                {"1","1","1","1","1","1","1","1","1","1","Numbers are not allowed","", "PIN Code must have 6 Digits","","Email-ID is not valid"}
            };
    }
    
    @DataProvider(name = "EditCustomerSubmitValidData")
    public static Object[][] getEditCustomerValidData() {
        num = (int)(Math.random() * 50 + 1);
        String email="change"+num+"@robot.com";
            return new Object[][] {
                {"2 King St","NY","NY","654321","0225208888",email,"Customer details updated Successfully"}
            };
    }
    
    @DataProvider(name = "EditCustomerSubmitBlankData")
    public static Object[][] getEditCustomerSubmitBlankData() {
            return new Object[][] {
                {"","","","","","","please fill all fields"},
            };
    }
    
    @DataProvider(name = "EditCustomerInputInvalidData")
    public static Object[][] getEditCustomerInvalidData() {
            return new Object[][] {
                {"","","","","","","must not be blank","must not be blank", "must not be blank","must not be blank","must not be blank"},
                {"#","#","#","#","#","#","Special characters are not allowed","Special characters are not allowed", "Special characters are not allowed", "Special characters are not allowed","Email-ID is not valid"},
                {"1","1","1","1","1","1","Numbers are not allowed","", "PIN Code must have 6 Digits","","Email-ID is not valid"}
            };
    }

}
