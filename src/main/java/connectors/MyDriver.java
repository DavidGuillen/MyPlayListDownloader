package connectors;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MyDriver {

	public static final String FIREFOX = "firefox";
	public static final String CHROME = "chrome";
	public static final String EDGE = "edge";
	private static final String PATH_FIREFOX_DRIVER = "C:\\firefoxdriver.exe";
	private static final String PATH_EDGE_DRIVER = "C:\\edgedriver.exe";
	private static final String PATH_CHROME_DRIVER = "C:\\Users\\formation\\Documents\\ChromeDrivers\\chromedriver.exe";
	private static final String DEFAULT_DOWNLOAD_FOLDER = "C:\\Users\\formation\\Downloads\\test\\";
//	private static final String DEFAULT_DOWNLOAD_FOLDER = "System.getProperty(\"user.dir\")";
	public static WebDriver driver;
//	private final String defaultBrowser = "chrome";

	public MyDriver(String browser) {
		super();
		try {
			switch (browser) {
			case FIREFOX:
				System.setProperty("webdriver.chrome.driver", PATH_FIREFOX_DRIVER);
				System.out.println("Loading Firefox WebDriver");
				driver = new FirefoxDriver();
				break;

			case EDGE:
				System.setProperty("webdriver.chrome.driver", PATH_EDGE_DRIVER);
				System.out.println("Loading Edge WebDriver");
				driver = new EdgeDriver();
				break;

			case CHROME:
				System.setProperty("webdriver.chrome.driver", PATH_CHROME_DRIVER);
				System.out.println("Loading Chrome WebDriver");

				// We create the options & capabilities
				Map<String, Object> prefs = new HashMap<String, Object>();
				prefs.put("download.default_directory", DEFAULT_DOWNLOAD_FOLDER);
				ChromeOptions options = new ChromeOptions();
				options.setExperimentalOption("prefs", prefs);
				options.addArguments("start-maximized");

				driver = new ChromeDriver(options);
				break;

			default:
				System.setProperty("webdriver.chrome.driver", PATH_CHROME_DRIVER);
				System.out.println("Loading Chrome WebDriver");
				driver = new ChromeDriver();
				break;
			}

			setDriverProperties();

		} catch (Exception e) {
			System.out.println(String.format(
					"A problem was detected while loading the driver of your test for the browser: %s", browser));
			System.out.println(e);
		} finally {

		}

	}

	public MyDriver() {
		super();
		new MyDriver("chrome");
	}

	public WebDriver getDriver() {
		if (driver == null) {
			new MyDriver();
			return driver;
		}
		return driver;
	}

//	private void setDriver(WebDriver driver) {
//		DriverInit.driver = driver;
//	}

	private void setDriverProperties() {
//		driver.manage().window().maximize();
		// Implicit wait - used to set the default waiting time throughout the program
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	/**
	 * Close the current window, quitting the browser if it's the last window
	 * currently open.
	 * 
	 */
	public static void closeDriver() {
		driver.close(); // closes a single window
	}

	/**
	 * Quits this driver, closing every associated window.
	 * 
	 */
	public static void quitDriver() {
		driver.quit(); // closes all windows
	}

	public static void pause(int pauseSec) {
		try {
			Thread.sleep(pauseSec * 1000);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}

}
