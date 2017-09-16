
public class Associate extends Employee {
	private static int BASE_SALARY = 40000;
	private Employee superior;
	public Associate(String name, String title, int bonus, Employee superior) {
		super(name, title, bonus);
		// TODO Auto-generated constructor stub
		this.superior = superior;
	}
	
	@Override
	public int calculatePay() {
		// TODO Auto-generated method stub
		return BASE_SALARY + this.bonus;
	}

}
