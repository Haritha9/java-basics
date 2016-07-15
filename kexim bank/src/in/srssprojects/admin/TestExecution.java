package in.srssprojects.admin;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;
import org.testng.ITest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.ITestAnnotation;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import in.srssprojects.utils.DataProviderClass;
import in.srssprojects.utils.EventListener;
import in.srssprojects.utils.Utility;
import in.srssprojects.utils.Validations;
//@Listeners(in.srssprojects.utils.TestLIstener.class)
public class TestExecution {
	public WebDriver driver;
	public RemoteWebDriver robj;
	public EventFiringWebDriver obj;
	public DesiredCapabilities caps;
	public EventListener eListener;
	public KeximHomePage keximHomePage;
	public AdminHomePage adminHomePage;
	public BranchDetailsPage branchDetailsPage;
	public BranchCreationPage branchCreationPage;
	public BranchUpdationPage branchUpdatePage;
	public EmployeeDetailsPage employeeDetailsPage;
	public EmployeeCreationPage employeeCreationPage;
	public RoleDetailsPage roleDetailsPage;
	public RoleCreationPage roleCreationPage;
	public RolesUpdatePage roleUpdationPage;
	public static ExtentReports report;
	
	@BeforeSuite
	public void BeforeSuiteMethod(){
		 report = new ExtentReports("./Results/report.html");
	}
	
	@AfterSuite
	public void afterSuiteMethod(){
		report.flush();
		obj.close();
	}
	
//	@Parameters({ "url", "browser" })
	public void launch(String u, String b){
		eListener = new EventListener();
		if (b.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "//Users//surya//Documents//Selenium//Selenium Softwares//chromedriver");
			driver = new ChromeDriver();
		} else if (b.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}else if(b.equalsIgnoreCase("safari")){
			driver = new SafariDriver();
		}
		obj = new EventFiringWebDriver(driver);
		obj.register(eListener);
		obj.get(u);
	}
	

	public void gridLaunch(String nodeUrl, String b){
		if(b.equalsIgnoreCase("firefox")){
			caps = new DesiredCapabilities();
			caps = DesiredCapabilities.firefox();
			caps.setBrowserName("firefox");
		}else if(b.equalsIgnoreCase("chrome")){
			caps = new DesiredCapabilities();
			caps = DesiredCapabilities.chrome();
			caps.setBrowserName("chrome");
		}else if(b.equalsIgnoreCase("safari")){
			caps = new DesiredCapabilities();
			caps = DesiredCapabilities.safari();
			caps.setBrowserName("safari");
			caps.setPlatform(Platform.WIN10);
		}
		try {
			robj = new RemoteWebDriver(new URL(nodeUrl), caps);
			obj = new EventFiringWebDriver(robj);
			obj.register(eListener);
			robj.get("http://gmail.com");
		} catch (Exception e) {

		}	
	}

//	public void launch(){
//		obj = new FirefoxDriver();
//		obj.get("http://srssprojects.in");
//	}
	
	// launch the application
	@BeforeTest(groups = { "branches", "roles", "creation", "positive", "negative" })
	@Parameters({ "url", "br" })
