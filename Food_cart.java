package project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FoodOrder {

    public static void main(String[] args) {
 
        System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);

        driver.get("http://127.0.0.1/onlinefood-php/login.php");

        WebElement usernameInput = driver.findElement(By.cssSelector("input[name='username']"));
        WebElement passwordInput = driver.findElement(By.cssSelector("input[name='password']"));
        WebElement loginButton = driver.findElement(By.cssSelector("input[name='submit']"));

        usernameInput.sendKeys("Nishat");
        passwordInput.sendKeys("Nishat123@");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        loginButton.click();

        driver.get("http://127.0.0.1/onlinefood-php/index.php");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement orderNowLink = driver.findElement(By.cssSelector("a.btn.theme-btn-dash.pull-right"));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        orderNowLink.click();

        for (int i = 0; i < 3; i++) {
        	 

            WebElement addToCartButton = driver.findElement(By.cssSelector("input.btn.theme-btn"));
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            addToCartButton.click();
        }
        
        driver.get("http://127.0.0.1/onlinefood-php/checkout.php?res_id=1&action=check");
        WebElement orderNowButton = driver.findElement(By.cssSelector("input[name='submit']"));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        orderNowButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.get("http://127.0.0.1/onlinefood-php/your_orders.php");
//        driver.quit();
    }
}
