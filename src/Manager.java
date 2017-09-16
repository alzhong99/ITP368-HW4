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
		String retVal = name + " has tasks " + tasks + "\n\t and has subordinates ";
		for(Employee subordinate: subordinates) {
			retVal = retVal + "[" + subordinate.getName() + "] ";
		}
		retVal = retVal + "\n\t and has superior " + superior.getName();
		return retVal;
	}
}
