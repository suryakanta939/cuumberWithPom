package stepDefination;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.TestRoom.BaseClasses.InvokeBrowser;
import com.TestRoom.BaseClasses.ReadPropertyData;
import com.TestRoom.CommonClasses.WindowHandel;
import com.TestRoom.PageClasses.RoomHomePage;
import com.TestRoom.ReportClasses.ExtentFactory;
import com.TestRoom.ScreenShotClasses.ScreenShot;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomePageStepDefinations {
	 WebDriver driver;
	 ExtentTest test;
	 ExtentReports report;
	RoomHomePage hp;
	String brwoser;
	String baseUrl;
	
	@Before
	public void settingUp() throws IOException{
		report=ExtentFactory.getInstance();
		test=report.startTest("checking the home page");
	  brwoser=ReadPropertyData.getData("testdata", "browserName");
	  baseUrl=ReadPropertyData.getData("testdata", "URL");
		driver=InvokeBrowser.openBrowser(brwoser);
		test.log(LogStatus.INFO, "browser opened");
		driver.get(baseUrl);
		test.log(LogStatus.INFO, "url is entered");
		driver.manage().window().maximize();
		hp=new RoomHomePage(driver, test);
	}
	@After
	public void tearDown(Scenario scn) throws IOException{
		if(scn.getStatus().equalsIgnoreCase("passed")){
			
			test.log(LogStatus.PASS, "test case got pass");
		}
		if(scn.isFailed()==true){
			String path=ScreenShot.takeAScreenShot(driver, scn.getName());
			test.log(LogStatus.FAIL,"testcase got fail",test.addScreenCapture(path));
		}
		else{
			System.out.println("The status is "+ scn.getStatus());
			test.log(LogStatus.INFO, "getting the status");
		}
				
		driver.close();
		test.assignAuthor("suryakanta sahoo");
		report.endTest(test);
		report.flush();
	}
	
	@Given("^user is on the home landing page$")
	public void user_is_on_the_home_landing_page()  {
		 hp.home.click();
		 test.log(LogStatus.INFO, "clicked on the home page");
	   System.out.println("user is on landing page");
	}

	@Then("^user reads the welcome text$")
	public void user_reads_the_welcome_text() {
	  String text=hp.welcome_message.getText();
	  System.out.println(text);
	  test.log(LogStatus.INFO, "read the text message");
	}

	@Then("^also reads the description$")
	public void also_reads_the_description()  {
	 String text=hp.description.getText();
	 System.out.println(text);
	 test.log(LogStatus.INFO, "read the text description message");
	}

	@Given("^user clicks on the terms$")
	public void user_clicks_on_the_terms() throws InterruptedException  {
	   hp.terms.click();
	   Thread.sleep(1000);
	   test.log(LogStatus.INFO, "clicked on the terms");
	}

	@When("^new window will open$")
	public void new_window_will_open()  {
		WindowHandel.handelWindowByNo(driver,2);
		driver.manage().window().maximize();
	    test.log(LogStatus.INFO, "passed the driver control to the new window");
	}

	@Then("^read the text from the new window$")
	public void read_the_text_from_the_new_window() {
		 
	   String message=hp.newWindowMessage.getText();
	   System.out.println(message);
	   test.log(LogStatus.INFO, "read the new window message");
	}
}
