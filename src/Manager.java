import java.util.ArrayList;

public class Manager extends Employee implements HasSubordinates {
	private ArrayList<Employee> subordinates;
	private Employee superior;
	public Manager(String name, String title, Employee superior) {
		super(name, title);
		// TODO Auto-generated constructor stub
		this.superior = superior;
		this.subordinates = new ArrayList<Employee>();
	}
	public void addSubordinate(Employee employee) {
		subordinates.add(employee);
	}
	public String getSuperior() {
		return superior.getName();
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
		return "\n" + name + ", " + title + ", has " + taskInfo + "\n\t and has " + subordinatesInfo + "\n\t and has superior " + superior.getName();
	}
}
