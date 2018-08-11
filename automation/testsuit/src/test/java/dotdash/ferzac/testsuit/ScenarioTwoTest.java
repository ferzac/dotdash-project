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
 * Unit test for Scenario Tow
 * Remove Category
 */
public class ScenarioTwoTest extends TestBase
{
	@Before
    public void iniTest()
    {
    	getDriver();
    }
    
    @Test
    public void removeCategory()
    {
    	boolean isOn = driver.findElement(By.xpath("//div[@class='advance-controls']")).isDisplayed();
    	boolean categoExist = false;
    	List<WebElement> catLst = null;
    	
    	assertTrue( isOn );
        
        catLst = driver.findElements(By.xpath("//div[@class='controls']/a"));
        catLst.get(catLst.size()-1).click();
        driver.findElement(By.xpath("//a[1]")).click();
        catLst = driver.findElements(By.xpath("//div[@class='controls']/a"));
        categoExist = catLst.get(catLst.size()-1).getText().equalsIgnoreCase(Constants.CAT_NAME);
        assertTrue( !categoExist );
    }
    
    @After
    public void closeAll()
    {
    	driver.close();
    }
}
