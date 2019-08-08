package util;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class AlertClass {
    
    public static String getMsg(WebDriver driver) {
        Alert alert = driver.switchTo().alert();
        String msg = alert.getText();
        alert.dismiss();
        return msg;
    }
}
