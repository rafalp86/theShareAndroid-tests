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
	private By NotificationPageTitle = GetBy.ResourceIdOnly("android:id/action_bar_title");
}
