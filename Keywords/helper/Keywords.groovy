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

public class Keywords {

	public String KEY_ACCOUNTS_CSV_PATH = "C:\\Users\\administrador\\Desktop\\Cuentas\\cuentas.csv";

	public String KEY_FOLDER_DEPO = "Z:\\depositadas\\";

	public String KEY_FOLDER_VERI = "C:\\Users\\administrador\\Desktop\\Cuentas\\verificadas\\";

	public String KEY_FOLDER_VERI_ND = "C:\\Users\\administrador\\Desktop\\Cuentas\\verificar_proximo_dia\\";

	public String KEY_AMK_INICAR_SESION_CMD = "\"C:\\Users\\administrador\\Desktop\\AutomaticMCFunctionalities\\ClicIniciarSesion.amk\"";

	public String KEY_AMK_VERIFY_YOPMAIL_CMD = "\"C:\\Users\\administrador\\Desktop\\AutomaticMCFunctionalities\\ClicVerificarYopmail.amk\"";

	public String KEY_AMK_CONFIRM_CMD = "\"C:\\Users\\administrador\\Desktop\\AutomaticMCFunctionalities\\ClicConfirmarCorreo.amk\"";

	public String KEY_AMK_ACTIVATE_ANTICAPTCHA = "\"C:\\Users\\administrador\\Desktop\\AutomaticMCFunctionalities\\ActivateAntiCaptcha.amk\"";

	public String KEY_AMK_ACTIVATE_ANTICAPTCHA_PROFILE = "\"C:\\Users\\admin\\Desktop\\AMC\\ActivateAntiCaptchaProfile.amk\"";

	public String KEY_AMK_RECAPTCHA_YOPMAIL = "\"C:\\Users\\administrador\\Desktop\\AutomaticMCFunctionalities\\IfRecaptchaFoundonYopmail.amk\"";

	public String KEY_AMK_RECAPTCHA_SGLOGIN = "\"C:\\Users\\admin\\Desktop\\AMC\\IfRecaptchaFoundonStormGLogin.amk\"";

	public String KEY_AMK_LOGOUTSG = "\"C:\\Users\\administrador\\Desktop\\AutomaticMCFunctionalities\\LogOutSG.amk\"";

	public String KEY_AMK_CREAR_PERFIL = "\"C:\\Users\\admin\\Desktop\\AMC\\CreacionDePerfiles.amk\"";

	public String KEY_AMK_ASOCIACION = "\"C:\\Users\\admin\\Desktop\\AMC\\AsociacionDeCuentaAPerfil.amk\"";

	public String KEY_AMK_ASOCIACION_SINCS = "\"C:\\Users\\admin\\Desktop\\AMC\\AsociacionDeCuentaAPerfilSinCerrarSesion.amk\"";

	public String KEY_AMK_MINER = "\"C:\\Users\\admin\\Desktop\\AMC\\ClicEnMinar.amk\"";
}
