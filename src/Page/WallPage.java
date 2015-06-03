package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Base.GetBy;
import Base.UI;
import Action.Gestures;

public class WallPage extends UI{

	
	
	// do usuni�cia po fixie
	private void CloseGoogleService()
	{
		//if (ElementExist(GetBy.Text("Get Google Play services"), 1)) Back();
	}
	
	public WallPage  TapMessageRespond(){
		 CloseGoogleService();
		  Click(MessageRespondElement);
		  return this;
	}
	public FilterPage  TapFilterFeed(){
		  CloseGoogleService();
		  WebElement FilterFeed= Finds(MainFilterFeedElement).get(0);
		  FilterFeed.click();
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
		  WebElement YourProfile= Finds(MainProfileElement).get(2);
		  YourProfile.click();
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
	public boolean NotificationElementIsPresentWithoutGoogle()
	{
		return ElementExist(NotificationsElement,1);
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
	public boolean MessageIsPresent(String MessageText)
	{
		CloseGoogleService();
		return ElementExist(MessageBytext(MessageText),7);
	}
	//
	// Wygenerowane prze skrypt , do sprawdzenia , poprawno��
	private By NotificationsElement = GetBy.ResourceId("action_notifications");
	private By ShareButtont = GetBy.className(Class.ImageButton); // po ID nie dzia�a ,
	private By MainProfileElement = GetBy.className(Class.ImageButton); // po ID nie dzia�a ,
	private By MessageBytext(String text) {return GetBy.ClassAndText(Class.TextView, text) ;}
	private By MainFilterFeedElement = GetBy.className(Class.ImageButton); // po ID nie dzia�a ,;
	
	private By ContainerElement = GetBy.ResourceId("container");
	private By MainSwipeLayoutElement = GetBy.ResourceId("main_swipe_layout");
	private By MainListElement = GetBy.ResourceId("main_list");
	private By MessageAvatarElement = GetBy.ResourceId("message_avatar");
	private By MessageAutorElement = GetBy.ResourceId("message_name");
	private By MessageDataElement = GetBy.ResourceId("message_when");
	private By MessageFlagElement = GetBy.ResourceId("message_flag");
	private By MessageContentElement = GetBy.ResourceId("message_content");
	private By ImageFrameElement = GetBy.ResourceId("image_frame");
	private By ImageElement = GetBy.ResourceId("image");
	private By MessageResponseElement = GetBy.ResourceId("message_response");
	private By MessageRelateIconElement = GetBy.ResourceId("message_relate_icon");
	private By MessageRelateTextElement = GetBy.ResourceId("message_relate_text");
	private By MessageRespondElement = GetBy.ResourceId("message_respond");

	
	
}
