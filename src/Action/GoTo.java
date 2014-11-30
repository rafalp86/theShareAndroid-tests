package Action;

import Base.UI;
import Page.AddPostPage;
import Page.LogInPage;
import Page.WallPage;

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
		if((new WallPage()).NotificationElementIsPresentWithoutGoogle())
			return new WallPage();
		
		return (new LogInPage())
				.TapXSkip()
				.SetEmail(appConfig.get("Email"))
				.SetPassword(appConfig.get("Password"))
				.TapLogin();
	}
	public static AddPostPage ComposeTextView()
	{
		return WallView().TapShare().TapTextMessage();

	}

	

}
