package Page;

import org.openqa.selenium.By;

import sun.security.action.GetBooleanSecurityPropertyAction;
import Base.GetBy;
import Base.UI;
import Action.Gestures;

public class FilterPage extends UI{
	
	
	// Tap
	public WallPage  TapButtonDone(){
		  Click(buttonDoneElement);
		return new WallPage();
	}
	// IS PRESENT
	public boolean PageTitleIsPresent()
	{
		return ElementExist(FilterPageTitle,10);
	}
	
	private By action_notificationsElement = GetBy.ResourceId("com.example.theshare:id/action_notifications");
	private By buttonDoneElement = GetBy.ResourceId("com.example.theshare:id/button_done");
	private By containerElement = GetBy.ResourceId("com.example.theshare:id/container");
	private By layoutElement = GetBy.ResourceId("com.example.theshare:id/layout");
	private By FilterPageTitle= GetBy.Text("Filter your feed");

	


}
