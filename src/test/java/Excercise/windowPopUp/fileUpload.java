package Excercise.windowPopUp;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumOptions;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class fileUpload {

	public static void main(String[] args) throws InterruptedException, IOException {

		String downloadPath = System.getProperty("user.dir");
		
		WebDriverManager.chromedriver().setup();
		
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadPath);
		
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);		
		
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://www.ilovepdf.com/pdf_to_jpg");
		driver.findElement(By.id("pickfiles")).click();
		Thread.sleep(1000);
		Runtime.getRuntime().exec("C:\\Users\\Gagi\\Documents\\fileupload.exe");
		Thread.sleep(1000);
		driver.findElement(By.id("processTask")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("pickfiles")).click();
		File f = new File(downloadPath+"/ilovepdf_pages-to-jpg.zip");
		Thread.sleep(5000);


		if(f.exists())
		{
			Assert.assertTrue(f.exists());
			if(f.delete())
			{
				System.out.println("File deleted");
			}
		}
		

	}

}
