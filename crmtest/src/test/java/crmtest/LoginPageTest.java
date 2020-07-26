package crmtest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pagefactory.HomePage;
import com.crm.qa.pagefactory.LoginPage;

public class LoginPageTest extends TestBase {

	public LoginPage loginpage;
	public HomePage homepage;

	public LoginPageTest() throws IOException {
		super();

	}

	@BeforeMethod
	public void SetUp() throws IOException {
		initialization();
		loginpage = new LoginPage();

	}

	@Test(priority = 1)
	public void TitleTest() {
		String str = loginpage.validateLoginPageTitle();
		Assert.assertEquals(str, "CRMPRO - CRM software for customer relationship management, sales, and support.");
	}

	@Test(priority = 2)
	public void LoginTest() throws IOException, InterruptedException {
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));

	}

	@AfterMethod
	public void QuitBrowser() {
		driver.quit();

	}

}
