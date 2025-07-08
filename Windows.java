package WorkingOnWindows;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Windows {

	public static void main(String[] args) throws InterruptedException {

		WebDriver  driver=new ChromeDriver();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");
		driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		
		//To read first window title
		String pgTitle1=driver.getTitle();
		System.out.println("1st page title is:"+pgTitle1);
		
		//to click on try it
		driver.switchTo().frame("iframeResult");
		
        driver.findElement(By.xpath("/html/body/button")).click();
        Thread.sleep(3000);
        
        //to read opened window handles
        Set<String> pgHandles=driver.getWindowHandles();
        
        // to read each window handle
        Iterator<String> winHandles=pgHandles.iterator();
        
        //to read window handle into variables
        String win1=winHandles.next();
        String win2=winHandles.next();
        
        System.out.println(win1);
        System.out.println(win2);
        
        //to focus on 2nd window
        driver.switchTo().window(win2);
        
        //to read second window title
        String pgTitle2=driver.getTitle();
        System.out.println("2nd title is:"+pgTitle2);
        

        driver.switchTo().window(win2);
        
        driver.close();
        Thread.sleep(3000);

        driver.quit();

	}

}
