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
		System.out.println("qwe");
		String title= driver.getTitle();
		System.out.println(title);
		driver.close();
	}

}
