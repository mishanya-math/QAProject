package web.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class login {
    private  static WebDriver driver;
    private  static boolean islogin;
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
    public void userLogin(){
        WebElement loginField = driver.findElement(By.id("user_email"));
        loginField.sendKeys("chernov_math@mail.ru");
        WebElement passwordField = driver.findElement(By.id("user_password"));
        passwordField.sendKeys("uraura");
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Login'and @type='submit']"));
        loginButton.click();
        WebElement messageElement     = driver.findElement(By.cssSelector("a[href='/@youngteacher/likes']"));
        islogin = messageElement.isEnabled();
        Assert.assertTrue(islogin == true);
    }
}

