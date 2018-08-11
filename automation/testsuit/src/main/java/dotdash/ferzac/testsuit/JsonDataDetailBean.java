package dotdash.ferzac.testsuit;

import com.google.gson.annotations.SerializedName;

public class JsonDataDetailBean 
{
	public int id;
	public String status;
	
	@SerializedName("task name")
	public String taskName;
	
	public String category;
	
	@SerializedName("due date")
	public String dueDate;
}
