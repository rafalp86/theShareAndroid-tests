package Base;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import sun.rmi.log.LogInputStream;

import Page.LogInPage;

import com.saucelabs.common.SauceOnDemandAuthentication;
import com.saucelabs.common.SauceOnDemandSessionIdProvider;
import com.saucelabs.testng.SauceOnDemandAuthenticationProvider;
import com.saucelabs.testng.SauceOnDemandTestListener;

@Listeners({SauceOnDemandTestListener.class})
public class ShareBase  implements SauceOnDemandSessionIdProvider, SauceOnDemandAuthenticationProvider {

	public static Config appConfig = new Config();
	
	protected  SauceOnDemandAuthentication authentication;
	protected static WebDriver driver;
	//@BeforeSuite 
	protected  WebDriver ConnectionWithApplication() 
	{ return ConnectionWithApplication("Test");}
	
	
	protected  WebDriver ConnectionWithApplication(String TestName) 
	{   
		
		authentication = new SauceOnDemandAuthentication(appConfig.get("Username"),appConfig.get("AccessKey"));
		driver= null;
		try
		{
			driver= appConfig.getBool("RunLocal")?new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), Configuration("Test2")):
				new RemoteWebDriver(new URL("http://"+appConfig.get("Username")+":"+appConfig.get("AccessKey")+"@ondemand.saucelabs.com:80/wd/hub"), Configuration(TestName));
			
		}
		catch (Exception ex)
		{
			Assert.fail("Problem with create Webdrive instantion: "+ ex.toString());
		}
		 driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		 //Wait for start application
		 (new LogInPage()).SkippButtonIsPresent(60);
		System.out.println("Connect  with application");
		System.out.println("Test :"+TestName);
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
        
            FileOutputStream out = new FileOutputStream(fileName + "_TheShare.png");
            out.write(((org.openqa.selenium.TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
            out.close();
        } catch (Exception e) {
          
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
   	   if(appConfig.getBool("RunLocal"))
   	   {
	   	   File appDir = new File("resources");
	       File app = new File(appDir, "theShare.apk");  
	   	   capabilities.setCapability("app",app);
   	   }
   	   else
   	   {
   		   capabilities.setCapability("app","sauce-storage:"+appConfig.get("StorageApk"));
   		   capabilities.setCapability("appium-version", "1.2");
   		
   	   }
   	   capabilities.setCapability("name",testName);
       capabilities.setCapability("platformName","Android");       
       //capabilities.setCapability("deviceName","LGOTMS1ab80a");     
       capabilities.setCapability("deviceName","Android Emulator");
       capabilities.setCapability("platformVersion", "4.4");
       capabilities.setCapability("deviceType", "phone");
       
       capabilities.setCapability("automationName", "appium");
       //capabilities.setCapability("device","appium");    
         
      //capabilities.setCapability("app-package", "com.example.theshare"); 
     // capabilities.setCapability("app-activity", ".activities.MainActivity"); 
      //capabilities.setCapability("app-wait-activity",".activities.MainActivity");
         
       return capabilities;
      }


    @Override
    public SauceOnDemandAuthentication getAuthentication() {
        return authentication;
    }

    @Override
    public String getSessionId() {
        SessionId sessionId = ((RemoteWebDriver)driver).getSessionId();
        return (sessionId == null) ? null : sessionId.toString();
    }
    

}



