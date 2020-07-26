package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {

	public static Properties prop;
	public static WebDriver driver;
	public WebDriverWait wait;
	public Actions action;

	public TestBase() throws IOException {
		try {

			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					"/E:\\Testing\\crmtest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void initialization() {
		if (prop.getProperty("browser").equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "//E:\\2020\\Driver3\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));

	}

}
