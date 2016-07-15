package in.srssprojects.utils;

import javax.swing.text.Utilities;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import in.srssprojects.admin.TestExecution;
import junit.framework.TestListener;

public class TestLIstener implements ITestListener {

	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailure(ITestResult arg0) {
		ExtentTest test = TestExecution.report.startTest(arg0.getName());
		
		
		// TODO Auto-generated method stub
		try {
			String path = Utility.alertScreenCapture(arg0.getName());
			System.out.println(path);
			Thread.sleep(2000);
			test.log(LogStatus.FAIL, arg0.getName()+"is failed" +test.addScreenCapture(path));
		} catch (Exception e) {
			// TODO: handle exception
			
		}
		TestExecution.report.endTest(test);
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		ExtentTest test = TestExecution.report.startTest(arg0.getName());
		test.log(LogStatus.SKIP, "");
		TestExecution.report.endTest(test);

	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

}
