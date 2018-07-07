package com.dd.DenZieNium.html;

/**
 * A generic interface for Web Page Objects in CatPaw.
 *
 */
public interface WebPage {

	/**
	 * Provides the mechanism to wait for this page to load
	 */
	public void waitForPage();
	
	/**
	 * Return the expected page title for this page
	 */
	public String getExpectedPageTitle();
	
	public abstract WebPage getPage();
	
	public void load();
		
}
