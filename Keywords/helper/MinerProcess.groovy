package helper

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

import functionalities.*
import helper.Keywords as Keywords
import java.sql.Timestamp as Timestamp
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import configurations.CustomDriver as CustomDriver
import helper.SgTestObjects as SgTestObjects
import org.openqa.selenium.WebDriver

public class MinerProcess {

	Keywords k = new Keywords()

	SgTestObjects sg = new SgTestObjects()

	AccountManagement am = new AccountManagement()

	CustomDriver cd = new CustomDriver();

	public boolean miner(String dataTestPath, int row) {
		//navegar a la pantalla de perfil
		WebUI.navigateToUrl('https://app.stormgain.com/crypto-miner/')
		WebUI.waitForPageLoad(20);

		boolean unExpected_1Pre = WebUI.verifyElementPresent(sg.unExpected_1, 1, FailureHandling.CONTINUE_ON_FAILURE)
		if(unExpected_1Pre) {
			//while(unExpected_1Pre) {
			//		WebUI.navigateToUrl('https://app.stormgain.com/crypto-miner/')
			//	WebUI.waitForPageLoad(20);
			//WebUI.delay(120)
			//unExpected_1Pre = WebUI.verifyElementPresent(sg.unExpected_1, 1, FailureHandling.CONTINUE_ON_FAILURE)
			//}
			println "unExpected_1Pre: "+unExpected_1Pre;
		}

		//Verificar monto y hacer clic en cargar dinero cartera si pasa de los 10
		Boolean amountPresent = false, withDbtnPresent = false, alerteMassagePresent = false, alertOkBtnPresent = false, cnpAlertMPre = false, cnpAlertClosePre = false;

		cnpAlertMPre = WebUI.verifyElementPresent(sg.cnpAlertM, 1, FailureHandling.CONTINUE_ON_FAILURE);
		int r = 0;

		boolean networkError1Pre = WebUI.verifyElementPresent(sg.networkError_1, 1, FailureHandling.CONTINUE_ON_FAILURE)
		if(networkError1Pre) {
			while(networkError1Pre) {
				if(r == 1) {
					WebUI.closeBrowser();
					return false;
				}
				r++;

				cnpAlertClosePre = WebUI.verifyElementPresent(sg.cnpAlertClose, 1, FailureHandling.CONTINUE_ON_FAILURE);
				while(!cnpAlertClosePre) {
					cnpAlertClosePre = WebUI.verifyElementPresent(sg.cnpAlertClose, 1, FailureHandling.CONTINUE_ON_FAILURE);
				}

				WebUI.click(sg.cnpAlertClose, FailureHandling.CONTINUE_ON_FAILURE);
				WebUI.delay(1)
				networkError1Pre = WebUI.verifyElementPresent(sg.networkError_1, 1, FailureHandling.CONTINUE_ON_FAILURE)
			}
		}


		String _amount = WebUI.getText(sg.amount, FailureHandling.CONTINUE_ON_FAILURE);
		Float max = 10.00;
		/*
		if(Float.parseFloat(_amount.replace("≈", '')) >= max) {
			withDbtnPresent = WebUI.verifyElementClickable(sg.withDbtn, FailureHandling.CONTINUE_ON_FAILURE);
			println withDbtnPresent;
			if(withDbtnPresent) {
				WebUI.click(sg.withDbtn, FailureHandling.CONTINUE_ON_FAILURE);
				WebUI.delay(1);
				alerteMassagePresent = WebUI.verifyElementPresent(sg.alerteMassage, 1, FailureHandling.CONTINUE_ON_FAILURE);
				alertOkBtnPresent = WebUI.verifyElementPresent(sg.alertOkBtn, 1, FailureHandling.CONTINUE_ON_FAILURE);
				if(alerteMassagePresent) {
					while(alertOkBtnPresent) {
						WebUI.click(sg.alertOkBtn);
						WebUI.waitForElementNotPresent(sg.alertOkBtn, 3, FailureHandling.CONTINUE_ON_FAILURE)
						alertOkBtnPresent = WebUI.verifyElementPresent(sg.alertOkBtn, 4, FailureHandling.CONTINUE_ON_FAILURE)
					}
					am.editFileCSV(dataTestPath, _amount, row, 4);
					am.editFileCSV(dataTestPath, "SI", row, 5);
					return true;
				}
			}
			am.editFileCSV(dataTestPath, _amount, row, 4);
			return true;
		}*/

		//hacer clck en minar
		boolean minerBtnPresent = false, minerBtn1Present = false;
		minerBtnPresent = WebUI.verifyElementPresent(sg.minerBtn, 1, FailureHandling.CONTINUE_ON_FAILURE)
		minerBtn1Present = WebUI.verifyElementPresent(sg.minerBtn1, 1, FailureHandling.CONTINUE_ON_FAILURE)
		println minerBtnPresent;
		println minerBtn1Present;

		if(minerBtnPresent) {
			while(minerBtnPresent) {
				WebUI.click(sg.minerBtn);
				WebUI.waitForElementNotPresent(sg.minerBtn, 1, FailureHandling.CONTINUE_ON_FAILURE)
				minerBtnPresent = WebUI.verifyElementPresent(sg.minerBtn, 1, FailureHandling.CONTINUE_ON_FAILURE)
			}
		}else if(minerBtn1Present) {
			while(minerBtn1Present) {
				WebUI.click(sg.minerBtn1);
				WebUI.waitForElementNotPresent(sg.minerBtn1, 1, FailureHandling.CONTINUE_ON_FAILURE)
				minerBtn1Present = WebUI.verifyElementPresent(sg.minerBtn1, 1, FailureHandling.CONTINUE_ON_FAILURE)
			}
		}

		am.editFileCSV(dataTestPath, _amount, row, 4);
		return true;

		/*Float max = 20.00;
		 println Float.parseFloat(_amount.replace("≈", ''))
		 println (Float.parseFloat(_amount.replace("≈", '')) >= max)
		 if(_amount == "NaN") {
		 return false;
		 }
		 if(Float.parseFloat(_amount.replace("≈", '')) >= max) {
		 withDbtnPresent = WebUI.verifyElementPresent(sg.withDbtn, 1, FailureHandling.CONTINUE_ON_FAILURE);
		 println withDbtnPresent;
		 if(withDbtnPresent) {
		 WebUI.click(sg.withDbtn);
		 WebUI.delay(1);
		 alerteMassagePresent = WebUI.verifyElementPresent(sg.alerteMassage, 1, FailureHandling.CONTINUE_ON_FAILURE);
		 alertOkBtnPresent = WebUI.verifyElementPresent(sg.alertOkBtn, 1, FailureHandling.CONTINUE_ON_FAILURE);
		 if(alerteMassagePresent) {
		 println alerteMassagePresent
		 println alertOkBtnPresent
		 WebUI.click(sg.alertOkBtn);
		 am.editFileCSV(dataTestPath, _amount, row, 4);
		 am.editFileCSV(dataTestPath, "SI", row, 5);
		 return true;
		 }else {
		 return false;
		 }
		 }
		 }else {
		 //hacer clck en minar
		 WebUI.delay(1)
		 boolean minerBtnPresent = false;
		 minerBtnPresent = WebUI.verifyElementPresent(sg.minerBtn, 3, FailureHandling.CONTINUE_ON_FAILURE)
		 println minerBtnPresent
		 if(minerBtnPresent) {
		 WebUI.click(sg.minerBtn);
		 WebUI.delay(0.5);
		 am.editFileCSV(dataTestPath, _amount, row, 4);
		 }
		 return true;
		 }
		 */

	}
}