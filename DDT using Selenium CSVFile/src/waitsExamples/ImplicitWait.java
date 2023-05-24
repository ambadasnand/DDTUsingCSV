package waitsExamples;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utility.Helper;

public class ImplicitWait {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = Helper.startBrowser("chrome");
		driver.manage().window().maximize();
		driver.get("https://www.easemytrip.com");
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.findElement(By.id("FromSector_show")).sendKeys("Delhi", Keys.ENTER);
		driver.findElement(By.id("Editbox13_show")).sendKeys("Mumbai", Keys.ENTER);
		driver.findElement(By.id("ddate")).click();
		driver.findElement(By.xpath("//*[@id=\"frth_3_24/05/2023\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"showOWRT\"]/div/div[7]/button")).click();
		Thread.sleep(11000);
		driver.findElement(By.xpath("//*[@id=\"ResultDiv\"]/div/div/div[4]/div[2]/div[1]/div[1]/div[6]/button[1]")).click();
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,1250)");
		
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("raghu.astepahead@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"divInsuranceTab\"]/div[3]/div[1]/label/span")).click();
		driver.findElement(By.xpath("//*[@id=\"spnVerifyEmail\"]")).click();
		
		WebElement title = driver.findElement(By.id("titleAdult0"));
		Select titleTraveller = new Select(title);
		titleTraveller.selectByVisibleText("MS");
		driver.findElement(By.xpath("//input[@placeholder='Enter First Name']")).sendKeys("ambadas");
		driver.findElement(By.xpath("//input[@placeholder='Enter Last Name']")).sendKeys("nand");
		driver.findElement(By.xpath("//input[@placeholder='Mobile Number']")).sendKeys("9890047387");
		Thread.sleep(4000);
		driver.findElement(By.id("spnTransaction")).click();
		driver.close();

	}

}
