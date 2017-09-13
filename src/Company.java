import java.util.HashMap;
import java.util.ArrayList;

public class Company {
	private String name;
	private ArrayList<Employee> employees;
	private HashMap<String, Executive> departmentToExecutive;
	public Company(String name) {
		this.name = name;
		this.employees = new ArrayList<Employee> ();
		this.departmentToExecutive = new HashMap<String, Executive> ();
	}
	public void addEmployee(Employee employee) {
		if(employee.getClass().getName() == "Executive") {
			String department = InputHelper.readString("What department is this executive in charge of?");
			departmentToExecutive.put(department, employee);
		}
		employees.add(employee);
	}
	//Returns string with company name, departments, and executives
	public String toString() {
		String retVal = name + " Company has departments:\n";
		for(String department: departmentToExecutive) {
			retVal = retVal + "\t[" + department + " headed by " + departmentToExecutive.get(department).getName() + "]\n";
		}
		return retVal;
	}
	public String getName() {
		return name;
	}
	public ArrayList<Employee> getEmployees() {
		return employees;
	}
}
