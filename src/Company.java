import java.util.HashMap;
import java.util.ArrayList;

public class Company {
	private static ArrayList<Employee> employees;
	private static HashMap<String, Employee> departmentToExecutive;
	
	//Creates and assigns new task
	public static void giveTask() {
		//Receive input to create new task
		employee.assignTask(new Task());
	}	
	//Adds employee and maps to department if employee is executive
	public static void addEmployee() {
		Employee employee = null;
		//Receive input to create new employee
		
		//Use this code if creating new executive
		/* 
			String department = InputHelper.readString("What department is this executive in charge of?");
			departmentToExecutive.put(department, employee);
		*/
		employees.add(employee);
	}
	//Prints company departments and executives
	public static void printDepartments() {
		System.out.println("Company has departments:");
		for(String department: departmentToExecutive.keySet()) {
			System.out.println("\t" + department + " headed by " + departmentToExecutive.get(department).getName());
		}
	}
	//Prints company employees
	public static void printAllEmployees() {
		System.out.println("Company has employees " + employees);
	}

	public static void main(String[] args) {
		
	}
}
