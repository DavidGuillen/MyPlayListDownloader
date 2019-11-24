package playlist.downloader.y2mate;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import connectors.MyDriver;

public class Y2Mate {

	private static final String Y2MATE_URL = "https://www.y2mate.com/youtube";

	public static void download(String URL) {
		new MyDriver();

		// Go to Y2Mate and search for the video
		MyDriver.driver.get(Y2MATE_URL);
		MyDriver.driver.findElement(By.id("txt-url")).sendKeys(URL);
		MyDriver.pause(4);
		MyDriver.driver.findElement(By.id("btn-submit")).click();

		// Set the possibilities to download
		MyDriver.driver.findElement(By.partialLinkText("Audio")).click();
		MyDriver.driver.findElement(By.id("dbtn-mp3128")).click();

		WebDriverWait wait = new WebDriverWait(MyDriver.driver, 100);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.className("#process-result .glyphicon.glyphicon-download-alt")));
		//
		MyDriver.driver.findElement(By.className("#process-result .glyphicon.glyphicon-download-alt")).click();

		System.out.println("END");
	}
}
