package com.selenium.TestCase;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.selenium.PageObjects.register;
import com.selenium.TestBase.testbase;

public class Registration extends testbase {

	@Test(priority = -1)
	public void testing() {
		register reg = new register(driver);
		logger.info("register Object is created ...");
		reg.UserName("seshu", "Seshubabu@gmail.com", "94930333", "vio");

	}

	@Test(priority = 0)
	public void Radio() {
		register reg = new register(driver);
		List<WebElement> check = reg.checkbox();
		for (int i = 0; i < check.size(); i++) {
			String str = check.get(i).getText();
			if (str.equals("Saturday")) {
				check.get(i).click();
			}

		}
	}

	@Test(priority = 1)
	public void Down() {
		register reg = new register(driver);
		    reg.DropDown("india");
		
	}

}
