package dotdash.ferzac.testsuit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase 
{
	public WebDriver driver;
	
	public void getDriver()
	{
		System.setProperty("webdriver.chrome.driver", Constants.PATH_CHROME_DRIVER);
        driver = new ChromeDriver();
        driver.get(Constants.URL_INDEX);
        
	}
}
