package Action;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import Base.UI;
import Page.WallPage;

public class Add extends UI  {
	
	private static SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
	
	public static WallPage MessageAndBackToWall(String messageText)
	{
		return GoTo
				.ComposeTextView()
				.SetMessage(messageText)
				.TapDone();
	}
	
	public static WallPage MessageAndBackToWall()
	{
		return MessageAndBackToWall("_Auto test message_"+timeFormat.format(Calendar.getInstance().getTime()));
	}

}
