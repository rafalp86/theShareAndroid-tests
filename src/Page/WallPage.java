package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Base.GetBy;
import Base.UI;
import Action.Gestures;

public class WallPage extends UI{

	
	
	// do usuniêcia po fixie
	private void CloseGoogleService()
	{
		if (ElementExist(GetBy.Text("Get Google Play services"), 1)) Back();
	}
	
	public WallPage  TapMessageRespond(){
		 CloseGoogleService();
		  Click(MessageRespondElement);
		  return this;
	}
	public FilterPage  TapFilterFeed(){
		  CloseGoogleService();
		  Click(MainFilterFeedElement);
		  return new FilterPage();
	}
	public AddPostPage  TapShare(){
		   CloseGoogleService();
		   WebElement share= Finds(ShareButtont).get(1);
		   share.click();
		   
		  return new AddPostPage();
	}
	public YourProfilePage  TapYourProfile(){
		  CloseGoogleService();
		  WaitAndClick(MainProfileElement);
		  return new YourProfilePage();
	}
	public NotificationsPage  TapNotifications(){
		  CloseGoogleService();
		  Click(NotificationsElement);
		  return new NotificationsPage();
	}
	
	//  Element Is Present
	public boolean ShareElementIsPresent()
	{
		CloseGoogleService();
		return ElementExist(ShareButtont,1);
	}
	public boolean YourProfileIsPresent()
	{
		CloseGoogleService();
		return ElementExist(MainProfileElement);
	}
	public boolean NotificationElementIsPresent()
	{
		CloseGoogleService();
		return ElementExist(NotificationsElement);
	}
	public boolean MessageAutorIsPresent()
	{
		CloseGoogleService();
		return ElementExist(MessageAutorElement);
	}
	public boolean MessageRespondIsPresent()
	{
		CloseGoogleService();
		return ElementExist(MessageRespondElement);
	}
	public boolean MessageDataIsPresent()
	{
		CloseGoogleService();
		return ElementExist(MessageDataElement);
	}
	//
	// Wygenerowane prze skrypt , do sprawdzenia , poprawnoœæ
	private By NotificationsElement = GetBy.ResourceId("com.example.theshare:id/action_notifications");
	private By ShareButtont = GetBy.className(Class.ImageButton); // po ID nie dzia³a ,
	private By MainProfileElement = GetBy.ResourceId("com.example.theshare:id/main_profile");
	
	private By ContainerElement = GetBy.ResourceId("com.example.theshare:id/container");
	private By MainSwipeLayoutElement = GetBy.ResourceId("com.example.theshare:id/main_swipe_layout");
	private By MainListElement = GetBy.ResourceId("com.example.theshare:id/main_list");
	private By MessageAvatarElement = GetBy.ResourceId("com.example.theshare:id/message_avatar");
	private By MessageAutorElement = GetBy.ResourceId("com.example.theshare:id/message_name");
	private By MessageDataElement = GetBy.ResourceId("com.example.theshare:id/message_when");
	private By MessageFlagElement = GetBy.ResourceId("com.example.theshare:id/message_flag");
	private By MessageContentElement = GetBy.ResourceId("com.example.theshare:id/message_content");
	private By ImageFrameElement = GetBy.ResourceId("com.example.theshare:id/image_frame");
	private By ImageElement = GetBy.ResourceId("com.example.theshare:id/image");
	private By MessageResponseElement = GetBy.ResourceId("com.example.theshare:id/message_response");
	private By MessageRelateIconElement = GetBy.ResourceId("com.example.theshare:id/message_relate_icon");
	private By MessageRelateTextElement = GetBy.ResourceId("com.example.theshare:id/message_relate_text");
	private By MessageRespondElement = GetBy.ResourceId("com.example.theshare:id/message_respond");
	private By MainFilterFeedElement = GetBy.ResourceId("com.example.theshare:id/main_filter_feed");
	
	
}
