package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class demotest {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","E:\\eclips projects\\Demo\\Driver\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
		System.out.println("welcome");
		System.out.println("test");
		System.out.println("test");
		System.out.println("test1");
<<<<<<< HEAD
		System.out.println("qwe");
=======
		System.out.println("1");
		System.out.println("2");
>>>>>>> dce3bcc6c9e1597d9d5fd3b722741d04c05f7639
		String title= driver.getTitle();
		System.out.println(title);
		driver.close();
	}

}
