package Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Base.ShareBase;
import Page.LogInPage;

public class WhenUserRunApp extends ShareBase {
	
	private LogInPage loginView= new LogInPage();
	
	@Test
	public void ShouldDisplayCloseButtonInSlide()
	{
		 Assert.assertTrue(loginView.SkippButtonIsPresent(),"Can not see the button to close X");
	}
	
	@Test
	public void ShouldSwipAllSlideAndDisplaySharingButton()
	{
		Assert.assertTrue(loginView.SwipeAllSlide().SharingButtonIsPresent(),"Can not see [Start sharing now]");

	}
	
	
	@BeforeClass
    public void setBeforeClass()
	{
		ConnectionWithApplication("DisplayInformationPage");
		System.out.println("Test :DisplayInformationPage");
	}

}
