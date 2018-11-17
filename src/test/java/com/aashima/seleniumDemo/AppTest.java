package com.aashima.seleniumDemo;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aashima.seleniumDemo.Pages.ResultsPage;
import com.aashima.seleniumDemo.Pages.SearchPage;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    private WebDriver driver;
    public ResultsPage resultspage;
    public SearchPage searchpage;
	By topResult = By.xpath("//h3[text()='Top 25 Deepak Koul profiles | LinkedIn']");
	By searchBox = By.id("input");
	By autocompleteBox = By.id("autocomplete-wrapper");
	By productsHeading = By.xpath("//ul/li/span/strong[text()='Products']");
	/**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }
 public void setUp(){
    	
	  driver = new FirefoxDriver();    }
    /**
     * Rigourous Test :-)
     * @throws InterruptedException 
    
     */
    public void testGoogleSearch() throws InterruptedException
    {
       
       searchpage = new SearchPage(driver);
       searchpage.visit();
       resultspage = searchpage.enterTextAndHitSearch("Deepak Koul");
	   assertTrue (resultspage.getTopResult().isDisplayed()); 
     
    }
    
    public void testConatinerSearchAutoPopulate() throws InterruptedException
    {
       
     driver.get("https://access.redhat.com/containers/");
     waitUntillClickable(searchBox);
     driver.findElement(searchBox).sendKeys("RHEL");
     waitUntillClickable(autocompleteBox);
     assertTrue(driver.findElement(productsHeading).isDisplayed());
     

     List<WebElement> allProducts = driver.findElements(By.xpath("//li[@class='style-scope cc-autocomplete']"));
     Iterator<WebElement> itr = allProducts.iterator();
     while(itr.hasNext()) {
         System.out.println(itr.next().getText());
     }
     
     
    }
    
 
    public void tearDown(){
    	
    	driver.quit();
    }
    
    public void waitUntillClickable(By locator) {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));

	}
}
