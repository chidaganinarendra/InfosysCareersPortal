package StepDefinictions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.google.common.io.Files;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Infosyscareersportal  {

	WebDriver driver;

	@Given("User is on Login page")
	public void user_is_on_login_page() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(
				"https://intapidm.infosysapps.com/auth/realms/careersite/protocol/openid-connect/auth?client_id=careersite&redirect_uri=https%3A%2F%2Fcareer.infosys.com%2Fjobs%2Fprivacy-consent&state=b3630079-d26a-46c2-9204-dee5c664c6ce&response_mode=fragment&response_type=code&scope=openid&nonce=8ba78781-a310-425f-bd20-38a6bcccce43");
		/*
		 * driver.navigate().to(
		 * "https://intapidm.infosysapps.com/auth/realms/careersite/protocol/openid-connect/auth?client_id=careersite&redirect_uri=https%3A%2F%2Fcareer.infosys.com%2Fjobs%2Fprivacy-consent&state=b3630079-d26a-46c2-9204-dee5c664c6ce&response_mode=fragment&response_type=code&scope=openid&nonce=8ba78781-a310-425f-bd20-38a6bcccce43"
		 * ); driver.navigate().refresh(); driver.navigate().forward();
		 * driver.navigate().back();
		 */

		Thread.sleep(3000);

	}

	@When("User enter the Vaild Username and Password")
	public void user_enter_the_vaild_username_and_password() throws InterruptedException {

		WebElement web = driver.findElement(By.xpath("//input [@id = 'username']"));
		web.sendKeys("narendrachidagani55@gmail.com");
		WebElement web1 = driver.findElement(By.xpath("//input [@id = 'password']"));
		web1.sendKeys("Nari@1234");

		Thread.sleep(3000);

	}

	@And("Click on Login button")
	public void click_on_login_button() throws InterruptedException {

		WebElement web2 = driver.findElement(By.xpath("//button [@id = 'btnSubmit']"));
		web2.click();

		Thread.sleep(2000);
	}

	@Then("User is navigated to Home page")
	public void user_is_navigated_to_home_page() {

		Assert.assertTrue(driver.findElements(By.xpath(
				"//html//body//app-root//div[2]//div//app-jobs//div//div[1]//div[2]//app-poststatus//div//div//div[1]"))
				.size() > 0, "User is navigated to Home page");
	}

	@And("Click on the My Application")
	public void click_on_the_my_application() throws InterruptedException {

		WebElement web5 = driver.findElement(By.xpath(
				"//html//body//app-root//div[1]//app-header-jobs//div[3]//div//div//div[2]//header[1]//nav//div[1]//div[2]//ul//li[2]//a"));
		web5.click();
		Thread.sleep(3000);

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollBy(0,300)");
	}

	@And("User Takethe Screen_Shot")
	public void user_takethe_screen_shot() throws IOException, InterruptedException {

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		Files.copy(src, new File("C:\\Users\\Admin\\OneDrive\\Desktop\\Screen Shot\\GoogleScreenShot.jpg"));

		Thread.sleep(3000);
	}

	@And("Close The Browser")
	public void close_the_browser() {

		// driver.close();

	}
}
