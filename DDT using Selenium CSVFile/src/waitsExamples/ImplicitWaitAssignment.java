package waitsExamples;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import utility.Helper;
import utility.Reusability;

public class ImplicitWaitAssignment {
	
	WebDriver driver;

	@Test
	public void TestSpicejetFlow() throws InterruptedException {
		// TODO Auto-generated method stub
		
		driver = Helper.startBrowser("chrome");
		driver.manage().window().maximize();
		driver.get("https://www.spicejet.com");
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(10000);
		WebElement from = driver.findElement(By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[3]/div/div[1]/div/div[2]/input"));
		from.sendKeys("Pune",Keys.ENTER);
		
		WebElement destination = driver.findElement(By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[3]/div/div[3]/div/div[2]/input"));
		destination.click();
		Thread.sleep(4000);
		destination.sendKeys("Del",Keys.TAB);
		
		Thread.sleep(4000);
		
		
		
		WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[4]/div/div/div[1]/div[2]/div[1]"));
		//Select s = new Select(dropdown);
		//s.selectByIndex(1);
		
		dropdown.click();
		driver.findElement(By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[5]/div[1]/div/div/div[2]")).click();
		
		//driver.findElement(By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[5]/div[1]/div/div[1]/div[2]")).click();
		int i;
		for(i=0;i<4;i++) {
			
		
		driver.findElement(By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[5]/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/div[2]/div[3]")).click();
		}
		
		driver.findElement(By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[7]/div[2]/div")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[5]/div/div/div[3]/div[2]")).click();
		
		Thread.sleep(8000);
		driver.findElement(By.xpath("//*[@id=\"primary-contact-details\"]/div[3]/div[2]/div/div/div[2]/input")).sendKeys("ambadas");
		driver.findElement(By.xpath("//*[@id=\"primary-contact-details\"]/div[3]/div[3]/div/div/div[2]/input")).sendKeys("nand");
		driver.findElement(By.xpath("//*[@id=\"primary-contact-details\"]/div[4]/div[1]/div/div/div[2]/input")).sendKeys("test@testt.test");
		driver.findElement(By.xpath("//*[@id=\"primary-contact-details\"]/div[3]/div[4]/div/div[2]/input")).sendKeys("7620278186");
		
		Thread.sleep(2000);
		
		
		
		WebElement elem1 = driver.findElement(By.xpath("//*[@id=\"pax-item-MCFBRFQ-\"]/div[2]/div/div/div[2]/div[2]/div/div/div[2]/input"));
		if(!elem1.isDisplayed()) {
			driver.findElement(By.xpath("//*[@id=\"pax-item-MCFBRFQ-\"]/div")).click();
		}
				
		elem1.sendKeys("prasad");
		driver.findElement(By.xpath("//*[@id=\"pax-item-MCFBRFQ-\"]/div[2]/div/div/div[2]/div[3]/div/div/div[2]/input")).sendKeys("nand");
		
		driver.findElement(By.xpath("//*[@id=\"pax-item-MCFBRFQ-\"]/div[2]/div/div/div[4]/div/div")).click();
		
		driver.findElement(By.xpath("//*[@id=\"pax-item-MSFBRFQ-\"]/div[2]/div/div/div[1]/div[2]/div/div/div[2]/input")).sendKeys("Anil");
		driver.findElement(By.xpath("//*[@id=\"pax-item-MSFBRFQ-\"]/div[2]/div/div/div[1]/div[3]/div/div/div[2]/input")).sendKeys("Panchal");
		driver.findElement(By.xpath("//*[@id=\"pax-item-MSFBRFQ-\"]/div[2]/div/div/div[3]/div/div")).click();
		
		driver.findElement(By.xpath("//*[@id=\"pax-item-MiFBRFQ-\"]/div[2]/div/div/div[1]/div[2]/div/div/div[2]/input")).sendKeys("Ravikant");
		driver.findElement(By.xpath("//*[@id=\"pax-item-MiFBRFQ-\"]/div[2]/div/div/div[1]/div[3]/div/div/div[2]/input")).sendKeys("Shinde");
		driver.findElement(By.xpath("//*[@id=\"pax-item-MiFBRFQ-\"]/div[2]/div/div/div[3]/div/div/div")).click();
		
		driver.findElement(By.xpath("//*[@id=\"pax-item-MyFBRFQ-\"]/div[2]/div/div/div[1]/div[2]/div/div/div[2]/input")).sendKeys("Pratap");
		driver.findElement(By.xpath("//*[@id=\"pax-item-MyFBRFQ-\"]/div[2]/div/div/div[1]/div[3]/div/div/div[2]/input")).sendKeys("Joshi");
		driver.findElement(By.xpath("//*[@id=\"pax-item-MyFBRFQ-\"]/div[2]/div/div/div[3]/div/div/div")).click();
		
		driver.findElement(By.xpath("//*[@id=\"pax-item-NCFBRFQ-\"]/div[2]/div/div/div[1]/div[2]/div/div/div[2]/input")).sendKeys("Vinayak");
		driver.findElement(By.xpath("//*[@id=\"pax-item-NCFBRFQ-\"]/div[2]/div/div/div[1]/div[3]/div/div/div[2]/input")).sendKeys("Aghor");
		
		driver.findElement(By.xpath("//*[@id=\"travellers-view\"]/div[2]/div/div/div[2]")).click();
		Thread.sleep(11000);

	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		
		if (ITestResult.SUCCESS == result.getStatus()) {
			Reusability.capturedScreenshot(driver, result.getName());
		}
		driver.quit();
	}

}
