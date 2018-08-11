// depending on the IDE/environment you use, your project files can reside here.
// It was added a maven project with all the source code in case is needs

//WebDrive Tests
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

// Fake API test class
public class TestJson
{

    public static void main( String[] args )
    {
    	try{
	    	TestJson test = new TestJson();
	    	Gson json = new Gson();
	    	JsonDataDetailBean[] data =  json.fromJson(Constants.jsonData, JsonDataDetailBean[].class);

	    	//Test Status one Task
	    	test.testStatus(data[3]);

	    	//Test Task without Category
	        test.noCategory(data);

	        //Test Display Task Name
	        test.displayTaskName(data);

	        //Display total of Task
	        System.out.println("Task # : "+data.length);

    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }

    public void testStatus(JsonDataDetailBean value)
    {
    	if (value.status.isEmpty()){
    		System.out.println("Task Pending");
    	}else{
    		System.out.println("Task Completed");
    	}
    	System.out.println("Status OK");
    }

    public void noCategory(JsonDataDetailBean[] value)
    {
    	int count = 0;

    	for(int x=0; x < value.length; x++)
    	{
    		if (value[x].category.isEmpty())
    			count++;
    	}

    	System.out.println("Task without Category = "+count);
    }

    public void displayTaskName(JsonDataDetailBean[] value)
    {
    	for(int x=0; x < value.length; x++)
    	{
    		System.out.println("Task name = "+value[x].taskName);
    	}
    }
}

