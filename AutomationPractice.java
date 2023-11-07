package Testingpackage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutomationPractice {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);

		driver.get("https://trytestingthis.netlify.app/");

		driver.findElement(By.id("[id=\"fname\"]")).sendKeys("venkatesh");
		driver.findElement(By.id("[id=\"lname\"]")).sendKeys("kooch");
		driver.findElement(By.id("[id=\"male\"]")).click();
		WebElement ddaddr = driver.findElement(By.name("\"Optionwithcheck[]"));
		ddaddr.click();
		Select sel = new Select(ddaddr);
		sel.selectByVisibleText(" Option 1"); // select by visible text
		sel.selectByValue("Option 3"); // select by value
		driver.findElement(By.xpath("//label[text()=' Option 3']")).click();

		WebElement text_field = driver.findElement(By.cssSelector("input[list=\"datalists\"]"));
		String searchQuery = "Cho";
		text_field.sendKeys(searchQuery);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		Actions act = new Actions(driver);
		act.sendKeys(Keys.DOWN).perform();
		act.sendKeys(Keys.ENTER).perform();

		driver.findElement(By.id("favcolor")).click(); // choose favorite color

		// select a date
		WebElement dateInput = driver.findElement(By.cssSelector("[type=\"date\"]"));
		dateInput.clear();
		String dateToEnter = "12/31/111113";
		dateInput.sendKeys(dateToEnter);

		// see a range value

		// file upload
		WebElement fileupload = driver.findElement(By.cssSelector("input[list=\"datalists\"]"));

		String filepath = "Specify the path to/the file you want to/upload.txt"; // relative path
		fileupload.sendKeys(filepath);

		// Select a quantity from a range
		driver.findElement(By.xpath("//input[@id='quantity']")).sendKeys("5");

		driver.findElement(By.name("message"))
				.sendKeys("skills: html,java,selenium,cypress,git,github,jenkins,jira,appium");

		driver.findElement(By.xpath("//button[@class=\"btn btn-success\"]")).click(); // submit button

		// layout page
		driver.findElement(By.xpath("//button[text()=' Your Sample Alert Button!']")).click();
		Alert al = driver.switchTo().alert();
		al.accept(); // click on the OK button.

		WebElement doubleclick = driver.findElement(By.xpath("//button[@ondblclick='myFunction()']"));
		Actions actions = new Actions(driver);
		actions.doubleClick(doubleclick).perform();// double click actions

		WebElement drag1 = driver.findElement(By.id("drag1"));
		WebElement drag2 = driver.findElement(By.xpath("//div[@ondragover=\"allowDrop(event)\"]"));
		Actions ac = new Actions(driver);
		ac.dragAndDrop(drag1, drag2).perform();// drag and drop methods

		driver.findElement(By.xpath("//input[@id='uname']")).sendKeys("test"); // username
		driver.findElement(By.xpath("//input[@id='pwd']")).sendKeys("test"); // password
		driver.findElement(By.cssSelector("input[type='submit']")).click(); // login button

	}

}
