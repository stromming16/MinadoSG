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

Keywords k = new Keywords();
AccountManagement am = new AccountManagement();

ExecuteCmd ec = new ExecuteCmd();
ClipBoard cb = new ClipBoard();
CustomDriver cd = new CustomDriver();

String dataTest = "cuentas_para_asociar";

while(true){
	//crea un archivo csv por cada corrida de minado de las 176 
	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	String csvFile = k.KEY_FOLDER_DEPO+timestamp.getTime()+"-DEPO.csv";
	am.createFileCSV(csvFile, ",");
	
	for (def row = 1; row <= findTestData(dataTest).getRowNumbers(); row++) {
		Boolean passed = false;
		while(!passed) {
			passed = false;
			
			if(row == 7) {
				passed = true;
				break;
			}
			
			try {
				cb.copy(findTestData(dataTest).getValue('email', row));
				DriverFactory.changeWebDriver(cd.getDriver((row).toString()));
				//ec.executeAmkScript(k.KEY_AMK_ACTIVATE_ANTICAPTCHA_PROFILE);
				
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
				
				//amount objects
				TestObject amount, withDbtn, alerteMassage, alertOkBtn;
				
				amount = findTestObject('Object Repository/Depositar/Page_Cryptominer - StormGain/span_0.14');
				withDbtn = findTestObject('Object Repository/Depositar/Page_Cryptominer - StormGain/button_Withdraw (min 10 USDT)');
				alerteMassage = findTestObject('Object Repository/Depositar/Page_Cryptominer - StormGain/div_It usually takes from 5 minutes to 2 hours for withdrawn funds to be credited to your account. Please wait to receive the funds');
				alertOkBtn = findTestObject('Object Repository/Depositar/Page_Cryptominer - StormGain/button_Ok');
				
				//recaptcha objects
				TestObject recaptchaTerms, recap;
				
				recaptchaTerms = findTestObject('Object Repository/Recaptcha/Page_Page not found - StormGain/div_reCAPTCHAPrivacy - Terms');
				recap = findTestObject('Object Repository/Recaptcha/Page_Page not found - StormGain/iframe_Remember email_a-7rmw5ukxstx4');
				
				//miner objects
				TestObject minerBtn;
				minerBtn = findTestObject('Object Repository/Miner/Page_Cryptominer - StormGain/button_ActivateMining 4 hours');
				
				//Generate Code objects
				TestObject titleGc;
				titleGc = findTestObject('Object Repository/GenerateCode/Page_Page not found - StormGain/div_Generate code');
				
				
				WebUI.navigateToUrl("https://app.stormgain.com/crypto-miner/");
				WebUI.maximizeWindow(FailureHandling.CONTINUE_ON_FAILURE);
				WebUI.waitForPageLoad(30);
				
				Boolean iconPresent = false, trianglePresent = false, bonusPresent = false;
				
				iconPresent = WebUI.verifyElementPresent(icon, 1, FailureHandling.CONTINUE_ON_FAILURE);
				trianglePresent = WebUI.verifyElementPresent(triangle, 1, FailureHandling.CONTINUE_ON_FAILURE);
				bonusPresent = WebUI.verifyElementPresent(bonus, 1, FailureHandling.CONTINUE_ON_FAILURE);
				
				if(!iconPresent || !trianglePresent || !bonusPresent) {
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
						
						//Verificar Error de Codigo Generado
						Boolean titleGcPresent;
						titleGcPresent = WebUI.verifyElementPresent(titleGc, 1, FailureHandling.CONTINUE_ON_FAILURE);
						if(titleGcPresent) {
							passed = true;
							WebUI.closeBrowser();
							break;
						}
						
						//verificar recaptcha
						Boolean recaptchaIsThere;
						welcomePresent = WebUI.verifyElementPresent(recap, 1, FailureHandling.CONTINUE_ON_FAILURE) || WebUI.verifyElementPresent(recaptchaTerms, 1, FailureHandling.CONTINUE_ON_FAILURE);
						if(welcomePresent) {
							WebUI.delay(30);
						}
						
						ec.executeAmkScript(k.KEY_AMK_RECAPTCHA_SGLOGIN)
					}
				}
				
				//Verificar monto y hacer clic en cargar dinero cartera si pasa de los 10
				Boolean amountPresent = false, withDbtnPresent = false, alerteMassagePresent = false, alertOkBtnPresent = false;
				
				String _amount = WebUI.getText(amount, FailureHandling.CONTINUE_ON_FAILURE);
				
				Float max = 10.00;
				
				println Float.parseFloat(_amount.replace("≈", ''))
				println (Float.parseFloat(_amount.replace("≈", '')) >= max)
				
				if(Float.parseFloat(_amount.replace("≈", '')) >= max) {
					withDbtnPresent = WebUI.verifyElementPresent(withDbtn, 1, FailureHandling.CONTINUE_ON_FAILURE);
					println withDbtnPresent;
					
					if(withDbtnPresent) {
						WebUI.click(withDbtn);
						WebUI.delay(1);
						alerteMassagePresent = WebUI.verifyElementPresent(alerteMassage, 1, FailureHandling.CONTINUE_ON_FAILURE);
						alertOkBtnPresent = WebUI.verifyElementPresent(alertOkBtn, 1, FailureHandling.CONTINUE_ON_FAILURE);
						
						if(alerteMassagePresent) {
							println alerteMassagePresent
							println alertOkBtnPresent
							
							WebUI.click(alertOkBtn);
							
							passed = true;
						}else {
							passed = false;
						}
						
						//escribir cuenta en csv
						am.addAccountToCsv(csvFile, findTestData(dataTest).getValue('email', row), findTestData(dataTest).getValue('password', row), _amount);
						
						
					}
				}else {
					//hacer clck en minar
					Boolean minerBtnPresent = false;
					minerBtnPresent = WebUI.verifyElementPresent(minerBtn, 0, FailureHandling.CONTINUE_ON_FAILURE)
					println minerBtnPresent
					
					if(minerBtnPresent) {
						WebUI.click(minerBtn);
						WebUI.delay(0.5)
					}
					
					passed = true
					
				}
				
				WebUI.closeBrowser();
				
			} catch (Exception e) {
				passed = false;
				WebUI.closeBrowser();
			}
		}
	}
	WebUI.delay(600)
}