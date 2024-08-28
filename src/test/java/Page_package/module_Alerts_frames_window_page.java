package Page_package;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class module_Alerts_frames_window_page 
{	
	
	public WebDriver driver;
	public JavascriptExecutor js;
	public WebDriverWait wait;
	
	
	@FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div/div[3]/div/div[3]")
	WebElement alerts_frames_windowElement;
	
	
	@FindBy(xpath = "/html/body/div[2]/div/div/div/div[1]/div/div/div[3]/div/ul/li[1]/span")
	WebElement broser_window;
	
	
	@FindBy(xpath = "//*[@id=\"tabButton\"]")
	WebElement new_tab; 
	
	@FindBy(xpath = "//*[@id=\"windowButton\"]")
	WebElement new_window;
	
	@FindBy(xpath = "//*[@id=\"messageWindowButton\"]")
	WebElement alert_window;
	
	@FindBy(xpath = "/html/body/div[2]/div/div/div/div[1]/div/div/div[3]/div/ul/li[2]")
	WebElement Alerts_page;
	
	@FindBy(xpath = "//*[@id=\"alertButton\"]")
	WebElement click_me_see_alert;
	
	@FindBy(xpath = "//*[@id=\"timerAlertButton\"]")
	WebElement click_me_see_5ses_alert;
	
	@FindBy(xpath = "//*[@id=\"confirmButton\"]")
	WebElement confirmButton;
	
	@FindBy(xpath = "//*[@id=\"promtButton\"]")
	WebElement promtButton;
	
	@FindBy(xpath = "/html/body/div[2]/div/div/div/div[1]/div/div/div[3]/div/ul/li[3]/span")
	WebElement frame_page;
	
	@FindBy(xpath = "/html/body/div[2]/div/div/div/div[1]/div/div/div[3]/div/ul/li[4]/span")
	WebElement nested_frame_page;
	
	
	
	public module_Alerts_frames_window_page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void alerts_frames_windowElement() throws Throwable
	{ 
		js=(JavascriptExecutor) driver;
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));

        System.out.println(">>>>>ENTERING Alerts_Frame_Windows MODULE PAGE<<<<<");
		//Thread.sleep(3000);
		js.executeScript("arguments[0].scrollIntoView(true);", alerts_frames_windowElement);
		alerts_frames_windowElement.click();
        System.out.println("----successfully loaded");
		System.out.println("\nOpening Browser Window page...");
		js.executeScript("arguments[0].scrollIntoView(true);", broser_window);
		wait.until(ExpectedConditions.elementToBeClickable(broser_window));
		broser_window.click();
		System.out.println("Clicking New Tab button...");
		js.executeScript("arguments[0].scrollIntoView(true);", new_tab);
		String parentTab = driver.getWindowHandle();

		new_tab.click();
		ArrayList<String> tablist= new ArrayList<>(driver.getWindowHandles());
		//Thread.sleep(2000);
		
		driver.switchTo().window(tablist.get(1));
		
	//	Thread.sleep(5000);
		String t1=driver.getTitle();
		System.out.println("Title of new tab: "+t1);
		System.out.println("URL of new tab: " + driver.getCurrentUrl());
		System.out.println("Closing the tab...");
		driver.close();
		driver.switchTo().window(tablist.get(0));
		
		System.out.println("Clicking New Window button...");
		js.executeScript("arguments[0].scrollIntoView(true);", new_window);
		parentTab = driver.getWindowHandle();
		new_window.click();
		tablist= new ArrayList<>(driver.getWindowHandles());
	//	Thread.sleep(2000);
		driver.switchTo().window(tablist.get(1));
		Thread.sleep(5000);
		String t2=driver.getTitle();
		System.out.println("Title of new window: "+t2);
		System.out.println("URL of new window: " + driver.getCurrentUrl());
		System.out.println("\nClosing the window...");
		driver.close();
		driver.switchTo().window(tablist.get(0));
		/*
		System.out.println("Clicking New Window Message button...");
		js.executeScript("arguments[0].scrollIntoView(true);", alert_window);
		String mainwindow=driver.getWindowHandle();
		alert_window.click();
		Set<String> allwindow = driver.getWindowHandles();
		for(String window:allwindow)
		{
			driver.switchTo().window(window);
			System.out.println("Title of newMSG window : " + driver.getTitle());
			driver.navigate().refresh();
			
			System.out.println("URL of new window: " + driver.getCurrentUrl());
			System.out.println("\nClosing the window...");
			driver.close();
		}*/
}
	public void  Alerts_page() throws Throwable
	{
		js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", Alerts_page);
		System.out.println("OPENING ALERT PAGE");
		Alerts_page.click();
		System.out.println("CLICKING ON >>> CLICK BUTTON TO SEE ALERT");
		js.executeScript("arguments[0].scrollIntoView(true);", click_me_see_alert);
		click_me_see_alert.click();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		Thread.sleep(3000);

		System.out.println("CLICKING ON >>> ON BUTTON CLICK, ALERT WILL APPEAR AFTER 5 SECONDS");
		js.executeScript("arguments[0].scrollIntoView(true);", click_me_see_5ses_alert);
		click_me_see_5ses_alert.click();
		Thread.sleep(3000);
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
			Thread.sleep(3000);
	        alert.accept();
			Thread.sleep(3000);
			
			 js.executeScript("arguments[0].scrollIntoView(true);", confirmButton);
		        System.out.println("CLICKING ON >>> ON BUTTON CLICK, CONFIRM BOX WILL APPEAR");
		        confirmButton.click();
				Thread.sleep(3000);
		        Alert alert2 = driver.switchTo().alert();
		        boolean shouldAccept = true;
		        if (shouldAccept) 
		        {
		            alert.accept(); 
		        } else {
		            alert.dismiss(); 
		        }
		        
		        js.executeScript("arguments[0].scrollIntoView(true);", promtButton);
		        System.out.println("CLICKING ON >>>ON BUTTON CLICK, PROMPT BOX WILL APPEAR");
		        promtButton.click();
		        Thread.sleep(3000);
		        Alert prompt = driver.switchTo().alert();
		        boolean shouldAccept2 = true;
		        if (shouldAccept) {
		            prompt.sendKeys("qwswww"); 
		            Thread.sleep(3000);		            
		            prompt.accept();  
		        } else {
		        	Thread.sleep(3000);
		            prompt.dismiss();  
		        }
	}
	public void frames()
	{
		js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", frame_page);
		System.out.println("OPENING FRAME PAGE");
		frame_page.click();
		System.out.println("SWITCH TO THE FIRST FRAME BY INDEX (frame name )");
		 driver.switchTo().frame("frame1");
		//FRAME1	
		   String frame1 = driver.findElement(By.id("sampleHeading")).getText();
		   System.out.println("Heading inside frame 1: " + frame1);
		   driver.switchTo().defaultContent();
		   
		   System.out.println("SWITCH TO THE 2 FRAME BY INDEX (frame name )");
			 driver.switchTo().frame("frame2");
			//FRAME1	
			   WebElement frame2 = driver.findElement(By.id("sampleHeading"));
			   System.out.println("Heading inside frame 1: " + frame2.getText());
			   driver.switchTo().defaultContent();
	}
	
	public void nested_frame()
	{
		js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", nested_frame_page);
		System.out.println("OPENING NESTED FRAME PAGE");
		nested_frame_page.click();
		System.out.println("SWITCH TO THE PARENT TO CHILD FRAME ");
		driver.switchTo().frame("frame1");
		 
		// WebElement child= driver.findElement(By.xpath("//iframe[@srcdoc='<p>Child Iframe</p>']"));
		 driver.switchTo().frame(0);
		 WebElement child= driver.findElement(By.tagName("p"));
		 System.out.println("Heading inside CHILD FRAME: " + child.getText());
		 
		 driver.switchTo().parentFrame();
		 
		 String frame1 = driver.findElement(By.tagName("body")).getText();
		   System.out.println("Heading inside PARENT FRAME : " + frame1);
		   driver.switchTo().defaultContent();
		 System.out.println("main page source>>>==	\n"+driver.getPageSource());
	}
	
}
