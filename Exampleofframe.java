package Frames;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Exampleofframe {

	public static void main(String[] args) {

		         WebDriver driver = new ChromeDriver();
		        driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe");
		        driver.manage().window().maximize();
		        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		        // Step 1: Switch to the outer iframe (editor result window)
		        driver.switchTo().frame("iframeResult");

		        // Step 2: Switch to the inner iframe inside iframeResult
		        WebElement innerFrame = driver.findElement(By.xpath("//iframe"));
		        driver.switchTo().frame(innerFrame);

		        // Step 3: Now you're inside the W3Schools homepage iframe
		        String heading = driver.findElement(By.xpath("//h1")).getText();
		        System.out.println("Text inside inner frame: " + heading);

		        // Cleanup
		        driver.switchTo().defaultContent();
		        driver.quit();
		    }
		

	}


