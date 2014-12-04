package Action;

import Base.UI;
import Page.AddPostPage;
import Page.EditProfilePage;
import Page.FilterPage;
import Page.LogInPage;
import Page.WallPage;
import Page.YourProfilePage;

public class GoTo extends UI {
	
	
	public static LogInPage LoginView()
	{
		if (new LogInPage().SkippButtonIsPresent(1))
			return (new LogInPage()).TapXSkip();
		
		//if((new WallPage()).ShareElementIsPresent())
		return	(new WallPage()).TapYourProfile().TapSettings().TapSettingsLogout();
				
	}
	
	public static WallPage WallView()
	{
		if((new WallPage()).NotificationElementIsPresent())
			return new WallPage();
		
		return (new LogInPage())
				.TapXSkip()
				.SetEmail(appConfig.get("Email"))
				.SetPassword(appConfig.get("Password"))
				.TapLogin();
	}
	public static YourProfilePage YourProfile()
	{
		return WallView().TapYourProfile();
	}
	
	public static AddPostPage ComposeTextView()
	{
		return WallView().TapShare().TapTextMessage();

	}
	public static FilterPage FilterView()
	{
		return WallView().TapFilterFeed();
	}

	public static EditProfilePage EditProfile() {
		return YourProfile().TapProfileEdit();
	}

	

}
