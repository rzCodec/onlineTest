package onlineTest;
import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.testng.Assert;
import org.testng.annotations.*;

public class URLResponseTest {
	private String baseUrl = "https://github.com/egis/handbook/blob/master/Tech-Stack.md";
	private Connection.Response response;
	
	@BeforeTest
	public void initialize() {
		try {
			response = Jsoup.connect(baseUrl).execute();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void verifyResponseCode() {
		int expectedResCode = 200;
		int receivedResCode = response.statusCode();
		Assert.assertEquals(receivedResCode, expectedResCode);
	}
}
