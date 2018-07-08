package com.dd.DenZieNium.test.pages;

import org.openqa.selenium.By;

import com.dd.DenZieNium.html.Button;
import com.dd.DenZieNium.html.CheckBox;
import com.dd.DenZieNium.html.PasswordField;
import com.dd.DenZieNium.html.TextField;
import com.dd.DenZieNium.html.react.ReactSelect;

public class Register {
	
	TextField 		loginId	= new TextField(By.id("loginId"));
	PasswordField	pwd		= new PasswordField(By.id("password"));
	PasswordField	rpwd	= new PasswordField(By.id("repassword"));
	TextField 		fnm		= new TextField(By.id("firstName"));
	TextField 		lnm		= new TextField(By.id("lastName"));
	TextField		bdt		= new TextField(By.id("birthDate"));
	TextField 		mnm		= new TextField(By.id("motherName"));
	TextField 		ssn		= new TextField(By.id("ssn"));
	TextField 		mno		= new TextField(By.id("memberNumber"));
	TextField 		snm		= new TextField(By.id("streetName1"));
	TextField 		cnm		= new TextField(By.id("cityName"));
	TextField 		pcd		= new TextField(By.id("postalCode"));
	TextField 		pem		= new TextField(By.id("primaryEmailAddress"));
	ReactSelect 	csel	= new ReactSelect(By.id("countrySelectInput"));
	ReactSelect		ssel	= new ReactSelect(By.id("stateSelectInput"));
	CheckBox		disc	= new CheckBox(By.id("disclosure"));
	Button			busu	= new Button(By.id("btnUserSubmit"));
	
//	public void Type()
	
	
}
