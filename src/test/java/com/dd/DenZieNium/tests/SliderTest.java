package com.dd.DenZieNium.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.dd.DenZieNium.Grid.Grid;
import com.dd.DenZieNium.test.pages.SliderDemoPage;

public class SliderTest {

	@Test
	public void register() {
		SliderDemoPage sdp = new SliderDemoPage("https://jqueryui.com//resources/demos/slider/default.html");
		sdp.load();
		sdp.slideByPercentage(75);
		sdp.slide(75);
		
		System.out.println(sdp.getProgress());
	}
	
	@BeforeClass
	public void createSession() {
		Grid.startSession("chrome");
	}

	@AfterClass
	public void closeSession() {
		Grid.closeSession();
	}
}
