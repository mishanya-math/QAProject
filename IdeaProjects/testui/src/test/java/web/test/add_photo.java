package web.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import java.io.File;
import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;
import java.awt.Robot;
import java.awt.AWTException;
public class add_photo {
    private  static WebDriver driver;
    private  static String revew_message;
    private  static boolean is_pickcher;

    @BeforeClass
    public  void setup(){
        System.setProperty("webdriver.chrome.driver", "/home/misha/Загрузки/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://unsplash.com");
        WebElement login_press_button = driver.findElement(By.linkText("Login"));
        login_press_button.click();
    }
    @Test
    public void userLogin() throws InterruptedException, AWTException{
        WebElement loginField = driver.findElement(By.id("user_email"));
        loginField.sendKeys("chernov_math@mail.ru");
        WebElement passwordField = driver.findElement(By.id("user_password"));
        passwordField.sendKeys("uraura");
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Login'and @type='submit']"));
        loginButton.click();
        WebElement submit_photo = driver.findElement(By.linkText("Submit a photo"));
        submit_photo.click();
        File file = new File("/home/misha/Загрузки/proverka_tcveta.jpg");
        WebElement add_pickcher = driver.findElement(By.linkText("Add a photo"));
        add_pickcher.click();
        StringSelection stringSelection = new StringSelection(file.getAbsolutePath());
	    Toolkit.getDefaultToolkit().getSystemClipboard()
			.setContents(stringSelection, null);
        Robot robot = new Robot();
		robot.delay(1000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.delay(300);
		robot.keyPress(KeyEvent.VK_V);
		robot.delay(300);
		robot.keyRelease(KeyEvent.VK_V);
		robot.delay(300);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.delay(300);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.delay(300);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(300);

		//driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);

        WebElement add_tag = driver.findElement(By.xpath("//input[@class='ui-autocomplete-input']"));
        add_tag.sendKeys("piz,de,ts,");
        WebElement  next = driver.findElement(By.xpath("//input[@value='Next'and @type='submit']"));
        next.click();

        WebElement  next_check = driver.findElement(By.xpath("//input[@value='Next'and @type='submit']"));
        next_check.click();

        WebElement  write_Title = driver.findElement(By.xpath("//input[@name='story_attributes[title]'and @type='text']"));
        write_Title.sendKeys("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

        WebElement  write_Story = driver.findElement(By.name("story_attributes[description]"));
        write_Story.sendKeys("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");

        WebElement  nex_after_write_Story = driver.findElement(By.xpath("//input[@value='Next'and @type='submit']"));
        nex_after_write_Story.click();


        WebElement check_box = driver.findElement(By.xpath("//input[@type='checkbox'and @name='photo_location_attributes[confidential]']"));
        check_box.click();

        driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);

       WebElement  submit_button = driver.findElement(By.xpath("//input[@type='submit'and @value='Submit']"));
       submit_button.click();

       revew_message = driver.findElement(By.cssSelector("h1[class='alpha text-center text-sans text-weight--bold']")).getText();

       Assert.assertEquals(revew_message,"Thank you");

       WebElement messageElement     = driver.findElement(By.cssSelector("a[href='/@youngteacher']"));
       messageElement.click();

       WebElement View_photo     = driver.findElement(By.cssSelector("div[class='bQJ8Z']"));
       is_pickcher = View_photo.isEnabled();
       Assert.assertTrue(is_pickcher == true);


    }
}

