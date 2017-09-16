import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;

public class Company {
	private static ArrayList<Executive> executives;
	private static ArrayList<Manager> managers;
	private static ArrayList<Associate> associates;
	private static HashMap<String, Executive> departmentToExecutive;
	
	public static String getEmployeeOfLevel(String level) {
		switch(level) {
		case "executive": {
			for(int i = 0; i < executives.size(); i++) {
				System.out.println(i + ": " + executives.get(i).getName());
			}
			break;
		}
		case "manager": {
			for(int i = 0; i < managers.size(); i++) {
				System.out.println(i + ": " + managers.get(i).getName());
			}
			break;
		}
		case "associate": {
			for(int i = 0; i < associates.size(); i++) {
				System.out.println(i + ": " + associates.get(i).getName());
			}
			break;
		}
		}
		return "Choose the number of the employee: ";
	}
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
		String name = InputHelper.readString("What is the employee's name?");
		String title = InputHelper.readString("What is the employee's title?");
		int bonus = InputHelper.readPositiveInt("What is the employee's bonus?");
		String level = InputHelper.readString("What is the employee's level? Type E for executive, M for manager, or A for associate.");
		switch(level.toLowerCase()) {
		case "e": {
			employee = new Executive(name, title, bonus);
			String department = InputHelper.readString("What department is this executive in charge of?");
			departmentToExecutive.put(department, (Executive) employee);
			executives.add((Executive) employee);
			break;
		}
		case "m": {
			if(executives.size() > 0) {
				System.out.println("Who is this manager's superior?");
				int superior = InputHelper.readIntBetween(getEmployeeOfLevel("executive"), 0, executives.size()-1);
				employee = new Manager(name, title, bonus, executives.get(superior));
				executives.get(superior).addSubordinate(employee);
				managers.add((Manager) employee);
			}
			else {
				System.out.println("You must add an executive before adding a manager.");
			}
			break;
		}
		case "a": {
			if(managers.size() > 0) {
				
			}
		}
		}
		//Use this code if creating new executive
		/* 
			String department = InputHelper.readString("What department is this executive in charge of?");
			departmentToExecutive.put(department, employee);
		*/
		//employees.add(employee);
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
		//System.out.println("Company has employees " + employees);
	}

	public static void main(String[] args) {
	}
}
