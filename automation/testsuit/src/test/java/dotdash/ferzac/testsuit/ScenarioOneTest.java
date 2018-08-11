package dotdash.ferzac.testsuit;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Unit test for Scenario One
 * Add Category
 */
public class ScenarioOneTest extends TestBase
{
    @Before
    public void iniTest()
    {
    	getDriver();
    }
    
    @Test
    public void addCategory()
    {
    	boolean isOn = driver.findElement(By.xpath("//div[@class='advance-controls']")).isDisplayed();
    	boolean categoExist = false;
    	List<WebElement> catLst = null;
    	
    	assertTrue( isOn );
        driver.findElement(By.xpath("//span[@id='extra']/input[@name='categorydata']")).sendKeys(Constants.CAT_NAME);
    	driver.findElement(By.xpath("//span[@id='extra']/input[@name='submit']")).click();
        catLst = driver.findElements(By.xpath("//div[@class='controls']/a"));
        categoExist = catLst.get(catLst.size()-1).getText().equalsIgnoreCase(Constants.CAT_NAME);
        assertTrue( categoExist );
    }
    
    @After
    public void closeAll()
    {
    	driver.close();
    }
}
