package com.aashima.seleniumDemo.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResultsPage extends Page {

	public ResultsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public static By topResult = By.xpath("//h3[text()='Top 25 Deepak Koul profiles | LinkedIn']");
	
	
	
	public WebElement getTopResult(){
		
		WebElement tr= driver.findElement(topResult);
		return tr;
		
		
	}
}
