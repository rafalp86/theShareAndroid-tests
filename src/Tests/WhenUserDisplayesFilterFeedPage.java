package Tests;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Action.GoTo;
import Base.ShareBase;
import Page.FilterPage;

public class WhenUserDisplayesFilterFeedPage extends ShareBase {
	
	private FilterPage FilterView;
	
	@BeforeClass
    public void setUp()
	 {
		ConnectionWithApplication("WhenUserTryAddNewTextMessage");
		FilterView =GoTo.FilterView();
		FilterView.UncheckAll();
	 }
	
	@Test
	public void PageShouldHaveCorrectTitle()
	{ //1.	1	Sprawdzi� wy�wietlanie tytu�u
		Assert.assertTrue(FilterView.PageTitleIsPresent(), "Can't see see [Compose text message] ");
	}
	@Test
	public void PageShouldHaveDoneButton()
	{ //2.	Sprawdzic czy Elemety Done jest dostpeny
		
		Assert.assertTrue(FilterView.DoneButtonPresent(), "Can't see see [Done button] ");		
	}
	@Test(dataProvider = "Filter")
	public void CheckboxInFilterShouldBeLinked(String Filter,Integer HowManyElementIsSelect)
	{ //4.	Sprawdzi� zale�no�ci miedzy checkboxami
		FilterView.TapFilter(Filter);
		Assert.assertEquals(FilterView.GetCountCheckedFilter(), HowManyElementIsSelect);	
	}

	/**
	* @param testMethod
	* @return
	*/
	  @DataProvider(name = "Filter")
	  public  Object[][] sauceBrowserDataProvider(Method testMethod) {
	        return new Object[][]{
	        		{"All videos from Alumni Program",1},
	        		{"All videos form Family Program",2},
	        		{"Most popular shares",1},
	        		{"People you are following",1},
	        		{"People following you",1},
	        		{"Only with men",2},
	        		{"All videos from Alumni Program",2},
	        		{"All videos form Family Program",3}};
	        
	    }
	  
	  @AfterClass
	    public void tearDown() {
		  System.out.println("tearDown");
		 	CloseConnection();
	    }
}
