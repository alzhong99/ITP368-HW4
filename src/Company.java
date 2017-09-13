import java.util.HashMap;
import java.util.ArrayList;

public class Company {
	private ArrayList<Employee> employees;
	private HashMap<String, Employee> departmentToExecutive;
	public void addEmployee(Employee employee) {
		if(employee.getClass().getName() == "Executive") {
			String department = InputHelper.readString("What department is this executive in charge of?");
			departmentToExecutive.put(department, employee);
		}
		employees.add(employee);
	}
	//Prints company departments and executives
	public void printDepartments() {
		System.out.println("Company has departments:");
		for(String department: departmentToExecutive.keySet()) {
			System.out.println("\t" + department + " headed by " + departmentToExecutive.get(department).getName());
		}
	}
	//Prints company employees
	public void printAllEmployees() {
		System.out.println("Company has employees " + employees);
	}

	public static void main(String[] args) {
		
	}
}
