
public class Associate extends Employee {
	private Employee superior;
	public Associate(String name, String title, Employee superior) {
		super(name, title);
		// TODO Auto-generated constructor stub
		this.superior = superior;
	}
	public String getSuperior() {
		return superior.getName();
	}
	public String toString() {
		String retVal = name + " has tasks " + tasks + "\n\t and has superior " + superior.getName();
		return retVal;
	}
}
