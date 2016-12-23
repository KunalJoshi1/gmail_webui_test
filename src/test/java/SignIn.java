import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by KJoshi on 12/14/16.
 */
public class SignIn {

        private static ChromeDriver driver;
        WebElement element;

    @Before
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/Selenium_broswer_drivers/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void loginShouldBeSuccessful(){

//        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/Selenium_broswer_drivers/chromedriver");
//        WebDriver driver = new ChromeDriver();

        driver.navigate().to("http://mail.google.com");

        WebElement usernameTextBox = driver.findElement(By.id("Email"));
        usernameTextBox.clear();
        usernameTextBox.sendKeys("glassverre2");

        WebElement nextButton = driver.findElement(By.xpath("//*[@id='next']"));
        nextButton.click();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        ExpectedCondition<WebElement> condition = ExpectedConditions.visibilityOfElementLocated(By.id("Passwd"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Passwd")));

        WebElement pwdTextBox = driver.findElement(By.id("Passwd"));

        pwdTextBox.click();
        pwdTextBox.clear();
        pwdTextBox.sendKeys("glasstesting");

        WebElement staySignedInCheckbox = driver.findElement(By.xpath("//*[@id='PersistentCookie']"));
        staySignedInCheckbox.click();

        WebElement signInButton = driver.findElement(By.id("signIn"));
        signInButton.click();

        Assert.assertTrue("Inbox should be present!!",driver.findElements(By.partialLinkText("Inbox")).size()>0);

        WebElement profButton = driver.findElement(By.cssSelector("a.gb_b.gb_db.gb_R"));
        profButton.click();

        WebElement signOutLink = driver.findElement(By.id("gb_71"));
        signOutLink.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"next\"]")));
        Assert.assertTrue("Sign In button should exist", driver.findElements(By.xpath("//*[@id=\"next\"]")).size()>0);





        //driver.close();
    }

//   s
}
