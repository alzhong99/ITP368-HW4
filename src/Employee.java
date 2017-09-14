import java.util.ArrayList;

public abstract class Employee {
	protected String name;
	protected String title;
	protected int bonus;
	protected ArrayList<Task> tasks;
	
	public Employee(String name, String title, int bonus)
	{
		this.name = name;
		this.title = title;
		this.bonus = bonus;
		this.tasks = new ArrayList<Task>();
	}
	
	public void assignTask(Task t1)
	{
		this.tasks.add(t1);
	}
	
	public abstract int calculatePay();
	
	public ArrayList<Task> getTasks()
	{
		return this.tasks;
	}
	
	public void removeTask(Task t1)
	{
		this.tasks.remove((Task)t1);
	}
	
	
}
