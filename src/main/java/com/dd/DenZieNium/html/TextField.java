package com.dd.DenZieNium.html;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;


/**
 * This class is the web element Input wrapper for handling infrastructure
 * testing technology.
 * <p>
 * In this class, the method 'type' is encapsulated and invoke claws session
 * to type content to the specified element.
 * </p>
 * 
 */

public class TextField extends AbstractElement {


	public TextField(By locator) {
		super(locator);
	}

	/**
	 * The TextField type function
	 * 
	 */
	public void type(String value) {
		WebElement element = getElement();
		element.clear();
		element.sendKeys(value);
	}
	/** The TextField type function which allow users
	 * to keep the TextField and append the input text to it.
	 * 
	 * It invokes CatPaw session to handle the type action against the element. 
	 */
	public void type(String value, boolean isKeepExistingText) {
		if(isKeepExistingText == true) {
			getElement().sendKeys(value);
		}
		else {
			type(value);
		}
	}
	/**
	 * Text TextField clear function
	 * 
	 * To clear the text box.
	 */
	public void clear() {
		getElement().clear();
	}
	/**
	 * The TextField isEditable function
	 * 
	 * It invokes CatPaw session to handle the isEditable function against the
	 * element.
	 */
	public boolean isEditable() {
		return ((RemoteWebElement) getElement()).isEnabled();
	}
	/**
	 * Get the text value from a TextField object.
	 * 
	 * @return text is the text in the TextField box.
	 */
	public String getText() {
		String text = getElement().getText();
		if(text.isEmpty()) {
			text = getValue();
		}
		return text;
	}
}
