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
		Assert.assertEquals(driver.findElement(By.xpath("//a[@onclick='logout()']")).getText(), "�ǳ�");
		
		driver.findElement(By.xpath("//span[contains(text(),'��Ʒ����')]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'��Ŀ����')]")));
		driver.findElement(By.xpath("//span[contains(text(),'��Ŀ����')]")).click();
		
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
		
		//��Ŀ����  
		//TODO this is tricky element that has no response to any mouse click of webdriver
		WebElement element = driver.findElement(By.xpath(".//td[contains(.,'��Ŀ����')]/following-sibling::td[1]//input[@id='projectSecondaryCat$text']"));
		
		Actions action = new Actions(driver);
		action.moveToElement(element).click().perform();
		element.click();
		WebElement chooseElement = driver.findElement(By.xpath(".//span[contains(text(),'���ز����')]"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//span[contains(text(),'���ز����')]")));
		chooseElement.click();
		//chooseItem(element, chooseElement);
		//ֱ�Ӹ���Ŀ���͸�ֵ
		//js.executeScript("arguments[0].value = '���ز� - ���ز����';", element);
		//js.executeScript("arguments[0].click();", driver.findElement(By.xpath(".//span[contains(text(),'���ز����')]")));
		//��Ŀ��Դ
		driver.findElement(By.xpath(".//td[contains(.,'��Ŀ��Դ')]/following-sibling::td[1]//span[@class='mini-buttonedit-buttons']")).click();
		driver.findElement(By.xpath(".//td[contains(text(),'�ⲿɸѡ')]")).click();
		
		//��Ŀ����
		driver.findElement(By.xpath(".//td[contains(.,'��Ŀ����')]/following-sibling::td[1]//span[@class='mini-buttonedit-buttons']")).click();
		driver.findElement(By.xpath(".//td[contains(text(),'��Ԫ')]")).click();
		
		//��������
		driver.findElement(By.xpath(".//td[contains(.,'��������')]/following-sibling::td[1]//span[@class='mini-buttonedit-buttons']")).click();
		driver.findElement(By.xpath(".//td[contains(text(),'�Ƹ�ҵ��')]")).click();
		
		//Ŀ��ļ�ʹ�ģ
		driver.findElement(By.xpath(".//*[@id='targetCollectionScale$text']")).sendKeys("1000");
		//���ļ�ʹ�ģ
		driver.findElement(By.xpath(".//*[@id='lowerLimitCollectionScale$text']")).sendKeys("1000");
		//ҵ���������
		driver.findElement(By.xpath(".//td[contains(.,'ҵ���������')]/following-sibling::td[1]//span[@class='mini-buttonedit-buttons']")).click();
		driver.findElement(By.xpath(".//td[text()='�Ƹ�']")).click();
		//��Ŀ�Ŷ�
		driver.findElement(By.xpath(".//td[contains(.,'��Ŀ�Ŷ�')]/following-sibling::td[1]//span[@class='mini-buttonedit-buttons']")).click();
		driver.findElement(By.xpath(".//td[contains(text(),'Ͷ��һ��')]")).click();
		
		
		//��Ŀ�ṹ
		driver.findElement(By.xpath(".//td[contains(.,'��Ŀ�ṹ')]/following-sibling::td[1]//span[@class='mini-buttonedit-buttons']")).click();
		driver.findElement(By.xpath(".//td[contains(text(),'����')]")).click();
		
		//Ȩ��ṹ
		driver.findElement(By.xpath(".//td[contains(.,'Ȩ��ṹ')]/following-sibling::td[1]//span[@class='mini-buttonedit-buttons']")).click();
		driver.findElement(By.xpath(".//td[contains(text(),'��Ȩ')]")).click();
		
		//��Ʒ����
		//driver.findElement(By.xpath(".//td[contains(.,'��Ʒ����')]/following-sibling::td[1]//span[@class='mini-buttonedit-buttons']")).click();
		//driver.findElement(By.xpath(".//span[contains(text(),'���ز����')]")).click();
		
		//��Ʒ�ܼ�
		driver.findElement(By.xpath(".//td[contains(.,'��Ʒ�ܼ�')]/following-sibling::td[1]//span[@class='mini-buttonedit-buttons']")).click();
		driver.findElement(By.xpath(".//*[@id='keyword2$text']")).sendKeys("4777");
		driver.findElement(By.xpath("//span[@id='keyword2']/following-sibling::a/span[text()='��ѯ']")).click();
		driver.findElement(By.xpath(".//span[contains(text(),'����(lim4777)')]")).click();
		
		
		//�ڲ������������
		driver.findElement(By.xpath(".//*[@id='inCreditRate$text']")).sendKeys("test");
		//�ⲿ�����������
		driver.findElement(By.xpath(".//*[@id='exCreditRate$text']")).sendKeys("test");
		
		//����˵��
		driver.findElement(By.xpath(".//*[@id='durationDesc$text']")).sendKeys("test");
		
		//��Ŀ����
		driver.findElement(By.xpath(".//*[@id='projectSwot$text']")).sendKeys("test");
		
		//�ʽ���;
		driver.findElement(By.xpath(".//*[@id='fundsUsage$text']")).sendKeys("test");
		//Ͷ�ʷ�Χ&����
		driver.findElement(By.xpath(".//*[@id='investStraScop$text']")).sendKeys("test");
		//�ؿ���Դ
		driver.findElement(By.xpath(".//*[@id='crSource$text']")).sendKeys("test");
		
		
		
		//2.���׽ṹͼ
		driver.findElement(By.xpath(".//*[@id='uploadTradeChart']/span")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath(".//iframe[contains(@src,'projectUploadFile')]")));
		//driver.findElement(By.xpath(".//*[@id='uploadTradeChart']/span")).click();
		//driver.findElement(By.xpath(".//td[contains(.,'��������')]/following-sibling::td[1]//span[@class='mini-buttonedit-buttons']")).click();
		driver.findElement(By.xpath(".//td[contains(.,'��������')]/following-sibling::td[1]//span[@class='mini-buttonedit-buttons']")).click();
		driver.findElement(By.xpath(".//td[contains(text(),'���׽ṹͼ')]")).click();		
		
		
		WebElement file = driver.findElement(By.cssSelector("input[type='file']"));
		js.executeScript("arguments[0].display = 'none'", file);
		
		file.sendKeys("E:\\Alex\\�������\\Selenium\\webdriver�ܹ�ͼ.png");
		driver.findElement(By.xpath(".//span[contains(text(),'�ϴ�����')]")).click();
		//wait for upload completed
		//sleep(30);
		
		
		//3.��Ա��Ϣ
		driver.switchTo().defaultContent();
		//switch to frame xpath => ".//*[@id='mini-7$body$1']/iframe"
		driver.switchTo().frame(driver.findElement(By.cssSelector("#mainframe")));		
		driver.switchTo().frame(driver.findElement(By.xpath(".//*[@id='tabs']//iframe[contains(@src,'cbs/product/projectMgmt/project/project')]")));
		driver.switchTo().frame(driver.findElement(By.xpath(".//iframe[contains(@src,'projectInfo')]")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//*[@id='operateChartBtn']/span")));
		
		driver.findElement(By.xpath(".//*[@id='addUserInfoBtns']/span")).click();
		
		driver.findElement(By.xpath("(//div[@id='userInfoGrid']//div[@class='mini-grid-rows-view']//tr[3]//input[@type='text'])[1]")).click();
		driver.findElement(By.xpath(".//*[@id='keyword3$text']")).sendKeys("4566");
		driver.findElement(By.xpath("//span[@id='keyword3']/following-sibling::a/span[text()='��ѯ']")).click();
		driver.findElement(By.xpath(".//span[contains(text(),'������(hzy4566)')]")).click();
		
		
		driver.findElement(By.xpath("(//div[@id='userInfoGrid']//div[@class='mini-grid-rows-view']//tr[3]//input[@type='text'])[2]")).click();
		driver.findElement(By.xpath(".//td[contains(text(),'��Ʒ���')]")).click();
		
		driver.findElement(By.xpath("(//div[@id='userInfoGrid']//div[@class='mini-grid-rows-view']//tr[3]//input[@type='text'])[3]")).sendKeys("11");;
	
		//�����Ա2
		driver.findElement(By.xpath(".//*[@id='addUserInfoBtns']/span")).click();
		driver.findElement(By.xpath("(//div[@id='userInfoGrid']//div[@class='mini-grid-rows-view']//tr[3]//input[@type='text'])[1]")).click();
		driver.findElement(By.xpath(".//*[@id='keyword3$text']")).clear();
		driver.findElement(By.xpath(".//*[@id='keyword3$text']")).sendKeys("3553");
		driver.findElement(By.xpath("//span[@id='keyword3']/following-sibling::a/span[text()='��ѯ']")).click();
		driver.findElement(By.xpath(".//span[contains(text(),'����(zhb3553)')]")).click();
		
		sleep(3);
		driver.findElement(By.xpath("(//div[@id='userInfoGrid']//div[@class='mini-grid-rows-view']//tr[3]//input[@type='text'])[2]")).click();
		sleep(2);
		//driver.findElement(By.xpath(".//table[@class='mini-listbox-items']//td[contains(text(),'��Ʒ���')]")).click();
		findVisibleElement(By.xpath(".//table[@class='mini-listbox-items']//td[contains(text(),'��Ʒ���')]")).click();
		driver.findElement(By.xpath("(//div[@id='userInfoGrid']//div[@class='mini-grid-rows-view']//tr[3]//input[@type='text'])[3]")).sendKeys("11");;
	
		
		//ɾ����Ա
		WebElement row = driver.findElement(By.xpath("//div[@id='userInfoGrid']//div[@class='mini-grid-rows-view']//tr[4]"));
		//Actions action = new Actions(driver);
		action.moveToElement(row).perform();
		row.findElement(By.xpath(".//span[text()='ɾ��']")).click();
		
		//ȷ��
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath(".//*[@class='mini-messagebox-buttons']//span[contains(text(),'ȷ��')]")).click();
		
			
		//switch to frame xpath => ".//*[@id='mini-7$body$1']/iframe"
		driver.switchTo().frame(driver.findElement(By.cssSelector("#mainframe")));		
		driver.switchTo().frame(driver.findElement(By.xpath(".//*[@id='tabs']//iframe[contains(@src,'cbs/product/projectMgmt/project/project')]")));
		driver.switchTo().frame(driver.findElement(By.xpath(".//iframe[contains(@src,'projectInfo')]")));						
		//��Ŀ�������׶�����Ϣ
		driver.findElement(By.xpath("(//div[@id='bizOrgListGrid']//div[@class='mini-grid-rows-view']//tr[2]//input[@type='text'])[1]")).click();
		driver.findElement(By.xpath(".//*[@id='keyText2$text']")).sendKeys("����");
		driver.findElement(By.xpath("//span[@id='keyText2']/following-sibling::a/span[text()='����']")).click();
		driver.findElement(By.xpath(".//div[contains(text(),'ŵ�»���')]")).click();
		
		driver.findElement(By.xpath("(//div[@id='bizOrgListGrid']//div[@class='mini-grid-rows-view']//tr[3]//input[@type='text'])[1]")).click();
		driver.findElement(By.xpath(".//*[@id='keyText2$text']")).clear();
		driver.findElement(By.xpath("//span[@id='keyText2']/following-sibling::a/span[text()='����']")).click();
		sleep(3);
		driver.findElement(By.xpath(".//*[@id='keyText2$text']")).clear();
		driver.findElement(By.xpath(".//*[@id='keyText2$text']")).sendKeys("����");
		sleep(1);
		driver.findElement(By.xpath("//span[@id='keyText2']/following-sibling::a/span[text()='����']")).click();
		sleep(2);
		driver.findElement(By.xpath(".//div[contains(text(),'ŵ�»���')]")).click();


		//�������
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
