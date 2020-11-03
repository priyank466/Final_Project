import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;


public class SecondClass {

    ChromeDriver  driver;
    int countDisplayedImages = 0;
    @BeforeTest
    void openBrowser() {

        System.setProperty("webdriver.chrome.driver", "C:\\\\Program Files\\\\Drivers\\\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://s1.demo.opensourcecms.com/wordpress/");
    }
    @Test
    void countImages() {
        List<WebElement> imgnums = driver.findElements(By.tagName("img"));

        //this is extra work to check how many images are displayed
        for(WebElement img:imgnums)
        {
            if(img.isDisplayed())
            {
                countDisplayedImages += 1;

            }
        }

        System.out.println("Number of images are : " + imgnums.size());

        System.out.println("Displayed images are: "+countDisplayedImages);

    }
    @Test
    void countButtons() {
        List<WebElement> btns = driver.findElements(By.tagName("button"));
        System.out.println("Number of buttons are : "+btns.size());


    }
    @AfterClass
    void closeBrowser()
    {
        driver.close();

    }
}
