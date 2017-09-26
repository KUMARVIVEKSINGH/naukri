package naukritesting;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

public class NaurkriLogin {

	public void naukriUpdate() {
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\dc-user\\Downloads\\geckodriver-v0.18.0-win64\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\dc-user\\Downloads\\chromedriver_win32\\chromedriver.exe");
		System.setProperty("phantomjs.binary.path",
				"C:\\Users\\dc-user\\Downloads\\phantomjs-2.1.1-windows\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
		WebDriver driver = new PhantomJSDriver();
		driver.get(Constant.LOGIN_URL);
		driver.manage().window().maximize();
		driver.findElement(By.id("emailTxt")).sendKeys(System.getProperty("naukriusername"));
		driver.findElement(By.id("pwd1")).sendKeys(System.getProperty("naukripassword"));
		driver.findElements(By.id("sbtLog")).get(1).click();
		waitForSecs(5);
		driver.get("https://my.naukri.com//Profile//edit?id=&altresid");
		waitForSecs(5);
		// takeScreenshot(driver);
		driver.findElement(By.cssSelector("[value='Save Changes']")).click();
	}

	public static void waitForSecs(int sec) {
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void takeScreenshot(WebDriver driver) {
		File f = new File(".\\target\\screenshots\\" + new Long(new Date().getTime()).toString() + ".png");
		File temp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(temp, f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
