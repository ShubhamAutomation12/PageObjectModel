package crmtest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pagefactory.DealMenuPage;
import com.crm.qa.pagefactory.HomePage;
import com.crm.qa.pagefactory.LoginPage;
import com.crm.qa.utils.ReadDealTestData;

public class CreateDealTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	DealMenuPage dealmenupage;

	public CreateDealTest() throws IOException {
		super();

	}

	@BeforeMethod
	public void setup() throws IOException, InterruptedException {
		initialization();

		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainpanel");
		homepage.clickDealMenu();
		Thread.sleep(5000);

	}

	@DataProvider
	public Iterator<Object[]> getData() {
		ArrayList<Object[]> testdata = ReadDealTestData.getTestData();
		return testdata.iterator();
	}

	@Test(dataProvider = "getData")
	public void addDeal(String Title, String Company) throws IOException, InterruptedException

	{
		dealmenupage = new DealMenuPage();
		dealmenupage.addDeal(Title, Company);

	}

	@AfterMethod
	public void CloseBrowser() {
		driver.quit();
	}
}
