
public class Associate extends Employee {
	private static int BASE_SALARY;
	public Associate(String name, String title, int bonus) {
		super(name, title, bonus);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int calculatePay() {
		// TODO Auto-generated method stub
		return BASE_SALARY + this.bonus;
	}

}
