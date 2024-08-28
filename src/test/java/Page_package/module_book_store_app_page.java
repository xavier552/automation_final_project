package Page_package;

import java.time.Duration;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class module_book_store_app_page {

	
	public WebDriver driver;
	public WebDriverWait wait;
	public JavascriptExecutor js;
	
	
	 @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div/div[6]/div/div[1]")
	 WebElement book_store_application;
	
	 @FindBy(xpath = "/html/body/div[2]/div/div/div/div[1]/div/div/div[6]/div/ul/li[1]")
	 WebElement login_page;
	 
	 @FindBy(xpath = "//*[@id=\"userName\"]")
	 WebElement username;
	 
	 @FindBy(xpath = "//*[@id=\"password\"]")
	 WebElement pass;
	 
	 @FindBy(xpath = "/html/body/div[2]/div/div/div/div[2]/div[2]/form/div[4]/div[1]/button")
	 WebElement loginbutton;
	 
	 @FindBy(xpath = "/html/body/div[2]/div/div/div/div[1]/div/div/div[6]/div/ul/li[3]/span")
	 WebElement profile_page;
	
	 
	
	
	public  module_book_store_app_page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void  Book_Store_Application()
	{

		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",book_store_application);
		book_store_application.click();
		System.out.println("OPENING Book_Store_Application PAGE");
	}
	public void  register() throws Throwable
	{
		js = (JavascriptExecutor) driver;
		driver.navigate().refresh();
		js.executeScript("arguments[0].scrollIntoView(true);",login_page);
		login_page.click();
		WebElement newUserButton = driver.findElement(By.xpath("//*[@id=\"newUser\"]"));
		js.executeScript("arguments[0].scrollIntoView(true);",newUserButton);
		System.out.println("OPENING REGISTER PAGE");
		newUserButton.click();
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstname")));
         WebElement firstNameField = driver.findElement(By.id("firstname"));
         firstNameField.sendKeys("appu");
         WebElement lastNameField = driver.findElement(By.id("lastname"));
         lastNameField.sendKeys("mon");
         WebElement userNameField = driver.findElement(By.id("userName"));
         userNameField.sendKeys("appumon123");
         WebElement passwordField = driver.findElement(By.id("password"));
         passwordField.sendKeys("AppuPassword@123");
         System.out.println("\n\n\ncan't automate CAPTCHA so  redieecting to login page\n\n\n");
         
         Thread.sleep(3000);
         driver.navigate().refresh();
         js.executeScript("arguments[0].scrollIntoView(true);",login_page);
 		login_page.click();
         
 		
 		
         
         /*WebElement back_to_login = driver.findElement(By.id("gotologin"));
         js.executeScript("arguments[0].scrollIntoView(true);",back_to_login);
         back_to_login.click();
         WebElement registerButton = driver.findElement(By.id("register"));
         js.executeScript("arguments[0].scrollIntoView(true);",registerButton);
         registerButton.click();
         // wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("confirmation_message"))); 
         System.out.println("User registration completed!");*/
         
         
         
	}
	public void  login()
	{
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",login_page);
		login_page.click();
		System.out.println("OPENING LOGIN PAGE");
		
		System.out.println("enterED user name");
		username.sendKeys("appumon123");
		System.out.println("enterED password");
		pass.sendKeys("Pass11@user");
		js.executeScript("arguments[0].scrollIntoView(true);",loginbutton);
		loginbutton.click();
		System.out.println("login successfull");
	}
	public void  profile() throws Throwable
	{
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",profile_page);
		System.out.println("OPENING profile_page");
		driver.navigate().refresh();
		 WebElement profileHeader = driver.findElement(By.xpath("//label[@id='userName-value']"));
			js.executeScript("arguments[0].scrollIntoView(true);",profileHeader);

		 js.executeScript("arguments[0].scrollIntoView(true);",profileHeader);
         if (profileHeader.isDisplayed())
         {
             System.out.println("Login successful and on the profile page!");
         }
         else {
        	 System.out.println("Error during interaction ");
         }
         System.out.println("clickimg delete all books");
         WebElement delallbook=driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/div[3]/div[3]/button"));
     	js.executeScript("arguments[0].scrollIntoView(true);",delallbook);
         delallbook.click();
         System.out.println("canceling delete all books");
         WebElement cancel=driver.findElement(By.xpath("/html/body/div[4]/div/div/div[3]/button[2]"));
     	js.executeScript("arguments[0].scrollIntoView(true);",cancel);
         cancel.click();
         System.out.println("going to book store");
         WebElement tobookstore=driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/div[3]/div[1]/button"));
      	js.executeScript("arguments[0].scrollIntoView(true);",tobookstore);
      	tobookstore.click();
      	Thread.sleep(3000);
      	 System.out.println("log out");
      	 WebElement logout=driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/div[1]/div[2]/button"));
       	js.executeScript("arguments[0].scrollIntoView(true);",logout);
       	logout.click();
        System.out.println("succesfully loge out and redirecting to login page");
         
	}
	
	
}
