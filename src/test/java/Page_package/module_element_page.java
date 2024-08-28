

package Page_package;


import java.awt.Desktop.Action;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
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

public class module_element_page
{
	public WebDriver driver;
	 public JavascriptExecutor js;
	public  WebDriverWait wait ;
	
	 @FindBy(xpath ="//div/div[2]/div/div/div/div")
	    WebElement element;
	
	
	@FindBy(xpath = "//*[@id=\"item-0\"]/span")
	WebElement Text_Box_page;
	
	@FindBy(xpath = "//*[@id=\"userEmail\"]")
	WebElement Email;
	
	@FindBy(xpath = "//*[@id=\"userName\"]")
	WebElement FullName;
	
	@FindBy(xpath = "//*[@id=\"currentAddress\"]")
	WebElement Current_Address;
	
	@FindBy(xpath = "//*[@id=\"permanentAddress\"]")
	WebElement Permenant_Address;
	
	@FindBy(xpath = "//*[@id=\"submit\"]")
	WebElement Text_box_Submit;
	

	@FindBy(xpath = "//*[@id=\"item-1\"]/span")
	WebElement Check_Box_page;
	

	@FindBy(xpath = "//*[@id=\"tree-node\"]/div/button[1]")
	WebElement Check_Box_expand;
	
	@FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/span/label/span[1]")
	WebElement check_home;
	
	@FindBy(xpath = "//*[@id=\"item-2\"]")
	WebElement Radio_Button_page;
	
	
	@FindBy(xpath= "//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[2]/label")
	WebElement Radio_yes;
	
	@FindBy(xpath ="//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[3]/label")
	WebElement Radio_impressive;
	
	@FindBy(xpath ="//*[@id=\"addNewRecordButton\"]")
	WebElement web_table_add;
	
	@FindBy(xpath ="//*[@id=\"item-3\"]")
	WebElement Web_Table;
	
	@FindBy(xpath = "//*[@id=\"item-4\"]/span")
	WebElement Buttons;
	
	@FindBy(xpath = "//*[@id=\"doubleClickBtn\"]")
	WebElement Double_click;
	
	@FindBy(xpath = "//*[@id=\"rightClickBtn\"]")
	WebElement Right_click;
	
	@FindBy(xpath = "/html/body/div[2]/div/div/div/div[2]/div[2]/div[3]/button")
	WebElement dynamic_click;
	
	@FindBy(xpath = "//*[@id=\"item-5\"]/span")
	WebElement element_Links;
	
	@FindBy(xpath = "//*[@id=\"simpleLink\"]")
	WebElement element_Links_to_home;

	@FindBy(xpath = "//*[@id=\"dynamicLink\"]")
	WebElement element_Links_home_dynamic;
	
	@FindBy(xpath = "//*[@id=\"item-6\"]")
	WebElement element_BrokenLinks;
	
	@FindBy(xpath = "//*[@id=\"item-7\"]")
	WebElement element_upload_download;
	
	@FindBy(xpath = "//*[@id=\"item-8\"]")
	WebElement element_dynamic_pro;
	
	
	public module_element_page(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}

	public void element_textbox() throws Throwable
	{
		js = (JavascriptExecutor) driver;
		Thread.sleep(3000);
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        System.out.println(">>>>>ENTERING ELEMENT MODULE PAGE<<<<<");
        element.click();
        System.out.println("----successfully loaded");
		System.out.println(">>>>>Entering ELEMENT MODULE text_box_page<<<<<");
		Text_Box_page.click();
		System.out.println("-----entering the textbox details");
		FullName.sendKeys("abcdefg");
		Thread.sleep(2000);
		Email.sendKeys("testemail@gmail.com");
		Thread.sleep(2000);
		Current_Address.sendKeys("1234 Elm Street, Springfield, IL 62704");
		Thread.sleep(2000);
		Permenant_Address.sendKeys("5678 Maple Avenue, Apt. 12B, Greenfield Estates, Northbrook, Chicago, IL 60062, United States");
		Thread.sleep(2000);
        js.executeScript("arguments[0].scrollIntoView(true);", Text_box_Submit);
        System.out.println("-----submitting ");
		Text_box_Submit.click();
		Thread.sleep(5000);	
	}
	public void element_checkbox() throws Throwable
	{
		js = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].scrollIntoView(true);", Check_Box_page);
		 System.out.println(">>>>>Entering ELEMENT Check_box_page<<<<<");
		Thread.sleep(3000);
		Check_Box_page.click();
		 js.executeScript("arguments[0].scrollIntoView(true);", Check_Box_expand);
		Thread.sleep(3000);
		System.out.println("-----expanding the checkbox directory");
		Check_Box_expand.click();
		Thread.sleep(3000);
		System.out.println("-----check in box");
		check_home.click();
		Thread.sleep(2000);
	
