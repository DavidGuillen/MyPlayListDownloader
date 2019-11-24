package playlist.youtube.downloader;

import java.util.List;

import org.openqa.selenium.By;

import connectors.MyDriver;
import playlist.youtube.pageIDs.PageIDs;

public class PlayListDownloader {

	private static final String SCONVERTER = "https://sconverter.com/";

	public void run() {
		new MyDriver(MyDriver.CHROME);
		selectPlayList();
//		downloadPlayList();
		downloadTube("https://www.youtube.com/watch?v=6485oNnwum8");

		// On laisse ouvert et apers on ferme
		pause(13);
		System.out.println("OK");
//		MyDriver.closeDriver();
	}

	private void downloadPlayList(List<String> list) {

	}

	private void downloadTube(String urlTube) {
		MyDriver.driver.get(SCONVERTER);
		MyDriver.driver.findElement(By.id(PageIDs.SEARCH_TEXT_ID)).sendKeys(urlTube);
		MyDriver.driver.findElement(By.id(PageIDs.SEARCH_BUTTON_ID)).click();
		MyDriver.driver.findElements(By.cssSelector(PageIDs.DOWNLOAD_BUTTON_CLASS)).get(0).click();
	}

	private void selectPlayList() {
		// TODO Auto-generated method stub

	}

	static void pause(int pauseSec) {
		try {
			Thread.sleep(pauseSec * 1000l);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}
}
