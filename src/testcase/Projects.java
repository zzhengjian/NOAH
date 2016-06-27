package testcase;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Projects {
	
	public WebDriver driver;

	
	String name = "";
	
	@AfterTest
	public void tearDown()
	{
		if(driver != null)
			driver.quit();
		
	}	
	
		
	@Test
	public void addProject()
	{
		
		driver = new ChromeDriver();	
		WebDriverWait wait = new WebDriverWait(driver, 50000);
		driver.get("http://10.4.168.175:8080/cbs/personal/index.jsp");
		driver.manage().timeouts().implicitlyWait(30000, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		//login
		
		driver.findElement(By.cssSelector("#accountId")).sendKeys("lhw1984");
		driver.findElement(By.cssSelector("#password")).sendKeys("any");
		driver.findElement(By.cssSelector(".btn.btn-lg.btn-primary.btn-block")).click();;
		
		
		
		//enter into project management
		//switch to left menu frame
		driver.switchTo().frame(driver.findElement(By.cssSelector("#leftMenu")));
		Assert.assertEquals(driver.findElement(By.xpath("//a[@onclick='logout()']")).getText(), "登出");
		
		driver.findElement(By.xpath("//span[contains(text(),'产品管理')]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'项目管理')]")));
		driver.findElement(By.xpath("//span[contains(text(),'项目管理')]")).click();
		
		driver.switchTo().defaultContent();
		//switch to frame xpath => ".//*[@id='mini-7$body$1']/iframe"
		driver.switchTo().frame(driver.findElement(By.cssSelector("#mainframe")));		
		driver.switchTo().frame(driver.findElement(By.xpath(".//*[@id='tabs']//iframe[contains(@src,'projectMgmt/project/projectList')]")));
		
		//create a new project
		driver.findElement(By.cssSelector("#newProjectBtns")).click();
		
		driver.switchTo().defaultContent();
		//switch to frame xpath => ".//*[@id='mini-7$body$1']/iframe"
		driver.switchTo().frame(driver.findElement(By.cssSelector("#mainframe")));		
		driver.switchTo().frame(driver.findElement(By.xpath(".//*[@id='tabs']//iframe[contains(@src,'cbs/product/projectMgmt/project/project')]")));
		driver.switchTo().frame(driver.findElement(By.xpath(".//iframe[contains(@src,'projectInfo')]")));
		
		driver.findElement(By.xpath(".//*[@name='projectName']")).sendKeys("test002");
		
		//项目类型  
		//TODO this is tricky element that has no response to any mouse click of webdriver
		WebElement element = driver.findElement(By.xpath(".//td[contains(.,'项目类型')]/following-sibling::td[1]//input[@id='projectSecondaryCat$text']"));
		
		Actions action = new Actions(driver);
		action.moveToElement(element).click().perform();
		element.click();
		WebElement chooseElement = driver.findElement(By.xpath(".//span[contains(text(),'房地产混合')]"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//span[contains(text(),'房地产混合')]")));
		chooseElement.click();
		//chooseItem(element, chooseElement);
		//直接给项目类型赋值
		//js.executeScript("arguments[0].value = '房地产 - 房地产混合';", element);
		//js.executeScript("arguments[0].click();", driver.findElement(By.xpath(".//span[contains(text(),'房地产混合')]")));
		//项目来源
		driver.findElement(By.xpath(".//td[contains(.,'项目来源')]/following-sibling::td[1]//span[@class='mini-buttonedit-buttons']")).click();
		driver.findElement(By.xpath(".//td[contains(text(),'外部筛选')]")).click();
		
		//项目币种
		driver.findElement(By.xpath(".//td[contains(.,'项目币种')]/following-sibling::td[1]//span[@class='mini-buttonedit-buttons']")).click();
		driver.findElement(By.xpath(".//td[contains(text(),'美元')]")).click();
		
		//销售渠道
		driver.findElement(By.xpath(".//td[contains(.,'销售渠道')]/following-sibling::td[1]//span[@class='mini-buttonedit-buttons']")).click();
		driver.findElement(By.xpath(".//td[contains(text(),'财富业资')]")).click();
		
		//目标募资规模
		driver.findElement(By.xpath(".//*[@id='targetCollectionScale$text']")).sendKeys("1000");
		//最低募资规模
		driver.findElement(By.xpath(".//*[@id='lowerLimitCollectionScale$text']")).sendKeys("1000");
		//业务所属板块
		driver.findElement(By.xpath(".//td[contains(.,'业务所属板块')]/following-sibling::td[1]//span[@class='mini-buttonedit-buttons']")).click();
		driver.findElement(By.xpath(".//td[text()='财富']")).click();
		//项目团队
		driver.findElement(By.xpath(".//td[contains(.,'项目团队')]/following-sibling::td[1]//span[@class='mini-buttonedit-buttons']")).click();
		driver.findElement(By.xpath(".//td[contains(text(),'投行一部')]")).click();
		
		
		//项目结构
		driver.findElement(By.xpath(".//td[contains(.,'项目结构')]/following-sibling::td[1]//span[@class='mini-buttonedit-buttons']")).click();
		driver.findElement(By.xpath(".//td[contains(text(),'信托')]")).click();
		
		//权益结构
		driver.findElement(By.xpath(".//td[contains(.,'权益结构')]/following-sibling::td[1]//span[@class='mini-buttonedit-buttons']")).click();
		driver.findElement(By.xpath(".//td[contains(text(),'股权')]")).click();
		
		//产品经理
		//driver.findElement(By.xpath(".//td[contains(.,'产品经理')]/following-sibling::td[1]//span[@class='mini-buttonedit-buttons']")).click();
		//driver.findElement(By.xpath(".//span[contains(text(),'房地产混合')]")).click();
		
		//产品总监
		driver.findElement(By.xpath(".//td[contains(.,'产品总监')]/following-sibling::td[1]//span[@class='mini-buttonedit-buttons']")).click();
		driver.findElement(By.xpath(".//*[@id='keyword2$text']")).sendKeys("4777");
		driver.findElement(By.xpath("//span[@id='keyword2']/following-sibling::a/span[text()='查询']")).click();
		driver.findElement(By.xpath(".//span[contains(text(),'李萌(lim4777)')]")).click();
		
		
		//内部信用评级结果
		driver.findElement(By.xpath(".//*[@id='inCreditRate$text']")).sendKeys("test");
		//外部信用评级结果
		driver.findElement(By.xpath(".//*[@id='exCreditRate$text']")).sendKeys("test");
		
		//期限说明
		driver.findElement(By.xpath(".//*[@id='durationDesc$text']")).sendKeys("test");
		
		//项目简述
		driver.findElement(By.xpath(".//*[@id='projectSwot$text']")).sendKeys("test");
		
		//资金用途
		driver.findElement(By.xpath(".//*[@id='fundsUsage$text']")).sendKeys("test");
		//投资范围&策略
		driver.findElement(By.xpath(".//*[@id='investStraScop$text']")).sendKeys("test");
		//回款来源
		driver.findElement(By.xpath(".//*[@id='crSource$text']")).sendKeys("test");
		
		
		
		//2.交易结构图
		driver.findElement(By.xpath(".//*[@id='uploadTradeChart']/span")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath(".//iframe[contains(@src,'projectUploadFile')]")));
		//driver.findElement(By.xpath(".//*[@id='uploadTradeChart']/span")).click();
		//driver.findElement(By.xpath(".//td[contains(.,'附件类型')]/following-sibling::td[1]//span[@class='mini-buttonedit-buttons']")).click();
		driver.findElement(By.xpath(".//td[contains(.,'附件类型')]/following-sibling::td[1]//span[@class='mini-buttonedit-buttons']")).click();
		driver.findElement(By.xpath(".//td[contains(text(),'交易结构图')]")).click();		
		
		
		WebElement file = driver.findElement(By.cssSelector("input[type='file']"));
		js.executeScript("arguments[0].display = 'none'", file);
		
		file.sendKeys("E:\\Alex\\软件测试\\Selenium\\webdriver架构图.png");
		driver.findElement(By.xpath(".//span[contains(text(),'上传附件')]")).click();
		//wait for upload completed
		//sleep(30);
		
		
		//3.人员信息
		driver.switchTo().defaultContent();
		//switch to frame xpath => ".//*[@id='mini-7$body$1']/iframe"
		driver.switchTo().frame(driver.findElement(By.cssSelector("#mainframe")));		
		driver.switchTo().frame(driver.findElement(By.xpath(".//*[@id='tabs']//iframe[contains(@src,'cbs/product/projectMgmt/project/project')]")));
		driver.switchTo().frame(driver.findElement(By.xpath(".//iframe[contains(@src,'projectInfo')]")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//*[@id='operateChartBtn']/span")));
		
		driver.findElement(By.xpath(".//*[@id='addUserInfoBtns']/span")).click();
		
		driver.findElement(By.xpath("(//div[@id='userInfoGrid']//div[@class='mini-grid-rows-view']//tr[3]//input[@type='text'])[1]")).click();
		driver.findElement(By.xpath(".//*[@id='keyword3$text']")).sendKeys("4566");
		driver.findElement(By.xpath("//span[@id='keyword3']/following-sibling::a/span[text()='查询']")).click();
		driver.findElement(By.xpath(".//span[contains(text(),'何张易(hzy4566)')]")).click();
		
		
		driver.findElement(By.xpath("(//div[@id='userInfoGrid']//div[@class='mini-grid-rows-view']//tr[3]//input[@type='text'])[2]")).click();
		driver.findElement(By.xpath(".//td[contains(text(),'产品设计')]")).click();
		
		driver.findElement(By.xpath("(//div[@id='userInfoGrid']//div[@class='mini-grid-rows-view']//tr[3]//input[@type='text'])[3]")).sendKeys("11");;
	
		//添加人员2
		driver.findElement(By.xpath(".//*[@id='addUserInfoBtns']/span")).click();
		driver.findElement(By.xpath("(//div[@id='userInfoGrid']//div[@class='mini-grid-rows-view']//tr[3]//input[@type='text'])[1]")).click();
		driver.findElement(By.xpath(".//*[@id='keyword3$text']")).clear();
		driver.findElement(By.xpath(".//*[@id='keyword3$text']")).sendKeys("3553");
		driver.findElement(By.xpath("//span[@id='keyword3']/following-sibling::a/span[text()='查询']")).click();
		driver.findElement(By.xpath(".//span[contains(text(),'张蓓(zhb3553)')]")).click();
		
		sleep(3);
		driver.findElement(By.xpath("(//div[@id='userInfoGrid']//div[@class='mini-grid-rows-view']//tr[3]//input[@type='text'])[2]")).click();
		sleep(2);
		//driver.findElement(By.xpath(".//table[@class='mini-listbox-items']//td[contains(text(),'产品设计')]")).click();
		findVisibleElement(By.xpath(".//table[@class='mini-listbox-items']//td[contains(text(),'产品设计')]")).click();
		driver.findElement(By.xpath("(//div[@id='userInfoGrid']//div[@class='mini-grid-rows-view']//tr[3]//input[@type='text'])[3]")).sendKeys("11");;
	
		
		//删除人员
		WebElement row = driver.findElement(By.xpath("//div[@id='userInfoGrid']//div[@class='mini-grid-rows-view']//tr[4]"));
		//Actions action = new Actions(driver);
		action.moveToElement(row).perform();
		row.findElement(By.xpath(".//span[text()='删除']")).click();
		
		//确定
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath(".//*[@class='mini-messagebox-buttons']//span[contains(text(),'确定')]")).click();
		
			
		//switch to frame xpath => ".//*[@id='mini-7$body$1']/iframe"
		driver.switchTo().frame(driver.findElement(By.cssSelector("#mainframe")));		
		driver.switchTo().frame(driver.findElement(By.xpath(".//*[@id='tabs']//iframe[contains(@src,'cbs/product/projectMgmt/project/project')]")));
		driver.switchTo().frame(driver.findElement(By.xpath(".//iframe[contains(@src,'projectInfo')]")));						
		//项目关联交易对手信息
		driver.findElement(By.xpath("(//div[@id='bizOrgListGrid']//div[@class='mini-grid-rows-view']//tr[2]//input[@type='text'])[1]")).click();
		driver.findElement(By.xpath(".//*[@id='keyText2$text']")).sendKeys("机构");
		driver.findElement(By.xpath("//span[@id='keyText2']/following-sibling::a/span[text()='搜索']")).click();
		driver.findElement(By.xpath(".//div[contains(text(),'诺德机构')]")).click();
		
		driver.findElement(By.xpath("(//div[@id='bizOrgListGrid']//div[@class='mini-grid-rows-view']//tr[3]//input[@type='text'])[1]")).click();
		driver.findElement(By.xpath(".//*[@id='keyText2$text']")).clear();
		driver.findElement(By.xpath("//span[@id='keyText2']/following-sibling::a/span[text()='搜索']")).click();
		sleep(3);
		driver.findElement(By.xpath(".//*[@id='keyText2$text']")).clear();
		driver.findElement(By.xpath(".//*[@id='keyText2$text']")).sendKeys("机构");
		sleep(1);
		driver.findElement(By.xpath("//span[@id='keyText2']/following-sibling::a/span[text()='搜索']")).click();
		sleep(2);
		driver.findElement(By.xpath(".//div[contains(text(),'诺德机构')]")).click();


		//点击保存
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.cssSelector("#mainframe")));		
		driver.switchTo().frame(driver.findElement(By.xpath(".//*[@id='tabs']//iframe[contains(@src,'cbs/product/projectMgmt/project/project')]")));
		
		driver.findElement(By.xpath(".//*[@id='conserveBtn2']/span")).click();
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.cssSelector("#mainframe")));
		driver.findElement(By.xpath(".//*[contains(@class,'mini-tab-close')]")).click();
	}
	
	void sleep(int seconds)
	{
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	WebElement findVisibleElement(By by)
	{
		WebElement visibleElement = null;
		List<WebElement> elements = driver.findElements(by);
		
		for(WebElement e : elements)
		{
			if(e.isDisplayed())
			{
				visibleElement = e;
			}
		}
		
		return visibleElement;
	}


}
