package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Iframe {
    public static void switchTo(WebDriver driver, int index) {
        driver.switchTo().frame(index);
    }
    
    public static void switchTo(WebDriver driver, String nameOrId) {
        driver.switchTo().frame(nameOrId);
    }
    
    public static void switchBack(WebDriver driver) {
        driver.switchTo().parentFrame();
    }
    
    public static void switchDefault(WebDriver driver) {
        driver.switchTo().defaultContent();
    }
    
    public static int getSize(WebDriver driver) {
        return driver.findElements(By.tagName("iframe")).size();
    }
}
