package onlineTest;

public abstract class TechCategory {
	protected String lifecycle;
	
	public TechCategory(String lifecycle) {
		this.lifecycle = lifecycle;
	}

	protected String getLifecycle() {
		return lifecycle;
	}

	protected void setLifecycle(String lifecycle) {
		this.lifecycle = lifecycle;
	}
}
