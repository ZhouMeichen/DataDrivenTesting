package util;

import java.util.Set;

import org.openqa.selenium.WebDriver;

public class Window {
    public static String getMainWindow(WebDriver driver) {
        return driver.getWindowHandle();
    }
    
    public static Set<String> getAllChildWindows(WebDriver driver) {
        return driver.getWindowHandles();
    }
    
    public static void switchTo(WebDriver driver, String nameOrHandle) {
        driver.switchTo().window(nameOrHandle);
    }
}
