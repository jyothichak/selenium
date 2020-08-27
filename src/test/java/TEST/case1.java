package TEST;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class case1 {


@Test
public void negativeLogin() {
WebDriverManager.chromedriver().setup();

	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	WebDriverWait wait= new WebDriverWait(driver,30); 
	driver.get("http://magento.com");
	driver.findElement(By.xpath("//*[@id=\"block-header\"]/ul/li[9]/a/span[1]/div")).click();
	driver.findElement(By.id("email")).sendKeys("jyothi.mi3@gmail.com");
	driver.findElement(By.id("pass")).sendKeys("selenium");
	driver.findElement(By.id("send2")).click();
	//Thread.sleep(10000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div")));
	String error =driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div")).getText();
	System.out.println("Error message:"+error);	
	Assert.assertEquals(error, "Invalid login or password.");
	driver.quit();
}

@Test
public void registation() {
	WebDriverManager.chromedriver().setup();
WebDriver driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	//WebDriverWait wait = new WebDriverWait(driver,30);
	driver.get("http://magento.com");
	driver.findElement(By.xpath("//*[@id=\"block-header\"]/ul/li[9]/a/span[1]/div")).click();
	driver.findElement(By.id("register")).click();
	driver.findElement(By.id("firstname")).sendKeys("jyothi");
	driver.findElement(By.id("lastname")).sendKeys("chak");
	driver.findElement(By.id("email_address")).sendKeys("click@gmail.com");
	driver.findElement(By.id("password")).sendKeys("Myselenium@1");


	Select type=new Select(driver.findElement(By.id("company_type")));
	type.selectByIndex(2);
	//type.selectByValue("development");
	//type.selectByVisibleText("Develops Magento extensions");
	Select role=new Select(driver.findElement(By.id("individual_role")));
	role.selectByValue("technical/developer");
	Select country = new Select(driver.findElement(By.id("country")));
	country.selectByVisibleText("India");





	driver.findElement(By.id("password-confirmation")).sendKeys("Myselenium@1");


	//driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"msp-recaptcha-d84b65fc916e7398083ea5f17089d8f1\"]/div/div/iframe")).click();
	//driver.findElement(By.xpath("/html/body))"
	driver.switchTo().defaultContent();
	if(! driver.findElement(By.id("agree_terms")).isSelected()){
	driver.findElement(By.id("agree_terms")).click();
	
	}}}
