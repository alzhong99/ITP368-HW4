import java.util.ArrayList;

public class Executive extends Employee implements HasSubordinates {
	private ArrayList<Employee> subordinates;
	public Executive(String name, String title) {
		super(name, title);
		// TODO Auto-generated constructor stub
		this.subordinates = new ArrayList<Employee>();
	}
	public void addSubordinate(Employee employee) {
		subordinates.add(employee);
	}
	public String toString() {
		String taskInfo = "tasks " + tasks.toString();
		if(tasks.size() == 0) {
			taskInfo = "no tasks";
		}
		String subordinatesInfo = "subordinates ";
		for(Employee subordinate: subordinates) {
			subordinatesInfo = subordinatesInfo + "[" + subordinate.getName() + "] ";
		}
		if(subordinates.size() == 0) {
			subordinatesInfo = "no subordinates";
		}
		return "\n" + name + ", " + title + ", has " + taskInfo + "\n\t and has " + subordinatesInfo;
	}
}
