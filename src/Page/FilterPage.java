package Page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import sun.security.action.GetBooleanSecurityPropertyAction;
import Base.GetBy;
import Base.UI;
import Base.UI.Class;
import Action.Gestures;

public class FilterPage extends UI{
	
	// Tap
	public WallPage  TapButtonDone(){
		  Click(buttonDoneElement);
		return new WallPage();
	}
	public FilterPage  TapFilter(String FilterText){
		  WaitAndClick(FilterByText(FilterText));
		  return this;
	}
	public Integer GetCountCheckedFilter()
	{
		return Finds(AllCheckedFillter).size();
	}
	public void UncheckAll() {
		List<WebElement> allChecked=Finds(AllCheckedFillter);
		for(int i=0; i<allChecked.size();i++)
			allChecked.get(i).click();	
	}
	// IS PRESENT
	public boolean PageTitleIsPresent()
	{
		return ElementExist(FilterPageTitle,10);
	}
	public boolean DoneButtonPresent()
	{
		return ElementExist(buttonDoneElement);
	}
	
	
	private By action_notificationsElement = GetBy.ResourceId("action_notifications");
	private By buttonDoneElement = GetBy.ResourceId("button_done");
	private By containerElement = GetBy.ResourceId("container");
	private By layoutElement = GetBy.ResourceId("layout");
	private By FilterPageTitle= GetBy.Text("Filter your feed");
	private By FilterByText(String Text){return GetBy.ClassAndText(Class.TextView, Text);}
	private By AllCheckedFillter= By.xpath("//"+Class.CheckBox+"[@checked='true']");
	
	
	

	


}
