package utility;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Reusability {
	
public static void capturedScreenshot (WebDriver driver, String screenshotName) {
		
		try {
			
			TakesScreenshot ts = (TakesScreenshot)driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File("./ScreenShots/" + screenshotName + ".png"));
			System.out.println("Captured screenshot - By Selenium WebDriver");
			
		} catch (Exception e) {
			
			System.out.println("Exception while taking sreenshot" + e.getMessage());
		}
	}

}
