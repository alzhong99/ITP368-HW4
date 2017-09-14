import java.util.ArrayList;

public class Executive extends Employee {
	private ArrayList<Employee> subordinates;
	private static int BASE_SALARY;
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

}
