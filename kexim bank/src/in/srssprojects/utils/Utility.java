package in.srssprojects.utils;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Utility {
	static boolean status = false;

	public static void webTable(WebDriver driver, By tableLoc, String data, String operation) {
		boolean flag = false;
		WebElement table = driver.findElement(tableLoc);
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		String[] pageLinks = rows.get(rows.size() - 1).getText().split(" ");
		for (int i = 1; i < pageLinks.length; i++) {
			table = driver.findElement(tableLoc);
			rows = table.findElements(By.tagName("tr"));
			for (WebElement row : rows) {
				List<WebElement> cells = row.findElements(By.tagName("td"));
				for (WebElement cell : cells) {
					if (cells.get(0).getText().equalsIgnoreCase(data)) {
						if (operation.equalsIgnoreCase("update")) {
							// update operation
							cells.get(cells.size() - 2).findElement(By.tagName("a")).click();
						} else if (operation.equalsIgnoreCase("delete")) {
							// delete operation
							cells.get(cells.size() - 1).findElement(By.tagName("a")).click();
						}
						flag = true;
						break;// cells
					}

				}
				if (flag == true) {
					break;// rows
				}
			}
			if(flag==true){
				status = false;
				break;//pages
			}

			try {
				if (pageLinks[i].equals("...") && status == true) {
					// xpath to click on second ...
					table.findElement(By.xpath(".//a[text()='...'][2]")).click();

				} else {
					table.findElement(By.linkText(pageLinks[i])).click();
				}
			} catch (Exception e) {

			}
			if (pageLinks[i].equals("...")) {
				status = true;
				webTable(driver, tableLoc, data, operation);
			}
		}
	}
	

	public static String getSysTime() {
		Date d = new Date();
		DateFormat df = new SimpleDateFormat("yy_MMM_dd hh_mm_ss");
		String date = df.format(d);
		return date;
	}

	// take screenshot
	public static void captureScreen(WebDriver driver,String fileName) {
		try {
			File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(file, new File("./screens//" + fileName + " " + getSysTime() + ".png"));
		} catch (Exception e) {

		}
	}

	// robot class
	public static String alertScreenCapture(String fileName) {
		try {
			String path = "\\Users\\surya\\Documents\\ATC Batch2\\"+fileName+" "+getSysTime()+".png";
			Robot r = new Robot();
			BufferedImage bi = r.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			ImageIO.write(bi,"png", new File(path));
			return path;
		} catch (Exception e) {
			return null;
		}
	}

	

}
