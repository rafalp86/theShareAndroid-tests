package Tests;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Action.GoTo;
import Base.ShareBase;
import Page.EditProfilePage;

public class WhenUserEditProfile extends ShareBase {
	
	private EditProfilePage EditProfileView;
	private  SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
	@BeforeClass
    public void setUp()
	 {
		ConnectionWithApplication("WhenUserEditProfile");
		EditProfileView= GoTo.EditProfile();
		
	 }
	
	@Test
	public void PageShouldHaveCorrectTitle()
	{ //1.	1	Sprawdziæ wyœwietlanie tytu³u
		Assert.assertTrue(EditProfileView.PageTitleIsPresent(), "Can't see see [Page title] ");
	}
	
	//@Test
	public void ShuldDisplayEditedUserNameInWallWhenUsechChangProfile()
	{ 
		String TimGuide=timeFormat.format(Calendar.getInstance().getTime());;
		String newUserName=appConfig.get("NewUserName")+TimGuide;
		String newAboutDesc="Rafal Test "+TimGuide;
		String newLocation="Bialystok "+TimGuide;
		
		EditProfileView
		.NewProfileName(newUserName)
		.NewAboutYou(newAboutDesc)
		.NewLocation(newLocation)
		.TapSave();
	}

}
