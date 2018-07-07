package com.dd.DenZieNium.html;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;

import org.openqa.selenium.By;

import com.dd.DenZieNium.Grid.Grid;

/**
 * DatePicker is a widget which shows up a monthly calendar
 * when clicked. It comes with "previous month" and "next month" 
 * navigators, and a tablet of clickable days in a month. Users
 * can navigate by clicking these item to arrive at a desired date.
 * 
 * How to make DatePicker work in excel page data declaration?
 * Since the DatePicker needs other three object to operate properly
 * (Orevious Button, Next Button, and Date Label) these object also
 * need to declare and initialize before the DatePicker can work. 
 * To initialize this DatePicker a user needs to call datePickerInit
 * before perform any actions on the DatePicker.
 *  
 */
public class DatePicker extends AbstractElement {
	private By 	monthLocator	= By.cssSelector(".ui-datepicker-month");
	private By 	yearLocator		= By.cssSelector(".ui-datepicker-year");
	Table calender				= new Table(By.cssSelector(".ui-datepicker-calendar"));
	Link next 					= new Link(By.cssSelector(".ui-datepicker-next"));
	Link prev 					= new Link(By.cssSelector(".ui-datepicker-prev"));
	Link caLink					= new Link();
	
	
//	 ui-corner-all
	
	
	/**
	 * This constructor assumess the "prev month" and "next month"
	 * locators and assign them to the variables as defaults.
	 * 
	 * @param datePickerLoc -  the calendar locator
	 */
	public DatePicker (By datePickerLoc) {
		super(datePickerLoc);
	}
//	
//	/**
//	 * This constructor provides a way for users to initialize
//	 * their calendar by specifying all calendar's parameters.
//	 * 
//	 * @param datePickerLoc
//	 */
	public DatePicker (By datePickerLoc, String name) {
		super(datePickerLoc, name);
	}

	public String getCurrentYear() {
		return locateElement(yearLocator).getText();
	}
	public String getCurrentMonth() {
		return locateElement(monthLocator).getText();
	}

	public void selectDate(String dtString) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date dt = sdf.parse(dtString);
			Calendar cal = Calendar.getInstance();
			cal.setTime(dt);
			Formatter frmt = new Formatter();
			frmt.format("%tB", cal);
			click();
			int deltaY = cal.get(Calendar.YEAR) - Integer.valueOf(getCurrentYear() ); 
			int deltaM = cal.get(Calendar.MONTH) - Month.valueOf(getCurrentMonth().toUpperCase()).getValue() + 1; 
			int delta = 12 * deltaY + deltaM;
			Link ln = next;
			if(delta <0) {
				ln=prev;
			} 
			for(int i=0;i< Math.abs(delta);i++) {
				ln.click();
			}
			int day = cal.get(Calendar.DATE);
			caLink.setLocator(By.linkText(String.valueOf(day)));
			caLink.click();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}
}
