import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class EarlySuccessclass {
	
	String path = System.getProperty("user.dir");
	WebDriver wd ;
	
	@BeforeTest
	public void chromeDriverSetup(){
		System.setProperty("webdriver.chrome.driver", path+"/Drivers/chromedriver.exe");
		wd = new ChromeDriver();
	}
	
	@Test
	public void amazonLaunchTest() {
		wd.get("https://www.amazon.in");
		WebElement searchBox =  wd.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		Assert.assertTrue(searchBox.isDisplayed());
	}
	@Test
	public void searchTest() {
		wd.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iphone");
		wd.findElement(By.xpath("//input[@type='submit' and @class='nav-input']")).click();
		String actualText = wd.findElement(By.xpath("//h2[@data-attribute='Apple iPhone 6 (Space Grey, 32GB)']/parent::a")).getText().trim();
		wd.findElement(By.xpath("//h2[@data-attribute='Apple iPhone 6 (Space Grey, 32GB)']/parent::a")).click();
		String expectedText = "Apple iPhone 6 (Space Grey, 32GB)";
		Assert.assertEquals(actualText, expectedText);
	}
	
	@AfterTest
	public void chromeDriverTeardown(){
		wd.close();
	}
	
}
