package Page;

import org.openqa.selenium.By;

import Base.GetBy;
import Base.UI;
import Base.UI.Class;

public class YourProfilePage extends UI {

	
	// TAP 
	public YourProfilePage  TapProfileVideos(){
	  Click(ProfileVideosElement);
	  return this;
	}
	public FollowingFollowersPage  TapProfileFollowing(){
	  Click(ProfileFollowingElement);
	  return  new FollowingFollowersPage();
	}
	public YourProfilePage  TapProfileFollowers(){
	  Click(ProfileFollowersElement);
	  return this;
	}
	public EditProfilePage  TapProfileEdit(){
	  Click(ProfileEditElement);
	  return new EditProfilePage();
	}
	public YourProfilePage  TapMessageDelete(){
	  Click(MessageDeleteButon);
	  return this;
	}
	public ProfileSetingsPage  TapSettings(){
		  Click(ActionSettingsElement);
		  return new ProfileSetingsPage();
	}
	//Get
	public int  GetFollowingCounter(){
		Sleep(1000); // Bez Wait bo trzeba by³oby znac stan licznika
		return  Integer.parseInt(GetText(ProfileFollowingElement).split(" ")[0]);
	}
	
	// IS PRESENT
	public boolean EditButonIsPresent()
	{
		return ElementExist(ProfileEditElement);
	}
	public boolean MessageIsPresent(String MessageText)
	{
		return ElementExist(MessageBytext(MessageText));
	}
	public boolean AnyMessageIsPresent() {
		return ElementExist(MessageDeleteButon);
	}
	public boolean PageTitleIsPresent() {
		return ElementExist(PageTitleLeabel);
	}
	public boolean FollowersIsPresent() {
		return ElementExist(ProfileFollowersElement);
	}
	public boolean VideosIsPresent() {
		return ElementExist(ProfileVideosElement);
	}
	public boolean FollowingIsPresent() {
		return ElementExist(ProfileFollowingElement);
	}
	
	private By MessageBytext(String text) {return GetBy.ClassAndText(Class.TextView, text) ;}
	private By MessageDeleteButon = GetBy.ResourceId("message_delete");
	private By ActionSettingsElement = GetBy.ResourceId("action_settings");
	private By PageTitleLeabel = GetBy.ResourceId("android:id/action_bar_title");
	private By ProfileVideosElement = GetBy.ResourceId("profile_videos");
	private By ProfileFollowingElement = GetBy.ResourceId("profile_following");
	private By ProfileFollowersElement = GetBy.ResourceId("profile_followers");

	
	private By ContainerElement = GetBy.ResourceId("container");
	private By MainSwipeLayoutElement = GetBy.ResourceId("main_swipe_layout");
	private By ProfileUserDataElement = GetBy.ResourceId("profile_user_data");
	private By ProfileAvatarElement = GetBy.ResourceId("profile_avatar");
	private By ProfileBtnsElement = GetBy.ResourceId("profile_btns");

	private By ProfileActionsFrameElement = GetBy.ResourceId("profile_actions_frame");
	private By ProfileEditElement = GetBy.ResourceId("profile_edit");
	private By ProfileUsernameElement = GetBy.ResourceId("profile_username");
	private By ProfileLocationElement = GetBy.ResourceId("profile_location");
	private By ProfileDescriptionElement = GetBy.ResourceId("profile_description");
	private By ProfileListElement = GetBy.ResourceId("profile_list");
	private By MessageContentElement = GetBy.ResourceId("message_content");
	private By ImageFrameElement = GetBy.ResourceId("image_frame");
	private By ImageElement = GetBy.ResourceId("image");
	private By MessageResponseElement = GetBy.ResourceId("message_response");
	private By MessageRelateIconElement = GetBy.ResourceId("message_relate_icon");
	private By MessageRelateTextElement = GetBy.ResourceId("message_relate_text");
	
	private By MessageAvatarElement = GetBy.ResourceId("message_avatar");
	private By MessageNameElement = GetBy.ResourceId("message_name");
	private By MessageWhenElement = GetBy.ResourceId("message_when");
		
}
