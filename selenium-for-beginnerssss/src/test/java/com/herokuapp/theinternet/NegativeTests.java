package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;



public class NegativeTests {

	@Test(priority=1, groups = { "functest", "checkintest" })
	public void incorrectUsernameTest() {

		System.out.println("Starting incorrectUsernameTest");

//		Create driver
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

//		sleep for 3 seconds
		sleep(3000);

//		maximize browser window
		driver.manage().window().maximize();
	  
	   
	   
//		open test page
		String url = "http://the-internet.herokuapp.com/login";
		driver.get(url);
		System.out.println("Page is opened");

//		sleep for 3 seconds
//		sleep(2000);

//		enter username
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("IncorrectUserName");
//		sleep(2000);

//		enter password
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("SuperSecretPassword!");
		sleep(2000);

//		click login button
		WebElement logInButton = driver.findElement(By.tagName("button"));
		logInButton.click();
		sleep(2000);

//		Verifications
		WebElement errorMessage = driver.findElement(By.cssSelector("#flash"));
		String expectedErrorMessage = "Your username is invalid!";
		String actualErrorMessage = errorMessage.getText();
		Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage),
				"Actual error message does not contain expected. \nActual: " + actualErrorMessage + "\nExpected: "
						+ expectedErrorMessage);

//		Close browser
		driver.quit();
	}
		
		@Test(priority=2,enabled=false, groups = { "functest", "checkintest" })
		public void incorrectPasswordTest() {

			System.out.println("Starting incorrectPasswordTest");

//			Create driver
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			WebDriver driver = new ChromeDriver();

//			sleep for 3 seconds
			sleep(3000);

//			maximize browser window
			driver.manage().window().maximize();

//			open test page
			String url = "http://the-internet.herokuapp.com/login";
			driver.get(url);
			System.out.println("Page is opened");

//			sleep for 3 seconds
//			sleep(2000);

//			enter username
			WebElement username = driver.findElement(By.id("username"));
			username.sendKeys("tomsmith");
//			sleep(2000);

//			enter password
			WebElement password = driver.findElement(By.name("password"));
			password.sendKeys("incorrectPassword!");
			sleep(2000);

//			click login button
			WebElement logInButton = driver.findElement(By.tagName("button"));
			logInButton.click();
			sleep(2000);

//			Verifications
			WebElement errorMessage = driver.findElement(By.cssSelector("#flash"));
			String expectedErrorMessage = "Your password is invalid!";
			String actualErrorMessage = errorMessage.getText();
			Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage),
					"Actual error message does not contain expected. \nActual: " + actualErrorMessage + "\nExpected: "
							+ expectedErrorMessage);

//			Close browser
			driver.quit();
		
	}

	private void sleep(long m) {
		try {
			Thread.sleep(m);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
