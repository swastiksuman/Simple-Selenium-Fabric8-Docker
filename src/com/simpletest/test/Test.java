package com.simpletest.test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.apache.commons.io.FileUtils;

public class Test {
	public static void main(String[] args) throws InterruptedException, IOException {
		DesiredCapabilities desCaps = DesiredCapabilities.firefox();
		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4545/wd/hub"), desCaps);
		driver.get("https://www.google.co.in/");
		Thread.sleep(30000);
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("screenshot.png"));
		driver.close();
		driver.quit();
	}
}
