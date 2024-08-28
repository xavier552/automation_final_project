package Page_package;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class module_widget_page {
	
	public WebDriver driver;
	public JavascriptExecutor js;
	public WebDriverWait wait; 

	@FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div/div[4]/div/div[3]/h5")
	WebElement widget_page;
	
	@FindBy(xpath = "/html/body/div[2]/div/div/div/div[1]/div/div/div[4]/div/ul/li[2]/span")
	WebElement auto_complete_page;
	
	@FindBy(xpath = "/html/body/div[2]/div/div/div/div[2]/div[2]/div[1]/div/div/div/div/div[1]")
	WebElement multiple_color;
	
	@FindBy(xpath = "/html/body/div[2]/div/div/div/div[2]/div[2]/div[2]/div/div/div/div")
	WebElement single_color;
	
	@FindBy(xpath = "/html/body/div[2]/div/div/div/div[1]/div/div/div[4]/div/ul/li[4]/span")
	WebElement slider_page;
	
	@FindBy(xpath = "/html/body/div[2]/div/div/div/div[1]/div/div/div[4]/div/ul/li[5]")
	WebElement progress_page;
	
	@FindBy(xpath = "/html/body/div[2]/div/div/div/div[1]/div/div/div[4]/div/ul/li[7]")
	WebElement tooltips_page;
	
	
	@FindBy(xpath = "/html/body/div[2]/div/div/div/div[1]/div/div/div[4]/div/ul/li[8]/span")
	WebElement Menu_page;
	
	
	
	
	
	public module_widget_page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void widgetpage() throws Throwable
	{
		js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", widget_page);
		System.out.println("OPENING WIDGET PAGE");
		widget_page.click();
		System.out.println("\nCLICKING ON AUTO COMPLETE PAGE...");
		js.executeScript("arguments[0].scrollIntoView(true);",auto_complete_page );
		auto_complete_page.click();
		Thread.sleep(3000);
	}
	public void widget_multiple() throws Throwable
	{
		System.out.println("\nType multiple color names");
		js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",multiple_color);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/div[1]/div/div/div/div/div[1]")));
		Actions act= new Actions(driver);
		Thread.sleep(2000);
		act.sendKeys(ele, "red").sendKeys(Keys.ENTER).perform();
		Thread.sleep(2000);
		act.sendKeys(ele, "blue").sendKeys(Keys.ENTER).perform();
		Thread.sleep(5000);
	}
	public void widget_single() throws Throwable
	{
		System.out.println("\nType single color names");
		js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",single_color);
		Actions act2= new Actions(driver);
		act2.sendKeys(single_color, "black").sendKeys(Keys.ENTER).perform();
	}
	public void widget_slider()
	{
		js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",slider_page);
		System.out.println("OPENING SLIDER PAGE");
		slider_page.click();
		
		Actions act3=new  Actions(driver);
		System.out.println("SLIDING TO X=-10 Y=0");
		WebElement slider_ = driver.findElement(By.xpath("//input[@type='range' and @class='range-slider range-slider--primary']"));
		js.executeScript("arguments[0].scrollIntoView(true);",slider_);
		
		System.out.println("BEFORE SLIDING");
		System.out.println("Slider size: " + slider_.getSize());
		System.out.println("Slider location: " + slider_.getLocation());
		System.out.println("Slider Width: " + slider_.getSize().getWidth());
		System.out.println("Slider Height: " + slider_.getSize().getHeight());
	//	act.clickAndHold(slider_).moveByOffset(300,523).release().perform();

		act3.dragAndDropBy(slider_ , 10 , 0).perform();
		System.out.println("AFTER SLIDING");
		System.out.println("Slider size: " + slider_.getSize());
		System.out.println("Slider location: " + slider_.getLocation());
		System.out.println("Slider Width: " + slider_.getSize().getWidth());
		System.out.println("Slider Height: " + slider_.getSize().getHeight());
	//	act.clickAndHold(slider_).moveByOffset(300,523).release().perform();
		
		 /* int minValue = 0;
          int maxValue = 100;
          int desiredValue = 50;
          int sliderWidth = slider_.getSize().getWidth();
          int offsetX = (desiredValue - minValue) * sliderWidth / (maxValue - minValue);
          System.out.println("SLIDING TO X=" + offsetX);
          act.clickAndHold(slider_).moveByOffset(offsetX, 15).release().perform();
          
          String newValue = slider_.getAttribute("value");
          System.out.println("New slider value: " + newValue);*/
	}
	public void widget_bar() throws Throwable
	{
		js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",progress_page);
		System.out.println("OPENING PROGRESS PAGE");
		progress_page.click();
		
		WebElement start_stop_ele=driver.findElement(By.xpath("//*[@id=\"startStopButton\"]"));
		
		js.executeScript("arguments[0].scrollIntoView(true);",start_stop_ele);

		//act.moveToElement(start_stop_ele).perform();
		System.out.println("STARTING");
		start_stop_ele.click();
		Thread.sleep(3000);
		System.out.println("STOPS UNDER 4 SEC");
		start_stop_ele.click();
		Thread.sleep(4000);
		System.out.println("STARTING");
		start_stop_ele.click();
		System.out.println("WAITING FOR 100%");
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
         wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("progressBar"), "100%"));
         Thread.sleep(5000);
         WebElement resetButton = driver.findElement(By.id("resetButton"));
         System.out.println("CLICKING RESET BUTTON AFTER COMPLETING 100% ");
         resetButton.click();
	}
	public void tool_tips_page() throws Throwable
	{
		js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",tooltips_page);
		System.out.println("OPENING TOOL TIPS PAGE");
		tooltips_page.click();
		
		WebElement button=driver.findElement(By.xpath("//*[@id=\"toolTipButton\"]"));
		WebElement textfield=driver.findElement(By.xpath("//*[@id=\"toolTipTextField\"]"));
		Actions act=new Actions(driver);
		System.out.println("MOVING MOUSE OVER THE BUTTON");
		js.executeScript("arguments[0].scrollIntoView(true);",button);
		act.moveToElement(button).perform();
        Thread.sleep(3000);
		System.out.println("MOVING MOUSE OVER THE textfield");
		js.executeScript("arguments[0].scrollIntoView(true);",textfield);
		act.moveToElement(textfield).perform();
	}
	public void  menu_page() throws Throwable
	{
		js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",Menu_page);
		Menu_page.click();
		System.out.println("OPENING MENU PAGE");
		
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		  Actions act=new Actions(driver);
		  WebElement mainItem2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/ul/li[2]/a")));
		  //mainItem2.click();
			js.executeScript("arguments[0].scrollIntoView(true);",mainItem2);

		  act.moveToElement(mainItem2).perform();
		  WebElement contentMainItem2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Main Item 2']")));
		  System.out.println("Main Item 2 Content Visible: " + contentMainItem2.isDisplayed());
		 // Thread.sleep(2000);
		  WebElement SUB_SUB_LIST= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/ul/li[2]/ul/li[3]/a")));
		//  SUB_SUB_LIST.click();
		  act.moveToElement(SUB_SUB_LIST).perform();
		  WebElement contentSubItem1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/ul/li[2]/ul/li[3]/ul/li[1]/a")));
		  System.out.println("SUB SUB Item 1 Content Visible: " + contentSubItem1.isDisplayed());
		//  Thread.sleep(2000);
		  WebElement mainItem1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/ul/li[1]/a")));
		  //mainItem1.click();
		  js.executeScript("arguments[0].scrollIntoView(true);",mainItem1);
		  act.moveToElement(mainItem1).perform();
		  WebElement contentMainItem1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Main Item 1']")));
		  System.out.println("Main Item 1 Content Visible: " + contentMainItem1.isDisplayed());
		 // Thread.sleep(2000);
	}
	
}

