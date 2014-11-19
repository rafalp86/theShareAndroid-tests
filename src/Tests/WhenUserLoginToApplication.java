package Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Action.GoTo;
import Base.ShareBase;
import Page.WallPage;

public class WhenUserLoginToApplication extends ShareBase {

	public WallPage WallView;
	
	@BeforeClass
    public void setUp()
	 {
		ConnectionWithApplication("WhenUserLoginToApplication");
		System.out.println("Test :WhenLoginPanelIsDisplayed");
		WallView= GoTo.WallView();
	 }
	
	@Test
	public void ShoulDisplayLoginPanel()
	{
		//Assert.assertTrue(loginView.LoginButtonIsPresent(),"Can not see [Login button]");
	}
}
