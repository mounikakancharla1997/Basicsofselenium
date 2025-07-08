package Frames;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Example2 {

	public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_iframe");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        driver.switchTo().frame("iframeResult");
        
        WebElement innerFrame = driver.findElement(By.xpath("//iframe"));
        driver.switchTo().frame(innerFrame);

        WebElement header = driver.findElement(By.xpath("/html/body//*[@id='subtopnav']/a[1]")); // ✅ Store
        String text = header.getText(); // Step 2: get the text
        System.out.println("Link text is: " + text); // Print the text
        header.click(); // Step 3: click the element


	}

}
