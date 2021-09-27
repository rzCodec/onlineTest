package onlineTest;

import org.jsoup.select.Elements;

public class TechCategoryFactory {

	public TechCategory getTechCategory(String category, Elements tdTags) {
		if(category.equals("Programming Stack")) {
			return new ProgrammingStack(tdTags.get(0).text(), tdTags.get(1).text(), tdTags.get(2).text());
		}
		else if(category.equals("Build Stack")) {
			return new BuildStack(tdTags.get(0).text(), tdTags.get(1).text(), tdTags.get(2).text(), tdTags.get(3).text());
		}
		else if(category.equals("Infrastructure")) {
			return new Infrastructure(tdTags.get(0).text(), tdTags.get(1).text(), tdTags.get(2).text());
		}
		
		return null;
	}
}
