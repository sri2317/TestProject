package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage {
	
	WebDriver driver;

	By txt_userName = By.name("loginUsername");
	By txt_Password = By.name("loginPassword");
	By btn_login = By.xpath("//button[normalize-space()='Login']");
	
	
	
	public loginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public void enterUsername(String username) {
		
		driver.findElement(txt_userName).sendKeys(username);
		
	}
	
	public void enterpassword(String password) {
		
		driver.findElement(txt_Password).sendKeys(password);

	}
	
	public void clickLogin() {
		
		driver.findElement(btn_login).click();
	}
	
	
}


