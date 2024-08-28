package Base_package;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Home_page_Base_class {
    public WebDriver driver;

    @BeforeMethod
    public void setUp() throws Throwable {
      
       driver = new ChromeDriver();
    	
    	/*Scanner sc = new Scanner(System.in);
		System.out.println("SELECT BROWSER:  Firefox  ,  Chrome ");
		String browser = sc.nextLine();
		 driver = null;
		 if(browser.equalsIgnoreCase("Firefox"))
		 {
			 driver=new FirefoxDriver();
		 }
		 else if (browser.equalsIgnoreCase("Chrome"))
		 {
			 driver= new ChromeDriver();
		 }
		 else
		 {
			 System.out.println("Invalid browser");
		 }
		 Thread.sleep(2000);
		 sc.close();*/
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    @AfterMethod
    public void tearDown() 
    {
    	if (driver != null) 
    	{
    		driver.quit();
    	}
    }
}
