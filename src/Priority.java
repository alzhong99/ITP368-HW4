
public enum Priority {
	LOW("low priority"),
	MEDIUM("medium priority"),
	HIGH("high priority");
	
	private String description;
	
	Priority(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
}
