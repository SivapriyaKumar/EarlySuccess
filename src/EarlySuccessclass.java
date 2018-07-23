import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class EarlySuccessclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path+"/Drivers/chromedriver.exe");
		WebDriver wd = new ChromeDriver();
		wd.get("https://www.amazon.in");
		wd.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iphone");
		wd.findElement(By.xpath("//input[@type='submit' and @class='nav-input']")).click();
		wd.close();
	}

}
