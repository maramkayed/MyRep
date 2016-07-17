package module1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Desired {

	public static void main(String[] args) {
		
		//DesiredCapabilities
		WebDriver fd = new FirefoxDriver();
		fd.get("http://youtube.com");
		
		
	}

}
