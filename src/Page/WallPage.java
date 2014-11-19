package Page;

import org.openqa.selenium.By;
import Base.GetBy;
import Base.UI;
import Action.Gestures;

public class WallPage extends UI{

	
	
	// do usuniêcia po fixie
	private void CloseGoogleService()
	{
		if (ElementExist(GetBy.Text("Get Google Play services"), 2)) Back();
	}
	
	public WallPage  TapMessageRespond(){
		 CloseGoogleService();
		  Click(MessageRespondElement);
		  return this;
	}
	public WallPage  TapMainFilterFeed(){
		 CloseGoogleService();
		  Click(MainFilterFeedElement);
		  return this;
	}
	public WallPage  TapMainShare(){
		 CloseGoogleService();
		  Click(MainShareElement);
		  return this;
	}
	public YourProfilePage  TapMainProfile(){
		  CloseGoogleService();
		  Click(MainProfileElement);
		  return new YourProfilePage();
	}
	// 
	public boolean ShareElementIsPresent()
	{
		CloseGoogleService();
		return ElementExist(MainShareElement,60);
	}
	
	// Wygenerowane prze skrypt , do sprawdzenia , poprawnoœæ
	private By ActionNotificationsElement = GetBy.ResourceId("com.example.theshare:id/action_notifications");
	private By NotificationsIconElement = GetBy.ResourceId("com.example.theshare:id/notifications_icon");
	private By ContainerElement = GetBy.ResourceId("com.example.theshare:id/container");
	private By MainSwipeLayoutElement = GetBy.ResourceId("com.example.theshare:id/main_swipe_layout");
	private By MainListElement = GetBy.ResourceId("com.example.theshare:id/main_list");
	private By MessageAvatarElement = GetBy.ResourceId("com.example.theshare:id/message_avatar");
	private By MessageNameElement = GetBy.ResourceId("com.example.theshare:id/message_name");
	private By MessageWhenElement = GetBy.ResourceId("com.example.theshare:id/message_when");
	private By MessageFlagElement = GetBy.ResourceId("com.example.theshare:id/message_flag");
	private By MessageContentElement = GetBy.ResourceId("com.example.theshare:id/message_content");
	private By ImageFrameElement = GetBy.ResourceId("com.example.theshare:id/image_frame");
	private By ImageElement = GetBy.ResourceId("com.example.theshare:id/image");
	private By MessageResponseElement = GetBy.ResourceId("com.example.theshare:id/message_response");
	private By MessageRelateIconElement = GetBy.ResourceId("com.example.theshare:id/message_relate_icon");
	private By MessageRelateTextElement = GetBy.ResourceId("com.example.theshare:id/message_relate_text");
	private By MessageRespondElement = GetBy.ResourceId("com.example.theshare:id/message_respond");
	private By MainFilterFeedElement = GetBy.ResourceId("com.example.theshare:id/main_filter_feed");
	private By MainShareElement = GetBy.ResourceId("com.example.theshare:id/main_share");
	private By MainProfileElement = GetBy.ResourceId("com.example.theshare:id/main_profile");
}
