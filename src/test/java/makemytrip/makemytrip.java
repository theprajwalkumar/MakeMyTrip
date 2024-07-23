package makemytrip;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class makemytrip{
	WebDriver driver;
	
	@BeforeClass
	public void BeforeClass1() {
		System.out.println("This will execute before class");
	}
	
	@BeforeMethod
	public void HomePage() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//*[@id=\"SW\"]/div[1]/div[2]/div[2]/div/section/span")).click();
		Thread.sleep(3000);
	}
	
	
	@Test
	public void urllanding() {
		String ExpectedUrl="https://www.makemytrip.com/";
		String ActualUrl=driver.getCurrentUrl();
		if (ExpectedUrl.equals(ActualUrl)) {
			System.out.println("Url Matched Successfully");
		}
		else {
			System.err.println("Invalid Url");
		}
	}
	
	
	@Test
	public void Title() {
		String Expected_Title="MakeMyTrip";
		String Actual_Title=driver.getTitle();
		if (Expected_Title.equals(Actual_Title)) {
			System.out.println("Title Matched Successfully");
		}
		else {
			System.out.println("Title didn't Matched Successfully");
		}
	}
	
	@Test
	public void Search() throws InterruptedException {
		
		Thread.sleep(3000);
		WebElement From = driver.findElement(By.xpath("//*[@id=\"fromCity\"]"));
		From.click();
		From.sendKeys("New Delhi");
		Thread.sleep(5000);
		List<WebElement> From1 = driver.findElements(By.xpath("//ul[@class='react-autosuggest__suggestions-list']/li"));
		From1.size();
		int count = From1.size();
		System.out.println(count);
		From1.get(1).click();

		WebElement To = driver.findElement(By.xpath("//*[@id=\"toCity\"]"));
		To.click();
		To.sendKeys("Ranchi");
		Thread.sleep(5000);
		List<WebElement> To1 = driver.findElements(By.xpath("//ul[@class='react-autosuggest__suggestions-list']/li"));
		To1.size();
		int count1 = To1.size();
		System.out.println(count1);
		To1.get(0).click();
		Thread.sleep(3000);

		WebElement DatePicker = driver.findElement(By.xpath("//*[@id=\"top-banner\"]/div[2]/div/div/div/div/div[2]/div[1]/div[3]/label/p[1]"));
		//DatePicker.click();

		String ExpectedMY = "August 2024";
		//String ExpectedD="20";

		while (true) {
			String ActualMY = driver.findElement(By.xpath("//*[@id=\"top-banner\"]/div[2]/div/div/div/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[1]/div[1]/div")).getText();
            System.out.println(ActualMY);
        
			if (ExpectedMY.equals(ActualMY)) {
				break;
			} else {
				driver.findElement(By.xpath("//*[@id=\"top-banner\"]/div[2]/div/div/div/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[1]/span[2]")).click();

			}
		}
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[@id=\"top-banner\"]/div[2]/div/div/div/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[1]/div[3]/div[4]/div[3]/div/p[1]")).click();
		
	    WebElement SelectF=driver.findElement(By.xpath("//*[@id=\"top-banner\"]/div[2]/div/div/div/div/div[2]/div[2]/div/div[2]/div[2]"));
		SelectF.click();
		Thread.sleep(3000);
		
		WebElement SearchButton=driver.findElement(By.xpath("//*[@id=\"top-banner\"]/div[2]/div/div/div/div/div[2]/p/a"));
		SearchButton.click();
		
		Thread.sleep(9000);
		
		
	}
	
	@AfterMethod
	public void TearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
		
		
	}
	
	
	@AfterClass
	public void AfterClass1() {
		System.out.println("This will execute after class");
	}

}
