package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.loginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login {

  WebDriver driver =null;
  loginPage login;
	@Given("user is on login page")
	public void user_is_on_login_page() {
		System.out.println("User is on login page");
		
		// to set relative path
		String projectpath=System.getProperty("user.dir");
		System.out.println("Project path is:"+projectpath);
		System.setProperty("webdriver.chrome.driver",projectpath+"/src/test/resources/drivers/chromedriver.exe");
		driver= new ChromeDriver();
		
		// to wait till the chrome driver launches and to maximize
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		//Launching url
		driver.navigate().to("https://login.dev.qa-experience.com");
			}

	@When("^user enters(.*)and(.*)$")
	public void user_enters_username_and_password(String username, String password) throws InterruptedException {
		System.out.println("User enters username and password");
		
		loginPage login = new  loginPage(driver);
		login.enterUsername(username);
		//driver.findElement(By.name("loginUsername")).sendKeys(username);
		Thread.sleep(5000);;
		//driver.findElement(By.name("loginPassword")).sendKeys(password);
		login.enterpassword(password);
		Thread.sleep(2000);
	}

	@And("clicks on login button")
	public void clicks_on_login_button() {
		System.out.println("User click on  login button");
		loginPage login = new  loginPage(driver);
		login.clickLogin();
		//driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
	}

	@Then("user is successfully logged in!")
	public void user_is_successfully_logged_in() throws InterruptedException {
		System.out.println("User login to homepage");
		Thread.sleep(2000);
		driver.close();
	}

}
