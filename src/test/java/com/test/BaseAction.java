package core.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.exceptions.CustomException;
import core.util.LogUtils;
import static core.base.TestGlobals.log;

public class BaseAction {
	
	
	//this method wait till given timeout if is locator is displayed or not
	
	public boolean isElementDisplayed(By locator, int seconds)
	{
		boolean isDisplayed=false;
		try {
			WebDriverWait wait=new WebDriverWait(TestGlobals.driver(), seconds);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			isDisplayed=true;
		}
		catch(Exception e)
		{
			log.error("element is not displayed");
		}
		return isDisplayed;
	}
	
	//this method verify if element is displayed or not for webelement
	public boolean isElementDisplayed(WebElement element, int seconds)
	{
		boolean isDisplayed=false;
		try {
			WebDriverWait wait=new WebDriverWait(TestGlobals.driver(),seconds);
			wait.until(ExpectedConditions.visibilityOf(element));
			isDisplayed=true;
		}
		catch(Exception e)
		{
			log.error("element is not displayed even after waiting time");
		}
		return isDisplayed;
		
	}
	
	
	//this method verify if expected text is displayed or not
	
	public boolean isExpectedTextDisplayed(WebElement element, String expectedText, int seconds)
	{
		boolean isExpectedTextDisplayed=false;
		try {
		WebDriverWait wait=new WebDriverWait(TestGlobals.driver(),seconds);
		if(isElementDisplayed(element))
		{
			wait.until(ExpectedConditions.textToBePresentInElement(element, expectedText.trim()));
			isExpectedTextDisplayed=true;
		}
		}
		catch(Exception e)
		{
			log.error("element is not present");
		}
		return isExpectedTextDisplayed;
				
	}
	
	//this methods return if element is present or not
	public boolean isElementDisplayed(WebElement element)
	{
		boolean isDisplayed=false;
		isDisplayed=isElementDisplayed(element, TestGlobals.ELEMENTTIMEOUT);
		return isDisplayed;
	}
	
	//this methods verify if element is clickable or not
	
	public boolean isElementEnabled(WebElement element, int seconds)
	{
		boolean isEnabled=false;
		try {
		WebDriverWait wait=new WebDriverWait(TestGlobals.driver(),seconds);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		isEnabled=true;
		}
		catch(Exception e)
		{
			log.error("element is not clickable even after timeout");
		}
		return isEnabled;
	}
	
	//this method verify element
	public boolean isElementEnabled(WebElement element)
	{
		boolean isEnabled=false;
		isEnabled=isElementEnabled(element, TestGlobals.ELEMENTTIMEOUT);
		return isEnabled;
	}
	
	//this method returns actual string text
	
	public String getText(WebElement element) {
		String returnvalue = "";
		try {
			returnvalue = element.getText().trim();
			if (returnvalue.equals("")) {
				returnvalue = element.getAttribute("value");
				if (returnvalue == null) {
					log.info("No text found in webelement");
				}
			}
		} catch (Exception e) {
			log.error("error while fetching text");
		}
		return returnvalue;

	}
	
	//this method select item from dropdownlist with item name
	
	public void SelectByText(WebElement element, String itemName) throws CustomException
	{
		try {
			new JavascriptActions().highlightElement(element);
		Select selectElement=new Select(element);
		selectElement.selectByVisibleText(itemName);
		}
		catch(Exception e)
		{
			log.error("error while selecting text"+itemName);
			throw new CustomException("error while selecting text");
		}
		
	}
	
	//this method select by value
	
	public void SelectByValue(WebElement element, String value) throws CustomException
	{
		try {
			Select SelectValue=new Select(element);
			SelectValue.selectByValue(value);
		}
		catch(Exception e)
		{
			log.error("error while selecting value"+value);
			throw new CustomException("error while selecting value");
		}
		
	}
	
	//this method select by index
	public void SelectByIndex(WebElement element, int index )
	{
		try {
		Select SelectByIndex=new Select(element);
		SelectByIndex.selectByIndex(index);
		}
		catch(Exception e)
		{
			log.error("error while selecting index"+index);
		}
		
	}
	
	//this methods use for click
	
	public void click(WebElement element)throws CustomException
	{
		try {
			if(isElementEnabled(element))
			{
				new JavascriptActions().highlightElement(element);
				element.click();
			}
		}
		catch(Exception e)
		{
			log.error("element is not clickable");
			throw new CustomException("error while selecting value");
		}
	}
	
	//this method use to enter text in element
	public void enterText(WebElement element, String value)  throws CustomException
	{
		System.out.println(element);
		System.out.println(value);
		try {
			System.out.println(element);
		new JavascriptActions().highlightElement(element);
		element.sendKeys(value);
		}
		catch(Exception e)
		{
			
			log.error("error while entering text into element"+element);
			throw new CustomException("error while entering value");
		}
	}
	
	//this methods is use to clear existing text
	public void clearExistingText(WebElement element) throws CustomException
	{
		try {
		new JavascriptActions().highlightElement(element);
		element.clear();
		}
		catch(Exception e)
		{
			log.error("error while clearing exisitng text");
			throw new CustomException("error while clearing value");
		}
	}
	
	//this method is use to verify is element is selected or not
	public boolean isSelected(WebElement element) throws CustomException
	{
		boolean isSelected=false;
		new JavascriptActions().highlightElement(element);
		try {
			isSelected=element.isSelected();
			}
		catch(Exception e)
		{
			log.error("error while verifying element");
			throw new CustomException("error while selecting value");
		}
		return isSelected;
	}
	
	//this method check the element
	
	public void check(WebElement element) throws CustomException
	{
		if(!this.isSelected(element))
		{
			new JavascriptActions().highlightElement(element);
			click(element);
		}
		else
		{
			log.info("element is already checked");
		}
	}
	
	//this method uncheck the element
	
	public void uncheck(WebElement element) throws CustomException
	{
		if(this.isSelected(element))
		{
			new JavascriptActions().highlightElement(element);
			click(element);
		}
		else {
			log.info("element is already unchecked");
		}
	}
	
	//this method wait the script
	
	public void waitForMilliseconds(int seconds)
	{
		try {
			Thread.sleep(seconds);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	
	
	//this methods return size of element
	public int getSizeOfElements(By locator) throws CustomException
	{
		int size;
		try {
			size=TestGlobals.driver().findElements(locator).size();
		}
		catch(Exception e)
		{
			log.info("error while fetching size");
			throw new CustomException("error while fetching size");
		}
		return size;
	}
	
	public int getSizeOfElements2(By locator) throws CustomException
	{
		int size;
		try {
			size=TestGlobals.driver().findElements(locator).size();
		}
		catch(Exception e)
		{
			log.info("error while fetching size");
			throw new CustomException("error while fetching size");
		}
		return size;
	}
	
}

