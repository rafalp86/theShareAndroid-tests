package Page;

import org.openqa.selenium.By;

import Action.Gestures;
import Base.GetBy;
import Base.UI;

public class EditProfilePage extends UI{
	//TAP
	public YourProfilePage TabSave()
	{
		Gestures.ScollTo(SaveElement);
		Click(SaveElement);
		return new YourProfilePage();
	}
	// SET TEXT
	public EditProfilePage NewProfileName(String newProfileName)
	{
		SetText(EditProfileNameElement, newProfileName);
		return this;
	}
	public EditProfilePage NewAboutYou(String newAboutYou)
	{
		SetText(AboutYouProfile, newAboutYou);
		return this;
	}
	public EditProfilePage NewLocation(String newLocation)
	{
		SetText(EditLocationElement, newLocation);
		return this;
	}
	// GET text
	public String GetEmial()
	{
		return GetText(EditEmailElement);
	}
	// IS PRESENT
	public boolean PageTitleIsPresent(){
			return ElementExist(TitleElement);
	}
	
	private By TitleElement = GetBy.ResourceId("android:id/action_bar_title");
	private By EditImageElement = GetBy.ResourceId("com.example.theshare:id/edit_profile_change_image");
	private By EditProfileNameElement = GetBy.ResourceId("com.example.theshare:id/edit_profile_username");
	private By AboutYouProfile = GetBy.ResourceId("com.example.theshare:id/edit_profile_about_you");
	private By EditLocationElement = GetBy.ResourceId("com.example.theshare:id/edit_profile_location");
	private By EditEmailElement = GetBy.ResourceId("com.example.theshare:id/edit_profile_email");
	private By SaveElement = GetBy.ResourceId("com.example.theshare:id/btn_save");

}
