package com.dd.DenZieNium.html.react;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * This class is the web element Select wrapper for handling infrastructure testing technology.
 * <p>
 * In this class, the method 'select' is encapsulated and invoke claws Grid.selenium() to select option against the
 * specified element.
 * </p>
 * 
 */
public class ReactMultiSelect extends ReactSelect {

	/**
	 * SelectList Construction method<br>
	 * <b>Usage:</b><br>
	 * {@code private SelectList selShippingService = new
	 *         SelectList("//select[@id='shipping']"}
	 * @param locator - the element locator
	 */
	public ReactMultiSelect(By locator) {
		super(locator);
	}

	public ReactMultiSelect(By locator, String controlName) {
		super(locator, controlName);
	}

	public void selectMultiple(List<String> options) {
		for(String option:options) {
			selectByLabel(option);
		}
	}

	public List<String> getSelectedLabels() {
		List<WebElement> options = getElement().findElements(By.className("Select-value-label"));
		List<String> ops = new ArrayList<>();
		for (WebElement option : options) {
			if (option.getAttribute("aria-selected").equals("true")) {
				ops.add(option.getText().replace("\n ", ""));
			}
		}
		return ops;
	}
	
	public void removeOption(String option) {
		List<WebElement> options = getElement().findElements(By.className("Select-value"));
		for (WebElement opt : options) {
			if (opt.getText().contains(option)) {
				opt.findElement(By.className("Select-value-icon")).click();
				break;
			}
		}
	}
	
	public void removeOptions(List<String> options) {
		for(String option: options) {
			removeOption(option);
		}
	}
	
}
