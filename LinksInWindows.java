package WorkingOnWindows;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinksInWindows {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver=new ChromeDriver();
		driver.get("https://testpages.herokuapp.com/styled/windows-test.html");
		driver.manage().window().maximize();
		
		// Get the original window handle
		String originalWindow = driver.getWindowHandle();
		System.out.println("Main window title:"+driver.getTitle());
		
		// Get all link elements
        List<WebElement>pgLinks=driver.findElements(By.tagName("a"));
		System.out.println(pgLinks.size());
		
		for(int i=0;i<pgLinks.size()-1;i++) {
			String pgLink=pgLinks.get(i).getText();
			if(!pgLink.isEmpty()) {
				System.out.println("Clicking link:"+pgLink);
				pgLinks.get(i).click();
				Thread.sleep(3000);
				// Get all window handles after click

				Set<String>windowHandles=driver.getWindowHandles();
				// If a new window is opened

				if(windowHandles.size()>1) {
					List<String> windows=new ArrayList<>(windowHandles);	
					// Find the newly opened window (not equal to the original)
                    for(String win:windows){
                    	if(!win.equals(originalWindow)) {
                    		driver.switchTo().window(win);
                    		
                    		System.out.println("New window title:"+driver.getTitle());
							driver.close(); // Close new window
							break;

                    	}
	
}
				driver.switchTo().window(originalWindow);
				}
				
				else {
					driver.navigate().back();//If no new window, go back
				}
				// Reload elements after navigation

				driver.navigate().to("https://testpages.herokuapp.com/styled/windows-test.html");
				pgLinks=driver.findElements(By.tagName("a"));
			}
		}
		driver.quit();
	}

}
