package com.dd.DenZieNium.html;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.dd.DenZieNium.Grid.Grid;


/**
 * This class is the web element Select wrapper for handling infrastructure testing technology.
 * <p>
 * In this class, the method 'select' is encapsulated and invoke claws Grid.selenium() to select option against the
 * specified element.
 * </p>
 * 
 */
public class ReactSelect extends AbstractElement {

//	activedescendant
	/**
	 * SelectList Construction method<br>
	 * <b>Usage:</b><br>
	 * {@code private SelectList selShippingService = new
	 *         SelectList("//select[@id='shipping']"}
	 * @param locator - the element locator
	 */
	public ReactSelect(By locator) {
		super(locator);
	}

	public ReactSelect(By locator, String controlName) {
		super(locator, controlName);
	}

	public void selectByLabel(String label) {
		getElement().click();
		List<WebElement> list = Grid.driver().findElements(By.cssSelector(".Select-option"));
		for( int i=0;i< list.size();i++) {
			if(list.get(i).getText().equals(label)) {
				selectByIndex(i+1);
				break;
			}
		}
	}
	
	public void selectByIndex(int index) {
		getElement().click();
		Grid.driver().findElement(By.cssSelector("div.Select-option:nth-child(" +String.valueOf(index)+")")).click();
		System.err.println("");
	}

	// Select single item.
	public void selectByValue(String value) {
		new Select(getElement()).selectByValue(value);
	}

	public void selectByLabel(String[] labels) {
		for (int i = 0; i < labels.length; i++) {
			selectByValue("label" + labels[i]);
		}
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
