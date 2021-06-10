package configurations;
import helper.Configurations;
import org.openqa.selenium.Keys;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

public class CustomDriver {

	public WebDriver getDriver(String profile) {
		
		Configurations c = new Configurations();

		// Optional. If not specified, WebDriver searches the PATH for chromedriver.       
		System.setProperty("webdriver.chrome.driver", c.CHROME_DRIVER);  
		ChromeOptions options = new ChromeOptions();
		
		
		List<String> arguments = new ArrayList<String>();
		arguments.add(c.PROF_CONF_USER_DATA_DIR);
		arguments.add(c.PROF_CONF_DIRECTORY+profile);
		arguments.add(c.PROF_CONF_ANTICATCHA_EXT);
		
		options.addArguments(arguments);
		//options.addExtensions(new File(c.ANTICATCHA_EXT));
		
		WebDriver driver = new ChromeDriver(options); 
		
		return driver;
	}
}