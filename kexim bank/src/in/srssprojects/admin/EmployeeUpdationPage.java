package in.srssprojects.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class EmployeeUpdationPage {
private WebDriver driver;
	
	//constructor
	public EmployeeUpdationPage(WebDriver obj){
		this.driver = obj;
	
	}
	// employee name
	public WebElement employeename(){
		return driver.findElement(By.xpath("//input[@id='txtBnameU']"));
	}
	//password
	public WebElement logpassword(){
		return driver.findElement(By.xpath("//input[@id='txtPwdU']"));
		
	}
	//select role
	public Select role(){
		return new Select(driver.findElement(By.xpath("//select[@id='lstrolesU']")));
		
	}
	// select branch
	public Select branch(){
		return new Select(driver.findElement(By.xpath("//select[@id='lstBidU']")));
	}
	// click updatebutton
	public WebElement update(){
		return driver.findElement(By.xpath("//input[@id='BtnUpdate']"));
	}
	// click cancel button
	public WebElement cancel(){
		return driver.findElement(By.xpath("//input[@id='btncancelU']"));
	}	
		
	// fill employee name
	public void fillemployeename(String name){
		this.employeename().sendKeys(name);
	}
		//fill password
	public void fillpassword(String password){
		this.logpassword().sendKeys(password);
		
	}
	//select role
	
	public void selectrole(String role){
		this.role().selectByVisibleText(role);
	}
	// select branch
	public void  selectbranch(String  branch){
		this.branch().selectByVisibleText(branch);
	}
	// update click
	public void clickupdate(){
		this.update().click();
	}
	
	//click cancel
	public void clickcancel(){
		this.cancel().click();
		
	}
	
	
	
	
	
	
	
	
	
	
}
