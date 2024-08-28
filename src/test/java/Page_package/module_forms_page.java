package Page_package;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class module_forms_page
{
	public WebDriver driver;
	public  WebDriver wait;
	public JavascriptExecutor js;

	
	 @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div/div[2]/div/div[3]")
	    WebElement forms;
	 
	@FindBy(xpath = "//*[@id=\"app\"]/div/div/div/div[1]/div/div/div[2]/span/div")
	WebElement form_page;
	
	@FindBy(xpath = "//div[2]/div/ul/li/span")
	WebElement form_practice_form_page;
	
	@FindBy(xpath = "//*[@id=\"firstName\"]")
	WebElement first_name;
	
	@FindBy(xpath = "//*[@id=\"lastName\"]")
	WebElement last_name;
	
	@FindBy(xpath = "//*[@id=\"userEmail\"]")
	WebElement email;
	
	
	@FindBy(xpath = "//*[@id=\"genterWrapper\"]/div[2]/div[1]/label")
	WebElement male;
	
	@FindBy(xpath = "//*[@id=\"genterWrapper\"]/div[2]/div[2]/label")
	WebElement female;
	
	@FindBy(xpath = "//*[@id=\"genterWrapper\"]/div[2]/div[3]/label")
	WebElement other;
	
	@FindBy(xpath = "//*[@id=\"userNumber\"]")
	WebElement mob_no;
	
	@FindBy(xpath = "//*[@id=\"dateOfBirthInput\"]")
	WebElement dateofbirth;
	
	@FindBy(xpath = "//input[@id='subjectsInput']")
	WebElement subject;
	
	@FindBy(xpath = "//*[@id=\"hobbiesWrapper\"]/div[2]/div[1]/label")
	WebElement sports;
	
	@FindBy(xpath = "//*[@id=\"hobbiesWrapper\"]/div[2]/div[2]/label")
	WebElement reading;
	
	@FindBy(xpath = "//*[@id=\"hobbiesWrapper\"]/div[2]/div[3]/label")
	WebElement music;
	
	@FindBy(xpath = "//*[@id=\"uploadPicture\"]")
	WebElement choose_file;
	
	@FindBy(xpath = "//*[@id=\"currentAddress\"]")
	WebElement c_address;
	
	@FindBy(xpath = "//*[@id=\"state\"]")
	WebElement state;
	
	@FindBy(xpath = "//*[@id=\"city\"]")
	WebElement city;
	
	@FindBy(xpath = "//*[@id=\"submit\"]")
	WebElement submit;
	
	
	
	
	
	public module_forms_page(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	
	
	public void module_forms_page()
	{
		
		js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", forms);
		System.out.println(">>>>>ENTERING FORMS MODULE PAGE<<<<<");
		forms.click();
		System.out.println("----successfully loaded");
		System.out.println(">>>>>Entering ELEMENT FORMS_page<<<<<");
        js.executeScript("arguments[0].scrollIntoView(true);", form_page);
		//form_page.click();
		System.out.println("success");
        System.out.println("entering form_practice_form_page ");
        js.executeScript("arguments[0].scrollIntoView(true);", form_practice_form_page);
        form_practice_form_page.click();
	}
	public void Student_Registration_Form() throws Throwable 
	{
		js=(JavascriptExecutor)driver;
		System.out.println(">>>>>Entering  FORM_DETAILS <<<<<");
        js.executeScript("arguments[0].scrollIntoView(true);", first_name);
        first_name.sendKeys("abcd");
        last_name.sendKeys("asd");
        email.sendKeys("usert@gmail.com");
        mob_no.sendKeys("1597534568");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions act= new Actions(driver);
        WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='subjectsInput']")));
		act.sendKeys(ele, "english").sendKeys(Keys.ENTER).perform();
		Thread.sleep(2000);
		act.sendKeys(ele, "physics").sendKeys(Keys.ENTER).perform();
		Thread.sleep(2000);
		act.sendKeys(ele, "maths").sendKeys(Keys.ENTER).perform();
		Thread.sleep(2000);

	}
	public void Student_Registration_Form_radio(String option)
	{
   WebElement radioButton = null;
   js.executeScript("arguments[0].scrollIntoView(true);", male);
   js.executeScript("arguments[0].scrollIntoView(true);", female);
   js.executeScript("arguments[0].scrollIntoView(true);", other);

        switch (option.toLowerCase()) 
        {
        case "male":
            radioButton = male;
            break;
        case "female":
            radioButton = female;
            break;
        case "other":
            radioButton = other;
            break;
        default:
            System.out.println("Invalid option: " + option);
            return;
        }
	
	 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	  wait.until(ExpectedConditions.elementToBeClickable(radioButton));
       if (!radioButton.isSelected())
       {
           radioButton.click();
       }
       System.out.println(option + " radio button selected.");
	}
	public void date_of_birth(String birthmonthyear,String birthdate)
	{
		dateofbirth.click();
		datepickmethod(birthmonthyear,birthdate);
	}


	private void datepickmethod(String birthmonthyear, String birthdate) 
	{
		while(true)
		{
			String month=driver.findElement(By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[1]/div[1]")).getText();
			System.out.println("current month& year in calender="+month);
			if (birthmonthyear.equalsIgnoreCase(month))
			{
				System.out.println("correct birth month & year");
				break;
			}else {
				WebElement nextmonth=driver.findElement(By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/button[2]"));
				nextmonth.click();
			}
		}
			List<WebElement> alldate=driver.findElements(By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[2]/div/div"));
			 for(WebElement clickdate:alldate)
			 {
				 String selectdate=clickdate.getText();
				 System.out.println("current date in the calender="+selectdate);
				 if(selectdate.equalsIgnoreCase(birthdate))
					{
					 clickdate.click();
						System.out.println("correct birth date");
						break;
					}
			 }
	}
	public void Hobbies_select()
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		sports.click();
		reading.click();
		music.click();
		wait.until(ExpectedConditions.elementToBeClickable(subject));
        js.executeScript("arguments[0].scrollIntoView(true);", subject);
        String sss="java,c,php,ruby";
		subject.sendKeys(sss);
		c_address.sendKeys("qwertyuiopasdfghjklzxcvbnmqwertyuioasdfhjklzxcvnmmnbvxzkgfd");
	}
	public void file_upload()
	{
		System.out.println("\nchoosing the file to upload ");
		js.executeScript("arguments[0].scrollIntoView(true);", choose_file);
		choose_file.sendKeys("E:\\\\xavier data\\\\error clear.txt");
		System.out.println("\nupload success");
	}
	public void state_city___submit()
	{
		/*Select select_state=new Select(state);
		select_state.selectByVisibleText("Haryana");
		
		Select select_city=new Select(city);
		select_city.selectByVisibleText("Karnal");*/
		state.click();
		WebElement option_NCR=driver.findElement(By.xpath("//div[@id='state']/div[2]/div/div[3]"));
        js.executeScript("arguments[0].scrollIntoView(true);", option_NCR);
		option_NCR.click();
		city.click();
		WebElement option_Karnal=driver.findElement(By.xpath("//div[@id='city']/div[2]/div/div"));
        js.executeScript("arguments[0].scrollIntoView(true);", option_Karnal);
		option_Karnal.click();
		submit.submit();
		
	}
}
