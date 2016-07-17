package module1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Gmail {

	public static void main(String[] args) {
		
		WebDriver fd= new FirefoxDriver();
		//fd.manage().window().maximize();
		fd.get("http://gmail.com");
		fd.findElement(By.id("Password")).sendKeys("maram");
	}

}
