package Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Action.GoTo;
import Base.ShareBase;

public class WhenUserEditProfile extends ShareBase {
	
	@BeforeClass
    public void setUp()
	 {
		ConnectionWithApplication("WhenUserDisplayedYourProfilePage");
		
	 }
	
	@Test
	public void ShouldSeeAddedPost()
	{
	//	Assert.assertTrue(ProfileView.AnyMessageIsPresent(),"Can't see [any post in your profile page]");
	}

}
