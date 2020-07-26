package com.crm.qa.pagefactory;

import java.io.IOException;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;


public class LoginPage extends TestBase {

	@FindBy(xpath = "//input[@name= 'username']")
	WebElement username;
	
	@FindBy(xpath = "//input[@name= 'password']")
	WebElement password;
	
	@FindBy(xpath = "//input[@type = 'submit']")
	//@FindBy(xpath = "//input[@class = 'btn btn-small']")
	WebElement submit;
	
	
	
	public LoginPage() throws IOException
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public HomePage login (String un,String pwd) throws IOException, InterruptedException
	{
	try {
		
			username.sendKeys(un);
			password.sendKeys(pwd);
			new WebDriverWait(driver, 100).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type = 'submit']")));
			new Actions(driver).moveToElement(submit, 62, 34).click().build().perform();
			Thread.sleep(5000);
			submit.click();
			
   		}
	 catch (Exception e) {
		
			new WebDriverWait(driver, 100).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type = 'submit']")));
			new Actions(driver).moveToElement(submit, 62, 34).click().build().perform();
			Thread.sleep(5000);
			submit.click();
	}
	return new HomePage();
	}
	
	
	
}
