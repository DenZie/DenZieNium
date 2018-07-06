package com.dd.DenZieNium.html;


import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebElement;

/**
 * This class is the web element Image wrapper for handling infrastructure testing technology.
 * <p>
 * In this class, the method 'click' are encapsulated and invoke claws session to do click against the specified
 * element.
 * </p>
 * 
 */
public class Image extends AbstractElement {
	public static final String WIDTH = "width";
	public static final String HEIGHT = "height";
	String currentPage;

	/**
	 * Button Construction method<br>
	 * <b>Usage:</b><br>
	 * {@code private Image imgeBayIcon = new Image("//Image[@id='eBayIcon']"}
	 * 
	 * @param locator
	 *            the element locator
	 */
	public Image(By locator) {
		super(locator);
	}

	public Image(By locator, String controlName) {
		super(locator, controlName);
	}

	/**
	 * This function is to get image's width.
	 * 
	 * @return the image's width
	 * 
	 * @throws RuntimeException
	 */
	public int getWidth() {
		try {
			return ((RemoteWebElement) getElement()).getSize().width;
		} catch (NumberFormatException e) {
			throw new RuntimeException("Attribute " + WIDTH + " not found for Image " + getLocator());
		}
	}

	/**
	 * This function is to get image's height.
	 * 
	 * @return the image's height
	 * 
	 * @throws RuntimeException
	 */
	public int getHeight() {
		try {
			return ((RemoteWebElement) getElement()).getSize().height;
		} catch (NumberFormatException e) {
			throw new RuntimeException("Attribute " + HEIGHT + " not found for Image " + getLocator());
		}
	}

}
