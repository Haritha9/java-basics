package in.srssprojects.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class UserCreationPage {
	public WebDriver driver;

	// constructor
	public UserCreationPage(WebDriver obj) {
		this.driver = obj;
	}

	// select Role
	public Select selectRole() {
		Select s = new Select(driver.findElement(By.xpath("//select[contains(@name,'lst_Roles')]")));
		return s;
	}

	// select Branch
	public Select selectBranch() {
		Select s1 = new Select(driver.findElement(By.xpath("//select[contains(@name,'Branch')]")));
		return s1;
	}

	// select CustomerId
	public Select selectCustomer() {
		Select s2 = new Select(driver.findElement(By.xpath("//select[contains(@name,'DrCName')]")));
		return s2;
	}

	// user name
	public WebElement userName() {
		return driver.findElement(By.id("txtUname"));
	}

	// login password
	public WebElement loginPassword() {
		return driver.findElement(By.id("txtLpwd"));
	}

	// transaction password
	public WebElement transactionPassword() {
		return driver.findElement(By.id("txtTpwd"));
	}

	// submit button
	public WebElement submitButton() {
		return driver.findElement(By.xpath("//input[@src='images/submit.jpg']"));
	}

	// reset button
	public WebElement resetButton() {
		return driver.findElement(By.xpath("//input[@name='btnreset']"));
	}

	// cancel button
	public WebElement cancelButton() {
		return driver.findElement(By.xpath("//input[@src='images/cancel.jpg']"));
	}

	// select role list with data
	public void selectRoleList(String role) {
		selectRole().selectByVisibleText(role);
	}

	// select branch list with data
	public void selectBranchList(String branchName) {
		selectBranch().selectByVisibleText(branchName);
	}

	// select customer id with data
	public void selectCustomeridList() {
		selectCustomer().selectByVisibleText("Select");
	}

	// enter user name
	public void userNameData(String userName) {
		this.userName().sendKeys(userName);
	}

	// enter login password
	public void loginPasswordData(String loginPassword) {
		this.loginPassword().sendKeys(loginPassword);
	}

	// enter transaction PasswordData
	public void transactionPasswordData(String transPassword) {
		this.transactionPassword().sendKeys(transPassword);
	}

	// clcik on submit button
	public void submitButtonClick() {
		this.submitButton().click();
	}

	// clcik on reset button
	public void resetbuttonClick() {
		this.resetButton().click();
	}

	// clcik on cancel button
	public void cancelbuttonClick() {
		this.cancelButton().click();
	}

}
