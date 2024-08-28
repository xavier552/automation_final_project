package Page_package;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_page 
{
    WebDriver driver;
    JavascriptExecutor js;

    @FindBy(xpath = "//*[@id='app']/header/a/img")
    WebElement logo;

    @FindBy(xpath ="//div/div[2]/div/div/div/div")
    WebElement element;
    
    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div/div[2]/div/div[3]")
    WebElement forms;
    
    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div/div[2]/div/div[3]")
    WebElement Alerts_Frame_Windows;
    
    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div/div[4]/div/div[1]")
    WebElement widget;
    
    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div/div[5]/div")
    WebElement interactions;
    
    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div/div[6]/div/div[1]")
    WebElement book_store_application;

    public Home_page(WebDriver driver) 
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void homepage_title_logo() 
    {
    	String actualTitle = driver.getTitle();
    	assertEquals(actualTitle, "DEMOQA", "Title verification failed.");
    	System.out.println("Title verification successful: " + actualTitle);

    	assertTrue(logo.isDisplayed(), "Logo is not present on the home page.");
    	System.out.println("Logo is present on the home page.");
    }

    public void module_interact() throws Throwable
    {
        js = (JavascriptExecutor) driver;
        
        js.executeScript("window.scrollBy(0, 300);");
        Thread.sleep(2000); 
        System.out.println(">>>>>ENTERING ELEMENT MODULE PAGE<<<<<");
        element.click();
        System.out.println("----successfully loaded");
        System.out.println("navigating back");
        driver.navigate().back();
        
        js.executeScript("window.scrollBy(0, 300);");
        Thread.sleep(2000); 
        System.out.println(">>>>>ENTERING FORMS MODULE PAGE<<<<<");
        forms.click();
        System.out.println("----successfully loaded");
        System.out.println("navigating back");
        driver.navigate().back();
        
        
        js.executeScript("window.scrollBy(0, 300);");
        Thread.sleep(2000); 
        System.out.println(">>>>>ENTERING Alerts_Frame_Windows MODULE PAGE<<<<<");
        Alerts_Frame_Windows.click();
        System.out.println("----successfully loaded");
        System.out.println("navigating back");
        driver.navigate().back();
        
        js.executeScript("window.scrollBy(0, 300);");
        Thread.sleep(2000); 
        System.out.println(">>>>>ENTERING interactions MODULE PAGE<<<<<");
        interactions.click();
        System.out.println("----success");
        System.out.println("navigating back");
        driver.navigate().back();
        
        js.executeScript("window.scrollBy(0, 300);");
        Thread.sleep(2000);
        System.out.println(">>>>>ENTERING widget MODULE PAGE<<<<<");
        widget.click();
        System.out.println("----success");
        System.out.println("navigating back");
        driver.navigate().back();
        
        js.executeScript("window.scrollBy(0, 300);");
        Thread.sleep(2000); 
        System.out.println(">>>>>ENTERING book_store_application MODULE PAGE<<<<<");
        book_store_application.click();
        System.out.println("----success");
        System.out.println("navigating back");
        driver.navigate().back();
    }
}
