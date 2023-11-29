package iteams;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class iteamsPrices extends parameters {

	WebDriver driver  =new ChromeDriver();
	
	
	@BeforeTest
	public void SetUp() {
		driver.manage().window().maximize();
		driver.get(URL);
		 WebElement userName=driver.findElement(By.id("user-name"));
		 WebElement passWord=driver.findElement(By.id("password"));
		 WebElement logIn=driver.findElement(By.id("login-button"));
		 userName.sendKeys(name);
		 passWord.sendKeys(password);
		 logIn.click();
		
	}
	@Test()
	public void PriceReview() {
		List <WebElement>priceIteams =driver.findElements(By.className("inventory_item_price"));
		for (int i=0;i<priceIteams.size();i++)
		{
			
		String	iteamPrice=priceIteams.get(i).getText().replace("$","");
		Double price =Double.parseDouble(iteamPrice);
		Double finalPrice=price +(price*.10);
		double roundedPrice = Math.ceil(finalPrice);
		
		if (roundedPrice % 2==0)
		{
			System.out.println("The final price is an Even number and the value of this price( "+finalPrice+" ) ");
		}
		else 
		{
			System.out.println("The final price is an odd number and the value of this price( "+finalPrice+" )");
		}
		
		}
		
	}
	@AfterTest
	public void PostTest () {
		  driver.quit();
	}
	
}
