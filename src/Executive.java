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
		String retVal = name + " has tasks " + tasks + "\n\t and has subordinates ";
		for(Employee subordinate: subordinates) {
			retVal = retVal + "[" + subordinate.getName() + "] ";
		}
		return retVal;
	}
}
