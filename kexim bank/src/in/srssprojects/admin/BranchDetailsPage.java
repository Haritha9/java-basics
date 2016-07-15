package in.srssprojects.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BranchDetailsPage {
	
	public WebDriver driver;
	
	//constructor
	public BranchDetailsPage(WebDriver obj){
		this.driver = obj;
	}
	
	//new branch button
	public WebElement newBranchButton(){
		return driver.findElement(By.id("BtnNewBR"));
	}
	
	//click on newBranch button
	public void clickNewBranchButton(){
		this.newBranchButton().click();
	}

}
