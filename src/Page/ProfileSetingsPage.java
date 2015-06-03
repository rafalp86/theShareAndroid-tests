package Page;

import org.openqa.selenium.By;

import Base.GetBy;
import Base.UI;

public class ProfileSetingsPage extends UI {

	

	public ProfileSetingsPage  TapSettingsAbout(){
	  Click(SettingsAboutElement);
	  return this;
	}
	public ProfileSetingsPage  TapSettingsPush(){
	  Click(SettingsPushElement);
	  return this;
	}
	public ProfileSetingsPage  TapSettingsDailyReminder(){
	  Click(SettingsDailyReminderElement);
	  return this;
	}
	public ProfileSetingsPage  TapSettingsBlockedUsers(){
	  Click(SettingsBlockedUsersElement);
	  return this;
	}
	public ProfileSetingsPage  TapSettingsDelete(){
	  Click(SettingsDeleteElement);
	  return this;
	}
	public LogInPage  TapSettingsLogout(){
	  Click(SettingsLogoutElement);
	  return new LogInPage();
	}
	
	private By ContainerElement = GetBy.ResourceId("container");
	private By SettingsAboutElement = GetBy.ResourceId("settings_about");
	private By SettingsPushElement = GetBy.ResourceId("settings_push");
	private By SettingsDailyReminderElement = GetBy.ResourceId("settings_daily_reminder");
	private By SettingsBlockedUsersElement = GetBy.ResourceId("settings_blocked_users");
	private By SettingsDeleteElement = GetBy.ResourceId("settings_delete");
	private By SettingsLogoutElement = GetBy.ResourceId("settings_logout");
}
