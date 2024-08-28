package Test_package;

import org.testng.annotations.Test;

import Base_package.Home_page_Base_class;
import Page_package.Home_page;
import Page_package.module_Alerts_frames_window_page;
import Page_package.module_book_store_app_page;
import Page_package.module_element_page;
import Page_package.module_forms_page;
import Page_package.module_interaction_page;
import Page_package.module_widget_page;

public class page_test extends Home_page_Base_class
{

@Test(priority=1)
    public void home_page_test() throws Throwable 
    {
        Home_page hm_obj = new Home_page(driver);
        hm_obj.homepage_title_logo();
        hm_obj.module_interact();
    }
	
@Test(priority=2)
	public void module_element_page_test() throws Throwable
	{
		module_element_page obj=new module_element_page(driver);
		obj.element_textbox();
		obj.element_checkbox();
		obj.element_RadioButton();
		obj.element_Web_Table();
		obj.element_Web_Table_add();
		obj.element_Web_Table_delete_and_search();
		obj.element_web_table_rows_select();
		obj.element_button();
		obj.element_Links();
		obj.element_Links_api();
		obj.Element_Broken_Links();
		obj.Element_upload_download();
		obj.element_dynamic_pro();
	}

@Test(priority=3)
	public void module_forms_page_test() throws Throwable
	{
		module_forms_page obj=new  module_forms_page(driver);
		obj.module_forms_page();
		obj.Student_Registration_Form();
		obj.Student_Registration_Form_radio("female");
		obj.date_of_birth("September 2024","25");
		obj.Hobbies_select();
		obj.file_upload();
		obj.state_city___submit();
	}
	
@Test(priority=4)
	public void module_Alerts_frames_window_page_test() throws Throwable
	{
		module_Alerts_frames_window_page oba=new module_Alerts_frames_window_page(driver);
		oba.alerts_frames_windowElement();
		oba.Alerts_page();
		oba.frames();
		oba.nested_frame(); 
	}
	
@Test(priority=5)
	public void module_widget_page_test() throws Throwable
	{
		module_widget_page obj=new module_widget_page(driver);
		obj.widgetpage();
		obj.widget_multiple();
		obj.widget_single();
		obj.widget_slider();
		obj.widget_bar();
		obj.tool_tips_page();
		obj.menu_page();
		
	}
	
@Test(priority=6)
	public void module_INTERACTION_page_test() throws Throwable
	{
	module_interaction_page obj= new module_interaction_page(driver);
	
		obj.module_interaction();
		Thread.sleep(3000);
		obj.resizeable();
		obj.drag_drop();
	}
@Test(priority=7)
	public void MODULE_Book_Store_Application() throws Throwable
	{
	 module_book_store_app_page ob=new  module_book_store_app_page(driver);
	 ob.Book_Store_Application();
	// ob.register();
	 ob.login();
	 Thread.sleep(3000);
	ob.profile();
	ob.register();
	 

	
	}
}
