package Base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import Base.UI.Class;

public class GetBy  {
 	 public static By className(Class claseName)
 	 {
 		 return By.className(claseName.toString());
 	 }
	 public static By ClassAndText(UI.Class ClassName, String Text)
     {
         return By.xpath("//"+ClassName.toString()+"[@text='" + Text + "']");
     }
	 public static By ClassAndTextContains(UI.Class ClassName, String Text)
     {
         return By.xpath("//"+ClassName.toString()+"[contains(text(),'"+Text+"')]");
     }
	 public static By ControlDesc(String desc)
 	 {
		 return By.xpath("//"+Class.ImageView.toString()+"[@content-desc='" + desc + "']");
 	 }   
	
     public static By Text(String message) {
 		return By.xpath("//*[@text='" + message + "']");
 	}
     public static By ButtonClass()
     {
    	return GetBy.className(Class.Button);
     }
	 public static By ResourceId(String resorceid)
 	 {
		 return By.xpath("//*[@resource-id='com.theshare.shareapp:id/" + resorceid + "']");
 	 }
	 public static By ResourceIdOnly(String resorceid)
 	 {
		 return By.xpath("//*[@resource-id='" + resorceid + "']");
 	 }
     
     
	}

