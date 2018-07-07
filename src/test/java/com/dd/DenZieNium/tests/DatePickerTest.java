package com.dd.DenZieNium.tests;

import java.util.Calendar;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.dd.DenZieNium.Grid.Grid;

import com.dd.DenZieNium.test.pages.DatePickerDemoPage;

public class DatePickerTest {

	@Test
	public void register() {
		DatePickerDemoPage dtp = new DatePickerDemoPage("http://jqueryui.com/resources/demos/datepicker/other-months.html");
		dtp.load();
		dtp.SelectDate("05/01/2017");
//		System.out.format("%02d",7);
//		System.out.format("%02d",21);
////		System.out.println(String.format("%01d", 7));
////		System.out.println(String.format("%01d", 21));
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
