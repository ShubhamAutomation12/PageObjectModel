package com.crm.qa.pagefactory;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class DealMenuPage extends TestBase {

	@FindBy(xpath = "//a[contains(text(), 'Deals')]")
	WebElement dealMenu;

	@FindBy(xpath = "//a[contains(text(), 'New Deal')]")
	WebElement newDealMenu;

	@FindBy(xpath = "//input[@name = 'title']")
	WebElement titleField;

	@FindBy(xpath = "//input[@name = 'client_lookup']")
	WebElement companyField;

	@FindBy(xpath = "//form/*//input[@type = 'submit' and @value = 'Save']")
	WebElement saveButton;

	public DealMenuPage() throws IOException {
		super();

		PageFactory.initElements(driver, this);

	}

	public CreatedDealPage addDeal(String Title, String Company) throws InterruptedException, IOException {
		new Actions(driver).moveToElement(dealMenu).build().perform();
		newDealMenu.click();
		Thread.sleep(5000);
		titleField.sendKeys(Title);
		companyField.sendKeys(Company);
		saveButton.click();

		return new CreatedDealPage();

	}

}