		WebElement checkDesktop=driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[1]/span/label/span[1]"));
		WebElement checkDocument=driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[2]/span/label/span[1]"));
		WebElement checkDownloads=driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[3]/span/label/span[1]"));
		
		List<WebElement> checkboxlist = new ArrayList<>();
		//checkboxlist.add(checkHome);
		checkboxlist.add(checkDesktop);
		checkboxlist.add(checkDocument);
		checkboxlist.add(checkDownloads);
		
		 for (WebElement checkBox : checkboxlist) 
		 {
	            if (!checkBox.isSelected()) 
	            {
	            	 Thread.sleep(2000);
	            	 js.executeScript("arguments[0].scrollIntoView(true);", checkBox);
	            	 checkBox.click();
	            }
		 }		Thread.sleep(5000);
	}
	public void element_RadioButton() throws Throwable
	{
		js = (JavascriptExecutor) driver;
		Thread.sleep(3000);
		System.out.println(">>>>>Entering ELEMENT Radio_button_page<<<<<");
		Radio_Button_page.click();
		Thread.sleep(3000);
		js.executeScript("window.scrollTo(0,400);");
		Thread.sleep(3000);
		System.out.println("-----selectig the radio buttons");
		Radio_yes.click();
		String ry=Radio_yes.getText();
		
		if(Radio_yes.isEnabled()) 
		{System.out.println("Do you like the site?      ---------"+ry);}
		String ri=Radio_impressive.getText();
		Radio_impressive.click();
		if(Radio_impressive.isEnabled())
		{System.out.println("Do you like the site?      ---------"+ri);}
	}
	public void element_Web_Table() throws Throwable
	{
		js = (JavascriptExecutor) driver;
		System.out.println(">>>>>Entering ELEMENT Web_Table_page<<<<<");

		Web_Table.click();
		Thread.sleep(2000);
	}
	public void element_Web_Table_add() throws Throwable
	{
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		js.executeScript("arguments[0].scrollIntoView(true);", web_table_add);
		System.out.println("-----adding details");
		web_table_add.click();
		
		WebElement FirstName= driver.findElement(By.xpath("//*[@id=\"firstName\"]"));FirstName.sendKeys("abcd123");
		WebElement LastName= driver.findElement(By.xpath("//*[@id=\"lastName\"]"));LastName.sendKeys("efgh123");
		WebElement Email= driver.findElement(By.xpath("//*[@id=\"userEmail\"]"));Email.sendKeys("abcd1232@gmail.com");
		WebElement Age = driver.findElement(By.xpath("//*[@id=\"age\"]"));Age.sendKeys("23a");
		WebElement Salary= driver.findElement(By.xpath("//*[@id=\"salary\"]"));Salary.sendKeys("12300");
		WebElement Department= driver.findElement(By.xpath("//*[@id=\"department\"]"));Department.sendKeys("d-analyst11");
		Thread.sleep(2000);
		WebElement submit= driver.findElement(By.xpath("//*[@id=\"submit\"]"));submit.click();
		
		System.out.println("Web Table Created");
		Thread.sleep(2000);	
			
			 
			 int i=3;
			String edit_column = "#edit-record-" + i + " path";
			WebElement edit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(edit_column)));
			js.executeScript("arguments[0].scrollIntoView(true);", edit);
			edit.click();
		Thread.sleep(2000);
		WebElement edFirstName= driver.findElement(By.xpath("//*[@id=\"firstName\"]"));edFirstName.sendKeys("");
		WebElement edLastName= driver.findElement(By.xpath("//*[@id=\"lastName\"]"));edLastName.sendKeys("");
		WebElement edEmail= driver.findElement(By.xpath("//*[@id=\"userEmail\"]"));edEmail.sendKeys("");
		WebElement edAge = driver.findElement(By.xpath("//*[@id=\"age\"]"));edAge.sendKeys("");
		WebElement edSalary= driver.findElement(By.xpath("//*[@id=\"salary\"]"));edSalary.sendKeys("");
		WebElement edDepartment= driver.findElement(By.xpath("//*[@id=\"department\"]"));edDepartment.sendKeys("");
		Thread.sleep(2000);
		WebElement esubmit= driver.findElement(By.xpath("//*[@id=\"submit\"]"));esubmit.click();
		System.out.println("Web Table Updated");
	}
	public void element_Web_Table_delete_and_search() throws Throwable
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		 int j=3;
		 String delete_column = "#delete-record-" + j + " path";
		 WebElement delete = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(delete_column)));
		 js.executeScript("arguments[0].scrollIntoView(true);", delete);
		 Thread.sleep(2000);
		 delete.click();
		 System.out.println("Web Table Deleted");
		 Thread.sleep(2000);

		WebElement search= driver.findElement(By.xpath("//*[@id=\"searchBox\"]"));
		System.out.println("Searching web_table data in table");
		search.sendKeys("abcd123");
		System.out.println("Showing  web_table data result ");
		 Thread.sleep(2000);
		 System.out.println("\npage refreshed");
		driver.navigate().refresh();
		//search.clear();
	}
	public void element_web_table_rows_select() throws Throwable
	{
		WebElement rows= driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[3]/div[2]/div/div[2]/span[2]/select"));
		 js.executeScript("arguments[0].scrollIntoView(true);", rows);

		Select row_dropdown=new Select(rows);
		System.out.println("\nSELECT THE ROWS TO BE SHOWN------	 5 rows		10 rows		20 rows		25 rows		50 rows		100 rows		");
		String selected_row = "5 rows";
		System.out.println("Selecting: " + selected_row);
		row_dropdown.selectByVisibleText(selected_row);
		System.out.println(selected_row+" --  is rows selected");
            Thread.sleep(2000); 
            
            WebElement nextbtn=driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[3]/div[2]/div/div[3]/button"));
        	WebElement previousbtn=driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[3]/div[2]/div/div[1]/button"));
        	WebElement jump_to_page=driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[3]/div[2]/div/div[2]/span[1]/div/input"));


        	
           
            if (nextbtn.isEnabled())
            {
            	 System.out.println("\nNext button is displayed. Clicking it.");
            	nextbtn.click();
            	Thread.sleep(2000); 
            	System.out.println("		jump to page = 1");
            	jump_to_page.sendKeys("1",Keys.ENTER);

            	Thread.sleep(2000); 
			}
            else if (previousbtn.isEnabled())
            {
                System.out.println("\nPrevious button is displayed. Clicking it.");
            	previousbtn.click();
            	Thread.sleep(2000); 
            	System.out.println("		jump to page = 2");
            	jump_to_page.sendKeys("2",Keys.ENTER);
            	Thread.sleep(2000); 
			}
            else 
            {
                System.out.println("\nNo more rows available.");
            }
	}
	public void element_button() throws Throwable
	{
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", Buttons);
		Buttons.click();	
		 
		Actions act= new Actions(driver);
		System.out.println("\nclicking buttons");
    	Thread.sleep(1000); 
		js.executeScript("arguments[0].scrollIntoView(true);", Double_click);
		System.out.println("double click");
		act.doubleClick(Double_click).perform();
		WebElement msgdc=driver.findElement(By.xpath("//*[@id=\"doubleClickMessage\"]"));
		System.err.println(msgdc.getText());
    	Thread.sleep(2000); 

		System.out.println("right click");
		js.executeScript("arguments[0].scrollIntoView(true);", Right_click);
		act.contextClick(Right_click).perform();
		WebElement msgrc=driver.findElement(By.xpath("//*[@id=\"rightClickMessage\"]"));
		System.err.println(msgrc.getText());
    	Thread.sleep(2000); 

		System.out.println("dynamic click");
		js.executeScript("arguments[0].scrollIntoView(true);", dynamic_click);
	act.click(dynamic_click).perform();
		//dynamic_click.click();
		WebElement msgc=driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/p"));
		System.err.println(msgc.getText());
	}
	public void element_Links() throws Throwable
	{
		js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView(true);", element_Links);
		System.out.println("ENTERING ELEMENT_LINKS_PAGE");
		element_Links.click();
    	Thread.sleep(3000); 
		js.executeScript("arguments[0].scrollIntoView(true);", element_Links_to_home);
		System.out.println("opening link -----  element_Links_to_home");
		element_Links_to_home.click();
		
		String parentTab = driver.getWindowHandle();
        ArrayList<String> tablist = new ArrayList<>(driver.getWindowHandles());
		Thread.sleep(3000);
		
		driver.switchTo().window(tablist.get(1));
		Thread.sleep(3000);
		System.out.println("\nTitle of new tab (Home):==	 " + driver.getTitle());
		System.out.println("\nclosing the tab===	"+ driver.getTitle());
		Thread.sleep(3000);
		driver.close();
		Thread.sleep(3000);
		driver.switchTo().window(tablist.get(0));
		System.out.println("\nswitiched to parent tab"+ driver.getTitle());
		

		System.out.println("\nopening link -----  element_Links_home_dynamic");
		element_Links_home_dynamic.click();
		tablist = new ArrayList<>(driver.getWindowHandles());
		Thread.sleep(3000);
		System.out.println("\nswitiching to parent tab"+ driver.getTitle());
		Thread.sleep(3000);
		driver.switchTo().window(tablist.get(0));
		Thread.sleep(3000);
		System.out.println("\nSwitched back to the home_dynamic tab."+ driver.getTitle());
		Thread.sleep(3000);
		driver.switchTo().window(tablist.get(1));
		System.out.println("\nclosing the tab===	"+ driver.getTitle());
		Thread.sleep(3000);
		driver.close();
		driver.switchTo().window(tablist.get(0));
		System.out.println("\nswitiched to parent tab"+ driver.getTitle());

	}
	public void element_Links_api() throws Throwable
	{
		js = (JavascriptExecutor) driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		js.executeScript("arguments[0].scrollIntoView(true);", element_Links);
		System.out.println("ENTERING ELEMENT_LINKS_PAGE");
		element_Links.click();
		
		WebElement  created_link=driver.findElement(By.xpath("//*[@id=\"created\"]"));
		WebElement  no_content=driver.findElement(By.xpath("//*[@id=\"no-content\"]"));
		WebElement  moved=driver.findElement(By.xpath("//*[@id=\"moved\"]"));
		WebElement  bad_request=driver.findElement(By.xpath("//*[@id=\"bad-request\"]"));
		WebElement  unauthorised=driver.findElement(By.xpath("//*[@id=\"unauthorized\"]"));
		WebElement  forebidden=driver.findElement(By.xpath("//*[@id=\"forbidden\"]"));
		WebElement  not_found=driver.findElement(By.xpath("//*[@id=\"invalid-url\"]"));
		js.executeScript("arguments[0].scrollIntoView(true);", created_link,no_content,moved,bad_request,unauthorised,forebidden,not_found);
		System.out.println("clicking the below links & getting its response code");
		System.out.println("created_link");
		created_link.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("linkResponse")));
        String responseText = driver.findElement(By.id("linkResponse")).getText();	 System.out.println("Extracted Text: " + responseText);
		Thread.sleep(2000);
		System.out.println("no_content");
		no_content.click();	System.out.println("Extracted Text: " + driver.findElement(By.id("linkResponse")).getText());
		System.out.println("moved");
		moved.click();	System.out.println("Extracted Text: " + driver.findElement(By.id("linkResponse")).getText());
		System.out.println("bad_request");
		bad_request.click();	System.out.println("Extracted Text: " + driver.findElement(By.id("linkResponse")).getText());
		System.out.println("unauthorised");
		unauthorised.click();	System.out.println("Extracted Text: " + driver.findElement(By.id("linkResponse")).getText());
		System.out.println("forebidden");
		forebidden.click();	System.out.println("Extracted Text: " + driver.findElement(By.id("linkResponse")).getText());
		System.out.println("not_found");
		not_found.click();	System.out.println("Extracted Text: " + driver.findElement(By.id("linkResponse")).getText());
	}
	public void Element_Broken_Links() throws Throwable
	{
		js = (JavascriptExecutor) driver;		
		js.executeScript("arguments[0].scrollIntoView(true);", element_BrokenLinks);
		element_BrokenLinks.click();
		System.out.println("checking the image is valid or not");
		
        WebElement image = driver.findElement(By.xpath("//img[@src='/images/Toolsqa.jpg']"));
        boolean isImageDisplayed = image.isDisplayed();
        
        if (isImageDisplayed)
        {
            System.out.println("The image is displayed.");
        } else 
        {
            System.out.println("The image is not displayed.");
        }
    	System.out.println("checking the link is valid or not");
        WebElement valid_link= driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div[2]/a[1]")); 
		js.executeScript("arguments[0].scrollIntoView(true);", valid_link);
       // valid_link.click();
        String valid_url = valid_link.getAttribute("href");
        URL ob= new URL(valid_url);
		HttpURLConnection con	=(HttpURLConnection)ob.openConnection();
		int a=con.getResponseCode();
		System.out.println("checking for valid_link");
		System.out.println("Response code  ===== "+a);
	//	driver.navigate().back();
		
		  WebElement broken_link= driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div[2]/a[1]")); 
			js.executeScript("arguments[0].scrollIntoView(true);", broken_link);
		  //broken_link.click();
	        String broken_link_url = valid_link.getAttribute("href");
	        URL ob2= new URL(broken_link_url);
			HttpURLConnection con2	=(HttpURLConnection)ob.openConnection();
			int b=con.getResponseCode();
			System.out.println("\nchecking for broken_link");

			System.out.println("Response code  ===== "+b);
			//driver.navigate().back();*/
	}
	public void Element_upload_download() throws Throwable
	{  
		js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element_upload_download);
		System.out.println("entering ELEMENT UPLOAD & DOWNLOAD");
		element_upload_download.click();
		WebElement choose_file=driver.findElement(By.xpath("//*[@id=\"uploadFile\"]"));
		System.out.println("\nchoosing the file to upload ");
		js.executeScript("arguments[0].scrollIntoView(true);", choose_file);
		choose_file.sendKeys("E:\\\\xavier data\\\\error clear.txt");
		System.out.println("\nupload success");
		System.out.println("\n clicking on the download button");
		WebElement download_btn=driver.findElement(By.xpath("//*[@id=\"downloadButton\"]"));
		js.executeScript("arguments[0].scrollIntoView(true);", download_btn);
		download_btn.click();
		System.out.println("\n download success");
	}
	public void element_dynamic_pro()
	{
		js=(JavascriptExecutor) driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		js.executeScript("arguments[0].scrollIntoView(true);", element_dynamic_pro);
		System.out.println("\n entering element_dynamic_pro ");
		element_dynamic_pro.click();
		
		
        WebElement enable_5s_dButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"enableAfter\"]")));
		js.executeScript("arguments[0].scrollIntoView(true);", enable_5s_dButton);
        if (enable_5s_dButton.isEnabled()) {
            System.out.println("The upload button is enabled.");
        } else {
            System.out.println("The upload button is not enabled.");
        }
        if (enable_5s_dButton.isEnabled()) {
        	enable_5s_dButton.click();
        }
        WebElement color_Button = driver.findElement(By.xpath("//*[@id=\"colorChange\"]"));
		js.executeScript("arguments[0].scrollIntoView(true);", color_Button);
        String initialColor = color_Button.getCssValue("color");
        System.out.println("Initial button text color: " + initialColor);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"colorChange\"]")));
        String newColor = color_Button.getCssValue("color");
        System.out.println("Button text color after 5 seconds: " + newColor);
        
        if (!initialColor.equals(newColor)) {
            System.out.println("The button text color has changed.");
        } else {
            System.out.println("The button text color has not changed.");
        }
        
        
        WebElement visible_dButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"visibleAfter\"]")));
		js.executeScript("arguments[0].scrollIntoView(true);", visible_dButton);
        System.out.println("visible after 5 sec");
	}
	
	
	  
}

