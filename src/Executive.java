import java.util.ArrayList;

public class Executive extends Employee implements HasSubordinates {
	private ArrayList<Employee> subordinates;
	private static int BASE_SALARY = 100000;
	public Executive(String name, String title, int bonus) {
		super(name, title, bonus);
		// TODO Auto-generated constructor stub
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
