package com.tyss.object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {
	
	public ShoppingCartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@class='product-name']")
	private WebElement cartShopping_button;

	public WebElement getCartShopping_button() {
		return cartShopping_button;
	}
	
	
	
	

}
