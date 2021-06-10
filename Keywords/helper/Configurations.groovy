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

public class Configurations {
	public String CHROME_DRIVER = "C:\\Users\\admin\\Downloads\\Katalon_Studio_Windows_64-8.0.0\\configuration\\resources\\drivers\\chromedriver_win32\\chromedriver.exe";
	public String ANTICATCHA_EXT = "C:\\Users\\admin\\Downloads\\anticaptcha-plugin_v0.54.crx";
	public String PROF_CONF_USER_DATA_DIR = "--user-data-dir=C:\\Users\\admin\\AppData\\Local\\Google\\Chrome\\User Data\\";
	public String PROF_CONF_DIRECTORY = "--profile-directory=Profile ";
	public String PROF_CONF_APPID = "--app-id=epiocimfnhgleklijmjmglgphfkcdbip";
	public String PROF_CONF_ANTICATCHA_EXT = "--load-extension=C:\\Users\\admin\\Downloads\\anticaptcha-plugin_v0.54";
}
