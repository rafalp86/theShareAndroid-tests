package Page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Action.Gestures;
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
		  
		  WaitAndClick(FilterByText(FilterText));
		  return this;
	}
	public AddPostPage  TapSpecificFollowersFilter(){
		Gestures.HideKeyboard();
		String filterText="Select specific followers";
		 List<WebElement> selectFiltes= Finds(AllCheckedFillter);
		 for(int i=0; i<selectFiltes.size();i++)
			 selectFiltes.get(i).click();
	 
		  Click(FilterByText(filterText));
		  return this;
	}
	public Integer GetCountCheckedFilter()
	{
		return Finds(AllCheckedFillter).size();
	}
	//Set
	public AddPostPage SetMessage(String messagetext)
	{
		SetText(ComposeTextArea, messagetext,true);
		return this;
	}
	//Present
	public boolean DoneButtonPresent()
	{
		return ElementExist(DoneButton);
	}
	public String PageTitle()
	{
		return GetText(TitleElemet);
	}
	public boolean MessageIsPresent()
	{
		return ElementExist(ComposeTextArea);
	}
	public boolean FilterIsPresent(String filterText)
	{
		return ElementExist(FilterByText(filterText));
	}
	public boolean SelectFollowerIsPresent()
	{
		Gestures.HideKeyboard();
		Gestures.ScrollToEnd();
		return ElementExist(SelectFollower);
	}
	//ELEMENTS
	private By DoneButton= GetBy.ResourceId("com.example.theshare:id/button_done");	
	private By ComposeTextArea= GetBy.ResourceId("com.example.theshare:id/compose_text");	
	private By TitleElemet= GetBy.ResourceId("android:id/action_bar_title");
	private By FilterByText(String Text){return GetBy.ClassAndText(Class.TextView, Text);}
	private By AllCheckedFillter= By.xpath("//"+Class.CheckBox+"[@checked='true']");
	private By SelectFollower= GetBy.ResourceId("com.example.theshare:id/select_followers");	 
	
	
	//Choose  source Dialog
	//TAP
	public AddPostPage  TapCamera(){
		  Click(CameraSaurceElemet);
		  return this;
	}
	public AddPostPage  TapTextMessage(){
		  WaitAndClick(TextMessageElemet);
		  Gestures.HideKeyboard();
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
