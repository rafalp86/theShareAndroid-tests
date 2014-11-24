package Base;

import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Action.Gestures;

import com.google.common.base.Function;

public class UI extends ShareBase {
 
	
	//dodaæ timeout
	protected static boolean ElementExist(By element,Integer ... timeout)
	{
		System.out.println("Wait for " +element+" max: "+(timeout.length>0?timeout[0]:3)+"s");
		try
		{
			return WaitForElement(element,timeout.length>0?timeout[0]:3);
		}
		catch (Exception ex) {
			System.out.println("Elemet NOT exist :  " +element);
		
			return false;}
	}
	
	
	protected static void Back()
	{
	 driver.navigate().back();
	 System.out.println("press :Back");
	}
	
	protected static String  ExeciutJS(String arg0,Object arg1) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return (String) js.executeScript(arg0, arg1);
	}
	
	protected static String GetTextFromAllChildren(WebElement elemet)
	{
		String temp="";	

		if (elemet== null)
			for (WebElement item : driver.findElements(By.className(Class.TextView.toString())))
				temp+=" "+item.getText();
		else
		for (WebElement item : elemet.findElements(By.className(Class.TextView.toString())))
			temp+=" "+item.getText();

		return temp;
	}
	
	protected static void Click(By element)
	{  // sprawdziæ dzia³aje click JS
		System.out.println("Click in  " +element);
		driver.findElements(element).get(0).click();
	}
	protected static void  ScrollAndClick(By element) {
		Gestures.ScollTo(element);
		Click(element);
	}
	protected static void ClickIfExist(By element,Integer ... timeout)
	  {
	       if(ElementExist(element, timeout.length>0?timeout[0]:2))
	    	   Click(element);
	  }
	 
	protected static WebElement Find(By element,String ... log)
	 {
		if(log.length<0) System.out.println("Find "+ element);
		return driver.findElements(element).get(0);
	}
	
	protected static List<WebElement> Finds(By element)
	 {
		return driver.findElements(element);
	}
	protected static WebElement FindLast(By element)
	 {
		List<WebElement> elememnts=driver.findElements(element);
		return elememnts.get(elememnts.size()-1);
	}
	
	protected static void WaitAndClick(By element)
	  {	
		WaitForElement(element, 5);
		Click(element);
	 }
	 
	protected boolean WaitForElement(String Xpath)
	  {	
		  WebDriverWait  wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Xpath)));
		return true;
	  }
	  
	protected static boolean WaitForElement(final By element,int timeout)
	  {		
		WebDriverWait  wait = new WebDriverWait(driver,new Long(timeout));
		wait.until( new Function<WebDriver, Boolean>() {
            public Boolean apply(WebDriver driver) {
                return isVisible(element);
              }
            } );
		
		return true;
	  }
	
	 public void WaitForDisappear(final By element)
     {
		 System.out.println("Wait for Disappear :"+ element);
         new WebDriverWait(driver, 60).until( new Function<WebDriver, Boolean>() {
             public Boolean apply(WebDriver driver) {
                 return !ElementExist(element,1);
               }
             } );

     }
	 private static boolean isVisible(final By element)
	 {
		 try
		 {
			 Find(element,"False");
			 return true;
		 }
		 catch (Exception ex) {return false;}
	 
	 }
	 protected static String GetText(By element)
	{
		WebElement Elementtext =driver.findElement(element);
		String text= Elementtext.getAttribute("text");
		System.out.println("Get text :"+text);
		return text;
	}
	 
	 public static void SetText(By element, String message,Boolean ... ClearContent) {
		    System.out.println("Set tekst in "+ element+" ="+message);
			WebElement textBox= Find(element);
			if(ClearContent.length<0)  textBox.clear();
			textBox.sendKeys(message);
		}
	 
		public static void SetText(WebElement element, String message,Boolean ... ClearContent) {
		    System.out.println("Set tekst in "+ element+" ="+message);
			if(ClearContent.length<0)element.clear();
			element.sendKeys(message);
		}
	
	 
	 public enum Class
	 	{
	    	  Button("android.widget.Button"),
	    	  ImageButton("android.widget.ImageButton"),
	    	  LinearLayout("android.widget.LinearLayout"),
	    	  TextView("android.widget.TextView"),
	    	  FrameLayout("android.widget.FrameLayout"),
	    	  ScrollView("android.widget.ScrollView"),
	    	  ListView("android.widget.ListView"),
	    	  View("android.view.View"),
	    	  RelativeLayout("android.widget.RelativeLayout"),
	    	  CheckBox("android.widget.CheckBox"),
	    	  EditText("android.widget.EditText"),
	    	  ImageView("android.widget.ImageView"),
	    	  Spinner("android.widget.Spinner"),
	    	  CheckedTextView("android.widget.CheckedTextView");
	    	  	  
	  	    private String displayName;

	  	   Class(String displayName) {
	  	        this.displayName = displayName;
	  	    }

	  	    public String displayName() { return displayName; }

	  	    @Override public String toString() { return displayName; }
	 	}
	
	
}
