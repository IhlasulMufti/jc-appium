package com.juaracoding;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class TixIDTest {

    AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("deviceName", "Redmi 10A");
        dc.setCapability("udid", "S8XOZLLVIRNNOB85");
        dc.setCapability("platformName", "Android");
        dc.setCapability("platformVersion", "11");
        dc.setCapability("appPackage", "id.tix.android");
        dc.setCapability("appActivity", ".splash.view.SplashActivity");
        dc.setCapability("noReset", true);
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver(url, dc);
    }

    @AfterClass
    public void finish() {
        delay(5);
        driver.quit();
    }

    @Test
    public void testSearchMovie() {
        delay(5);
        MobileElement search = (MobileElement) driver.findElement(By.id("id.tix.android:id/et_input"));
        search.click();
        delay(3);
        driver.findElement(By.id("id.tix.android:id/et_input")).sendKeys("venom");
        MobileElement searchFirst = (MobileElement) driver.findElement(By.id(("id.tix.android:id/tv_search_first")));
        searchFirst.click();
        String getTitleMovie = driver.findElement(By.id("id.tix.android:id/tv_title_of_movie")).getText();
        Assert.assertTrue(getTitleMovie.contains("VENOM"));
    }

    public static void delay(long detik){
        try {
            Thread.sleep(detik*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
