package com.dd.DenZieNium.html;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.dd.DenZieNium.Grid.Grid;


/**
 * This class is the web element CheckBox wrapper for handling infrastructure
 * testing technology.
 * <p>
 * In this class, the method 'check' and 'uncheck' are encapsulated and invoke
 * blufin session to do the check/uncheck against the specified element. The
 * method 'isChecked' is to verify whether this element is checked.
 * </p>
 * 
 */
public class CheckBox extends AbstractElement {
	String currentPage = "currentPage";
	/**
	 * CheckBox Construction method<br>
	 * <b>Usage:</b><br>{@code private CheckBox chkAcceptReturn = new
	 * CheckBox("//CheckBox[@id='AcceptReturn']"}
	 * 
	 * @param locator
	 *            the element locator
	 */
	public CheckBox(By locator) {
		super(locator);
	}
	public CheckBox(By locator, String controlName) {
		super(locator, controlName);
	}
	/**
	 * The CheckBox check function It invokes selenium session to handle the
	 * check action against the element.
	 */
	public void check() {
		WebElement e = getElement();
		while (!e.isSelected())
			e.click();
	}
	public void check(By locator) {
		this.check();
		validatePresenceOfAlert();
		Grid.waitUntilElementPresent(locator);
	}

	/**
	 * The CheckBox uncheck function
	 * It invokes claws session to handle the uncheck action against the
	 * element.
	 */
	public void uncheck() {
		RemoteWebElement e = (RemoteWebElement) getElement();
		while (e.isSelected()){
			e.click();
		}
	}
	public void uncheck(By locator) {
		this.uncheck();
		Grid.waitUntilElementPresent(locator);
	}
	/**
	 * The CheckBox click function and wait for page to load
	 */
	/**
	 * The CheckBox click function and wait for object to load
	 */
	public void click(By locator) {
		click();
		Grid.waitUntilElementPresent(locator);
	}
	/**
	 * The CheckBox isChecked function
	 * 
	 * It invokes claws session to handle the isChecked function against the
	 * element.
	 */
	public boolean isChecked() {
		return getElement().isSelected();
	}

	/**
	 * The CheckBox isEditable function
	 * 
	 * It invokes claws session to handle the isEditable function against the
	 * element.
	 */
	public boolean isEnabled() {
		return getElement().isEnabled();
	}
}
