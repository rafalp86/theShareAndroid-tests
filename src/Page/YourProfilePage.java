package Page;

import org.openqa.selenium.By;

import Base.GetBy;
import Base.UI;

public class YourProfilePage extends UI {

	
	public YourProfilePage  TapProfileVideos(){
	  Click(ProfileVideosElement);
	  return this;
	}
	public YourProfilePage  TapProfileFollowing(){
	  Click(ProfileFollowingElement);
	  return this;
	}
	public YourProfilePage  TapProfileFollowers(){
	  Click(ProfileFollowersElement);
	  return this;
	}
	public YourProfilePage  TapProfileEdit(){
	  Click(ProfileEditElement);
	  return this;
	}
	public YourProfilePage  TapMessageDelete(){
	  Click(MessageDeleteElement);
	  return this;
	}
	public ProfileSetingsPage  TapSettings(){
		  Click(ActionSettingsElement);
		  return new ProfileSetingsPage();
	}
	
	private By ActionSettingsElement = GetBy.ResourceId("com.example.theshare:id/action_settings");
	private By ContainerElement = GetBy.ResourceId("com.example.theshare:id/container");
	private By MainSwipeLayoutElement = GetBy.ResourceId("com.example.theshare:id/main_swipe_layout");
	private By ProfileUserDataElement = GetBy.ResourceId("com.example.theshare:id/profile_user_data");
	private By ProfileAvatarElement = GetBy.ResourceId("com.example.theshare:id/profile_avatar");
	private By ProfileBtnsElement = GetBy.ResourceId("com.example.theshare:id/profile_btns");
	private By ProfileVideosElement = GetBy.ResourceId("com.example.theshare:id/profile_videos");
	private By ProfileFollowingElement = GetBy.ResourceId("com.example.theshare:id/profile_following");
	private By ProfileFollowersElement = GetBy.ResourceId("com.example.theshare:id/profile_followers");
	private By ProfileActionsFrameElement = GetBy.ResourceId("com.example.theshare:id/profile_actions_frame");
	private By ProfileEditElement = GetBy.ResourceId("com.example.theshare:id/profile_edit");
	private By ProfileUsernameElement = GetBy.ResourceId("com.example.theshare:id/profile_username");
	private By ProfileLocationElement = GetBy.ResourceId("com.example.theshare:id/profile_location");
	private By ProfileDescriptionElement = GetBy.ResourceId("com.example.theshare:id/profile_description");
	private By ProfileListElement = GetBy.ResourceId("com.example.theshare:id/profile_list");
	private By MessageContentElement = GetBy.ResourceId("com.example.theshare:id/message_content");
	private By ImageFrameElement = GetBy.ResourceId("com.example.theshare:id/image_frame");
	private By ImageElement = GetBy.ResourceId("com.example.theshare:id/image");
	private By MessageResponseElement = GetBy.ResourceId("com.example.theshare:id/message_response");
	private By MessageRelateIconElement = GetBy.ResourceId("com.example.theshare:id/message_relate_icon");
	private By MessageRelateTextElement = GetBy.ResourceId("com.example.theshare:id/message_relate_text");
	private By MessageDeleteElement = GetBy.ResourceId("com.example.theshare:id/message_delete");
	private By MessageAvatarElement = GetBy.ResourceId("com.example.theshare:id/message_avatar");
	private By MessageNameElement = GetBy.ResourceId("com.example.theshare:id/message_name");
	private By MessageWhenElement = GetBy.ResourceId("com.example.theshare:id/message_when");
}
