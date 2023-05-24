package dataDrivenUsingCsv;

import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import au.com.bytecode.opencsv.CSVReader;
import utility.Helper;
import utility.Reusability;

public class CSVAssignment {
	
	String CsvPath = "C:\\Users\\Admin\\Desktop\\registerdata.csv";
	WebDriver driver;
	
	@BeforeTest
	public void setup() throws InterruptedException {
		
		driver = Helper.startBrowser("chrome");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com");
		driver.findElement(By.linkText("Create new account")).click();
		Thread.sleep(3000);
	}
	
	@Test
	public void locatorsTestingBlog() throws IOException, InterruptedException {
		
		CSVReader reader = new CSVReader(new FileReader(CsvPath));
		String[] csvCell;
		while ((csvCell = reader.readNext()) != null) {
			String fname = csvCell[0];
			String lname = csvCell[1];
			String email = csvCell[2];
			String emailconf = csvCell[3];
			String password = csvCell[4];
			String age = csvCell[5];
			
			driver.findElement(By.name("firstname")).sendKeys(fname);
			driver.findElement(By.name("lastname")).sendKeys(lname);
			driver.findElement(By.name("reg_email__")).sendKeys(email);
			driver.findElement(By.name("reg_email_confirmation__")).sendKeys(emailconf);
			driver.findElement(By.name("reg_passwd__")).sendKeys(password);
			driver.findElement(By.xpath("//label[contains(text(),'Male')]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@name='websubmit']")).click();
			driver.findElement(By.xpath("//button[@name='websubmit']")).click();
			Thread.sleep(3000);
			driver.findElement(By.name("birthday_age")).sendKeys(age);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@name='websubmit']")).click();
			Thread.sleep(8000);
			Alert alert = driver.switchTo().alert();
			System.out.println(alert.getText());
			String text = alert.getText();
			
			Assert.assertEquals("No one else will see your date of birth. You can change this on your profile later.", text);
			driver.switchTo().alert().dismiss();
			
		}
		
		reader.close();
		//driver.close();
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		
		if (ITestResult.FAILURE == result.getStatus()) {
			Reusability.capturedScreenshot(driver, result.getName());
		}
		driver.quit();
	}

}
