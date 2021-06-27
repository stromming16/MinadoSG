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

public class SgTestObjects {

	//sesion verification objects
	public TestObject span_USDT = findTestObject('Object Repository/LogOutObjects/span_USDT');
	public TestObject span_0_00USDT = findTestObject('Object Repository/LogOutObjects/span_0.00USDT');
	public TestObject div_USDT_triangle = findTestObject('Object Repository/LogOutObjects/div_USDT_triangle');
	public TestObject h1_Welcome = findTestObject('Object Repository/LoginObjects/h1_Welcome to StormGain');
	public TestObject div_email_session = findTestObject('Object Repository/VerifySessionObjects/div_aangeles3344yopmail.com');
	public TestObject div_email_session_1 = findTestObject('Object Repository/VerifySessionObjects/span_so1-q4qurh_4-rso1gmail.com');
	public TestObject div_Account = findTestObject('Object Repository/VerifySessionObjects/div_Account ID 3804053611');

	//login objects
	public TestObject email_input = findTestObject('Object Repository/LoginObjects/input_Email_login');
	public TestObject password_input = findTestObject('Object Repository/LoginObjects/input_Restore password_password');
	public TestObject btn_login = findTestObject('Object Repository/LoginObjects/input_Please verify that you are not a robot_btn btn-mint btn-login');

	//signup objects
	public TestObject email_input_su_text = findTestObject('Object Repository/RegisterObjects/input_Tu email real_login');
	public TestObject email_input_su = findTestObject('Object Repository/RegisterObjects/dt_Tu email real');
	public TestObject phone_input_su = findTestObject('Object Repository/RegisterObjects/input_Tu nmero de telfono real_phone');
	public TestObject pass_input_su = findTestObject('Object Repository/RegisterObjects/input_Crear contrasea_password');
	public TestObject btn_signup = findTestObject('Object Repository/RegisterObjects/input_Por favor, confirma que no eres un robot_btn btn-mint btn-register');

	//logout objects
	public TestObject span_Logout = findTestObject('Object Repository/LogOutObjects/span_Logout');
	public TestObject span_Logout_es = findTestObject('Object Repository/LogOutObjects/span_Cerrar sesin');

	//mining objects
	public TestObject button_ActivateMining = findTestObject('Object Repository/ActivateBtn/Page_Cryptominer - StormGain/button_ActivateMining 4 hours');
	public TestObject div_Activate = findTestObject('Object Repository/ActivateBtn/Page_Cryptominer - StormGain/div_Activate');

	//email verification objects
	public TestObject h1_Profile = findTestObject('Object Repository/EmailVerificationObjects/h1_Profile settings');
	public TestObject span_Edit_email = findTestObject('Object Repository/EmailVerificationObjects/span_Edit');
	public TestObject input_Email_email = findTestObject('Object Repository/EmailVerificationObjects/input_Email_email');
	public TestObject btn_email_verify = findTestObject('Object Repository/EmailVerificationObjects/input_Please verify that you are not a robot_btn btn-pos');
	public TestObject msg_mail_sent = findTestObject('Object Repository/EmailVerificationObjects/p_We have sent a link to your email address. Please follow the link to complete verification');
	public TestObject verified_badge_email = findTestObject('Object Repository/EmailVerificationObjects/span_r.ic.ard.os.andoyopmail.com_verified-badge tooltip-info');
	public TestObject unverified_badge_email = findTestObject('Object Repository/EmailVerificationObjects/span_aangeles3345yopmail.com_not-verified-badge tooltip-info');


	//phone verification objects
	public TestObject span_Edit_phone = findTestObject('Object Repository/PhoneVerificationObjects/span_Edit');
	public TestObject input_Phone_phone = findTestObject('Object Repository/PhoneVerificationObjects/input_Phone number_phone');
	public TestObject btn_phone_verify = findTestObject('Object Repository/PhoneVerificationObjects/input_Please verify that you are not a robot_btn btn-pos');
	//public TestObject msg_phone_sent =
	//public TestObject verified_badge_phone =
	public TestObject err_phone_already_exist = findTestObject('Object Repository/PhoneVerificationObjects/div_This phone number already exists. Please provide another one');
	public TestObject unverified_badge_phone = findTestObject('Object Repository/PhoneVerificationObjects/span_Phone number_not-verified-badge tooltip-info');

	//account error objects
	public TestObject error_login = findTestObject('Object Repository/AccountsErrorsObjects/div_Invalid login or password. Number of attempts is limited. You can restore the password if it is necessary.Restore password');

	//Miner Objects
	public TestObject minerBtn = findTestObject('Object Repository/MinerObjects/button_ActivateMining 4 hours');
	public TestObject minerBtn1 = findTestObject('Object Repository/MinerObjects/button_Activar4 horas de minado1')
	public TestObject amount = findTestObject('Object Repository/DepositObjects/span_0.14');
	public TestObject withDbtn = findTestObject('Object Repository/DepositObjects/button_Withdraw (min 10 USDT)');
	public TestObject alerteMassage = findTestObject('Object Repository/DepositObjects/div_It usually takes from 5 minutes to 2 hours for withdrawn funds to be credited to your account. Please wait to receive the funds');
	public TestObject alertOkBtn = findTestObject('Object Repository/DepositObjects/button_Ok');

	//Generate Code objects
	public TestObject titleGc = findTestObject('Object Repository/GenerateCodeObjects/div_Generate code');

	//credentials are not provider alert objects
	public TestObject cnpAlertM = findTestObject('Object Repository/NCProAlertObject/div_Authentication credentials were not provided');
	public TestObject cnpAlertClose = findTestObject('Object Repository/NCProAlertObject/svg_Authentication credentials were not provided_flex w-8 h-8 fill-current');

	//errores comunes
	public TestObject networkError = findTestObject('Object Repository/ErroresSG/h2_No se pudo conectar con StormGain');
	public TestObject networkError_1 = findTestObject('Object Repository/ErroresSG/div_Network error');
	public TestObject unExpected_1 = findTestObject('Object Repository/ErrorSG/h2_An unexpected error has occurred,  please try again later');
}