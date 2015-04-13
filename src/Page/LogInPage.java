package Page;

import org.openqa.selenium.By;
import Base.GetBy;
import Base.UI;
import Action.Gestures;

public class LogInPage extends UI{
	
	public LogInPage SwipeSlide()
	{
		Gestures.ScollHorizontally();
		return this;
	}
	public LogInPage SwipeAllSlide()
	{
		for(int i=0 ;i<appConfig.getInt("SlideCount"); i++) 
			SwipeSlide();
		return this;
	}
	
	public LogInPage SetEmail(String email_acount)
	{
		//Gestures.ScrollToTop(Class.Button);
		WaitForElement(emailElemet, 5);
		SetText(emailElemet, email_acount);
		return this;
	}
	public LogInPage SetPassword(String password_acount)
	{
		SetText(passwordElement, password_acount);
		return this;
	}
	
	public boolean LoginButtonIsPresent()
	{
		return ElementExist(loginButton);
	}

    //Tap
	public LogInPage TapSharing()
	{
		WaitAndClick(SharingButton);
		return this;
	}
	public LogInPage TapXSkip()
	{
		SkippButtonIsPresent();
		WaitAndClick(SkippButton);
		return this;
	}
	public LogInPage TapFacebook()
	{
		Click(facebookButton);
		return this;
	}
	public LogInPage TapCreateAccount()
	{
		Click(CreateAccountButton);
		return this;
	}
	public WallPage TapLogin()
	{
		Click(loginButton);
		return new WallPage();
	}
	public LogInPage TapLoginFailed()
	{
		Click(loginButton);
		return this;
	}
	// Elements Is Present
	public boolean SkippButtonIsPresent(Integer ...Timeout)
	{
		int timeout= Timeout.length>0?Timeout[0]:5;
		return ElementExist(SkippButton,timeout);
	}
	public boolean SharingButtonIsPresent()
	{
		return ElementExist(SharingButton);
	}
	public boolean FacebookButtonIsPresent()
	{
		return ElementExist(facebookButton);
	}
	public boolean CreateAccountButtonIsPresent()
	{
		Gestures.ScollTo(CreateAccountButton);
		return ElementExist(CreateAccountButton);
	}
	public boolean LoginResetButtonIsPresent()
	{
		Gestures.ScollTo(LoginResetButton);
		return ElementExist(LoginResetButton);
	}
	public boolean NotRegisteredMessageIsPresent()
	{
		return ElementExist(NotRegistered,10);
	}
	
	// Elements
	private By emailElemet= GetBy.ResourceId("com.example.theshare:id/login_email");
	private String emialResorceId="com.example.theshare:id/login_email";
	private By passwordElement= GetBy.ResourceId("com.example.theshare:id/login_password");
	private By loginButton= GetBy.ResourceId("com.example.theshare:id/login_login");
	private By facebookButton= GetBy.ResourceId("com.example.theshare:id/login_facebook");
	private By CreateAccountButton= GetBy.ResourceId("com.example.theshare:id/login_create_account");
	private By LoginResetButton= GetBy.ResourceId("com.example.theshare:id/login_reset_password");
	private By SlideImage = GetBy.className(Class.ImageView);
	private By SkippButton= GetBy.ResourceId("com.example.theshare:id/button_skip");//Class.ImageButton);
											
	private By SharingButton= GetBy.ClassAndText(Class.Button, "Start sharing now");
	private By NotRegistered = GetBy.Text("User with this email is not registered.");
			
	
}
