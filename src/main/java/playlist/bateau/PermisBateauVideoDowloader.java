package playlist.bateau;

import java.util.List;

import org.openqa.selenium.WebElement;

import connectors.MyDriver;

public class PermisBateauVideoDowloader {

	private static final String HOME_PAGE_URL = "https://www.prepacode-enpc.fr/landing_page";
	private static final String USER = "david.bec-guillen-jimenez7433";
	private static final String PASS = "6210";

	public static void run() {
		// Load Driver
		new MyDriver();
		// Get page & log-in
		loggin();

		unitdownloader();
		// Foreach unit
		// Go to the Unit
		// Download the whole unit

	}

	private static void unitdownloader() {
		BateauPageActions.goToMesCours();

		List<WebElement> allSommaires = BateauPageActions.getAllSommaires();
		int n = BateauPageActions.getNumberOfSommaires();

		System.out.println("Il y a " + n + " sommaires");

//		int n = allSommaires.size();
//		allSommaires.get(0).click();
//		for (int i = 0; i < n; i++) {
//
//		}
	}

	private static void loggin() {
		MyDriver.driver.get(HOME_PAGE_URL);
		BateauPageActions.logginWith(USER, PASS);
	}
}
