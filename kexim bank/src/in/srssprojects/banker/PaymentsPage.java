package in.srssprojects.banker;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PaymentsPage {
	public WebDriver driver;
	private Select dd;

	// constructor
	public PaymentsPage(WebDriver obj) {
		this.driver = obj;
	}

	// accont number
	public WebElement accontNumber() {
		return driver.findElement(By.id(".//*[@id='TxtaccNO']"));
	}

	// transaction date
	public WebElement transactionDate() {
		return driver.findElement(By.id(".//*[@id='txttransDate']"));
	}

	// transaction type
	public Select transactionType(Select Element) {
		return Element = new Select(driver.findElement(By.id("lstTransType")));
	}

	// fill accontnumber
	public void fillaccontNumber() {
		this.accontNumber().sendKeys("1234567890");
	}

	// fill transaction date
	public void enterTransactionDate() {
		this.transactionDate().sendKeys("7/4/2016");
	}

	// select transaction type
	public void selectTransactionType() {
		this.transactionType(dd).selectByVisibleText("dd deposit(-)");
	}
}
