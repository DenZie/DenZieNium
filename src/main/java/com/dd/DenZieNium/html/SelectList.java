package com.dd.DenZieNium.html;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


/**
 * This class is the web element Select wrapper for handling infrastructure testing technology.
 * <p>
 * In this class, the method 'select' is encapsulated and invoke claws Grid.selenium() to select option against the
 * specified element.
 * </p>
 * 
 */
public class SelectList extends AbstractElement {

	/**
	 * SelectList Construction method<br>
	 * <b>Usage:</b><br>
	 * {@code private SelectList selShippingService = new
	 *         SelectList("//select[@id='shipping']"}
	 * @param locator - the element locator
	 */
	public SelectList(By locator) {
		super(locator);
	}

	public SelectList(By locator, String controlName) {
		super(locator, controlName);
	}

	public void select(String optionLocator) {
	    if (optionLocator.split("=").length != 2){
	        StringBuffer errMsg = new StringBuffer("Invalid locator specified :"); 
	        errMsg.append(optionLocator);
	        errMsg.append(". Locator should be of the form label=<value> (or) ");
	        errMsg.append("value=<value> (or) ");
	        errMsg.append("index=<value> (or) ");
	        errMsg.append("id=<value>.");
	        throw new IllegalArgumentException(errMsg.toString());
	    }
		WebElement element = getElement();
		String locatorToUse = optionLocator.split("=")[1].trim();
		String tLocator = optionLocator.toLowerCase().split("=")[0].trim();
		if (tLocator.indexOf("label") >= 0) {
			// label was given
			new Select(element).selectByVisibleText(locatorToUse);
		} else if (tLocator.indexOf("value") >= 0) {
			// value was given
			new Select(element).selectByValue(locatorToUse);
		} else if (tLocator.indexOf("index") >= 0) {
			// index was given
			new Select(element).selectByIndex(Integer.parseInt(locatorToUse));
		} else if (tLocator.indexOf("id") >= 0) {
			// id was given
			locateElement(By.id(locatorToUse)).click();
		} else {
			throw new NoSuchElementException("Unable to find " + optionLocator);
		}
	}

	public void select(String[] optionLocators) {
		for (int i = 0; i < optionLocators.length; i++) {
			select(optionLocators[i]);
		}
	}

	public void addSelection(String optionLocator) {
		select(optionLocator);
	}

	// Select single item.
	public void selectByValue(String value) {
		new Select(getElement()).selectByValue(value);
	}

	public void selectByLabel(String label) {
		new Select(getElement()).selectByVisibleText(label);
	}

	public void selectByIndex(int index) {
		new Select(getElement()).selectByIndex(index);
	}

	// Select multiple items
	public void selectByValue(String[] values) {
		for (int i = 0; i < values.length; i++) {
			selectByValue(values[i]);
		}
	}

	public void selectByLabel(String[] labels) {
		for (int i = 0; i < labels.length; i++) {
			selectByValue("label" + labels[i]);
		}
	}

	public void selectByIndex(String[] indexs) {
		for (int i = 0; i < indexs.length; i++) {
			selectByValue("index=" + indexs[i]);
		}
	}

	public void addSelectionByValue(String value) {
		selectByValue(value);
	}

	public void addSelectionByLabel(String label) {
		selectByLabel(label);
	}

	public void addSelectionByIndex(String index) {
		selectByIndex(Integer.parseInt(index));
	}

	public String[] getSelectOptions() {
		List<WebElement> optionList = getElement().findElements(By.tagName("option"));
		String[] optionArray = new String[optionList.size()];
		for (int i=0; i<optionList.size(); i++) {
			optionArray[i] = optionList.get(i).getText();
		}
		return optionArray;
	}

	// Get a single selected item.
	public String getSelectedLabel() {
		List<WebElement> options = getElement().findElements(By.tagName("option"));
		for (WebElement option : options) {
			if (option.isSelected()) {
				return option.getText();
			}
		}
		return null;
	}

	public String getSelectedValue() {
        List<WebElement> options = getElement().findElements(By.tagName("option"));
        for (WebElement option : options) {
            if (option.isSelected()) {
                return option.getAttribute("value");
            }
        }
        return null;
	}

    // Get multiple selected items.
	public String[] getSelectedLabels() {
		List<WebElement> options = getElement().findElements(By.tagName("option"));
		List<String> selected = new ArrayList<String>();
		for (WebElement option : options) {
			if (option.isSelected())
				selected.add(option.getText());
		}
		return (String[]) selected.toArray(new String[selected.size()]);
	}
	
	public String[] getSelectedValues() {
	    List<WebElement> options = getElement().findElements(By.tagName("option"));
	    List<String> selected = new ArrayList<String>();
	    for(WebElement option : options) {
	        if (option.isSelected()) {
	            selected.add(option.getAttribute("value"));
	        }
	    }
		return (String[]) selected.toArray(new String[selected.size()]);
	}
	
	// Get select list content.
	public String[] getContentLabel () {
        List<WebElement> options = getElement().findElements(By.tagName("option"));
        List<String> contents = new ArrayList<String>();
        
        for(WebElement option : options) {
            contents.add(option.getText());
        }
        
        return (String[]) contents.toArray(new String[contents.size()]);
	}
	
    public String[] getContentValue () {
        List<WebElement> options = getElement().findElements(By.tagName("option"));
        List<String> contents = new ArrayList<String>();
        
        for(WebElement option : options) {
            contents.add(option.getAttribute("value"));
        }
        
        return (String[]) contents.toArray(new String[contents.size()]);
    }
	
	/**
	 * Clear all selected entries. This is only valid when the SELECT supports multiple selections.
	 * 
	 * @throws UnsupportedOperationException If the SELECT does not support multiple selections
	*/
	public void deselectAll () {
		new Select(getElement()).deselectAll();
	}
	
	public void deselectByValue(String value) {
		new Select(getElement()).deselectByValue(value);
	}
	
	public void deselectByIndex(int index) {
		new Select(getElement()).deselectByIndex(index);
	}
	
	public void deselectByLabel(String label) {
		new Select(getElement()).deselectByVisibleText(label);
	}
}
