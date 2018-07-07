package com.dd.DenZieNium.test.pages;

import org.openqa.selenium.By;

import com.dd.DenZieNium.html.Slider;
import com.dd.DenZieNium.pages.BasePageImpl;

public class SliderDemoPage extends BasePageImpl{
	
	Slider sld = new Slider(By.id("slider"));
	
	public SliderDemoPage(String URL) {
		this.URL=URL;
	}
	
	public void slide(int pixel) {
		sld.slide(pixel);
	}
	
	public void slideByPercentage(int percentage) {
		sld.slideByPercentage(percentage);
	}
	
	public int getProgress() {
		return sld.getProgress();
	}
}
