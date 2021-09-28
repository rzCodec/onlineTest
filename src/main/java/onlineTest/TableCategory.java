package onlineTest;
import java.util.List;

public class TableCategory {
	private String category;
	private List<TechCategory> subCategories;

	public TableCategory(String category, List<TechCategory> subCategories) {
		this.category = category;
		this.subCategories = subCategories;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<TechCategory> getTableContentList() {
		return subCategories;
	}

	public void setTableContentList(List<TechCategory> tableContentList) {
		this.subCategories = tableContentList;
	}

}