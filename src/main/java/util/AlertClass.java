package util;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class AlertClass {
    public static String getMsg(WebDriver driver) {
        Alert alert = driver.switchTo().alert();
        String msg = alert.getText();
        return msg;
    }
    
    public static String getMsgAccept(WebDriver driver) {
        Alert alert = driver.switchTo().alert();
        String msg = alert.getText();
        alert.accept();
        return msg;
    }
    
    public static String getMsgDismiss(WebDriver driver) {
        Alert alert = driver.switchTo().alert();
        String msg = alert.getText();
        alert.dismiss();
        return msg;
    }
    
    public static void accept(WebDriver driver) {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    
    public static void dismiss(WebDriver driver) {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }
    
    public static void sendKeys(WebDriver driver, String str) {       
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(str);
    }
}
