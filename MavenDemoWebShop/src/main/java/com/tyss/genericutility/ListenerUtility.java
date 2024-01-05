package com.tyss.genericutility;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

public class ListenerUtility extends Baseclass implements ITestListener,ISuiteListener{

	@Override
	public void onTestFailure(ITestResult result) {
		
		test.log(Status.FAIL,"test script failed");
		
		TakesScreenshot ts=(TakesScreenshot) driver;
		
	test.addScreenCaptureFromBase64String(ts.getScreenshotAs(OutputType.BASE64),"bug")	;
		
		
	}
	
	
	
	
	
	
	

}
