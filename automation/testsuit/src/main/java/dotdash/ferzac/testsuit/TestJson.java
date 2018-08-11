package dotdash.ferzac.testsuit;

import com.google.gson.Gson;

/**
 * @author Jorge Zavala
 *
 */
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
