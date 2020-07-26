package com.crm.qa.pagefactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//td[contains(text() , 'User: Demo User')]")
	WebElement userLabel;

	@FindBy(xpath = "//td[contains(text(), 'CRMPRO')]")
	// @FindBy(xpath = "//div[@class = 'noprint']//td[@class = 'logo_text']")
	WebElement logoName;

	@FindBy(xpath = "//a[contains(text(), 'Deals')]")
	WebElement dealMenu;

	@FindBy(xpath = "//a[contains(text(), 'Companies')]")
	WebElement companiesMenu;

	public HomePage() throws IOException {
		super();

		PageFactory.initElements(driver, this);
	}

	public boolean validateUserLabel() throws InterruptedException {
		// driver.switchTo().defaultContent();
		// driver.switchTo().frame("mainpanel");
		// new WebDriverWait(driver,
		// 50).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text()
		// , 'User: Demo User')]")));
		Thread.sleep(10000);
		return userLabel.isDisplayed();

	}

	public boolean validateLogoName() throws InterruptedException {
		// driver.switchTo().defaultContent();
		// driver.switchTo().frame("mainpanel");
		// new WebDriverWait(driver,
		// 50).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class
		// = 'noprint']//td[@class = 'logo_text']")));
		Thread.sleep(10000);
		return logoName.isDisplayed();
	}

	public DealMenuPage clickDealMenu() throws IOException {
		// driver.switchTo().defaultContent();
		// driver.switchTo().frame("mainpanel");
		dealMenu.click();
		return new DealMenuPage();
	}

	public CompaniesMenuPage clickcompaniesMenu() throws IOException {
		// driver.switchTo().defaultContent();

		dealMenu.click();
		return new CompaniesMenuPage();
	}

}
