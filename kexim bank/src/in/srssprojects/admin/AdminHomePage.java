package in.srssprojects.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminHomePage {
	private WebDriver driver;
	
	//constructor
	public AdminHomePage(WebDriver obj){
		this.driver = obj;
	}
	
	//logout Button
	public WebElement logOutButton(){
		return driver.findElement(By.xpath("//img[@src='images/admin_but_03.jpg']"));
	}
	//changePassword button
	public WebElement changePasswordButton(){
		WebElement element = driver.findElement(By.xpath("//img[@src='images/admin_but_02.jpg']"));
		return element;
	}
	//branches button
	public WebElement branchesButton(){
		return driver.findElement(By.xpath("//img[@src='images/Branches_but.jpg']"));
	}
	
	//roles button
	public WebElement rolesButton(){
		return driver.findElement(By.xpath("//img[@src='images/Roles_but.jpg']"));
	}
	
	//employee button
	public WebElement employeeButton(){
		return driver.findElement(By.xpath("//img[@src='images/emp_btn.jpg']"));
	}
	
	//users button
	public WebElement usersButton(){
		return driver.findElement(By.xpath("//img[@src='images/Users_but.jpg']"));
	}
	
	
	//click on logout button
	public void clickLogOutButton(){
		this.logOutButton().click();
	}
	
	//click on change password button
	public void clickChangePasswordButton(){
		this.changePasswordButton().click();
	}
	
	//click on branches button
	public void clickBranchesButton(){
		this.branchesButton().click();
	}
	
	//click on employee button
	public void clickEmployeeButton(){
		this.employeeButton().click();
	}
	
	//click on roles button
	public void clickRolesButton(){
		this.rolesButton().click();
	}
	
	//click on users button
	public void clickUsersButton(){
		this.usersButton().click();
	}
}
