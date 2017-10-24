package selt2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SecTest {

    private static WebDriver driver;

    @BeforeTest
    public static void setDriver(){
        System.setProperty("webdriver.chrome.driver","C://Users//serg-qa//Downloads/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.google.com.ua");
    }
    @Test
    public void userSearch() throws InterruptedException {

        WebElement searchField = driver.findElement(By.xpath(".//*[@id='lst-ib']"));
        searchField.sendKeys("коллайдер");
        searchField.submit();

        List <WebElement> searchRez1 = driver.findElements(By.xpath("//h3[@class='r']/a"));
        for (int i = 0; i < searchRez1.size(); i++) {
            System.out.println(searchRez1.get(i).getText());
            System.out.println(searchRez1.get(i).getAttribute("href"));
            }

            driver.get(searchRez1.get(5).getAttribute("href"));
        Assert.assertEquals(driver.getTitle(), "Большой адронный коллайдер: жизнь после Хиггса - YouTube");

//        try {
//            Thread.sleep(30000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

    }

    @AfterTest
    public void tearDown(){driver.quit();}

}
