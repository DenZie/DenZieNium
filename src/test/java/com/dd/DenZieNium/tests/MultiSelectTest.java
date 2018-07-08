package com.dd.DenZieNium.tests;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.dd.DenZieNium.Grid.Grid;
import com.dd.DenZieNium.test.pages.*;

public class MultiSelectTest {
	
	@Test
	public void register() {
		MultiSelectPage msp = new MultiSelectPage("https://jedwatson.github.io/react-select/");
		msp.load();
		List<String> options =  new ArrayList<>();
		options.add("Chocolate");;
		options.add("Caramel");
		msp.selectMultiple(options);
		msp.selectNthItem(1);
		System.out.println(msp.getSelectedItems());
		msp.selectNthItem(3);
		options.remove("Chocolate");
		msp.removeOptions(options);
		System.out.println(msp.getSelectedItems());
	}
	
	@BeforeClass
	public void createSession() {
		Grid.startSession("chrome");
	}

	@AfterClass
	public void closeSession() {
		Grid.closeSession();
	}
}
