package com.dd.DenZieNium.test.pages;

import java.util.List;

import org.openqa.selenium.By;

import com.dd.DenZieNium.html.react.ReactMultiSelect;
import com.dd.DenZieNium.pages.BasePageImpl;

public class MultiSelectPage extends BasePageImpl{
	
	ReactMultiSelect sld = new ReactMultiSelect(By.id("react-select-3--value"));
	
	public MultiSelectPage(String URL) {
		this.URL=URL;
	}
	
	public void selectMultiple(List<String> options) {
		sld.selectMultiple(options);
	}
	public void selectNthItem(int i) {
		sld.selectByIndex(i);
	}
	public void removeOption(String option) {
		sld.removeOption(option);
	}
	public void removeOptions(List<String> option) {
		sld.removeOptions(option);
	}
	public List<String> getSelectedItems() {
		return sld.getSelectedLabels();
	}
}
