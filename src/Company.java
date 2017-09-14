import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;

public class Company {
	private static ArrayList<Employee> employees;
	private static HashMap<String, Employee> departmentToExecutive;
	
	//Creates and assigns new task
	public static void giveTask(Employee employee) {
		//Prompt for name of task
		String name = InputHelper.readString("What is the name of the task?");
		//Prompt for priority of task, input restricted to values in Priority enum
		boolean isValidPriority = false;
		Priority priority = null;
		while(!isValidPriority) {
			String prompt = ("What is the priority of this task?" + Arrays.toString(Priority.values()));
			String input = InputHelper.readString(prompt).toUpperCase();
			//Throws exception if input is not value of Priority
			try {
				priority = Priority.valueOf(input); 
				isValidPriority = true;
			}
			//If invalid input, display error message and prompt again
			catch(Exception e) {
				System.out.println(input + " is not a valid priority option.");
			}
		}
		//Create new task from input
		Task newTask = new Task(name, priority);
		//Assign new task to employee
		employee.assignTask(newTask);
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
