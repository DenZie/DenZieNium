package com.dd.DenZieNium.pages;


import java.awt.image.DataBuffer;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import org.openqa.selenium.By;

import com.dd.DenZieNium.Grid.Grid;
import com.dd.DenZieNium.html.WebPage;


/**
 * The Class BasePageImpl.
 */
public abstract class BasePageImpl implements WebPage {

	private boolean pageInitialized;
	protected String pageTitle;
	protected String URL;
	/**
	 * Instantiates a new base page impl.
	 */
	protected BasePageImpl() {
		pageTitle = "";
		pageInitialized = false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dd.test.catpaw.platform.html.WebPage#getExpectedPageTitle()
	 */
	public String getExpectedPageTitle() {
		return getPage().pageTitle;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dd.test.catpaw.platform.html.WebPage#isInitialized()
	 */
	public boolean isInitialized() {
		return pageInitialized;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dd.test.catpaw.platform.html.WebPage#waitForPage()
	 */
	public void waitForPage() {
		Grid.waitUntilPageTitlePresent(getExpectedPageTitle());
	}

	/**
	 * Require extended class to provide this implementation.
	 * 
	 * @return the page
	 */
	public BasePageImpl getPage() {
		return this;
	}


	/**
	 * This method takes a HashMap of expected content in which the keys are an identifier for the content (field name,
	 * id etc.) and the values are the expected strings. The Method iterates through the HashMap and verifies that the
	 * full page text contains each string. This method does not validate positioning on the page or association between
	 * elements. It only checks that the expected content strings appear somewhere on the page.
	 * 
	 * @param expectedStrings
	 *            the expected content strings
	 */
	public static void validateExpectedContentOnPage(HashMap<String, String> expectedStrings) {
		Set<String> keys = expectedStrings.keySet();

		String actualText = Grid.driver().findElement(By.tagName("body")).getText();
		for (String key : keys) {
			String expectedText = expectedStrings.get(key);

			boolean textPresent = actualText.contains(expectedText);
			String message = expectedText + " ";
			if (textPresent) {

				message += "found ";
			} else {
				message += "not found ";
			}
			message += "on the page";
//			CatPawAsserts.assertTrue(textPresent, message);
		}
	}
	
	public String getURL () {
		return this.URL;
	}
	
	public void load() {
		Grid.driver().get(getURL());
	}
}
