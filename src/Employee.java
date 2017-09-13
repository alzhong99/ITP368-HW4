import java.util.ArrayList;

public abstract class Employee {
	protected String name;
	protected String title;
	protected int bonus;
	protected ArrayList<Task> tasks;
	
	
	public Task assignTask(Task t1)
	{
		
	}
	
	public abstract int calculatePay();
	
	public ArrayList<Task> getTasks()
	{
		return this.tasks;
	}
	
	public void removeTask(Task t1)
	{
		
	}
	
	
}
