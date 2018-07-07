package com.dd.DenZieNium.html;


import org.openqa.selenium.By;


/**
 * This class is the web element Link wrapper for handling infrastructure testing technology.
 * <p>
 * In this class, the method 'click' is encapsulated and invoke claws session to do the click against the specified
 * element.
 * </p>
 * 
 */
public class Link extends AbstractElement {
	/**
	 * Link Construction method<br>
	 * <b>Usage:</b><br>
	 * {@code private Link lnkSYI = new Link("//a[contains(@href,'?eBayCommand')]"}
	 * 
	 * @param locator
	 *            the element locator
	 */
	public Link() {
		super();
	}
	public Link(By locator) {
		super(locator);
	}

	public Link(By locator, String controlName) {
		super(locator, controlName);
	}
	
	

}
