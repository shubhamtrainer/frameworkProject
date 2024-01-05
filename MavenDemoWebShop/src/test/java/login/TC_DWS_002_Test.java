package login;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.tyss.genericutility.Baseclass;
import com.tyss.genericutility.ListenerUtility;


@Listeners(ListenerUtility.class)

public class TC_DWS_002_Test extends Baseclass {
	
	@Test
	public void login_test() throws EncryptedDocumentException, IOException
	{
		String expected_title = eu.getDataFromExcel("login",2, 2);
		
		Assert.assertEquals(driver.getTitle(), expected_title,"login pages is not displayed");
		test.log(Status.PASS,"login successfully done");
		
	}

}
