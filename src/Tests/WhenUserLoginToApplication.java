package Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Action.GoTo;
import Base.ShareBase;
import Page.FilterPage;
import Page.NotificationsPage;
import Page.SharePage;
import Page.WallPage;
import Page.YourProfilePage;

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
	public void ShouldDisplayShareProfileAndNotificationButton()
	{// Sprawdzenia czy  Przyciski Share, Your profile   Filter fees  i notyfikacji s¹ widoczne 
		
		Assert.assertTrue(WallView.ShareElementIsPresent(),"Can not see [Share button]");
		Assert.assertTrue(WallView.YourProfileIsPresent(),"Can not see [Your Profile button]");
		Assert.assertTrue(WallView.NotificationElementIsPresent(),"Can not see [Notification button]");
	}
	@Test
	public void ShouldDisplayNameDateAndResponceButton()
	{// Sprawdziæ czy post zawiera  Nazwe , Date  i  Przycisk Responce
	
		Assert.assertTrue(WallView.MessageAutorIsPresent(),"Can not see [Message Autor element]");
		Assert.assertTrue(WallView.MessageDataIsPresent(),"Can not see [Message Data element]");
		Assert.assertTrue(WallView.MessageRespondIsPresent(),"Can not see [Message Respond button]");
	}
	@Test
	public void ShouldGoToFilterFeedView()
	{ //Sprawdziæ przejœcie do Filter Feed (Dodaæ sprawdzanie gdzie jestem
		FilterPage FilterView= WallView.TapFilterFeed();

		Assert.assertTrue(FilterView.PageTitleIsPresent(),"Can not see Filter Page");
	}
	@Test
	public void ShouldGoToYourProfileView()
	{ //4.	Sprawdziæ przejœcie do Yoiur profile 
		YourProfilePage YourProfilerView= WallView.TapYourProfile();

		Assert.assertTrue(YourProfilerView.EditButonIsPresent() ,"Can not see Edit buton");
	}
	@Test
	public void ShouldGoToNotificationView()
	{ //5.	Sprawdziæ przejœcie do notyfikacji 
		NotificationsPage NotificationsView= WallView.TapNotifications();

		Assert.assertTrue(NotificationsView.NotificationTitleIsPresent() ,"Can not see page title");
	}
	@Test
	public void ShouldGoToAddShareDialog()
	{ //6.	Sprawdziæ przejœcie do Share 
		SharePage ShareView= WallView.TapShare();

		Assert.assertTrue(ShareView.TextMessageIsPresent(),"Can not see TextMessage in dialog");
	}
	
	
	@AfterMethod
	public void BackToWallPage()
	{
		System.out.println("");
		if(!WallView.ShareElementIsPresent()) BackToWallPage();
	}
	
}
