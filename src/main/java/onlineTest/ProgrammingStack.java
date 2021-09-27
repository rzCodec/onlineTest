package onlineTest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProgrammingStack extends TechCategory {
	protected String tech;
	protected String reason;
	
	public ProgrammingStack(String tech, String reason, String lifecycle) {
		super(lifecycle);
		this.tech = tech;
		this.reason = reason;
	}
}
