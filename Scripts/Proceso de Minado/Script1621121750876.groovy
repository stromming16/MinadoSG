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
import functionalities.ExecuteCmd as ExecuteCmd
import functionalities.*
import helper.Keywords as Keywords
import java.sql.Timestamp as Timestamp

Timestamp timestamp = new Timestamp(System.currentTimeMillis())

Keywords k = new Keywords()

AccountManagement am = new AccountManagement()

ExecuteCmd ec = new ExecuteCmd()

ClipBoard cb = new ClipBoard()

String dataTest = 'cuentas_para_asociar'

boolean stop = false

while (!(stop)) {
    for (def row = 1; row <= findTestData(dataTest).getRowNumbers(); row++) {
        cb.copy(findTestData(dataTest).getValue('email', row))

		DriverFactory.changeWebDriver(cd.getDriver((row).toString()));
		
        WebUI.delay(11)

        ec.executeAmkScript(k.KEY_AMK_MINER)

        WebUI.delay(4)
    }
    
    WebUI.delay(30)
}

