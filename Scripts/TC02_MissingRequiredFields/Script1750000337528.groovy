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

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

// 1. Buka halaman form
WebUI.openBrowser('')
WebUI.navigateToUrl('https://demoqa.com/automation-practice-form')
WebUI.maximizeWindow()

// 2. Scroll agar tombol 'Submit' terlihat
WebUI.scrollToElement(findTestObject('WebUI/Forms/button_Submit'), 10)

// 3. Klik tombol submit langsung tanpa isi nama/email
WebUI.click(findTestObject('WebUI/Forms/button_Submit'))

// 4. Delay sejenak untuk memastikan tidak ada modal muncul
WebUI.delay(2)

// 5. Verifikasi bahwa elemen modal tidak muncul
boolean isModalVisible = WebUI.verifyElementNotPresent(findTestObject('WebUI/Forms/modal_title'), 5, FailureHandling.CONTINUE_ON_FAILURE)

if (isModalVisible) {
	WebUI.comment('✅ Test passed: Modal tidak muncul, form gagal dikirim karena field wajib kosong.')
} else {
	WebUI.comment('❌ Test failed: Modal muncul padahal field wajib kosong.')
}

// 6. Tutup browser
WebUI.closeBrowser()
