package onlineTest;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class main {
	
	private static String jsonString = "";
	public static String createJSONString(String startBracket, String th, String td, String closingBracket) {
		return jsonString = jsonString + " " + startBracket + th + ": " + td + closingBracket;
	}
	
	public static String getJSONString(String category) {
		return "{" + category + ": [\n" + jsonString.replace("}\n {", "},\n\n{") + "]";
	}
	
	public static void makeContent(String content, int tableIndex, int i) {
		if(content.equals("")) content = "''";
		if(tableIndex == 0) {
			if((i % 3) == 0) createJSONString("{", "Tech", content, ",\n");
		    else if((i % 3) == 1) createJSONString("", "Reason", content, ",\n");
			else if((i % 3) == 2) createJSONString("", "Lifecycle", content, "}\n");
		}
		else if(tableIndex == 1) {
			if((i % 4) == 0) createJSONString("{", "Tech", content, ",\n");
		    else if((i % 4) == 1) createJSONString("", "Use", content, ",\n");
			else if((i % 4) == 2) createJSONString("", "Reason", content, ",\n");
			else if((i % 4) == 3) createJSONString("", "Lifecycle", content, "}\n");
		}
		else if(tableIndex == 2) {
			if((i % 3) == 0) createJSONString("{", "Infrastructure", content, ",\n");
			else if((i % 3) == 1) createJSONString("", "Use", content, ",\n");
			else if((i % 3) == 2) createJSONString("", "Lifecycle", content, "}\n");
		}
	}

	public static void main(String[] args) {		
		try {
			//Jsoup makes it easier to traverse and handle html
			Document doc = Jsoup.connect("https://github.com/egis/handbook/blob/master/Tech-Stack.md").get();
			Elements allTableSections = doc.getElementsByTag("table");
			allTableSections.remove(allTableSections.size() - 1);
				
			int tableIndex = 0;
			for(Element tableSection : allTableSections) {		
				Elements tdElements = tableSection.getElementsByTag("td");	
				
				if(tableIndex == 0) {		
					for(int i = 0; i < tdElements.size(); i++) { 
						makeContent(tdElements.get(i).text(), tableIndex, i);
					}	
					System.out.println(getJSONString("\nProgramming Stack") + "}");
					
				} 
				else if(tableIndex == 1) {					
					for(int i = 0; i < tdElements.size(); i++) { 
						makeContent(tdElements.get(i).text(), tableIndex, i);
					}	
					System.out.println(getJSONString("\nBuild Tools") + "}");
				}
				else {
					for(int i = 0; i < tdElements.size(); i++) { 
						makeContent(tdElements.get(i).text(), tableIndex, i);
				    }
					System.out.println(getJSONString("\nInfrastructure") + "}");
				}
						
				tableIndex++;
				jsonString = "";
			}
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}

}
