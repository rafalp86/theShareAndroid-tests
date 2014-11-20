package Page;

import org.openqa.selenium.By;

import Base.GetBy;
import Base.UI;
import Base.UI.Class;

public class SharePage extends UI {

	
	
	//Choose  source Dialog
	//TAP
	public SharePage  TapCamera(){
		  Click(CameraSaurceElemet);
		  return this;
	}
	public SharePage  TapTextMessage(){
		  Click(TextMessageElemet);
		  return this;
	}
	public SharePage  TapCancel(){
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
