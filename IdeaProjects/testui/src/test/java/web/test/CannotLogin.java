package web.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class CannotLogin {
    private  static WebDriver driver;
    private  static String allert_massage;
    @BeforeClass
    public  void setup(){
        System.setProperty("webdriver.chrome.driver", "/home/misha/Загрузки/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://unsplash.com");
        WebElement login_press_button = driver.findElement(By.linkText("Login"));
        login_press_button.click();
    }
    @Test
    public void errorwithlogin(){
        WebElement loginField = driver.findElement(By.id("user_email"));
        loginField.sendKeys("sfe34266@gmail.com");
        WebElement passwordField = driver.findElement(By.id("user_password"));
        passwordField.sendKeys("1993agrq");
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Login'and @type='submit']"));
        loginButton.click();
        //String msg_in_alert=driver.switchTo().alert().getText();
        allert_massage = driver.findElement(By.xpath("//div[@class='col-xs-10 col-sm-6 center-block flash__message']")).getText();
        Assert.assertEquals(allert_massage,"Invalid email or password.");
    }
}
