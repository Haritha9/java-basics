package in.srssprojects.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RolesUpdatePage {
	private WebDriver driver;

	public RolesUpdatePage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement roleName() {
		return driver.findElement(By.id("txtrNameU"));
	}

	public WebElement roleDesc() {
		return driver.findElement(By.id("txtrdescU"));
	}

	public WebElement roleType() {
		return driver.findElement(By.id("lstRtype"));
	}

	public WebElement roleupdate() {
		return driver.findElement(By.xpath("//input[@id='btnupdate']"));
	}

	public WebElement roleCancel() {
		return driver.findElement(By.xpath("//input[@id='Btncancel']"));
	}

	public void fillRoleName(String roleName) {
		this.roleName().sendKeys(roleName);
	}

	public void fillRoleDesc(String roleDesc) {
		this.roleDesc().sendKeys(roleDesc);
	}

	public void selectRoleType(String roleType) {
		new Select(this.roleType()).selectByVisibleText(roleType);
	}

	public void clickRoleUpdate() {
		this.roleupdate().click();
	}

	public void clickRoleCancel() {
		this.roleCancel().click();
	}
	
	//fill update form
	public void fillRoleUpdateForm(String roleName, String roleDesc, String roleType){
		this.fillRoleName(roleName);
		this.fillRoleDesc(roleDesc);
		this.selectRoleType(roleType);
	}
}
