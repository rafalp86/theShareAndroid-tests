package Tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Action.GoTo;
import Base.ShareBase;
import Page.LogInPage;

public class WhenUserRunApp extends ShareBase {
	
	private LogInPage loginView= new LogInPage();
	
	@BeforeClass
    public void setUp()
	 {
		ConnectionWithApplication("WhenUserRunApp");
		System.out.println("Test :WhenUserRunApp");
	
	 }
	
	@Test
	public void ShouldDisplayCloseButtonInSlide()
	{
		 Assert.assertTrue(loginView.SkippButtonIsPresent(20),"Can not see the button to close X");
	}
	
	@Test
	public void ShouldSwipAllSlideAndDisplaySharingButton()
	{
		Assert.assertTrue(loginView.SwipeAllSlide().SharingButtonIsPresent(),"Can not see [Start sharing now]");

	}
	
	
	
	 @AfterClass
	    public void tearDown() {
		  System.out.println("tearDown");
		 	CloseConnection();
	    }

}
