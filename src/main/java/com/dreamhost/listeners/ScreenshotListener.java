package com.dreamhost.listeners;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.dreamhost.generic.IAutocon;
import com.dreamhost.reporting.ExtentManager;
import com.dreamhost.reporting.ExtentTestManager;

public class ScreenshotListener implements ITestListener,IAutocon {

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ExtentTestManager.startTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String status="pass";
		String method_name=result.getMethod().getMethodName();
		//System.out.println(method_name);
		String dateAndTime=time();
		//System.out.println(dateAndTime);
		ITestContext context = result.getTestContext();
		WebDriver webdriver = (WebDriver)context.getAttribute("vigitta-driver");
		
		try {
			
			String targetLocation =  ".\\Screenshots\\"+takeScreenshot( webdriver, method_name,status,dateAndTime);
			
			ExtentTestManager.getTest().pass("details",
					MediaEntityBuilder.createScreenCaptureFromPath(targetLocation).build());
			
			
		} catch (Exception e) {
			e.printStackTrace();
			ExtentTestManager.getTest().log(Status.PASS, "Test passed");
		}
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		

		String status="fail";
		String method_name=result.getMethod().getMethodName();
		String dateAndTime=time();
		ITestContext context = result.getTestContext();
		WebDriver webdriver = (WebDriver)context.getAttribute("vigitta-driver");
		try {
			//startTest( webdriver, method_name,status,dateAndTime);
			String targetLocation = ".\\Screenshots\\"+takeScreenshot( webdriver, method_name,status,dateAndTime);
			ExtentTestManager.getTest().fail("Captured the screenshot of the failiure, the shot is attached below",
					MediaEntityBuilder.createScreenCaptureFromPath(targetLocation).build());
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
			ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");
		}
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ExtentTestManager.endTest();
		ExtentManager.getInstance().flush();
	}
	
	public String  takeScreenshot(WebDriver driver,String method_name, String status,String dateAndTime) throws IOException {
		String DestinationFilePath=DestinationFile+""+method_name+"_"+status+"_"+dateAndTime+".png";
		//report = new ExtentReports(System.getProperty("user.dir")+DestinationFile_Extent+method_name+"_"+status+"_"+dateAndTime+".html");
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File Destination=new File(DestinationFilePath);
		//System.out.println(Destination);
		
		FileUtils.copyFile(src, Destination);
	
		 
//		catch (IOException e)
//		 {
//		  System.out.println(e.getMessage());
//		 
//		 }
		return Destination.getName();
	}
	
	public String time() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");  
	    Date date = new Date();  
	   String Datetime= formatter.format(date); 
	   return Datetime;
	   
	}
	
}
