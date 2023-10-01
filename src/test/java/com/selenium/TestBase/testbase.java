package com.selenium.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

@Listeners(com.selenium.TestCase.ExtentReportManager.class)
public class testbase {
	public static WebDriver driver;
	public Logger logger;
	public ResourceBundle rb;

	@BeforeSuite
	public void start() {
		logger = LogManager.getLogger(this.getClass());
		driver = new ChromeDriver();
		rb = ResourceBundle.getBundle("dynamic");
		logger.info("Driver Instance Created");
		driver.get(rb.getString("Url"));
		logger.info("opened The URL");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		logger.info("Added wait Command");
		driver.manage().window().maximize();
		logger.info("maximizing the Window");

	}

	@AfterSuite
	public void teardown() {
		driver.close();

	}
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + ".\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;

	}

}
