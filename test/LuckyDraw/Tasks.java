package LuckyDraw;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



import org.testng.annotations.Test;

import basic.TestData;

public class Tasks {
	
	@Test
	public void baiduSearch()
	{
		HashMap<String, String> testdata = TestData.getTestData("ËÑË÷");
		WebDriver dr = new FirefoxDriver();
		
		dr.get("http://www.baidu.com");		
		WebDriverWait wait = new WebDriverWait(dr, 5);
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe")));
			dr.switchTo().frame(dr.findElement(By.xpath("//iframe")));
		}
		catch (Exception e){
			e.printStackTrace();
			
		}
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#kw")));
	
		
		// find element and type webdriver
		dr.findElement(By.id("kw")).sendKeys(testdata.get("¹Ø¼ü´Ê"));
		dr.findElement(By.id("su")).click();
		//This is JS way to check for document is ready - It reads document and check readyState flag to be equal to complete
		//waitForLoad(dr);
	
		//µÈ´ýÁ½Ãë
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		String url = dr.getCurrentUrl();		
		System.out.println(url);
		dr.switchTo().defaultContent();		
		dr.quit();	
		
	}

}
