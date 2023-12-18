package Login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginFunction {
	public static WebDriver driver;
	
	@Test
	  public void f() throws InterruptedException {
			driver.findElement(By.id("uid")).sendKeys("qatest@habile.in");
			driver.findElement(By.id("pwd")).sendKeys("Qatest123$");
			driver.findElement(By.id("login-button")).click();
			
			//Step2
			driver.findElement(By.linkText("Client")).click();
			driver.findElement(By.id("firstname")).sendKeys("Kantha");
			driver.findElement(By.id("middlename")).sendKeys("Vel");
			driver.findElement(By.id("lastname")).sendKeys("S");
			driver.findElement(By.id("mobileNo")).sendKeys("6365760012");
			//Thread.sleep(3000);	
			

			Thread.sleep(3000);
			WebElement gender=driver.findElement(By.linkText("--Select Gender--"));

			Actions action= new Actions(driver);
			action.click(gender).sendKeys("Male\n").build().perform();
			
			JavascriptExecutor js = (JavascriptExecutor)driver;
		    js.executeScript("window.scrollBy(0,5000)");
		    
		Thread.sleep(3000);
			
	
		driver.findElement(By.xpath("//button[@ng-click='addAddress()']")).click();
		
		js.executeScript("window.scroll(0,5000)");
		
		WebElement Address=driver.findElement(By.linkText("Select Address Type"));
		Actions  Addressact=new Actions(driver);
		Addressact.click(Address).sendKeys("Permanent\n").build().perform();
		
		
		Thread.sleep(2000);

		
		driver.findElement(By.name("street0")).sendKeys("1st");
		driver.findElement(By.name("addressline1")).sendKeys("Shivan Street");
		driver.findElement(By.name("addressline2")).sendKeys("Thiruvanmeyur");
		driver.findElement(By.name("addressline3")).sendKeys("600036");
		
		js.executeScript("window.scroll(0,6000)");
		
		Thread.sleep(2000);
		
     driver.findElement(By.xpath("//button[@id='save']")).click();
     System.out.println("login Sucessful");

		
	
		
		Thread.sleep(2000);
   
		
		WebElement actdate= driver.findElement(By.xpath("//input[@min='mindate']"));
		Actions actdateobj= new Actions(driver);
		actdateobj.click(actdate).sendKeys("18 December 2023\n").build().perform();
		

		
		driver.findElement(By.xpath("//button[@has-permission='ACTIVATE_CLIENT']")).click();
		//page-01


		driver.findElement(By.xpath("//a[@has-permission='CREATE_LOAN']")).click();
		
		Thread.sleep(2000);
		
		WebElement product= driver.findElement(By.xpath("//select[@id='productId']"));
		product.click();
		Select productobj=new Select(product);
		productobj.selectByValue("number:76");
		
		
      WebElement Loanpurpose=driver.findElement(By.linkText("Select Type"));
      Loanpurpose.click();
      Select  loanobj=new Select(Loanpurpose);
      loanobj.selectByIndex(1);
      js.executeScript("window.scroll(0,6000)");
		
      driver.findElement(By.id("expectedDisbursementDate")).sendKeys("18 December 2023");
		
		
		
      
      WebElement repay=driver.findElement(By.linkText("Select Repayment Mode"));
       Actions repayact= new Actions(driver);
		action.click(repay).sendKeys("Cash/Cheque\n").build().perform();
		
		  driver.findElement(By.xpath("//button[@ng-hide='disabled']")).click();
      //page 2
		  
		  js.executeScript("window.scroll(0,-5000)");
      
      WebElement rapid=driver.findElement(By.id("repaymentFrequencyNthDayType"));
      rapid.click();
      Select rapidobj=new Select(rapid);
      rapidobj.selectByValue("number:1");

      
      WebElement days= driver.findElement(By.id("repaymentFrequencyDayOfWeekType"));
      Actions daysact=new Actions(driver);
      daysact.click(days).sendKeys("SUNDAY\n").build().perform();
      
      Thread.sleep(2000);
      driver.findElement(By.className("btn btn-default pull-right")).click();
      
      driver.findElement(By.id("new-lender")).sendKeys("Sivasankari");
      driver.findElement(By.xpath("//*[@id=\\\"mifos-reskin-body-view\\\"]/div/div/div/div[2]/div/div[3]/form/fieldset/button[2]")).click();

      
      //page 3
      js.executeScript("window.scroll(0,5000)");
      
      driver.findElement(By.xpath("//*[@id=\"mifos-reskin-body-view\"]/div/div/div/div[2]/div/div[4]/form/fieldset/button[2]")).click();
      
      Thread.sleep(1000);
      
      js.executeScript("window.scroll(0,5000)");
      driver.findElement(By.xpath("//button[@id='save']")).click();
      
	}
	
	
	@BeforeMethod
	  public WebDriver beforeMethod() {
		  WebDriverManager.chromedriver().setup();
		  driver= new ChromeDriver();
		  driver.get("https://qatest.uat.cloudbankin.com/");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		  
		 return driver;
		  
	  }

	  @AfterMethod
	  public void afterMethod() {
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  driver.close();
	  }
	  
	  }


