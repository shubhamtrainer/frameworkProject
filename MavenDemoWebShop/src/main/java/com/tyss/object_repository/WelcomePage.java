package com.tyss.object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage {
	public WelcomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
		
		
	}
	
	@FindBy(linkText = "Register")
	private WebElement register_link;
	
	@FindBy(linkText = "Log in")
	private WebElement login_link;
	
	@FindBy(xpath="//span[text()='Shopping cart']")
	private WebElement cart_link;

	public WebElement getRegister_link() {
		return register_link;
	}

	public WebElement getLogin_link() {
		return login_link;
	}

	public WebElement getCart_link() {
		return cart_link;
	}
	
	
	
	

}
