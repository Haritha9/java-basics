package in.srssprojects.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RoleDetailsPage {
	public WebDriver driver;
	public static WebElement wb;

	// constructor
	public RoleDetailsPage(WebDriver obj) {
		this.driver = obj;
	}
	
	// new role button
	public WebElement newRoleButton() {
		return driver.findElement(By.id("btnRoles"));
	}

	// click on newRole button
	public void clickNewRoleButton() {
		this.newRoleButton().click();
	}
}
