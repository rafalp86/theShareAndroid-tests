package Action;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;

import java.util.HashMap;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import com.gargoylesoftware.htmlunit.javascript.host.arrays.Uint16Array;

import Base.GetBy;
import Base.UI;

public class Gestures extends UI {
	
	public  static void Scroll(double startX,double startY,double endX,double endY)
	 {
		 try
		 {
		/* HashMap<String, Double> swipeObject = new HashMap<String, Double>();
		 swipeObject.put("startX", startX);
		 swipeObject.put("startY",startY);
		 swipeObject.put("endX", endX);
		 swipeObject.put("endY", endY);
		 swipeObject.put("duration", 3.0);
		 UI.ExeciutJS("mobile: swipe", swipeObject);
		 */
			 TouchAction action = new TouchAction((MobileDriver) driver);
			 action.press((int)startX, (int)startY).waitAction(500).moveTo((int)endX, (int)endY).release().perform();
		 }
		 catch (Exception ex )
		 {
			 // know UIAutomation issue  https://groups.google.com/forum/#!topic/appium-discuss/isReHWFsZhs	
		 }	
	 }
	
	//dodac opcje skrolowania 
	public static void ScollTo(By element)
	{
		org.openqa.selenium.Dimension FrameSize =driver.manage().window().getSize();
		for(int i=0;i<15;i++)
		{
			if (ElementExist(element, 0)) break;
			System.out.println("Scroll");
			Scroll(1.,(double)FrameSize.height-20, 1., 1.);
		}
	}
	public static void ScollHorizontally()
	{
		org.openqa.selenium.Dimension FrameSize =driver.manage().window().getSize();
		Scroll((double)FrameSize.width-10,(double)FrameSize.height/2, 1.,(double)FrameSize.height/2);
	}
	public static void ScrollToEnd()
	{
		String lastText="";
		String currentText="";
		org.openqa.selenium.Dimension FrameSize =driver.manage().window().getSize();
		while(!lastText.equalsIgnoreCase(FindLast(GetBy.className(Class.TextView)).getText()))
			{
			currentText=FindLast(GetBy.className(Class.TextView)).getText();
			System.out.println("C :"+currentText+" L:"+lastText);
			lastText=currentText;
			Scroll(1.,(double)FrameSize.height/2, 1., 1.);		
			}
	}
	public static void ScrollToTop(UI.Class ...ElementType)
	{
		String lastText="";
		String currentText="";
		Class type=ElementType.length>0?ElementType[0]:Class.TextView;
		Dimension FrameSize =driver.manage().window().getSize();
		
		while(!lastText.equalsIgnoreCase(FindLast(GetBy.className(type)).getText()))
			{
			currentText=FindLast(GetBy.className(type)).getText();
			System.out.println("C :"+currentText+" L:"+lastText);
			lastText=currentText;
			Scroll(1.,(double)FrameSize.height/3, 1., (double)FrameSize.height-5);		
			}
	}
	
		
	public static void Back()
	{
		UI.Back();
	}
	public static void HideKeyboard()
	{
		try
		{
		driver.hideKeyboard();
		}
		catch(Exception ex){}
	}
}
