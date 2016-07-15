package in.srssprojects.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class KeximHomePage {
	
	private WebDriver driver;
	
	public KeximHomePage(WebDriver obj) {
		this.driver = obj;
	}
	//branchName
	public WebElement branchName(){
		return driver.findElement(By.id("drlist"));
	}
	
	//username
	public WebElement userName(){
		return driver.findElement(By.id("txtuId"));
	}
	//password
	public WebElement password(){
		return driver.findElement(By.id("txtPword"));
	}
	
	//login button
	public WebElement loginButton(){
		return driver.findElement(By.id("login"));
	}
	
	//select branchName
	public void selectBranchName(String bname){
		new Select(this.branchName()).selectByVisibleText(bname);
	}
	
	//fill username
	public void fillUserName(String username){
		this.userName().sendKeys(username);
	}
	
	//fill password
	public void fillPassword(String password){
		this.password().sendKeys(password);
	}
	
	//click on login button
	public void clickLoginButton(){
		this.loginButton().click();
	}
	
	
	
	
	
	
	
}
