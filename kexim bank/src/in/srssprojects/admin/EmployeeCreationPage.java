package in.srssprojects.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class EmployeeCreationPage {
	private WebDriver driver;

	// constructor
	public EmployeeCreationPage(WebDriver obj) {
		this.driver = obj;
	}

	// employee name
	public WebElement employeename() {
		return driver.findElement(By.xpath("//input[@id='txtUname']"));
	}

	// transactionid
	public WebElement loginpassword() {
		return driver.findElement(By.xpath("//input[@id='txtLpwd']"));
	}

	// role
	public Select role() {
		return new Select(driver.findElement(By.xpath("//select[@id='lst_Roles']")));
	}

	// brabch
	public Select branch() {
		return new Select(driver.findElement(By.xpath("//select[@id='lst_Branch']")));
	}

	// submit
	public WebElement submit() {
		return driver.findElement(By.xpath("//input[@id='BtnSubmit']"));
	}

	public WebElement reset() {
		return driver.findElement(By.xpath("//input[@id='btnreset']"));
	}

	public WebElement cancel() {
		return driver.findElement(By.xpath("//input[@id='btnCancel']"));
	}

	// fill employee name
	public void fillemployeename(String employeename) {
		this.employeename().sendKeys(employeename);

	}

	// fill loginpassword
	public void fillPassword(String loginpassword) {
		this.loginpassword().sendKeys(loginpassword);

	}

	// select role
	public void selectrole(String role) {
		this.role().selectByVisibleText(role);
	}

	// select branch
	public void selectbranch(String branch) {
		this.branch().selectByVisibleText(branch);

	}

	// submit
	public void clicksubmit() {
		this.submit().click();
	}

	// click reset
	public void clickreset() {
		this.reset().click();
	}

	// click cancel
	public void clickcancel() {
		this.cancel().click();
	}
	
	//fill employee creation form
	public void fillEmployeeCreationForm(String employeename, String loginpassword, String role, String branch){
		this.fillemployeename(employeename);
		this.fillPassword(loginpassword);
		this.selectrole(role);
		this.selectbranch(branch);
	}

}
