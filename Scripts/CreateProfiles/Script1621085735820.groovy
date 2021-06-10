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

import functionalities.ExecuteCmd
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

import functionalities.*
import helper.Keywords as Keywords
import java.sql.Timestamp;

Timestamp timestamp = new Timestamp(System.currentTimeMillis());

Keywords k = new Keywords();
AccountManagement am = new AccountManagement()

ExecuteCmd ec = new ExecuteCmd();
ClipBoard cb = new ClipBoard();

for (def row = 138; row <= 200; row++) {
	String profile = "perfil"+row;
	
	cb.copy(profile)
	
	ec.executeAmkScript(k.KEY_AMK_CREAR_PERFIL)
	
	ec.executeAmkScript("move \"C:\\Users\\admin\\Desktop\\" + profile + ".lnk\" \"C:\\Users\\admin\\Desktop\\Perfiles\\" + profile + ".lnk\"")
}		
