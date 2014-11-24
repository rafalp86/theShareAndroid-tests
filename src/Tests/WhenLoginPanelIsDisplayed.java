package Tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Action.GoTo;
import Base.ShareBase;
import Page.LogInPage;
import Page.WallPage;

public class WhenLoginPanelIsDisplayed extends ShareBase {
	
	private LogInPage loginView;
	
	@BeforeClass
    public void setUp()
	 {
		ConnectionWithApplication("WhenLoginPanelIsDisplayed");
		System.out.println("Test :WhenLoginPanelIsDisplayed");
		loginView= GoTo.LoginView();
	 }
	
	@Test
	public void ShoulDisplayLoginPanel()
	{
		Assert.assertTrue(loginView.LoginButtonIsPresent(),"Can not see [Login button]");
	}
	
	@Test
	public void ShouldDisplayAllCOntrols()
	{
		Assert.assertTrue(loginView.FacebookButtonIsPresent(),"Can not see [FacebookButton]");
		Assert.assertTrue(loginView.CreateAccountButtonIsPresent(),"Can not see [CreateAccountButton]");
		Assert.assertTrue(loginView.LoginResetButtonIsPresent(),"Can not see [LoginReset]");
		Assert.assertTrue(loginView.FacebookButtonIsPresent(),"Can not see [FacebookButton]");
	}
	
	@Test
	public void ShouldDisplayMessageWhenUserSendNotReginstedEmail()
	{
		loginView.SetEmail("ReginstedEmail@fs.com")
				 .SetPassword(appConfig.get("Password"))
				 .TapLoginFailed();
		//Assert.assertTrue(loginView.NotRegisteredMessageIsPresent(), "Can not see [User with this email is not registered]");
		
	}
	
	@Test
	public void ShouldLogWhenUserEnterCorrectData()
	{
		WallPage HomeView= loginView.SetEmail(appConfig.get("Email"))
				 .SetPassword(appConfig.get("Password"))
				 .TapLogin();
		Assert.assertTrue(HomeView.ShareElementIsPresent(), "Can not see [ShareElement]");
		
	}
	
	 @AfterClass
	    public void tearDown() {
		  System.out.println("tearDown");
		 	CloseConnection();
	    }

}
