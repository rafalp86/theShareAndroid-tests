package Tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Action.GoTo;
import Base.ShareBase;
import Page.AddPostPage;

public class WhenUserDisplayedAddNewTextMessageView extends ShareBase{
	
	AddPostPage AddMesageView;

	@BeforeClass
    public void setUp()
	 {
		ConnectionWithApplication("WhenUserTryAddNewTextMessage");
		AddMesageView =GoTo.ComposeTextView();
	 }
	@Test
	public void PageShouldHaveCorrectTitle()
	{ //1.	Sprawdziæ czy ekran ma tytul „Compose text message..”
		Assert.assertTrue(AddMesageView.PageTitleIsPresent(), "Can't see see [Compose text message] ");
	}
	@Test
	public void PageShouldHaveTextControlAndDoneButton()
	{ //2.	Sprawdzic czy Elemety Done, pole tekstowe sa dostepne 
		
		Assert.assertTrue(AddMesageView.DoneButtonPresent(), "Can't see see [Done button] ");
		Assert.assertTrue(AddMesageView.MessageIsPresent(), "Can't see see [Message content] ");
		
	}
	@Test(dataProvider = "Filter")
	public void PageShouldHaveFewParameters(String Filter,Integer notUsedparameter)
	{ //3.	Sprawdziæ czy parametry "showe to" s¹ dostêpne (data Provider)
		Assert.assertTrue(AddMesageView.FilterIsPresent(Filter), "Can't see see [Filter] ");		
	}
	
	@Test(dataProvider = "Filter")
	public void CheckboxInFilterShouldBeLinked(String Filter,Integer HowManyElementIsSelect)
	{ //4.	Sprawdziæ zale¿noœci miedzy checkboxami
		AddMesageView.TapFilter(Filter);
		Assert.assertEquals(AddMesageView.GetCountCheckedFilter(), HowManyElementIsSelect);	
	}
	
	
	
	  @DataProvider(name = "Filter")
	  public  Object[][] Filtertext() {
	        return new Object[][]{
	        		{"Entire Alumni Program",1},
	        		{"Entire Family Program",2},
	        		{"People you are following",1},
	        		{"People following you",2},
	        		{"Only with men",3},
	        		{"Select specific followers",2}};
	    }
    
	@AfterMethod
	public void BackToWallPage()
	{
	
	}
	
	 @AfterClass
	    public void tearDown() {
		  System.out.println("tearDown");
		 	CloseConnection();
	  }
	

}
