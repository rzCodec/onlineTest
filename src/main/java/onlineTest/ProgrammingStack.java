package onlineTest;

public class ProgrammingStack extends TechCategory {
	protected String tech;
	protected String reason;
	
	public ProgrammingStack(String tech, String reason, String lifecycle) {
		super(lifecycle);
		this.tech = tech;
		this.reason = reason;
	}
}
