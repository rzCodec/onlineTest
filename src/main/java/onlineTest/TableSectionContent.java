package onlineTest;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class TableSectionContent {
	private String category;
	
	@SerializedName("tableContent")
	private List<TechCategory> tableContentList;

	public TableSectionContent(String category, List<TechCategory> tableContentList) {
		super();
		this.category = category;
		this.tableContentList = tableContentList;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<TechCategory> getTableContentList() {
		return tableContentList;
	}

	public void setTableContentList(List<TechCategory> tableContentList) {
		this.tableContentList = tableContentList;
	}

}