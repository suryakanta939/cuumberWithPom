package stepDefination;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.TestRoom.BaseClasses.InvokeBrowser;
import com.TestRoom.BaseClasses.ReadPropertyData;
import com.TestRoom.CommonClasses.SelectFunctions;
import com.TestRoom.PageClasses.AdoptionPage;
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

public class AdoptionAnimalSteps {
	 WebDriver driver;
	 ExtentTest test;
	 ExtentReports report;
	RoomHomePage hp;
	AdoptionPage ap;
	String brwoser;
	String baseUrl;
	@Before
	public void setting() throws IOException{
		report=ExtentFactory.getInstance();
		test=report.startTest("checking the home page");
	  brwoser=ReadPropertyData.getData("testdata", "browserName");
	  baseUrl=ReadPropertyData.getData("testdata", "URL");
		driver=InvokeBrowser.openBrowser(brwoser);
		test.log(LogStatus.INFO, "browser opened");
		
		hp=new RoomHomePage(driver, test);
		ap=new AdoptionPage(driver, test);
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
	
	@Given("^user is on the landing page$")
	public void user_is_on_the_landing_page() throws Throwable {
		driver.get(baseUrl);
		test.log(LogStatus.INFO, "url is entered");
		driver.manage().window().maximize();

	}

	@When("^user clicks on the adoption$")
	public void user_clicks_on_the_adoption() throws Throwable {
      ap.adoption.click();
      test.log(LogStatus.INFO, "clciekd on the adoption");

	}

	@Then("^will confirm that user is on adoption page$")
	public void will_confirm_that_user_is_on_adoption_page() throws Throwable {
     String text=ap.adoptionconfirm.getText();
       //assertEquals(text, "ADOPTION OPTIONS");
     System.out.println(text);
     test.log(LogStatus.INFO, "we are on adoption page");

	}

	@Then("^user can see the adoption page and the animals$")
	public void user_can_see_the_adoption_page_and_the_animals() throws Throwable {

          System.out.println("user is seeing the animals");
	}

	@Then("^user will note the available animals$")
	public void user_will_note_the_available_animals() throws Throwable {
         for(int j=2;j<4;j++){
        	 String animal=ap.animalType(j).getText();
        	 System.out.println("the animals are "+animal);
         }
         test.log(LogStatus.INFO, "noted the animals");

	}

	@Given("^user will select the date$")
	public void user_will_select_the_date() throws Throwable {
      SelectFunctions.selectByValue(ap.date, "fmonth");
      test.log(LogStatus.INFO, "date is selected");

	}

	@When("^user will click on the check$")
	public void user_will_click_on_the_check() throws Throwable {
     ap.checkbutton1.click();
     test.log(LogStatus.INFO, "user clicked on the chek");

	}

	@Then("^user has to note the availabity$")
	public void user_has_to_note_the_availabity() throws Throwable {
     String text=ap.result.getText();
     System.out.println(text);
     test.log(LogStatus.INFO, "user noted the result");
	}
	@When("^user will click on the check for turtle$")
	public void user_will_click_on_the_check_for_turtle() throws Throwable {
	    ap.checkbutton2.click();
	    test.log(LogStatus.INFO, "user clciked on the check button of tutle");
	}
	@Then("^user will enter \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_will_enter_and(String name, String adress) throws Throwable {
       ap.nameField.sendKeys(name);
       test.log(LogStatus.INFO, "enterd the name");
       ap.adressField.sendKeys(adress);
       test.log(LogStatus.INFO, "enterd the adress");

	}

	@Then("^then will enter \"([^\"]*)\" and \"([^\"]*)\"$")
	public void then_will_enter_and(String post, String email) throws Throwable {
       ap.postcodeField.sendKeys(post);
       test.log(LogStatus.INFO, "enterd the post");
       ap.emailField.sendKeys(email);
       test.log(LogStatus.INFO, "enterd the email");

	}

	@Then("^will click on the check button$")
	public void will_click_on_the_check_button() throws Throwable {
    ap.submit.click();
    test.log(LogStatus.INFO, "clieked  the submit");

	}


}
