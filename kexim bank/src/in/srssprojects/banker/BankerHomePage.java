package in.srssprojects.banker;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BankerHomePage {
	public WebDriver driver;
	
	//constructor
	public BankerHomePage(WebDriver obj){
		this.driver = obj;
	}
	
	//customers button
	public WebElement customersButton(){
		return driver.findElement(By.xpath("//img[@src='images/Customer_but.jpg']"));
	}
	
	//receipts button
	public WebElement receiptsButton(){
		return driver.findElement(By.xpath("//img[@src='images/Receipts_but.jpg']"));
	}
	
	//payments Button
	public WebElement paymentsButton(){
		return driver.findElement(By.xpath("//img[@src='images/Pay_but.jpg']"));
	}
	
	//click customers button
	public void clickCustomersButton(){
		this.customersButton().click();
	}
	
	//click receipts button
	public void clickReceiptsButton(){
		this.receiptsButton().click();
	}
	
	//click payments button
	public void clickPaymentsButton(){
		this.paymentsButton().click();
	}
}
