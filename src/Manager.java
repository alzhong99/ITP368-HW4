import java.util.ArrayList;

public class Manager extends Employee implements HasSubordinates {
	private static int BASE_SALARY = 70000;
	private ArrayList<Employee> subordinates;
	private Employee superior;
	public Manager(String name, String title, int bonus, Employee superior) {
		super(name, title, bonus);
		// TODO Auto-generated constructor stub
		this.superior = superior;
		this.subordinates = new ArrayList<Employee>();
	}

	
	
	@Override
	public int calculatePay() {
		// TODO Auto-generated method stub
		return BASE_SALARY + this.bonus;
	}
	public void addSubordinate(Employee employee) {
		subordinates.add(employee);
	}
	public void delegate(Object task, int employeeNumber) {
		tasks.remove((Task) task);
		subordinates.get(employeeNumber).assignTask((Task) task); 
	}
}
