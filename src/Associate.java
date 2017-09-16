
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
		String taskInfo = "tasks " + tasks.toString();
		if(tasks.size() == 0) {
			taskInfo = "no tasks";
		}
		return "\n" + name + ", " + title + ", has " + taskInfo + "\n\t and has superior " + superior.getName();
	}
}
