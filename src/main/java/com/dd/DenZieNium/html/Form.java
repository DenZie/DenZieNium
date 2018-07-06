package com.dd.DenZieNium.html;

import org.openqa.selenium.By;

/**
 * This class is the web element Form wrapper for handling infrastructure
 * testing technology.
 * <p>
 * In this class, the method 'submit' are encapsulated and invoke claws
 * session to do submit against the specified element.
 * </p>
 * 
 */
public class Form extends AbstractElement {

	/**
	 * Form Construction method<br>
	 * <b>Usage:</b><br>
	 * {@code private Form frmDummy = new Form("//Form[@name='DummyForm']"}
	 * 
	 * @param locator
	 *            the element locator
	 */
	public Form(By locator) {
		super(locator);
	}
	public Form(By locator, String controlName) {
		super(locator, controlName);
	}
	/**
	 * The Form submit function It invokes CatPaw session to handle the submit
	 * action against the element.
	 */
	public void submit() {
		AbstractElement.locateElement(getLocator()).submit();
	}
}
