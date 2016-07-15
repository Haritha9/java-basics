package in.srssprojects.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EmployeeDetailsPage {
	public WebDriver driver;
	
	//constructor
	public EmployeeDetailsPage(WebDriver obj){
		this.driver = obj;
	}
	
	//new employee buttn
	public WebElement newEmployeeButton(){
		return driver.findElement(By.id("BtnNew"));
	}
	
	//click new employee button
	public void clickNewEmployeeButton(){
		this.newEmployeeButton().click();
	}
}
