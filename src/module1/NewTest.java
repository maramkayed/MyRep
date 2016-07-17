package module1;

import java.util.List;

import org.junit.Ignore;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NewTest {

	private FirefoxDriver fd;

	@BeforeSuite
	public void initailizedSelenium() {
		System.out.println("before suite");

	}

	@AfterSuite
	public void endSelenium() {
		System.out.println("after suite");
	}

	@Test(priority = 1)
	public void testYoutube() {
		fd = new FirefoxDriver();

		fd.get("http://www.youtube.com");
		fd.findElementByName("search_query").sendKeys("abc");
		fd.findElement(By.id("search-btn")).click();
		fd.findElement(By.xpath("//a[@href='/watch?v=_UR-l3QI2nE']")).click();
		// href="/watch?v=_UR-l3QI2nE"

		List<WebElement> list = fd.findElementsByCssSelector("#item-section-882105 li div.yt-lockup-thumbnail");
		Assert.assertTrue(fd.findElement(By.id("placeholder-player")).isDisplayed());

		fd.getCurrentUrl();
	}

	@Ignore
	@Test(priority = 2)
	public void Test1() {

		System.out.println("test 1");
		fd = new FirefoxDriver();

		fd.get("http://Gmail.com");
		String oldTab = fd.getWindowHandle();

		WebElement element = (new WebDriverWait(fd, 10))
				.until(ExpectedConditions.presenceOfElementLocated(By.id("next")));

		Assert.assertTrue(setEmail("kayedkmaram"), "Invalid Email");

		Assert.assertTrue(clickById("next"));

		// fd.findElement(By.id("link-forgot-passwd")).click();
		// fd.findElement(By.id("PersistentCookie")).click();
		Assert.assertTrue(setPassword("GoKa135%^&"), "wrong password");
		Assert.assertTrue(clickById("signIn"));

		// to youtube https://www.youtube.com/
		fd.findElement(By.xpath("//a[@href='https://www.google.co.il/intl/en/options/']")).click();
		fd.findElement(By.xpath("//a[@href='https://www.youtube.com/']")).click();
		// fd.findElementByName("search_query").sendKeys("abc");
		// fd.findElement(By.id("search-btn")).click();
		// fd.findElement(By.xpath("//a[@href='/watch?v=_UR-l3QI2nE']")).click();

		String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.RETURN);
		fd.findElement(By.xpath("//a[@href='https://www.youtube.com/']")).sendKeys(selectLinkOpeninNewTab);
		new Actions(fd).sendKeys(Keys.chord(Keys.CONTROL, Keys.TAB)).perform();

		fd.switchTo().window(oldTab);

		String currentURL = fd.getCurrentUrl();
		System.out.println(currentURL);

		// Assert.assertTrue(clickByCss("div.T-I.J-J5-Ji.ash.T-I-ax7.L3",""));
		// setting
		fd.findElementByCssSelector("div.T-I.J-J5-Ji.ash.T-I-ax7.L3").click();
		fd.findElementByCssSelector("div.J-N-Jz").click();

		// Compose
		Assert.assertTrue(clickByCss("div.T-I.J-J5-Ji.T-I-KE.L3", ""));
		Assert.assertTrue(setRecipient("kayedkmaram@gmail.com"));
		Assert.assertTrue(clickByCss("div.Am.Al.editable.LW-avf", "Done!"));
		Assert.assertTrue(clickByCss("div.T-I.J-J5-Ji.aoO.T-I-atl.L3", ""));
		// nael.abdaljawad@galilsoftware.com

	}

	@Ignore
	@Test(priority = 3)
	public void TestSetting() {
		Assert.assertTrue(clickByCss("div.T-I.J-J5-Ji.ash.T-I-ax7.L3", ""));
	}

	private boolean setEmail(String email) {
		try {
			this.fd.findElement(By.id("Email")).sendKeys(email);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	private boolean setPassword(String password) {
		try {
			this.fd.findElement(By.id("Passwd")).sendKeys(password);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	private boolean setRecipient(String rec) {
		try {
			this.fd.findElementByName("to").sendKeys(rec);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	private boolean clickById(String next) {
		try {
			this.fd.findElement(By.id(next)).click();

			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	private boolean clickByCss(String next, String sendKey) {
		try {
			if (sendKey != "") {
				this.fd.findElement(By.cssSelector(next)).sendKeys(sendKey);
				return true;
			}

			else {
				this.fd.findElement(By.cssSelector(next)).click();
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	// Assert.assertTrue(setEmail("kayedkmaram"), "Invalid Email");
	// Assert.assertTrue(clickNext("next"));
	// Assert.assertTrue(setPassword("GoKa135%^&"), "wrong password");
	// Assert.assertTrue(clickNext("signIn"));
	//
	// fd.findElement(By.cssSelector("div.T-I.J-J5-Ji.T-I-KE.L3")).click();
	//
	// Assert.assertTrue(setRecipient("kayedkmaram@gmail.com"));
	//
	// fd.findElement(By.cssSelector("div.Am.Al.editable.LW-avf")).sendKeys("Done.");
	//
	// fd.findElement(By.cssSelector("div.T-I.J-J5-Ji.aoO.T-I-atl.L3")).click();
	//

	/*
	 * @Test(priority = 1) public void Test2() { System.out.println("test 2");
	 * FirefoxDriver fd = new FirefoxDriver(); fd.get("http://Gmail.com");
	 * WebDriverWait bro = (new WebDriverWait(fd, 0));
	 * 
	 * fd.close();
	 * 
	 * // fd.close(); } /*
	 * 
	 * @Test(dataProvider = "Data") public void testApp(String browserName,
	 * String UserName, String password) { if (browserName.equals("Mozilla")) {
	 * FirefoxDriver fd = new FirefoxDriver(); fd.get("http://Gmail.com"); } }
	 * 
	 * @DataProvider public Object[][] getData() { Object[][] data = new
	 * Object[1][3];
	 * 
	 * data[0][0] = "Mozilla"; data[0][1] = "U1"; data[0][2] = "P1";
	 * 
	 * // data[1][0]="Chrome"; // data[1][1]="U2"; // data[1][2]="P2";
	 * 
	 * return data; }
	 */
}
