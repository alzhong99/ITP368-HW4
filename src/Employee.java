import java.util.ArrayList;

public abstract class Employee {
	protected String name;
	protected String title;
	protected ArrayList<Task> tasks;
	
	public Employee(String name, String title)
	{
		this.name = name;
		this.title = title;
		this.tasks = new ArrayList<Task>();
	}
	
	public void assignTask(Task t1)
	{
		this.tasks.add(t1);
	}
	
	public ArrayList<Task> getTasks()
	{
		return this.tasks;
	}
	public String getName() {
		return name;
	}
	
}
