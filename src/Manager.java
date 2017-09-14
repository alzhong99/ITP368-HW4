import java.util.ArrayList;

public class Manager extends Employee {
	private static int BASE_SALARY;
	private ArrayList<Employee> subordinates;
	public Manager(String name, String title, int bonus) {
		super(name, title, bonus);
		// TODO Auto-generated constructor stub
		this.subordinates = new ArrayList<Employee>();
	}

	
	
	@Override
	public int calculatePay() {
		// TODO Auto-generated method stub
		return BASE_SALARY + this.bonus;
	}

}
