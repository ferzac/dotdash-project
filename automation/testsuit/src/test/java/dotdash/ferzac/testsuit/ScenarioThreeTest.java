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
 * Unit test for Scenario Three
 * Add Task
 */
public class ScenarioThreeTest extends TestBase 
{
	@Before
    public void iniTest()
    {
    	getDriver();
    }
    
    @Test
    public void addTask()
    {
    	boolean isOn = driver.findElement(By.xpath("//div[@class='advance-controls']")).isDisplayed();
    	List<WebElement> taskLstOrg = null;
    	List<WebElement> taskLstAfter = null;
    	
    	assertTrue( isOn );
    	taskLstOrg = driver.findElements(By.xpath("//div[@id='todos-content']//li"));
    	
    	driver.findElement(By.xpath("//div[@class='advance-controls']/input[@name='data']")).sendKeys(Constants.TASK_NAME);
    	driver.findElement(By.xpath("//div[@class='advance-controls']/input[@name='submit']")).click();
    	
    	taskLstAfter = driver.findElements(By.xpath("//div[@id='todos-content']//li"));
    	
    	
        assertTrue( taskLstOrg.size() != taskLstAfter.size() );
    }
    
    @After
    public void closeAll()
    {
    	driver.close();
    }
}
