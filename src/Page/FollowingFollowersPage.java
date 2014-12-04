package Page;

import org.openqa.selenium.By;

import Base.GetBy;
import Base.UI;

public class FollowingFollowersPage extends UI {

	//TAP
	public FollowingFollowersPage  TapAnyFollowing(){
		  Click(FollowingElement);
		return this;
	}
	public FollowingFollowersPage  TapAnyFollow(){
		  Click(FollowElement);
		return this;
	}
	public YourProfilePage  TapBack(){
		  Click(TitleElement);
		return new YourProfilePage();
	}
	// IS Present
	public boolean AnyFollowingIsPresent() {
		return ElementExist(FollowingElement);
	}
	public boolean AnyFollowIsPresent() {
		return ElementExist(FollowElement);
	}
	
	
	private By FollowingElement = GetBy.ClassAndText(Class.Button, "Following");
	private By FollowElement = GetBy.ClassAndText(Class.Button, "Follow");
	private By TitleElement = GetBy.ResourceId("android:id/action_bar_title");
	


	
}
