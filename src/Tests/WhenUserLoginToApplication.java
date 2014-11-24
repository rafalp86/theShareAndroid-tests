package Tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Action.Gestures;
import Action.GoTo;
import Base.ShareBase;
import Page.FilterPage;
import Page.NotificationsPage;
import Page.AddPostPage;
import Page.WallPage;
import Page.YourProfilePage;

public class WhenUserLoginToApplication extends ShareBase {

	public WallPage WallView;
	
	@BeforeClass
    public void setUp()
	 {
		ConnectionWithApplication("WhenUserLoginToApplication");
		WallView= GoTo.WallView();
	 }
	
	@Test
	public void ShouldDisplayShareProfileAndNotificationButton()
	{// Sprawdzenia czy  Przyciski Share, Your profile   Filter fees  i notyfikacji s¹ widoczne 
		
		Assert.assertTrue(WallView.ShareElementIsPresent(),"Can't see [Share button]");
		Assert.assertTrue(WallView.YourProfileIsPresent(),"Can't see [Your Profile button]");
		Assert.assertTrue(WallView.NotificationElementIsPresent(),"Can't see [Notification button]");
	}
	@Test
	public void ShouldDisplayNameDateAndResponceButton()
	{// Sprawdziæ czy post zawiera  Nazwe , Date  i  Przycisk Responce
	
		Assert.assertTrue(WallView.MessageAutorIsPresent(),"Can't see [Message Autor element]");
		Assert.assertTrue(WallView.MessageDataIsPresent(),"Can't see [Message Data element]");
		Assert.assertTrue(WallView.MessageRespondIsPresent(),"Can't see [Message Respond button]");
	}
	@Test
	public void ShouldGoToFilterFeedView()
	{ //Sprawdziæ przejœcie do Filter Feed 
		FilterPage FilterView= WallView.TapFilterFeed();

		Assert.assertTrue(FilterView.PageTitleIsPresent(),"Can't see Filter Page");
	}
	@Test
	public void ShouldGoToYourProfileView()
	{ //4.	Sprawdziæ przejœcie do Yoiur profile 
		YourProfilePage YourProfilerView= WallView.TapYourProfile();

		Assert.assertTrue(YourProfilerView.EditButonIsPresent() ,"Can't see Edit buton");
	}
	@Test
	public void ShouldGoToNotificationView()
	{ //5.	Sprawdziæ przejœcie do notyfikacji 
		NotificationsPage NotificationsView= WallView.TapNotifications();

		Assert.assertTrue(NotificationsView.NotificationTitleIsPresent() ,"Can't see page title");
	}
	@Test
	public void ShouldGoToAddShareDialog()
	{ //6.	Sprawdziæ przejœcie do Share 
		AddPostPage ShareView= WallView.TapShare();

		Assert.assertTrue(ShareView.TextMessageIsPresent(),"Can't see TextMessage in dialog");
	}
	
	@AfterMethod
	public void BackToWallPage()
	{
		if(!WallView.ShareElementIsPresent()) Gestures.Back();
	}
	
	 @AfterClass
	    public void tearDown() {
		  System.out.println("tearDown");
		 	CloseConnection();
	    }
	
}
