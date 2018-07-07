package com.dd.DenZieNium.test.pages;

import org.openqa.selenium.By;

import com.dd.DenZieNium.html.DatePicker;
import com.dd.DenZieNium.pages.BasePageImpl;

public class DatePickerDemoPage extends BasePageImpl{
	
	DatePicker dtp = new DatePicker(By.id("datepicker"));
	
	public DatePickerDemoPage(String URL) {
		this.URL=URL;
	}
	
	public void SelectDate(String dtString) {
		dtp.selectDate(dtString);
	}
}
