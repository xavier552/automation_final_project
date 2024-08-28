package Page_package;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class module_interaction_page {
	public WebDriver driver;
	public WebDriverWait wait;
	public JavascriptExecutor js;
	
	
	@FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div/div[5]")
	WebElement Interaction_page;
	
	@FindBy(xpath = "/html/body/div[2]/div/div/div/div[1]/div/div/div[5]/div/ul/li[3]/span")
	WebElement resizeable_page;
	
	@FindBy(xpath = "/html/body/div[2]/div/div/div/div[1]/div/div/div[5]/div/ul/li[5]/span")
	WebElement drag_page;
	
	
	public module_interaction_page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void module_interaction()
	{
		js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",Interaction_page);
		Interaction_page.click();
		System.out.println("OPENING INTERACTION PAGE");
		
		
		System.out.println("OPENING SORTABLE  PAGE");
		WebElement sortable=driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div/div/div[5]/div/ul/li[1]"));
		js.executeScript("arguments[0].scrollIntoView(true);",sortable);
		sortable.click();
		
		  WebElement item1 = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/div/div[1]/div/div[1]"));
          WebElement item2 = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/div/div[1]/div/div[2]"));
          WebElement item3 = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/div/div[1]/div/div[3]"));
          WebElement item4 = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/div/div[1]/div/div[4]"));
          WebElement item5 = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/div/div[1]/div/div[5]"));
          WebElement item6 = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/div/div[1]/div/div[6]"));
          Actions actions = new Actions(driver);
  		js.executeScript("arguments[0].scrollIntoView(true);",item1,item2,item3,item4,item5,item6);

          actions.dragAndDrop(item1, item2).perform();
          actions.dragAndDrop(item3, item5).perform();
	}
	public void resizeable()
	{
		js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",resizeable_page);
		resizeable_page.click();
		System.out.println("OPENING RESIZEABLE PAGE");
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		 WebElement resizableBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("resizable")));
		// js.executeScript("arguments[0].scrollIntoView(true);",resizableBox);
		 js.executeScript("arguments[0].scrollIntoView(true);", resizableBox);
		 WebElement resizeHandle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='react-resizable-handle react-resizable-handle-se']")));
		 Actions actions = new Actions(driver);
		  actions.clickAndHold(resizeHandle).moveByOffset(10,10).release().perform();
		  System.out.println("resizing the box");
		 WebElement resizedBox = driver.findElement(By.id("resizable"));
		  js.executeScript("arguments[0].scrollIntoView(true);",resizedBox);
		  js.executeScript("arguments[0].scrollIntoView(true);", resizedBox);
		  System.out.println("AFTER RESIZING ");
          String width = resizedBox.getCssValue("width");
          String height = resizedBox.getCssValue("height");
          System.out.println("Resized Box Width: " + width);
          System.out.println("Resized Box Height: " + height);
		
	}
	public void drag_drop()
	{
		js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",drag_page);
		drag_page.click();
		System.out.println("OPENING DRAGGABLE PAGE");
		  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		  WebElement draggableElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dragBox")));
          Actions actions = new Actions(driver);
          actions.clickAndHold(draggableElement);
          actions.moveByOffset(100, 10).release().perform();
          System.out.println("AFTER DRAGGING");
          WebElement movedElement = driver.findElement(By.id("dragBox"));
          String positionX = movedElement.getCssValue("left");
          String positionY = movedElement.getCssValue("top");
          System.out.println("Draggable Element Position X: " + positionX);
          System.out.println("Draggable Element Position Y: " + positionY);

	}

}
