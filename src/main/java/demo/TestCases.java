package demo;

import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCases {
    ChromeDriver driver;

    public TestCases() {
        System.out.println("Constructor: TestCases");

        WebDriverManager.chromedriver().timeout(30).setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.INFO);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);

        // Connect to the chrome-window running on debugging port
        options.setExperimentalOption("debuggerAddress", "127.0.0.1:9222");

        // Set path for log file
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);

        // Set browser to maximize and wait
        driver.manage().window().maximize();
    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    public void testCase01() {
        System.out.println("Start Test case: testCase01");
        driver.get("https://calendar.google.com/ ");
        String url = driver.getCurrentUrl();
        if (url.contains("calendar")) {
            System.out.println("Test Case Passed: URL Contains " + url);
        }

        System.out.println("end Test case: testCase01");
    }

    public void testCase02() throws InterruptedException {
        System.out.println("Start Test case: testCase02");
        Thread.sleep(7000);

        WebElement option = driver.findElement(By.xpath("(//span[@jsname='V67aGc'])[5]"));
        option.click();
        WebElement SwitchMonth = driver.findElement(By.xpath("(//span[@class='VfPpkd-StrnGf-rymPhb-b9t22c'])[3]"));
        SwitchMonth.click();
        Thread.sleep(5000);
        WebElement date = driver.findElement(By.xpath("(//div[@class='qLWd9c'])[25]"));
        date.click();
        Thread.sleep(5000);
        WebElement task = driver.findElement(By.xpath("(//div[@class='x5FT4e kkUTBb'])[4]"));
        task.click();
        Thread.sleep(5000);
        // WebElement date = driver.findElement(By.xpath("(//input[@value='Saturday,
        // June 22'])[1]"));
        // date.click();
        // Thread.sleep(5000);
        // WebElement date22 =
        // driver.findElement(By.xpath("(//div[@aria-label='22'])[2]"));
        // date22.click();
        WebElement title = driver.findElement(By.xpath("(//input[@class='VfPpkd-fmcmS-wGMbrd '])[2]"));
        title.click();
        title.sendKeys("Crio INTV Task Automation");
        Thread.sleep(5000);
        WebElement description = driver.findElement(By.xpath("//textarea[@class='VfPpkd-fmcmS-wGMbrd TaTzUd']"));
        description.click();
        description.sendKeys(" Crio INTV Calendar Task Automation");
        Thread.sleep(10000);
       
        // String dynamicPath = "//span[text()='Save']"; // Example of a dynamic XPath
        // WebElement button = driver.findElement(By.xpath(dynamicPath));
        // button.click();
        WebElement button = driver.findElement(By.xpath("//span[text()='Save']"));
Actions actions = new Actions(driver);
actions.moveToElement(button).click().perform();

                System.out.println("end Test case: testCase02");

    }

    public void testCase03() throws InterruptedException {
        System.out.println("Start Test case: testCase03");
WebElement click = driver.findElement(By.xpath("//span[text()='Crio INTV Task Automation']"));
click.click();
Thread.sleep(3000);
WebElement edit = driver.findElement(By.xpath("(//button[contains(@class,'VfPpkd-Bz112c-')])[19]"));
edit.click();
Thread.sleep(3000);
WebElement desc = driver.findElement(By.xpath("//textarea[@class='VfPpkd-fmcmS-wGMbrd vRGQ0d']"));
desc.click();
desc.clear();
desc.sendKeys("Crio INTV Task Automation is a test suite designed for automating various tasks on the Google Calendar web application");

WebElement button = driver.findElement(By.xpath("//span[text()='Save']"));
Actions actions = new Actions(driver);
actions.moveToElement(button).click().perform();
Thread.sleep(5000);
WebElement click1 = driver.findElement(By.xpath("//span[text()='Crio INTV Task Automation']"));
click1.click();
Thread.sleep(5000);
WebElement verifyDes = driver.findElement(By.xpath("//div[@class='toUqff D29CYb']"));
String verify = verifyDes.getText();
Thread.sleep(5000);
if (verify.contains("Crio INTV Task Automation is a test suite designed for automating various tasks on the Google Calendar web application")) {
    System.out.println("Test Passed: Task description is successfully updated." );
} else {
    System.out.println("Test Failed: Task description is not updated as expected." );
}
        System.out.println("end Test case: testCase03");
        Thread.sleep(5000);
    }

    public void testCase04() throws InterruptedException {
        System.out.println("Start Test case: testCase04");
       
        WebElement title = driver.findElement(By.xpath("(//span[text()='Crio INTV Task Automation'])[2]"));
        String tit = title.getText();
        System.out.println(tit);
        Thread.sleep(5000);
        WebElement delete = driver.findElement(By.xpath("//button[@aria-label='Delete task']"));
delete.click();
Thread.sleep(5000);


WebElement confirmationMessage = driver.findElement(By.xpath("//div[@class='VYTiVb']"));
if (confirmationMessage.getText().equals("Task deleted")) {
    System.out.println("Task deletion confirmation message verified.");
} else {
    System.out.println("Task deletion confirmation message verification failed.");
    // Handle failure scenario
}
        System.out.println("end Test case: testCase04");
    }



}
