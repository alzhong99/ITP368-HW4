
public class Task {
	private String name;
	private Priority priority;
	
	public Task(String name, Priority priority) {
		this.name = name;
		this.priority = priority;
	}
	
	public String toString() {
		return name + " with " + priority.getDescription();
	}
}
