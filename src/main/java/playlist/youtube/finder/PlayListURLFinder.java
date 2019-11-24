package playlist.youtube.finder;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import connectors.MyDriver;
import playlist.youtube.pageIDs.PageIDs;

public class PlayListURLFinder {

	private static final String URL = "https://www.youtube.com/watch?v=GCpvmHi1gxU&list=PLV9Y77TQ4I9dYBu7yXGrQbiiUbhgrAYZv&index=1";

	public static List<String> getURLList(String url) {
		new MyDriver();
		MyDriver.driver.get(url);
		List<String> allTubes = new ArrayList<>();
		allTubes.add(url); // On ajoute la premiere video a la liste

		int numberOfListes = getNumberOfVideosInThePlayList();
		System.out.println("Nombre de videos: " + numberOfListes);

		List<WebElement> allURLWebElements = getAllURLWebElements();
		for (int i = 1; i < numberOfListes; i++) {
			allTubes.add(allURLWebElements.get(i).getAttribute("href"));
		}
		MyDriver.quitDriver();
		return allTubes;
	}

	private static List<WebElement> getAllURLWebElements() {
		return MyDriver.driver.findElements(By.cssSelector(PageIDs.VIDEO_i_SELECTOR));
//		return videoElement.getAttribute("href");
	}

	private static int getNumberOfVideosInThePlayList() {
		String listNumber = MyDriver.driver.findElements(By.cssSelector(PageIDs.QUANTITY_CSS)).get(1).getText();
		return Integer.valueOf(listNumber.split(" / ")[1]);
	}

	public void run() {
		List<String> alltubes = getURLList(URL);
		for (String url : alltubes) {
			System.out.println(url);
		}
	}
}