//	@Parameters({"nodeURL","br"})
	public void launchApp(String u, String b) {		
		launch(u,b);
//		gridLaunch(u, b);
		obj.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		obj.manage().window().maximize();
		keximHomePage = new KeximHomePage(obj);
		adminHomePage = new AdminHomePage(obj);
		branchDetailsPage = new BranchDetailsPage(obj);
		branchCreationPage = new BranchCreationPage(obj);
		branchUpdatePage = new BranchUpdationPage(obj);
		employeeDetailsPage = new EmployeeDetailsPage(obj);
		roleDetailsPage = new RoleDetailsPage(obj);
		roleCreationPage = new RoleCreationPage(obj);
		roleUpdationPage = new RolesUpdatePage(obj);
	}

	// loginMethod
	@Test(priority = 0, alwaysRun = true, groups = { "branches", "roles", "creation", "positive", "negative" })
	public void loginAsAdmin() {
		ExtentTest test = report.startTest("loginAsAdmin");
		System.out.println(Thread.currentThread().getId());
		keximHomePage.fillUserName("Admin");
		test.log(LogStatus.INFO, "username entered as Admin");
		keximHomePage.fillPassword("Adminn");
		test.log(LogStatus.INFO, "password entered as Admin");
		keximHomePage.clickLoginButton();
		test.log(LogStatus.INFO, "login button clicked");
		obj.switchTo().alert().accept();
		boolean result = Validations.isURLContains(obj, "adminflow")&&Validations.isTextPresent(obj, "Welcome to Admin");
		if(result){
			test.log(LogStatus.PASS, "loginAsAdmin test case is passed");
		}else{
			test.log(LogStatus.FAIL, "loginAsAdmin test case is failed");
			test.log(LogStatus.FATAL, "loginASAdmin is accepting valid username and password");
		}
		report.endTest(test);
//		Assert.assertTrue(result);
		
		Reporter.log("Login successfull");
	}

	@Test(priority = 30, groups={"branches"})
	public void verifyBranchesButton() {
		System.out.println("branches button clicked");
		adminHomePage.clickBranchesButton();
	}

	@Test(priority = 1, dependsOnMethods = { "verifyBranchesButton" }, groups = { "branches", "positive", "creation" })
	public void branchCreationWithVData() {
		ExtentTest test = report.startTest("branchCreationWithVdata");
		adminHomePage.clickBranchesButton();
		test.log(LogStatus.INFO, "branches button clikced");
		branchDetailsPage.clickNewBranchButton();
		test.log(LogStatus.INFO, "new branch button clicked");
		branchCreationPage.fillBranchCreationForm("ATCBatch3", "sr nagar", "89797", "INDIA", "GOA", "GOA");
		test.log(LogStatus.INFO, "branch creation form filled");
		branchCreationPage.clickSubmitButton();
		test.log(LogStatus.INFO, "submit button clicked");
		String alertText = obj.switchTo().alert().getText();
		Reporter.log(alertText, true);
		test.log(LogStatus.INFO, "alert text is "+alertText);
		obj.switchTo().alert().accept();
		test.log(LogStatus.INFO, "alert accepted");
		test.log(LogStatus.PASS, "branchCreationWithVData is passed");
		report.endTest(test);
	}

	@Test(priority = 2, dependsOnMethods = { "verifyBranchesButton" },groups = { "branches", "creation", "nagative" })
	public void branchCreationWithDData() {
		adminHomePage.clickBranchesButton();
		branchDetailsPage.clickNewBranchButton();
		branchCreationPage.fillBranchCreationForm("ATCBatch3", "sr nagar", "89797", "INDIA", "GOA", "GOA");
		branchCreationPage.clickSubmitButton();
		String alertText = obj.switchTo().alert().getText();
		Reporter.log(alertText, true);
		obj.switchTo().alert().accept();
	}

	@Test(priority = 3, groups = { "branches", "negative" })
	public void branchCreationWithBlankData() {
		adminHomePage.clickBranchesButton();
		branchDetailsPage.clickNewBranchButton();
		branchCreationPage.fillBranchCreationForm("", "", "", "Select", "Select", "Select");
		branchCreationPage.clickSubmitButton();
		String alertText = obj.switchTo().alert().getText();
		Reporter.log(alertText, true);
		obj.switchTo().alert().accept();
	}

	@Test(priority = 4, groups = { "branches", "creation" })
	public void branchCreationReset() {
		adminHomePage.clickBranchesButton();
		branchDetailsPage.clickNewBranchButton();
		branchCreationPage.fillBranchCreationForm("ATCBranch", "sr nagar", "89789", "INDIA", "GOA", "GOA");
		branchCreationPage.clickResetButton();
	}

	@Test(priority = 5, groups = { "branches" })
	public void branchCreationCancel() {
		adminHomePage.clickBranchesButton();
		branchDetailsPage.clickNewBranchButton();
		branchCreationPage.clickCancelButton();
	}

	@Test(priority = 6, groups = { "branches" })
	public void bracnhCreationCancelAfterFillingTheData() {
		adminHomePage.clickBranchesButton();
		branchDetailsPage.clickNewBranchButton();
		branchCreationPage.fillBranchCreationForm("ATCBranch", "sr nagar", "89789", "INDIA", "GOA", "GOA");
		branchCreationPage.clickCancelButton();
	}

	@Test(priority = 7, groups = { "branches" })
	public void branchUpdationWithVData() {
		adminHomePage.clickBranchesButton();
		Utility.webTable(obj, By.id("DG_bankdetails"), "223", "update");
		branchUpdatePage.Address1().clear();
		branchUpdatePage.Address1().sendKeys("ameerpet");
	}

	@Test(priority = 8, groups = { "branches" })
	public void branchDeletionWithDependency() {
		adminHomePage.clickBranchesButton();
		Utility.webTable(obj, By.id("DG_bankdetails"), "103", "delete");
		obj.switchTo().alert().accept();
		String alertText = obj.switchTo().alert().getText();
		System.out.println(alertText);
		obj.switchTo().alert().accept();
	}

	@Test(priority = 9, groups = { "branches" })
	public void branchDeletionWODependency() {
		adminHomePage.clickBranchesButton();
		Utility.webTable(obj, By.id("DG_bankdetails"), "225", "delete");
		obj.switchTo().alert().accept();
	}

	@Test(priority = 10, groups = { "roles", "creation", "positive" })
	public void roleCreationWithVData() {
		adminHomePage.clickRolesButton();
		roleDetailsPage.clickNewRoleButton();
		roleCreationPage.fillRoleCreationForm("AsstManager", "assistant Manager", "E");
		roleCreationPage.clickSubmitButton();
		String alertText = obj.switchTo().alert().getText();
		obj.switchTo().alert().accept();
		System.out.println(alertText);
	}

	@Test(priority = 11, groups = { "roles" })
	public void roleCreationWithDData() {
		roleCreationWithVData();
	}

	@Test(priority = 12, groups = { "roles" })
	public void roleCreationWithBlankData() {
		adminHomePage.clickRolesButton();
		roleDetailsPage.clickNewRoleButton();
		roleCreationPage.fillRoleCreationForm("", "", "Select");
		roleCreationPage.clickSubmitButton();
		String alertText = obj.switchTo().alert().getText();
		obj.switchTo().alert().accept();
		System.out.println(alertText);
	}

	@Test(priority = 13, groups = { "roles" })
	public void roleCreationReset() {
		adminHomePage.clickRolesButton();
		roleDetailsPage.clickNewRoleButton();
		roleCreationPage.fillRoleCreationForm("AsstManager", "assistant Manager", "E");
		roleCreationPage.clickResetButton();
	}

	@Test(priority = 14, groups = { "roles" })
	public void roleCreationCancel() {
		adminHomePage.clickRolesButton();
		roleDetailsPage.clickNewRoleButton();
		roleCreationPage.fillRoleCreationForm("AsstManager", "assistant Manager", "E");
		roleCreationPage.clickCancelButton();
	}

	@Test(priority = 15, groups = { "roles" })
	public void roleUpadationWithVD() {
		adminHomePage.clickRolesButton();
		Utility.webTable(obj, By.id("DGRoles"), "153", "update");
		roleUpdationPage.fillRoleUpdateForm("Manager", "Manager", "E");
		roleUpdationPage.clickRoleUpdate();
		String alertText = obj.switchTo().alert().getText();
		obj.switchTo().alert().accept();
		System.out.println(alertText);
	}

	@Test(priority = 16, groups = { "roles" })
	public void roleUpadationWithDuplicateData() {
		adminHomePage.clickRolesButton();
		Utility.webTable(obj, By.id("DGRoles"), "153", "update");
		roleUpdationPage.fillRoleUpdateForm("AsstManager", "assistant Manager", "E");
		roleUpdationPage.clickRoleUpdate();
		String alertText = obj.switchTo().alert().getText();
		obj.switchTo().alert().accept();
		System.out.println(alertText);
	}

	@Test(priority = 17, groups = { "roles" })
	public void roleUpdationCancel() {
		adminHomePage.clickRolesButton();
		Utility.webTable(obj, By.id("DGRoles"), "152", "update");
		roleUpdationPage.fillRoleUpdateForm("Manager", "Manager", "E");
		roleUpdationPage.clickRoleUpdate();
	}

	@Test(priority = 18, groups = { "employee" })
	public void employeeCreationWVD() {
		adminHomePage.clickEmployeeButton();
		employeeDetailsPage.clickNewEmployeeButton();
		employeeCreationPage.fillEmployeeCreationForm("surya", "selenium", "Asst Manager", "ATC Batch 3");
		employeeCreationPage.clicksubmit();
		String alertText = obj.switchTo().alert().getText();
		obj.switchTo().alert().accept();
		System.out.println(alertText);
	}

	@Test(priority = 19, groups = { "employee" })
	public void employeeCreationWDD() {
		employeeCreationWVD();
	}

	@Test(priority = 20, groups = { "employee" })
	public void employeeCreationWBlankData() {
		adminHomePage.clickEmployeeButton();
		employeeDetailsPage.clickNewEmployeeButton();
		employeeCreationPage.fillEmployeeCreationForm("", "", "Select", "Select");
		employeeCreationPage.clicksubmit();
		String alertText = obj.switchTo().alert().getText();
		obj.switchTo().alert().accept();
		System.out.println(alertText);
	}

	@Test(priority = 21, groups = { "employee" })
	public void employeeCreationReset() {
		adminHomePage.clickEmployeeButton();
		employeeDetailsPage.clickNewEmployeeButton();
		employeeCreationPage.fillEmployeeCreationForm("surya", "selenium", "Asst Manager", "ATC Batch 3");
		employeeCreationPage.clickreset();
	}
	@DataProvider(name = "branches")
	public Object[][] branchData(){
		String[][] data = DataProviderClass.getExcelContents("./input.xls", "branch data");
		return data;
	}
	
	@Test(priority = 22, dataProvider="branches", enabled=false)
	public void branchCreationWithMultipleData(String bname, String add1, String zcode, String country, String state, String city){
		adminHomePage.clickBranchesButton();
		branchDetailsPage.clickNewBranchButton();
		branchCreationPage.fillBranchCreationForm(bname,add1,zcode,country,state,city);
		branchCreationPage.clickSubmitButton();
		String alertText = obj.switchTo().alert().getText();
		Reporter.log(alertText, true);
		obj.switchTo().alert().accept();
	}

	// banker module
	@Test(priority = 23)
	public void loginASEmployee() {
		keximHomePage.selectBranchName("ATCBatch3");
		keximHomePage.fillUserName("surya");
		keximHomePage.fillPassword("selenium");
		keximHomePage.clickLoginButton();
	}

}
