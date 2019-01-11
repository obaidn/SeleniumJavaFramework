package com.stc.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchPage {
	
	//Constructor
	public GoogleSearchPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@title='Search']")
	public WebElement txtSearch;
	
public void searchTextBox(String searchText) {
	txtSearch.sendKeys(searchText);
	txtSearch.sendKeys(Keys.RETURN);
}

public void clickEnter() {
	
}
}
