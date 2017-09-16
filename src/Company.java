import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;

public class Company {
	private static String companyName = null;
	private static ArrayList<Executive> executives = new ArrayList<Executive>();
	private static ArrayList<Manager> managers = new ArrayList<Manager>();
	private static ArrayList<Associate> associates = new ArrayList<Associate>();
	private static HashMap<String, Executive> departmentToExecutive = new HashMap<String, Executive>();
	
	//Prints employees of a given level and prompts user to enter employee's displayed number
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
		return "Enter the number of the employee: ";
	}
	//Creates and assigns new task
	public static void giveTask() {
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
		
		String level = InputHelper.readString("What is the employee's level? Type E for executive, M for manager, or A for associate.");
		switch(level.toLowerCase()) {
		//If executive, add to map and executives ArrayList
		case "e": {
			if(executives.size() > 0) {
				System.out.println("Which executive would you like to assign the task to?");
				int employeeNumber = InputHelper.readIntBetween(getEmployeeOfLevel("executive"), 0, executives.size()-1);
				//Assign new task to employee
				executives.get(employeeNumber).assignTask(newTask);
			}
			else {
				System.out.println("There are no executives.");
			}
			break;
		}
		//If manager, set superior, add to superior's subordinates, and add to managers ArrayList
		case "m": {
			if(managers.size() > 0) {
				System.out.println("Which manager would you like to assign the task to?");
				int employeeNumber = InputHelper.readIntBetween(getEmployeeOfLevel("manager"), 0, managers.size()-1);
				managers.get(employeeNumber).assignTask(newTask);
			}
			else {
				System.out.println("There are no managers.");
			}
			break;
		}
		//If associate, set superior, add to superior's subordinates, and add to associates ArrayList
		case "a": {
			if(associates.size() > 0) {
				System.out.println("Which associate would you like to assign the task to?");
				int employeeNumber = InputHelper.readIntBetween(getEmployeeOfLevel("associate"), 0, associates.size()-1);
				associates.get(employeeNumber).assignTask(newTask);
			}
			else {
				System.out.println("There are no associates.");
			}
			break;
		}
		//If invalid option, print error and exit function
		default: {
			System.out.println("Not a valid level option.");
			break;
		}
		}
		
		
	}	
	//Adds employee and maps to department if employee is executive
	public static void addEmployee() {
		Employee employee = null;
		//Receive input to create new employee
		String name = InputHelper.readString("What is the employee's name?");
		String title = InputHelper.readString("What is the employee's title?");
		String level = InputHelper.readString("What is the employee's level? Type E for executive, M for manager, or A for associate.");
		switch(level.toLowerCase()) {
		//If executive, add to map and executives ArrayList
		case "e": {
			employee = new Executive(name, title);
			String department = InputHelper.readString("What department is this executive in charge of?");
			departmentToExecutive.put(department, (Executive) employee);
			executives.add((Executive) employee);
			break;
		}
		//If manager, set superior, add to superior's subordinates, and add to managers ArrayList
		case "m": {
			if(executives.size() > 0) {
				System.out.println("Who is this manager's superior?");
				int superior = InputHelper.readIntBetween(getEmployeeOfLevel("executive"), 0, executives.size()-1);
				employee = new Manager(name, title, executives.get(superior));
				executives.get(superior).addSubordinate(employee);
				managers.add((Manager) employee);
			}
			else {
				System.out.println("You must add an executive before adding a manager.");
			}
			break;
		}
		//If associate, set superior, add to superior's subordinates, and add to associates ArrayList
		case "a": {
			if(managers.size() > 0) {
				System.out.println("Who is this associate's superior?");
				int superior = InputHelper.readIntBetween(getEmployeeOfLevel("manager"), 0, managers.size()-1);
				employee = new Associate(name, title, managers.get(superior));
				managers.get(superior).addSubordinate(employee);
				associates.add((Associate) employee);
			}
			else {
				System.out.println("You must add a manager before adding an associate.");
			}
			break;
		}
		//If invalid option, print error and exit function
		default: {
			System.out.println("Not a valid level option.");
			break;
		}
		}
	}
	//Prints company departments and executives
	public static void printDepartments() {
		if(!departmentToExecutive.isEmpty()) {
			System.out.println("Company has departments:");
			for(String department: departmentToExecutive.keySet()) {
				System.out.println("\t" + department + " headed by " + departmentToExecutive.get(department).getName());
			}
		}
		else{
			System.out.println("There currently no departments available.");
		}
	}
	//Prints company employees
	public static void printEmployees() {
		if(executives.size() > 0) {
			System.out.println("Executives:\n" + executives);
		}
		else {
			System.out.println("No executives");
		}
		if(managers.size() > 0) {
			System.out.println("Managers:\n" + managers);
		}
		else {
			System.out.println("No managers");
		}
		if(associates.size() > 0) {
			System.out.println("Associates:\n" + associates);
		}
		else {
			System.out.println("No associates");
		}
	}
	public static void printMenuOptions()
	{
		System.out.println("\n***** Welcome to " + companyName + " *****");
		
		System.out.println("1: Add Employee");
		System.out.println("2. Print All Departments");
		System.out.println("3. Give Task to Employee");
		System.out.println("4: Print All Employees");
		System.out.println("\n**********************************************\n");
	}
	public static void askForAction()
	{
		boolean hasnotQuit = false;
		
		while(!hasnotQuit)
		{
			printMenuOptions();
			int choice = InputHelper.readIntBetween("Choose a number:", 1, 4);
			switch(choice) {
			case 1:{
				addEmployee();
				break;
			}
			case 2:{
				printDepartments();
				break;
			}
			case 3: {
				giveTask();
				break;
			}
			case 4:{
				printEmployees();
				break;
			}
			}
			
		}
	}
	public static void main(String[] args) {
		companyName = InputHelper.readString("What would you like the software company name to be?");
		askForAction();
		
	}
}
