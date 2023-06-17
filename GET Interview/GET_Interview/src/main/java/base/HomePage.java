package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

@Test
public class HomePage {

	public WebDriver ChromeDriverObject;
	public Faker fake=new Faker();
	public String NewEmail = "test" + fake.number().digits(5) + "@gmail.com";
	public String Phone = fake.number().digits(11);

@BeforeMethod
public void Open() throws InterruptedException, IOException {
		
		System.setProperty("webdriver.chrome.driver","D:\\GET Interview\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriverObject = new ChromeDriver(options);
		Reporter.log("Chrome browser is opened");
		
		Properties properties = new Properties();
		FileInputStream inputstream = new FileInputStream("D:\\GET Interview\\GET_Interview\\Properties\\testdata.properties");
		properties.load(inputstream);
		ChromeDriverObject.navigate().to(properties.getProperty("url"));
		ChromeDriverObject.manage().window().maximize();
		Reporter.log("Chrome browser is maximized");
	}
}
