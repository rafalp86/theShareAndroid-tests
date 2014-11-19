package Tests;

import org.testng.annotations.Test;

import Base.Config;
import Base.UI;

public class Firstest  {
	
	Config appConfig = new Config();
	@Test
	public void test()
	{
	
		System.out.println("-"+appConfig.get("RunLocal"));
		System.out.println("-"+appConfig.getBool("RunLocal"));
		System.out.println("-"+appConfig.getInt("SlideCount"));
		
		
	}
	

}
