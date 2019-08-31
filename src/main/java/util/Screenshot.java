package util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {
    public static void capture(WebDriver driver, String filename) {
        TakesScreenshot scrShot =((TakesScreenshot)driver);
        File src = scrShot.getScreenshotAs(OutputType.FILE);
        File Dest = new File("test-output/screenshots/"+filename);
        try {
            FileUtils.copyFile(src, Dest);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
