import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.webui.driver.DriverFactory

import functionalities.ExecuteCmd
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

import functionalities.*
import helper.Keywords as Keywords
import java.sql.Timestamp;
import configurations.CustomDriver;

Timestamp timestamp = new Timestamp(System.currentTimeMillis());

Keywords k = new Keywords();
AccountManagement am = new AccountManagement();

ExecuteCmd ec = new ExecuteCmd();
ClipBoard cb = new ClipBoard();
CustomDriver cd = new CustomDriver();

String dataTest = "cuentas_para_asociar";

for (def row = 132; row <= findTestData(dataTest).getRowNumbers(); row++) {
	Boolean passed = false;
	while(!passed) {
		passed = false;
		
		try {
			cb.copy(findTestData(dataTest).getValue('email', row));
			DriverFactory.changeWebDriver(cd.getDriver((row).toString()));
			ec.executeAmkScript(k.KEY_AMK_ACTIVATE_ANTICAPTCHA_PROFILE);
			
			//login objects
			TestObject welcome, email, password, login;
			
			welcom = findTestObject('Object Repository/LoginObjects/Page_Page not found - StormGain/h1_Welcome to StormGain');
			email = findTestObject('Object Repository/LoginObjects/Page_Page not found - StormGain/input_Email_login');
			password = findTestObject('Object Repository/LoginObjects/Page_Page not found - StormGain/input_Restore password_password');
			login = findTestObject('Object Repository/LoginObjects/Page_Page not found - StormGain/input_Please verify that you are not a robot_btn btn-mint btn-login');
			
			//logout objects
			TestObject icon, triangle, bonus, logout;
			
			icon = findTestObject('Object Repository/LogOut/Page_Cryptominer - StormGain/div_Affiliate programme_loyalty-icon');
			triangle = findTestObject('Object Repository/LogOut/Page_Cryptominer - StormGain/div_USDT_triangle');
			bonus = findTestObject('Object Repository/LogOut/Page_Cryptominer - StormGain/span_Bonus');
			logout = findTestObject('Object Repository/LogOut/Page_Cryptominer - StormGain/span_Logout');
			
			//recaptcha objects
			TestObject recaptchaTerms, recap;
			
			recaptchaTerms = findTestObject('Object Repository/Recaptcha/Page_Page not found - StormGain/div_reCAPTCHAPrivacy - Terms');
			recap = findTestObject('Object Repository/Recaptcha/Page_Page not found - StormGain/iframe_Remember email_a-7rmw5ukxstx4');      
			
			WebUI.navigateToUrl("https://app.stormgain.com/crypto-miner/");
			WebUI.maximizeWindow(FailureHandling.CONTINUE_ON_FAILURE);
			WebUI.waitForPageLoad(30);
			
			Boolean iconPresent = false, trianglePresent = false, bonusPresent = false;
			
			iconPresent = WebUI.verifyElementPresent(icon, 1, FailureHandling.CONTINUE_ON_FAILURE);
			trianglePresent = WebUI.verifyElementPresent(triangle, 1, FailureHandling.CONTINUE_ON_FAILURE);
			bonusPresent = WebUI.verifyElementPresent(bonus, 1, FailureHandling.CONTINUE_ON_FAILURE);
			
			if(iconPresent) {
				WebUI.click(icon);
				WebUI.click(logout);
				WebUI.waitForPageLoad(30);
				
			}else if(trianglePresent) {
				WebUI.click(triangle);
				WebUI.click(logout);
				WebUI.waitForPageLoad(30);
				
			}else if(bonusPresent) {
				WebUI.click(bonus);
				WebUI.click(logout);
				WebUI.waitForPageLoad(30);
			}
			
			Boolean welcomePresent;
			welcomePresent = WebUI.verifyElementPresent(welcom, 1, FailureHandling.CONTINUE_ON_FAILURE);
			
			if(!welcomePresent) {
				WebUI.navigateToUrl("https://app.stormgain.com/crypto-miner/");
				WebUI.waitForPageLoad(30);
				welcomePresent = WebUI.verifyElementPresent(welcom, 1, FailureHandling.CONTINUE_ON_FAILURE);
			}
			
			if(welcomePresent) {
				WebUI.clearText(email, FailureHandling.CONTINUE_ON_FAILURE);
				WebUI.setText(email, findTestData(dataTest).getValue('email', row));
				
				WebUI.clearText(password, FailureHandling.CONTINUE_ON_FAILURE);
				WebUI.setText(password, findTestData(dataTest).getValue('password', row));
				
				WebUI.click(login);
				WebUI.waitForPageLoad(30);
				
				//verificar recaptcha
				
				Boolean recaptchaIsThere;
				welcomePresent = WebUI.verifyElementPresent(recap, 1, FailureHandling.CONTINUE_ON_FAILURE) || WebUI.verifyElementPresent(recaptchaTerms, 1, FailureHandling.CONTINUE_ON_FAILURE);
				if(welcomePresent) {
					WebUI.delay(30);
				}
				
				ec.executeAmkScript(k.KEY_AMK_RECAPTCHA_SGLOGIN)
				
				iconPresent = WebUI.verifyElementPresent(icon, 1, FailureHandling.CONTINUE_ON_FAILURE);
				trianglePresent = WebUI.verifyElementPresent(triangle, 1, FailureHandling.CONTINUE_ON_FAILURE);
				bonusPresent = WebUI.verifyElementPresent(bonus, 1, FailureHandling.CONTINUE_ON_FAILURE);
				
				if(iconPresent || trianglePresent || bonusPresent) {
					passed = true;
				}else {
					passed = false;
				}
			}
			
			WebUI.closeBrowser();
		} catch (Exception e) {
			passed = false;
			WebUI.closeBrowser();
		}
	}
}