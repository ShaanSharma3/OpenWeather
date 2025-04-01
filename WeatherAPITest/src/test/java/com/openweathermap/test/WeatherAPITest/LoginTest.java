package com.openweathermap.test.WeatherAPITest;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testLogin() throws InterruptedException {
        driver.get("https://openweathermap.org/");
        driver.findElement(By.linkText("Sign in")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("user_email")).sendKeys("shansharma417@gmail.com");
        driver.findElement(By.id("user_password")).sendKeys("1234@4321");
        driver.findElement(By.name("commit")).click();
        Thread.sleep(3000);

        assertTrue(driver.getPageSource().contains("Dashboard") || driver.getPageSource().contains("Logout"), "Login failed!");
    }

    @AfterEach
    public void tearDown() {
       // driver.quit();
    }
}
