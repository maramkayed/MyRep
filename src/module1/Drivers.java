package module1;

import javax.swing.text.html.HTML;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Drivers {

	public static void main(String[] args) {
		
		
		FirefoxDriver fd = new FirefoxDriver();
		
		fd.get("http://gmail.com");
		WebElement list = fd.findElement(By.id("lang-chooser"));
		list.sendKeys("Dansk");
		
		 
	
		

	}

}
