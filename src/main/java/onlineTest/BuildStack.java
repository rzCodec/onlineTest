package onlineTest;

public class BuildStack extends TechCategory {
	protected String tech;
	protected String use;
	protected String reason;
	
	public BuildStack(String tech, String use, String reason, String lifecycle) {
		super(lifecycle);
		this.tech = tech;
		this.use = use;
		this.reason = reason;
	}

	
}
