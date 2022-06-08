package reports;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Reports {

	static WebDriver driver = null;
	static WebDriverWait wait = null;

	@Test (priority = 0)
			
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\chromedriver_102.exe");
		driver = new ChromeDriver();
		driver.get("https://online.actitime.com/cisco3/login.do");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 30);
	}

	@Test  (priority = 1)
	public void login() {
		driver.findElement(By.id("username")).sendKeys("vk.santhu@gmail.com");
		driver.findElement(By.xpath("//body[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/table[1]/tbody[1]/tr[5]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[2]/td[1]/input[1]")).sendKeys("JqZ9tqE$");
		driver.findElement(By.cssSelector("#keepLoggedInCheckBox")).click();
		driver.findElement(By.xpath("//body[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/table[1]/tbody[1]/tr[5]/td[1]/table[1]/tbody[1]/tr[2]/td[1]/table[1]/tbody[1]/tr[1]/td[3]/a[1]/div[1]")).click();
	}
	
	@Test  (priority = 2)
	public void createreport() throws InterruptedException {
		
		//reports  text name print out in console
		SoftAssert sf=new SoftAssert();
		System.out.println(driver.findElement(By.xpath("//a[div[@id='container_reports']]")).getText());
		//click on reports header part in actitime application
		driver.findElement(By.xpath("//a[div[@id='container_reports']]")).click();
		//result dashbord title is present in the console  output
		System.out.println(driver.findElement(By.xpath("//div[text()='Reports Dashboard']")).getText());
		//compared on title of result dashborad title
		sf.assertEquals("Reports Dashboard", driver.findElement(By.xpath("//div[text()='Reports Dashboard']")).getText());
		//softassert is used for compared the title is failed but not stop the execution
		sf.assertAll();
		//select the all button in  drop down view all
		driver.findElement(By.xpath("//div[@class='components-Dropdown-trigger--1w6PGjU6']")).click();

		sf.assertEquals("Quick Shortcuts to Reports & Charts",driver.findElement(By.xpath("//div[@class='containers-WidgetsDashboard-ShortcutsSection-title--p0BCITOJ']")).getText());
		sf.assertAll();
		//xpath of  whole box customer filed reports title
		driver.findElement(By.xpath("//div[@class='containers-WidgetsDashboard-ShortcutsSection-Shortcut-clickableArea--1jf2LP8N']")).click();
		//print out in console customer filed title
		System.out.println(driver.findElement(By.xpath("//body/div[@id='atNextMount']/div[@id='atNextAppRoot']/div[1]/div[1]/div[1]/div[2]")).getText());
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//body/div[@id='atNextMount']/div[@id='atNextAppRoot']/div[1]/div[1]/div[1]/div[2]")).click();

		//driver.findElement(By.xpath("//div[@class='components-GroupedMultiSelector-text--3TjVcfi1']")).click();
		driver.findElement(By.xpath("(//div[contains(@class,'components-Dropdown')])[6]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@type='radio'])[3]")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("(//span[@class='components-Checkbox-checkbox--1d3LRPa8 components-Checkbox-listbox--1AaAkHuc'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()='Apply']")).click();

		Thread.sleep(2000);
		
		driver.findElement(By.id("logoutLink")).click();
		Thread.sleep(2000);
		driver.close();

	}
}