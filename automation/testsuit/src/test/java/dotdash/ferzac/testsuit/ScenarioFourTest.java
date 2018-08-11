package dotdash.ferzac.testsuit;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * 
 * @author Jorge Zavala
 * Unit test for Scenario Four
 * remove Task
 */
public class ScenarioFourTest extends TestBase 
{
	@Before
    public void iniTest()
    {
    	getDriver();
    }
    
    @Test
    public void addTask()
    {
    	boolean isOn = driver.findElement(By.xpath("//div[@class='controls']")).isDisplayed();
    	List<WebElement> taskLst = null;
    	int orgSize = 0;
    	
    	assertTrue( isOn );
    	isOn = driver.findElement(By.xpath("//div[@id='todos-content']")).isDisplayed();
    	assertTrue( isOn );
    	taskLst = driver.findElements(By.xpath("//div[@id='todos-content']//li/input"));
    	orgSize = taskLst.size();
    	taskLst.get(taskLst.size()-1).click();
    	driver.findElement(By.xpath("//div[@class='controls']/input[@value='Remove']")).click();
    	taskLst = driver.findElements(By.xpath("//div[@id='todos-content']//li"));
    	assertTrue( orgSize != taskLst.size() );
    }
    
    @After
    public void closeAll()
    {
    	driver.close();
    }
}
