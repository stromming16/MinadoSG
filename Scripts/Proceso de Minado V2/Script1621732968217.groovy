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
import com.sun.org.apache.xml.internal.resolver.helpers.Debug as Debug
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import functionalities.*
import helper.Keywords as Keywords
import java.sql.Timestamp as Timestamp
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import configurations.CustomDriver as CustomDriver
import helper.SgTestObjects as SgTestObjects
import helper.EnvConfig as EnvConfig
import helper.MinerProcess as MinerProcess
import helper.Configurations as Configurations

/*
 *
 *
 * 	Este bucle for recorre los datos del Test Data llamado "emails". Se debe considerar la inciacion y finalizacion del mismo,
 *  segun la lista de corres disponibles del Test Data.
 *
 *
*/
Timestamp timestamp = new Timestamp(System.currentTimeMillis())

Keywords k = new Keywords()

SgTestObjects sg = new SgTestObjects()

AccountManagement am = new AccountManagement()

MinerProcess mp = new MinerProcess()

ExecuteCmd ec = new ExecuteCmd()

EnvConfig env = new EnvConfig()

CustomDriver cd = new CustomDriver()

Configurations cnf = new Configurations();

String dataTest = 'cuentas'

String dataTestPath = findTestData(dataTest).getSourceUrl()

//findTestData(dataTest).getRowNumbers()
while (true) {
	for (def row = 1; row <= findTestData(dataTest).getRowNumbers(); row++) {
		boolean passed = false

		boolean withLogin = findTestData(dataTest).getValue('amount', row) == "";

		String email

		String sessionEmail

		String password

		email = findTestData(dataTest).getValue('email', row)

		password = findTestData(dataTest).getValue('password', row)
		
		String cache = cnf.CHROME_DATA_DIR_PATH + "Profile " + row + "\\Cache";
		String code_cache = cnf.CHROME_DATA_DIR_PATH + "Profile " + row + "\\Code Cache";
		
		String clear_cache_cmd_1 = "if exist \"" + cache + "\" rd /s /q \"" + cache + "\"";
		String clear_cache_cmd_2 = "if exist \"" + code_cache + "\" rd /s /q \"" + code_cache + "\"";

		while (!(passed)) {
			try {
				//Abrir el explorador
				DriverFactory.changeWebDriver(cd.getDriver(row.toString()))

				WebUI.maximizeWindow()

				//ec.executeCMD(k.KEY_AMK_ACTIVATE_ANTICAPTCHA_PROFILE);
				//Inicio de sesion
				boolean networkErrorPre = false

				boolean error_loginPre = false

				boolean msg_mail_sentPre = false

				boolean _000USDPre = false

				boolean span_USDTPre = false

				boolean div_USDT_trianglePre = false

				boolean emailIsPre1 = false

				boolean emailIsPre = false

				boolean verified_badge_emailPre = false

				boolean unverified_badge_emailPre = false

				boolean span_Edit_emailPre = false

				if (true) {
					//navegar a la pantalla de perfil//findTestData(dataTest).getValue('amount', row) == ""
					WebUI.navigateToUrl('https://app.stormgain.com/profile-settings/#modal_login')

					WebUI.waitForPageLoad(20)

					//verifica se aparece el error de red
					networkErrorPre = WebUI.verifyElementPresent(sg.networkError, 1, FailureHandling.CONTINUE_ON_FAILURE)

					if (networkErrorPre) {
						passed = true

						WebUI.closeBrowser()

						continue
					}
					
					//Si hay un usuario en sesion se debe verificar que sea el correspondiente y si no, cerrar sesion
					_000USDPre = WebUI.verifyElementPresent(sg.span_0_00USDT, 1, FailureHandling.CONTINUE_ON_FAILURE)

					span_USDTPre = WebUI.verifyElementPresent(sg.span_USDT, 1, FailureHandling.CONTINUE_ON_FAILURE)

					div_USDT_trianglePre = WebUI.verifyElementPresent(sg.div_USDT_triangle, 1, FailureHandling.CONTINUE_ON_FAILURE)

					//Pregunta si ya hay una sesion abierta en el perfil
					if ((_000USDPre || span_USDTPre) || div_USDT_trianglePre) {
						emailIsPre = WebUI.verifyElementPresent(sg.div_email_session, 1, FailureHandling.CONTINUE_ON_FAILURE)

						emailIsPre1 = WebUI.verifyElementPresent(sg.div_email_session_1, 1, FailureHandling.CONTINUE_ON_FAILURE)

						if (emailIsPre || emailIsPre1) {
							sessionEmail = WebUI.getText(sg.div_email_session, FailureHandling.CONTINUE_ON_FAILURE)

							if ((sessionEmail == '') || (sessionEmail == ' ')) {
								sessionEmail = WebUI.getText(sg.div_email_session_1, FailureHandling.CONTINUE_ON_FAILURE)
							}
							
							if (sessionEmail != email) {
								println((sessionEmail + ' ') + email)

								WebUI.callTestCase(findTestCase('AccountManagement/SignOut'), null, FailureHandling.STOP_ON_FAILURE)

								WebUI.navigateToUrl('https://app.stormgain.com/crypto-miner/')

								WebUI.callTestCase(findTestCase('AccountManagement/Login'), [('email') : email, ('password') : env.genericPass],
									FailureHandling.STOP_ON_FAILURE)
							}
							
							_000USDPre = WebUI.verifyElementPresent(sg.span_0_00USDT, 1, FailureHandling.CONTINUE_ON_FAILURE)

							span_USDTPre = WebUI.verifyElementPresent(sg.span_USDT, 1, FailureHandling.CONTINUE_ON_FAILURE)

							div_USDT_trianglePre = WebUI.verifyElementPresent(sg.div_USDT_triangle, 1, FailureHandling.CONTINUE_ON_FAILURE)

							if ((_000USDPre || span_USDTPre) || div_USDT_trianglePre) {
								passed = mp.miner(dataTestPath, row)
							}
						} else {
							passed = false
						}
						//Si no hay sesion abierta entonses iniciala
					} else {
						WebUI.callTestCase(findTestCase('AccountManagement/Login'), [('email') : email, ('password') : env.genericPass],
							FailureHandling.STOP_ON_FAILURE)

						_000USDPre = WebUI.verifyElementPresent(sg.span_0_00USDT, 1, FailureHandling.CONTINUE_ON_FAILURE)

						span_USDTPre = WebUI.verifyElementPresent(sg.span_USDT, 1, FailureHandling.CONTINUE_ON_FAILURE)

						div_USDT_trianglePre = WebUI.verifyElementPresent(sg.div_USDT_triangle, 1, FailureHandling.CONTINUE_ON_FAILURE)

						if ((_000USDPre || span_USDTPre) || div_USDT_trianglePre) {
							passed = mp.miner(dataTestPath, row)
						}
					}
				} else {
					passed = mp.miner(dataTestPath, row)
				}
				
				WebUI.closeBrowser()
				//ec.executeCMD(clear_cache_cmd_1);
				//ec.executeCMD(clear_cache_cmd_2);
			}
			catch (Exception e) {
				WebUI.closeBrowser()

				println(e)
			}
		}
	}
	
	WebUI.delay(1)
}