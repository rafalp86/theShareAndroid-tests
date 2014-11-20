package Action;

import Base.UI;
import Page.LogInPage;
import Page.WallPage;

public class GoTo extends UI {
	
	
	public static LogInPage LoginView()
	{
		if((new WallPage()).ShareElementIsPresent())
		return	(new WallPage()).TapYourProfile().TapSettings().TapSettingsLogout();
			
		return (new LogInPage()).TapXSkip();
	}
	
	public static WallPage WallView()
	{
		return (new LogInPage())
				.TapXSkip()
				.SetEmail(appConfig.get("Email"))
				.SetPassword(appConfig.get("Password"))
				.TapLogin();
	}

	

}
