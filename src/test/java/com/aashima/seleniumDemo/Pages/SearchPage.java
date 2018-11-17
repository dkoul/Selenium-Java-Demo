package com.aashima.seleniumDemo.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class SearchPage extends Page{
	
	public SearchPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}


	By searchTextArea = By.name("q");

	
	public ResultsPage enterTextAndHitSearch(String keyword) throws InterruptedException{
		
	       driver.findElement(searchTextArea).sendKeys(keyword);
	       driver.findElement(searchTextArea).sendKeys(Keys.ENTER);
	       Thread.sleep(3000);
		return new ResultsPage(driver);
	}
	
	public void visit(){
		
		driver.get("https://google.co.in");
	}

}
