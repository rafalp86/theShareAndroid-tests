package Base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;


import Page.LogInPage;



public class ShareBase   {

	public static Config appConfig = new Config();
	
	protected static AppiumDriver driver;
	//@BeforeSuite 
	protected  WebDriver ConnectionWithApplication() 
	{ return ConnectionWithApplication("Test");}
	
	
	protected  WebDriver ConnectionWithApplication(String TestName) 
	{   
		try
		{
			driver= new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), Configuration(TestName)) {
				
				@Override
				public MobileElement scrollToExact(String arg0) {
					// TODO Auto-generated method stub
					return null;
				}
				
				@Override
				public MobileElement scrollTo(String arg0) {
					// TODO Auto-generated method stub
					return null;
				}
			};
			
		}
		catch (Exception ex)
		{
			ScreenshotDesktop("FAIL"+TestName);
			Assert.fail("Problem with create Webdrive instantion: "+ ex.toString());
		}
		 driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		 //Wait for start application
		 (new LogInPage()).SkippButtonIsPresent(60);
		System.out.println("Connect  with application");
		System.out.println("Test :"+TestName);
		//driver.resetApp();
		WaitForApplication();
		return driver;
	}
	
	//@AfterClass
	protected void CloseConnection()
	{
		driver.quit();
		System.out.println("CloseConnection");
	}
	
	protected  void Screenshot(String fileName) {
        try {
        	File screenshotDir = new File("Screenshot");
        	if (!screenshotDir.exists()) screenshotDir.mkdir();
        	
            FileOutputStream out = new FileOutputStream("Screenshot/"+fileName + "_TheShare.png");
            out.write(((org.openqa.selenium.TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
            out.close();
        } catch (Exception e) {
          
        }
	 }
	protected void ScreenshotDesktop(String fileName)
	{
		Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		BufferedImage capture;
		try {
			File screenshotDir = new File("Screenshot");
        	if (!screenshotDir.exists()) screenshotDir.mkdir();
			capture = new Robot().createScreenCapture(screenRect);
			ImageIO.write(capture, "jpg", new File("Screenshot/"+fileName + "_TheShare.png"));
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@AfterMethod
	protected  void ScreenshotWhenFail(ITestResult result) {
		  if (result.getStatus() == ITestResult.FAILURE) {
		    	Screenshot("FAIL"+result.getName());
		    }   
	}
	
	
//This configuration should by taken from configuration file 
    private   DesiredCapabilities Configuration(String testName)
      {		  
   	   DesiredCapabilities capabilities = new DesiredCapabilities();
   	
   	   capabilities.setCapability("deviceName","Android Emulator");
       capabilities.setCapability("platformVersion", "4.4");
   	   capabilities.setCapability("name",testName);
   	   capabilities.setCapability("platformName","Android");
   	   capabilities.setCapability("deviceName","Android Emulator");
   	   capabilities.setCapability("app-package", "com.example.theshare"); 
      // capabilities.setCapability("app-activity", ".Activities.MainActivity"); 
   	  capabilities.setCapability("app-activity", ".activities.WelcomeFragmentActivity"); 
     capabilities.setCapability("app-wait-package", ".activities.WelcomeFragmentActivity"); 
   	
      capabilities.setCapability("appWaitActivity", ".activities.WelcomeFragmentActivity");      
              
       return capabilities;
      }

    private void WaitForApplication()
    {
    	int timeout=0;
    	do
    	{
	    	try
	    	{
	    		Thread.sleep(5000);    
	    		if (!UI.Finds(By.xpath("//*")).isEmpty())
	    			return ;    		
	    	}
	    	catch (Exception ex){}
	    	timeout++;	    	
    	} while (timeout <10);
    }

}



