package Page;

import org.openqa.selenium.By;
import Base.GetBy;
import Base.UI;
import Action.Gestures;

public class NotificationsPage extends UI {
	
	
//  Element Is Present
	public boolean NotificationTitleIsPresent()
	{
		
		return ElementExist(NotificationPageTitle);
	}
	
	//BY
	private By NotificationPageTitle = GetBy.ResourceId("android:id/action_bar_title");
}
