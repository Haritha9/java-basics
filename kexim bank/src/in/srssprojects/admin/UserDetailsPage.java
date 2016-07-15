package in.srssprojects.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class UserDetailsPage {
	public WebDriver driver;

	// constructor
	public UserDetailsPage(WebDriver obj) {
		this.driver = obj;
	}

	// new user create button
	public WebElement newUserCreate() {
		return driver.findElement(By.id("Btnuser"));
	}

	// select Branch list
	public Select selectBranchList() {
		Select s = new Select(driver.findElement(By.xpath("//select[contains(@id,'branchS')]")));
		return s;

	}

	// select role list
	public Select selectRoleList() {
		Select s1 = new Select(driver.findElement(By.xpath("//select[contains(@id,'lst_rolesS')]")));
		return s1;
	}

	// search button
	public WebElement searchButton() {
		return driver.findElement(By.xpath("//input[contains(@id,'btn_search')]"));
	}

	// clear button
	public WebElement clearButton() {
		return driver.findElement(By.xpath("//input[contains(@id,'btn_clear')]"));
	}

	// click on newUserCreate
	public void clickNewUser() {
		this.newUserCreate().click();
	}

	// Select BranchLIst with data
	public void selectBranchListData() {
		selectBranchList().selectByVisibleText("TenaliBranch2016");
	}

	// Select RoleLIst with data
	public void selectRoleListData() {
		selectRoleList().selectByVisibleText("icustomer");
	}

	// click on Search button
	public void clickSearchButton() {
		this.searchButton().click();
	}

	// click on clear button
	public void clickClearButton() {
		this.clearButton().click();
	}
}
