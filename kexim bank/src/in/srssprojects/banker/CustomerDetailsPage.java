package in.srssprojects.banker;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomerDetailsPage {
	public WebDriver driver;

	// constructor
	public CustomerDetailsPage(WebDriver obj) {
		this.driver = obj;
	}

	// Date
	public WebElement newCustomerButton() {
		return driver.findElement(By.id("btnNEW"));
	}

	// click on new customer button
	public void clicknewcustomerButton() {
		this.newCustomerButton().click();;
	}

}
