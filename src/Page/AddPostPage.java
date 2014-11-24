package Page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Base.GetBy;
import Base.UI;
import Base.UI.Class;

public class AddPostPage extends UI {

	
	//TAP
	public WallPage  TapDone(){
		  Click(DoneButton);
		  return new WallPage();
	}
	public AddPostPage  TapFilter(String FilterText){
		  Click(FilterByText(FilterText));
		  return this;
	}
	public Integer GetCountCheckedFilter()
	{
		Integer checked= new Integer(0);
		List<WebElement> allFilter= Finds(AllFillterCheckbox);
		for(int i=0; i<allFilter.size();i++)
			if(allFilter.get(i).isSelected()) checked++;
		return checked;
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
		return ElementExist(FilterByText(filterText));
	}
	//ELEMENTS
	private By DoneButton= GetBy.ResourceId("com.example.theshare:id/button_done");	
	private By ComposeTextArea= GetBy.ResourceId("com.example.theshare:id/compose_text");	
	private By TitleElemet= GetBy.ClassAndText(Class.TextView, "Compose text message");
	private By FilterByText(String Text){return GetBy.ClassAndText(Class.TextView, Text);}
	private By AllFillterCheckbox= GetBy.ResourceId("com.example.theshare:id/filter_checkbox");
	
	
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
