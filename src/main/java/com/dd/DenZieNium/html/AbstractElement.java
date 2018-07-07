package com.dd.DenZieNium.html;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.dd.DenZieNium.Grid.Grid;

public abstract class AbstractElement {
	
    private By locator;
    private boolean loaded;
    private String controlName;
    
    private Map<String, String> propMap = new HashMap<String, String>();
    protected static final String LOG_DEMARKER  = "&#8594;";
    
    public static WebElement locateElement(By locator) {
    	WebElement element = null;
    	element = Grid.driver().findElement(locator);
        return element;
    }

    public WebElement getElement() {
    	if(!isLoaded()) {
    		Grid.waitUntilElementPresent(getLocator());
    		markLoaded();
    	}
        return locateElement(getLocator());
    }
    public AbstractElement() {
    	loaded=false;
    }
    
    public AbstractElement(By locator) {
        this.locator = locator;
    }
    public AbstractElement(By locator,String controlName) {
        this.locator = locator;
        this.controlName = controlName;
      }
    public By getLocator() {
        return locator;
    }
    
    public void setLocator(By locator) {
        this.locator = locator;
    }
    public String getControlName() {
        return controlName;
        
    }
    public String getText() {
        return getElement().getText();
    }

    public boolean isElementPresent() {
    	boolean returnValue = false;
    	try {
    		returnValue = getElement() != null;
    	}
    	catch(Exception e) {
    	}
       return returnValue;
    }

    public boolean isVisible() {
        return ((RemoteWebElement) getElement()).isDisplayed();
    }
    
    public boolean isEnabled(){
    	return getElement().isEnabled();
    }

    public String getAttribute(String attributeName) {
        return getElement().getAttribute(attributeName);
    }

    /**
     * Gets the (whitespace-trimmed) value of an input field (or anything else
     * with a value parameter). For checkbox/radio elements, the value will be
     * "on" or "off" depending on whether the element is checked or not.
     * 
     * @return the element value, or "on/off" for checkbox/radio elements
     */
    public String getValue() {
    	return getAttribute("value");
    }

    public String getProperty(String key) {
        return propMap.get(key);
    }

    public void setProperty(String key, String value) {
        propMap.put(key, value);
    }
    
	public void click() {
		getElement().click();
	}

	/**
	 * The RadioButton click function and wait for object to load
	 */
	public void click(By locator) {
		getElement().click();
		validatePresenceOfAlert();
		Grid.waitUntilElementPresent(locator);
	}

//    protected String getWaitTime() {
//        return CatPawConfig.getConfigProperty(CatPawConfigProperty.EXECUTION_TIMEOUT);
//    }
    
    protected String fetchClassName(){
    	return Thread.currentThread().getStackTrace()[4].getClassName();
    }

	protected String resolvePageNameToUseForLogs(){
		// logger.entering();
		String pageName =fetchClassName();
		int firstChar = pageName.lastIndexOf ('.') + 1;
		pageName = pageName.substring ( firstChar );
		if (! pageName.toLowerCase().contains("page")){
				pageName="";
		}
		if (! pageName.isEmpty()){
			pageName = " in " + pageName;
		}
		// logger.exiting(pageName);
		return pageName;
	}


	
//	protected void processScreenShot(){
//		// logger.entering();
//		processAlerts(Grid.getWebTestConfig().getBrowser());
//
//		String title = "Default Title";
//		try{
//			title = Grid.driver().getTitle();
//		}catch (Throwable thrown){
//			//Do nothing with the exception
//		}
//		boolean logPages = CatPawConfig.getBoolConfigProperty(CatPawConfigProperty.LOG_PAGES);
//		if (CatPawConfig.getBoolConfigProperty(CatPawConfigProperty.AUTO_SCREEN_SHOT)) {
//			WebReporter.log(title, true, logPages);
//		} else {
//			WebReporter.log(title, false,logPages);
//		}
//		// logger.exiting();
//	}
	//TODO: This method would need re-factoring in the future.
	//The moment alerts processing is supported in iPhone, we need to disable the edit
	//checks that are put in this method.
	
	protected void validatePresenceOfAlert(){
		try{
			Grid.driver().switchTo().alert();
			String errorMsg = "Encountered an alert. Cannot wait for an element when an operation triggers an alert.";
			throw new InvalidElementStateException(errorMsg);
		}catch (NoAlertPresentException exception){
			//gobble the exception and do nothing with it. No alert was triggered.
			//so its safe to proceed ahead.
		}
	}

	public boolean isLoaded() {
		return loaded;
	}
	
	public void markLoaded() {
		 loaded=true;
	}
}
