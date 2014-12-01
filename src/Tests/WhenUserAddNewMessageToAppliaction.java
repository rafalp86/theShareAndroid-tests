package Tests;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Action.Add;
import Action.Gestures;
import Action.GoTo;
import Base.ShareBase;
import Page.AddPostPage;
import Page.WallPage;

public class WhenUserAddNewMessageToAppliaction extends ShareBase {
	
	private  SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
	private  String testMessage= "_Auto test message_"+timeFormat.format(Calendar.getInstance().getTime());

	@BeforeClass
    public void setUp()
	 {
		ConnectionWithApplication("WhenUserTryAddNewTextMessage");
	 }
	@Test
	public void MessageSchouldByPresentInWall()
	{
		Assert.assertTrue(Add
				.MessageAndBackToWall(testMessage)
				.MessageIsPresent(testMessage)
				,"Can't see [message "+testMessage+" in Wall]");
	}
	
	@Test
	public void MessageSchouldByPresentInProfileViewList()
	{
		Assert.assertTrue(Add
				.MessageAndBackToWall(testMessage)
				.TapYourProfile()
				.MessageIsPresent(testMessage)
				,"Can't see [message "+testMessage+" in Profile view]");
	}
	//@Test(dataProvider = "MessageGenerator")
	public void AllMessageSchouldByPresentInWall(String message,Integer notUsedparameter)
	{
		Assert.assertTrue(Add
				.MessageAndBackToWall(message)
				.MessageIsPresent(message)
				,"Can't see [message "+message+" in Wall]");
	}
	
	
	@AfterMethod
	public void BackToWallPage()
	{
		System.out.println("AfterMethod");
		if(!(new WallPage()).NotificationElementIsPresentWithoutGoogle()) Gestures.Back();
	}
	
	 @AfterClass
	    public void tearDown() {
		  System.out.println("tearDown");
		 	CloseConnection();
	  }
	 /**
		* @param testMethod
		* @return
		*/
		  @DataProvider(name = "MessageGenerator")
		  public  Object[][] sauceBrowserDataProvider(Method testMethod) {
		        return new Object[][]{
		        		//{"Litwo! Ojczyzno moja! ty jesteœ jak zdrowie.Ile ciê trzeba ceniæ, ten tylko siê dowie,Kto ciê straci³.",1},
		        		{"Test link https://github.com/saucelabs/sauce-java/blob/master/testng/src/test/java/com/saucelabs/testng/SampleSauceTest.java",1},
		        		{"test@gmail.com",1},
		        		{"#autotest $23",1},
		        		{"long text test test test test test test test test test test test test test test test test test test test test",1},
		        		{"<iframe src=\"www.wp.pl\"></iframe>",1}};
		    }
}
