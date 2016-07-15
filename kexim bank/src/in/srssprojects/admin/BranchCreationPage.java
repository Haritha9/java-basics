package in.srssprojects.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BranchCreationPage {
	public WebDriver driver;

	// constructor
	public BranchCreationPage(WebDriver obj) {
		this.driver = obj;
	}

	// Branch Name
	public WebElement BranchName() {
		return driver.findElement(By.id("txtbName"));
	}

	// Address1
	public WebElement Address1() {
		return driver.findElement(By.id("txtAdd1"));
	}

	// Zipcode
	public WebElement Zipcode() {
		return driver.findElement(By.id("txtZip"));
	}

	// Country
	public WebElement Country() {
		return driver.findElement(By.id("lst_counrtyU"));
	}

	// State
	public WebElement State() {
		return driver.findElement(By.id("lst_stateI"));
	}

	// City
	public WebElement City() {
		return driver.findElement(By.id("lst_cityI"));
	}

	// fill BranchName
	public void fillBranchName(String BranchName) {
		this.BranchName().sendKeys(BranchName);
	}

	// fill Address1
	public void fillAddress1(String Address1) {
		this.Address1().sendKeys(Address1);
	}

	// fill Zipcode
	public void fillZipcode(String Zipcode) {
		this.Zipcode().sendKeys(Zipcode);
	}

	// fill Country
	public void fillCountry(String Country) {
		new Select(this.Country()).selectByVisibleText(Country);
	}

	// fill State
	public void fillState(String State) {
		new Select(this.State()).selectByVisibleText(State);
	}

	// fill City
	public void fillCity(String City) {
	new Select(this.City()).selectByVisibleText(City);
	}

	// Submit button
	// new submit button
	public WebElement SubmitButton() {
		return driver.findElement(By.id("btn_insert"));
	}

	// click on newBranch button
	public void clickSubmitButton() {
		this.SubmitButton().click();
	}

	// Reset button
	public WebElement ResetButton() {
		return driver.findElement(By.id("Btn_Reset"));
	}

	// click on Reset button
	public void clickResetButton() {
		this.ResetButton().click();
	}

	// cancel button
	public WebElement CancelButton() {
		return driver.findElement(By.id("Btn_cancel"));
	}

	// click on Cancel button
	public void clickCancelButton() {
		this.CancelButton().click();
	}
	
	//fill branch creation form
	public void fillBranchCreationForm(String bname, String add1, String zipcode, String country, String state, String city){
		this.fillBranchName(bname);
		this.fillAddress1(add1);
		this.fillZipcode(zipcode);
		this.fillCountry(country);
		this.fillState(state);
		this.fillCity(city);
		
	}
	

}