package example;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class NewTest {
	
	static WebDriver driver = null;
	static ChromeOptions chromeOptions = null;

	@BeforeTest
	public void beforeTest() throws InterruptedException {
		//System.setProperty("webdriver.chrome.driver", "ZephyrJiraSeleniumJenkins\\WebDrivers_Stack\\chromedriver.exe");
		//driver = new ChromeDriver();
		
	    chromeOptions = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
	}

	@Test
	public void method() {
		driver.get("http://demo.guru99.com/test/guru99home/");
		String title = driver.getTitle();
		System.out.println("Title is: "+title);
		Assert.assertTrue(title.contains("Demo Guru99 Page"));
		
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
		
	}

}
