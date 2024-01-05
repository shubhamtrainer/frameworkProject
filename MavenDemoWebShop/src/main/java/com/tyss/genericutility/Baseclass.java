package com.tyss.genericutility;

import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.tyss.object_repository.Homepage;
import com.tyss.object_repository.LoginPage;
import com.tyss.object_repository.WelcomePage;

public class Baseclass {
	public JavaUtility ju=new JavaUtility();
	public ExcelUtility eu=new ExcelUtility();

	public static WebDriverWait wait;
	public static	FileUtility fl=new FileUtility();
	
	public static WebDriver driver;
	public static ExtentSparkReporter spark;
	public static ExtentReports report;
	public static ExtentTest test ;
	public static Homepage hp;
	
	public static WelcomePage wp;
	public static LoginPage lp;
	
	@BeforeSuite
	public void configReport()
	{
		
		String Time = ju.getSystemTime().toString().replace(":", "-");
		
		 spark=new ExtentSparkReporter("./HTML_report/extent-"+Time+".png");
		 report=new ExtentReports();
		 
		 report.attachReporter(spark);
		 
	}
	
	@Parameters("Browser")
	@BeforeClass
	public void launch(@Optional("chrome") String browser) throws IOException
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		
	}
		else if(browser.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		
		
		String URL = fl.getfromProperty("url");
		driver.get(URL);
		
		
	

}
	
	@BeforeMethod
	public void login(Method method) throws EncryptedDocumentException, IOException
	{
		test= report.createTest(method.getName());
		wp=new WelcomePage(driver);
		
		wp.getLogin_link().click();
		
		
		String EMAIL = eu.getDataFromExcel("login", 2, 0);
		String PWD = eu.getDataFromExcel("login",2, 1);
		
		lp=new LoginPage(driver);
		lp.getEmail_text().sendKeys(EMAIL);
		lp.getPwd_text().sendKeys(PWD);
		lp.getLogin_button().click();
		}
	
	@AfterMethod
	public void logout()
	{
		hp=new Homepage(driver);
		hp.getLogout_button().click();
	}
	
	@AfterClass
	public void close()
	{
		driver.quit();
	}
	
	@AfterSuite
	public void reportBackup()
	{
		report.flush();
	}
	
}
