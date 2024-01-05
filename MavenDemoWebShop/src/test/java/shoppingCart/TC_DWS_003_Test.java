package shoppingCart;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.tyss.genericutility.Baseclass;
import com.tyss.genericutility.ListenerUtility;
import com.tyss.object_repository.Homepage;
import com.tyss.object_repository.ShoppingCartPage;



@Listeners(ListenerUtility.class)

public class TC_DWS_003_Test extends Baseclass {
	
	@Test
	public void shopping_test() throws EncryptedDocumentException, IOException
	{
		hp=new Homepage(driver);
		hp.getCart_button().get(1).click();
		
		boolean msg = hp.getConfirm_msg().isDisplayed();
		Assert.assertEquals(msg, true,"product is not added");
		test.log(Status.PASS,"product is added succesfully");
		
		wait.until(ExpectedConditions.invisibilityOf(hp.getConfirm_msg()));
		
		wp.getCart_link().click();
		
		String Cart_title = eu.getDataFromExcel("shoppingcart", 1, 0);
		Assert.assertEquals(driver.getTitle(),Cart_title,"shopping cart is not displayed");
		test.log(Status.PASS, "shopping page is dipalyed");
		
		ShoppingCartPage scp=new ShoppingCartPage(driver);
		boolean msg_cart = scp.getCartShopping_button().isDisplayed();
		Assert.assertEquals(msg_cart, true,"product is not added in shopping cart");
		
		test.log(Status.PASS,"product is displayed in shopping page");
		
		
		
	}

}
