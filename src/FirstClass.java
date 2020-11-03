import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class FirstClass {
    ChromeDriver driver;

    @BeforeClass
    void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\\\Program Files\\\\Drivers\\\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://s1.demo.opensourcecms.com/wordpress/");
    }
    @Test
    void checkTitle() {
        Assert.assertEquals(driver.getTitle(), "opensourcecms – Just another WordPress site", "Title is not matching");
    System.out.println("Title has been matched");
    }
    @Test
    void checkDisplayingImg(){
        driver.findElementByXPath("//*[@id=\"wp-custom-header\"]/img").isDisplayed();

        System.out.println("Image has been displayed");
    }
    @AfterClass
    void closeBrowser()
    {
        driver.close();

    }
}
