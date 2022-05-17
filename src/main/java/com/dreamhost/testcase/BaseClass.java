package com.dreamhost.testcase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.dreamhost.generic.IAutocon;

public class BaseClass implements IAutocon {
	public WebDriver driver;
	@BeforeMethod(alwaysRun=true)
	@Parameters("browser")
	//public void setProperty(String browser, ITestContext context){
	public void setProperty(@Optional("chrome")String browser, ITestContext context){
		if(browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", CHROMPATH);
		    driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", FIREFOXPATH);
			driver=new FirefoxDriver();
		}
		context.setAttribute("vigitta-driver", driver);
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@BeforeTest
	public void InitializeBrowser() {
	
	
	
	}
	@AfterTest
	public void CleanUp() {
		driver.close();
	}
	/*
	 * Implimenting the datadriven approch, by using appache poi. Code for calling data from Excel sheet.
	 */
	public static String readFromExcelSheet(String sheet, int row, int cell) throws EncryptedDocumentException, FileNotFoundException, IOException {
		Workbook wb;
		String value;
		wb =WorkbookFactory.create(new FileInputStream(EXCELURL));
		value=wb.getSheet(sheet).getRow(row).getCell(cell).toString();
		return value;
	}
	
}
