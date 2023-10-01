package com.selenium.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class register {

	WebDriver driver;

	@FindBy(xpath = "//input[@id='name']")
	WebElement Name;
	@FindBy(xpath = "//input[@id='email']")
	WebElement Email;
	@FindBy(xpath = "//input[@id='phone']")
	WebElement Phone;
	@FindBy(xpath = "//textarea[@id='textarea']")
	WebElement Address;
	@FindBy(xpath = "//input[@type='checkbox' and@class='form-check-input']/..")
	List<WebElement> list;
	@FindBy(xpath = "//select[@id='country']")
	WebElement dropdown;

	public void UserName(String name, String email, String ph, String add) {
		Name.sendKeys(name);
		Email.sendKeys(email);
		Phone.sendKeys(ph);
		Address.sendKeys(add);
	}

	/*
	 * public void checkbox() { for (int i = 0; i < list.size(); i++) { String str =
	 * list.get(i).getText(); if (str.equals("Sunday")) { list.get(i).click(); } }
	 * 
	 * }
	 */

	public List<WebElement> checkbox() {
		return list;

	}

	public void DropDown(String se) {
		Select select = new Select(dropdown);
		select.selectByValue(se);
	}

	public register(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
