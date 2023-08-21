package com.selenium.TestBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class baseclass {
	public WebDriver driver;

	public baseclass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

}
