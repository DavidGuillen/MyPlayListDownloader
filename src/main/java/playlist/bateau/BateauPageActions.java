package playlist.bateau;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import connectors.MyDriver;

public class BateauPageActions {

	/**
	 * Login with the right credentials
	 * 
	 * @param user user name
	 * @param pass password
	 */
	public static void logginWith(String user, String pass) {
		MyDriver.driver.findElement(By.cssSelector(BateauPageIDs.BUTTON_IDENTIFY)).click();
		MyDriver.driver.findElement(By.cssSelector(BateauPageIDs.USER_LOGIN)).sendKeys(user);
		MyDriver.driver.findElement(By.cssSelector(BateauPageIDs.USER_PASS)).sendKeys(pass);
		MyDriver.driver.findElement(By.cssSelector(BateauPageIDs.BUTTON_CONNECT)).click();
	}

	/**
	 * Click COURS button to display all the Summaries
	 */
	public static void goToMesCours() {
		MyDriver.driver.findElement(By.cssSelector(BateauPageIDs.COURS_BUTTON)).click();
	}

	public static List<WebElement> getAllSommaires() {
		return MyDriver.driver.findElements(By.cssSelector(BateauPageIDs.SOMMAIRE_BUTTON));
	}

	public static int getNumberOfSommaires() {
		return MyDriver.driver.findElements(By.cssSelector(BateauPageIDs.BLOCK_TITLES)).size();
	}

}
