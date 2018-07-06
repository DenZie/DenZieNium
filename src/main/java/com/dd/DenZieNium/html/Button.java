package com.dd.DenZieNium.html;

import org.openqa.selenium.By;

/**
 * This class is the web element Button wrapper for handling infrastructure testing technology.
 * <p>
 * In this class, the method 'click' is encapsulated and invoke claws session to do the click against the specified
 * element.
 * </p>
 * 
 */
public class Button extends AbstractElement {

	/**
	 * Button Construction method<br>
	 * <b>Usage:</b> <br> {@code Button btnSignIn = new Button(
	 * "//Button[@id='SignIn']"}
	 * 
	 * @param locator
	 *            the element locator
	 * 
	 */
	public Button(By locator) {
		super(locator);
	}

	public Button(By locator, String controlName) {
		super(locator, controlName);
	}

	/**
	 * The Button click function and wait for page to load
	 */
	public void click() {
		getElement().click();
	}
}