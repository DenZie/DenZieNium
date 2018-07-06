package com.dd.DenZieNium.html;


import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebElement;


/**
 * This class is the web element RadioButton wrapper for handling infrastructure
 * testing technology.
 * <p>
 * In this class, the method 'check' is encapsulated and invoke CatPaw session
 * to do the check against the specified element. The method 'isChecked' is to
 * verify whether this element is checked.
 * </p>
 * 
 */
public class RadioButton extends AbstractElement {

	/**
	 * RadioButton Construction method<br>
	 * <b>Usage:</b><br>{@code private RadioButton rbnElement = new
	 * RadioButton("//Radio[@id='dummyElement']"}
	 * 
	 * @param locator
	 *            the element locator
	 */
	public RadioButton(By locator) {
		super(locator);
	}
	public RadioButton(By locator, String controlName) {
		super(locator, controlName);
	}
	/**
	 * The RadioButton check function
	 * 
	 * It invokes CatPaw session to handle the check action against the
	 * element.
	 */
	public void check() {
		if (!isChecked()) {
			this.click();
		}
	}

	/**
	 * The RadioButton isChecked function
	 * 
	 * It invokes CatPaw session to handle the isChecked function against the
	 * element.
	 */
	public boolean isChecked() {
		return  ( getElement()).isSelected();
	}
}
