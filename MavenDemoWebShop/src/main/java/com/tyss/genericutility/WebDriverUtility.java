package com.tyss.genericutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WebDriverUtility {
	
	
	public void getMouseHover(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	public void getDragDrop(WebDriver driver,WebElement src,WebElement des)
	{
		Actions act=new Actions(driver);
		act.dragAndDrop(src, des);
	}

}
