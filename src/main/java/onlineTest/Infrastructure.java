package onlineTest;

public class Infrastructure extends TechCategory {
	private String infrastructure;
	private String use;

	public Infrastructure(String infrastructure, String use, String lifecycle) {
		super(lifecycle);
		this.infrastructure = infrastructure;
		this.use = use;
	}
}
