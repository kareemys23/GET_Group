package test;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.TakesScreenshot;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import base.HomePage;

public class Register extends HomePage{
	
	@Test
	public void signup() throws InterruptedException, IOException {
	//Entering valid data
		// Load the properties file
		Properties properties = new Properties();
		FileInputStream inputstream = new FileInputStream("D:\\GET Interview\\GET_Interview\\Properties\\testdata.properties");
		properties.load(inputstream);
		Reporter.log("Data is loaded from properties file.");

		// Retrieve the values from the properties file
		String fName = properties.getProperty("FName");
		String lName = properties.getProperty("LName");

		// Check if the FName value meets the requirements(Password requirements)
		if (fName.length() > 6) {
		    System.out.println("Error: FName must be 6 characters or less.");
		    return;
		}

		if (!fName.matches("^[A-Z][a-z]+$")) {
		    System.out.println("Error: FName must start with a capital letter, followed by small letters.");
		    return;
		}
		// Capitalize the first letter of the LName value
		lName = lName.substring(0, 1).toUpperCase() + lName.substring(1);
		// Validating FName value doesn't equal LName value
		if (fName.equalsIgnoreCase(lName)) {
		    System.out.println("Error: FName and LName cannot be the same.");
		    return;
		}
		Reporter.log("Data meets requirements");
		// Find the form fields using their XPaths and add values
		WebElement Fname_field = ChromeDriverObject.findElement(By.xpath("//input[@id='nf-field-17']"));
		Fname_field.sendKeys(fName);
		WebElement Lname_field = ChromeDriverObject.findElement(By.xpath("//input[@id='nf-field-18']"));
		Lname_field.sendKeys(lName);
		WebElement Email_field = ChromeDriverObject.findElement(By.xpath("//input[@id='nf-field-19']"));
		Email_field.sendKeys("kareemys23@gmail.com");
		WebElement Phone_field = ChromeDriverObject.findElement(By.xpath("//input[@id='nf-field-20']"));
		Phone_field.sendKeys(Phone);
		Reporter.log("Data entered");
	
		// Click the checkbox and registration button
		WebElement Check_field = ChromeDriverObject.findElement(By.xpath("//div[@id='nf-field-23-wrap']/div[2]/ul/li[3]/label"));
		Check_field.click();
		WebElement Register_btn = ChromeDriverObject.findElement(By.xpath("//input[@id='nf-field-15']"));
		Register_btn.click();

		// Wait for the response message and verify it
		Thread.sleep(15000);
		String actualString = ChromeDriverObject.findElement(By.xpath("//div[@class='nf-response-msg']")).getText();
		assertTrue(actualString.contains("completed"));
		File src1 = ((TakesScreenshot)ChromeDriverObject).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src1, new File("screenshots//screenshot1.png"));
		Reporter.log("Account registered!");
		System.out.println(actualString);
		Reporter.log("<a href=\"D:\\GET Interview\\GET_Interview\\screenshots\\screenshot1.png\">Screenshot</a>");
		ChromeDriverObject.quit();
}
	}
