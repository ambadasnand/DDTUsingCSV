package dataDrivenUsingCsv;

import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import au.com.bytecode.opencsv.CSVReader;
import utility.Helper;

public class CSVFileReading {
	
	String CsvPath = "C:\\Users\\Admin\\Desktop\\csvtestdata.csv";
	WebDriver driver;
	
	@BeforeTest
	public void setup() {
		
		driver = Helper.startBrowser("chrome");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://only-testing-blog.blogspot.com/2014/05/form.html");
	}
	
	@Test
	public void locatorsTestingBlog() throws IOException, InterruptedException {
		
		CSVReader reader = new CSVReader(new FileReader(CsvPath));
		String[] csvCell;
		while ((csvCell = reader.readNext()) != null) {
			String fname = csvCell[0];
			String lname = csvCell[1];
			String email = csvCell[2];
			String mob = csvCell[3];
			String cname = csvCell[4];
			
			driver.findElement(By.name("FirstName")).sendKeys(fname);
			driver.findElement(By.name("LastName")).sendKeys(lname);
			driver.findElement(By.name("EmailID")).sendKeys(email);
			driver.findElement(By.name("MobNo")).sendKeys(mob);
			driver.findElement(By.name("Company")).sendKeys(cname);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[contains(@type, 'submit')]")).click();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			
		}
		
		reader.close();
		driver.close();
	}
	

}
