package Page;

import org.openqa.selenium.By;

import Base.GetBy;
import Base.UI;
import Base.UI.Class;

public class AddPostPage extends UI {

	
	//TAP
	public WallPage  TapDone(){
		  Click(DoneButton);
		  return new WallPage();
	}
	//Set
	public AddPostPage SetMessage(String messagetext)
	{
		SetText(ComposeTextArea, messagetext);
		return this;
	}
	//Present
	public boolean DoneButtonPresent()
	{
		return ElementExist(DoneButton);
	}
	public boolean PageTitleIsPresent()
	{
		return ElementExist(TitleElemet);
	}
	public boolean MessageIsPresent()
	{
		return ElementExist(ComposeTextArea);
	}
	public boolean FilterIsPresent(String filterText)
	{
		return ElementExist(GetBy.ClassAndText(Class.TextView, filterText));
	}
	//ELEMENTS
	private By DoneButton= GetBy.ResourceId("com.example.theshare:id/button_done");	
	private By ComposeTextArea= GetBy.ResourceId("com.example.theshare:id/compose_text");	
	private By TitleElemet= GetBy.ClassAndText(Class.TextView, "Compose text message");
	
	
	
	//Choose  source Dialog
	//TAP
	public AddPostPage  TapCamera(){
		  Click(CameraSaurceElemet);
		  return this;
	}
	public AddPostPage  TapTextMessage(){
		  WaitAndClick(TextMessageElemet);
		  return this;
	}
	public AddPostPage  TapCancel(){
		  Click(CancelButton);
		  return this;
	}
	public boolean TextMessageIsPresent()
	{
		return ElementExist(TextMessageElemet);
	}
	public boolean CameraIsPresent()
	{
		return ElementExist(CameraSaurceElemet);
	}
	//
	private By CameraSaurceElemet= GetBy.ClassAndText(Class.TextView, "Camera");
	private By TextMessageElemet= GetBy.ClassAndText(Class.TextView, "Text message");
	private By CancelButton= GetBy.ClassAndText(Class.TextView, "Cancel");
}
