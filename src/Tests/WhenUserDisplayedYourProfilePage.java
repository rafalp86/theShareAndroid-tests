package Tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;

import Action.GoTo;
import Base.ShareBase;
import Page.YourProfilePage;

public class WhenUserDisplayedYourProfilePage extends ShareBase {
	private YourProfilePage ProfileView;
	
	@BeforeClass
    public void setUp()
	 {
		ConnectionWithApplication("WhenUserDisplayedYourProfilePage");
		ProfileView =GoTo.YourProfile().TapProfileFollowing()
				.TapAnyFollow()
				.TapBack().TapProfileFollowing()
				.TapAnyFollow()
				.TapBack();	
	 }
	
	@Test
	public void ShouldSeeAddedPost()
	{
		Assert.assertTrue(ProfileView.AnyMessageIsPresent(),"Can't see [any post in your profile page]");
	}
	@Test
	public void PageShouldHaveCorrectTitle()
	{ 
		Assert.assertTrue(ProfileView.PageTitleIsPresent(), "Can't see see Title] ");
	}
	
	@Test
	public void PageShouldHaveEnebledFollowingFollowersVideosButton()
	{
		Assert.assertTrue(ProfileView.FollowingIsPresent(), "Can't see see [Following] ");
		Assert.assertTrue(ProfileView.FollowersIsPresent(), "Can't see see [Followers] ");
		Assert.assertTrue(ProfileView.VideosIsPresent(), "Can't see see [Videos] ");
	}
	//@Test
	public void AddFollowingShouldIncreaseCounter()
	{ 
		int currentCount= ProfileView.GetFollowingCounter();
		int IncreaseCounter =ProfileView
		.TapProfileFollowing()
		.TapAnyFollow()
		.TapBack().GetFollowingCounter();
		Assert.assertEquals(IncreaseCounter, currentCount+1,"Was :"+currentCount+" Is:"+IncreaseCounter);
	}
	@Test
	public void SubtractFollowingShouldReduceCounter()
	{ 
		int currentCount= ProfileView.GetFollowingCounter();
		int ReduceCounter =ProfileView
		.TapProfileFollowing()
		.TapAnyFollowing()
		.TapBack().GetFollowingCounter();
		Assert.assertEquals(ReduceCounter, currentCount-1,"Was :"+currentCount+" Is:"+ReduceCounter);
		
	}
	
	@AfterClass
    public void tearDown() {
	 	CloseConnection();
  }

}
