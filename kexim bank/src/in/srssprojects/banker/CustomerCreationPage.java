package in.srssprojects.banker;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CustomerCreationPage {
	public WebDriver driver;

	// constructor
	public CustomerCreationPage(WebDriver obj) {
		this.driver = obj;
	}

	// Date
	public WebElement Date() {
		return driver.findElement(By.id("txtdate"));
	}

	public Select selectCustomertype() {
		Select s2 = new Select(driver.findElement(By.xpath("//select[@tabindex='2']")));
		return s2;
	}

	// last name
	public WebElement LastName() {
		return driver.findElement(By.id("txtCLname"));
	}

	// middle name
	public WebElement MiddleName() {
		return driver.findElement(By.id("txtCMname"));
	}

	// first name
	public WebElement FirstName() {
		return driver.findElement(By.id("txtCFname"));
	}

	// Date of birth
	public WebElement DateofBirth() {
		return driver.findElement(By.id("txtDOB"));
	}

	// Address
	public WebElement Address() {
		return driver.findElement(By.id("txtAddress"));
	}

	// City
	public WebElement City() {
		return driver.findElement(By.id("txtcity"));
	}

	// zipcode
	public WebElement Zipcode() {
		return driver.findElement(By.id("txtZcode"));
	}

	// Emailid
	public WebElement EmailId() {
		return driver.findElement(By.id("txtEID"));
	}

	// PhoneNo
	public WebElement PhoneNo() {
		return driver.findElement(By.id("txtPno"));
	}

	// MobileNo
	public WebElement MobileNo() {
		return driver.findElement(By.id("txtMno"));
	}

	// OpeningBalance
	public WebElement OpeningBalance() {
		return driver.findElement(By.id("txtopnbal"));
	}

	// reset button
	public WebElement submitButton() {
		return driver.findElement(By.xpath("//input[@id='btnSubmit']"));
	}

	// reset button
	public WebElement resetButton() {
		return driver.findElement(By.xpath("//input[@id='btnReset']"));
	}

	// cancel button
	public WebElement cancelButton() {
		return driver.findElement(By.xpath("//input[@id='btnCancel']"));
	}

	// select branch list with data
	public void selectcustomertype() {
		selectCustomertype().selectByValue("ncustomer");
	}

	// fill date
	public void fillDate(String username) {
		this.Date().sendKeys(username);
	}

	// fill last name
	public void fillLastName(String LastName) {
		this.LastName().sendKeys(LastName);
	}

	// fill middle name
	public void fillMiddleName(String MiddleName) {
		this.MiddleName().sendKeys(MiddleName);
	}

	// fill first name
	public void fillFirstName(String FirstName) {
		this.FirstName().sendKeys(FirstName);
	}

	// fill date of birth
	public void fillDateofBirth(String Dateofbirth) {
		this.DateofBirth().sendKeys(Dateofbirth);
	}

	// fill address
	public void fillAddress(String Address) {
		this.Address().sendKeys(Address);
	}

	// fill city
	public void fillCity(String City) {
		this.City().sendKeys(City);
	}

	// fill zip code
	public void fillZipcode(String Zipcode) {
		this.Zipcode().sendKeys(Zipcode);
	}

	// fill email id
	public void fillEmailid(String Emailid) {
		this.Zipcode().sendKeys(Emailid);
	}

	// fill phone no
	public void fillPhoneNo(String PhoneNo) {
		this.PhoneNo().sendKeys(PhoneNo);
	}

	// fill mobile no
	public void fillMobileNo(String MobileNo) {
		this.MobileNo().sendKeys(MobileNo);
	}

	// fill opening balance
	public void fillOpeningBalance(String OpeningBalance) {
		this.OpeningBalance().sendKeys(OpeningBalance);
	}

	// click on submit button
	public void clicksubmitButton() throws InterruptedException {
		this.submitButton().click();
	}

	// click on reset button
	public void clickresetbutton() {

		this.resetButton().click();
	}

	// click on cancel button
	public void clickcancelbutton() {
		this.cancelButton().click();
	}
}
