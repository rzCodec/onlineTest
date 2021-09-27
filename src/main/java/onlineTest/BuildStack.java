package onlineTest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BuildStack extends ProgrammingStack {
	protected String use;

	public BuildStack(String tech, String use, String reason, String lifecycle) {
		super(tech, reason, lifecycle);
		this.use = use;
	}
}
