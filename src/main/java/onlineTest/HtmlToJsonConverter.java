package onlineTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class HtmlToJsonConverter {
	public static void main(String[] args) {		
		try {
			System.out.println("Requesting information... \n");
			//Jsoup makes it easier to traverse and handle html
			Document doc = Jsoup.connect("https://github.com/egis/handbook/blob/master/Tech-Stack.md").get();
			Elements allTableSections = doc.getElementsByTag("table");
			Elements h2Sections =  doc.getElementsByTag("h2");
			LinkedHashMap<String, Element> tableContent = new LinkedHashMap<String, Element>();
			
			allTableSections.remove(allTableSections.size() - 1);
			h2Sections.remove(0);
			h2Sections.remove(h2Sections.size() - 1);
			
			if(allTableSections.size() == h2Sections.size()) {
				for(int i = 0; i < allTableSections.size(); i++) {
					tableContent.put(h2Sections.get(i).text(), allTableSections.get(i));
				}
			}
			else {
				System.out.println("The number of table sections is not equal to the h2 headers for each section.");
			}
			
			List<TableCategory> categories = new ArrayList<TableCategory>();
			for(Map.Entry<String, Element> tableEntry : tableContent.entrySet()) {
				String category = tableEntry.getKey();
				Element tableSection = tableEntry.getValue();
				Elements trTags = tableSection.getElementsByTag("tr");
				trTags.remove(0);
				List<TechCategory> subCategories = new ArrayList<TechCategory>();
				TechCategoryFactory factory = new TechCategoryFactory();
				
				for(Element trTag : trTags) {
					Elements tdTags = trTag.getElementsByTag("td");	
					subCategories.add(factory.getTechCategory(category, tdTags));
				}
				
				TableCategory tblCategory = new TableCategory(category, subCategories);
				categories.add(tblCategory);
			}
			
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			String jsonText = gson.toJson(categories);
			System.out.println(jsonText);
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
