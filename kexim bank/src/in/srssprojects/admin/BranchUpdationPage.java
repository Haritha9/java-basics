package in.srssprojects.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BranchUpdationPage {
	public WebDriver driver;

	// constructor
	public BranchUpdationPage(WebDriver obj) {
		this.driver = obj;
	}

	// Branch Name
	public WebElement BranchName() {
		return driver.findElement(By.id("txtbName"));
	}

	// Address1
	public WebElement Address1() {
		return driver.findElement(By.id("txtadd1u"));
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
		this.State().sendKeys(State);
	}

	// fill City
	public void fillCity(String City) {
		this.City().sendKeys(City);
	}

	// Update button
	// new submit button
	public WebElement updateButton() {
		return driver.findElement(By.id("btnupdate"));
	}

	// click on newBranch button
	public void clickupdateButton() {
		this.updateButton().click();
	}

	// cancel button
	public WebElement CancelButton() {
		return driver.findElement(By.id("Btn_cancel"));
	}

	// click on Cancel button
	public void clickCancelButton() {
		this.CancelButton().click();
	}
	
	//fill branch updation form
	public void fillBranchUpdationForm(String bname, String add1, String zcode, String country, String state, String city){
		this.BranchName().clear();
		this.fillBranchName(bname);
		this.Address1().clear();
		this.fillAddress1(add1);
		this.Zipcode().clear();
		this.fillZipcode(zcode);
		this.fillCountry(country);
	}
}
