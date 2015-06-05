package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Base.GetBy;
import Base.UI;
import Action.Gestures;

public class WallPage extends UI{

	
	
	
	
	public WallPage  TapMessageRespond(){
		  Click(MessageRespondElement);
		  return this;
	}
	public FilterPage  TapFilterFeed(){
		  WebElement FilterFeed= Finds(MainFilterFeedElement).get(0);
		  FilterFeed.click();
		  return new FilterPage();
	}
	public AddPostPage  TapShare(){
		   WebElement share= Finds(ShareButtont).get(1);
		   share.click();
		   
		  return new AddPostPage();
	}
	public YourProfilePage  TapYourProfile(){
		  WebElement YourProfile= Finds(MainProfileElement).get(2);
		  YourProfile.click();
		  return new YourProfilePage();
	}
	public NotificationsPage  TapNotifications(){
		  Click(NotificationsElement);
		  return new NotificationsPage();
	}
	
	//  Element Is Present
	public boolean ShareElementIsPresent()
	{
		return ElementExist(ShareButtont,3);
	}
	public boolean YourProfileIsPresent()
	{
		return ElementExist(MainProfileElement);
	}
	public boolean NotificationElementIsPresent()
	{
		return ElementExist(NotificationsElement);
	}
	public boolean NotificationElementIsPresentWithoutGoogle()
	{
		return ElementExist(NotificationsElement,1);
	}
	public boolean MessageAutorIsPresent()
	{
		return ElementExist(MessageAutorElement);
	}
	public boolean MessageRespondIsPresent()
	{
		return ElementExist(MessageRespondElement);
	}
	public boolean MessageDataIsPresent()
	{
		return ElementExist(MessageDataElement);
	}
	public boolean MessageIsPresent(String MessageText)
	{
		return ElementExist(MessageBytext(MessageText),7);
	}
	//
	// Wygenerowane prze skrypt , do sprawdzenia , poprawnoœæ
	private By NotificationsElement = GetBy.ResourceId("action_notifications");
	private By ShareButtont = GetBy.className(Class.ImageButton); // po ID nie dzia³a ,
	private By MainProfileElement = GetBy.className(Class.ImageButton); // po ID nie dzia³a ,
	private By MessageBytext(String text) {return GetBy.ClassAndText(Class.TextView, text) ;}
	private By MainFilterFeedElement = GetBy.className(Class.ImageButton); // po ID nie dzia³a ,;
	
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
