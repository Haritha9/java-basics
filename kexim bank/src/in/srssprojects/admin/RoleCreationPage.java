package in.srssprojects.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RoleCreationPage {
	public WebDriver wd;
	public WebElement wb;

	public RoleCreationPage(WebDriver obj) {
		this.wd = obj;
	}

	// RoleName textbox For Roles Page
	public WebElement Rolename() {
		wb = wd.findElement(By.id("txtRname"));
		return wb;

	}

	// RoleDesc textbox For Roles Page
	public WebElement RoleDesc() {
		wb = wd.findElement(By.id("txtRDesc"));
		return wb;

	}

	// RoleType textbox For Roles Page
	public WebElement RoleType() {
		wb = wd.findElement(By.name("lstRtypeN"));
		return wb;

	}

	// Submit_Button For Roles Page
	public WebElement Submit_Button() {
		wb = wd.findElement(By.id("btninsert"));
		return wb;

	}

	// Reset_Button For Roles Page
	public WebElement Reset_Button() {
		wb = wd.findElement(By.id("Btn_Reset"));
		return wb;

	}

	// Cancel_Button For Roles Page
	public WebElement Cancel_Button() {
		wb = wd.findElement(By.id("Btn_cancel"));
		return wb;
	}
	
	//fill role name
	public void fillRoleName(String roleName){
		this.Rolename().sendKeys(roleName);
	}
	
	//fill role desc
	public void fillRoleDesc(String roleDesc){
		this.RoleDesc().sendKeys(roleDesc);
	}
	
	//select role type
	public void selectRoleType(String roleType){
		new Select(this.RoleType()).selectByVisibleText(roleType);
	}
	
	//click submit button
	public void clickSubmitButton(){
		this.Submit_Button().click();
	}
	
	//click reset button
	public void clickResetButton(){
		this.Reset_Button().click();
	}
	
	//click cancel button
	public void clickCancelButton(){
		this.Cancel_Button().click();
	}
	
	//fill role creation form
	public void fillRoleCreationForm(String roleName, String roleDesc, String roleType){
		this.fillRoleName(roleName);
		this.fillRoleDesc(roleDesc);
		this.selectRoleType(roleType);
	}
}
