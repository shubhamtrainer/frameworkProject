package com.tyss.object_repository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	
	public Homepage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
		
	}
	
	
	@FindBy(xpath="//input[@value='Add to cart']")
	private List<WebElement> cart_button;
	
	@FindBy(xpath="//p[@class='content']")
	private WebElement confirm_msg;
	
	@FindBy(linkText = "Log out")
	private WebElement logout_button;

	public List<WebElement> getCart_button() {
		return cart_button;
	}

	public WebElement getConfirm_msg() {
		return confirm_msg;
	}

	public WebElement getLogout_button() {
		return logout_button;
	}
	
	
}
