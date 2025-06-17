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
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import org.openqa.selenium.WebElement


WebUI.openBrowser('')
WebUI.navigateToUrl('https://demoqa.com/automation-practice-form')

WebUI.setText(findTestObject('WebUI/Forms/input_FirstName'), 'Irma')
WebUI.setText(findTestObject('WebUI/Forms/input_LastName'), 'Widyawati')
WebUI.setText(findTestObject('WebUI/Forms/input_Email'), 'irmaemail.com') // ❌ Invalid format

WebUI.click(findTestObject('WebUI/Forms/radio_Gender_Female'))
WebUI.setText(findTestObject('WebUI/Forms/input_MobileNumber'), '081234567890')

// SCROLL ke elemen DOB
WebUI.scrollToElement(findTestObject('WebUI/Forms/input_DOB'), 2)

// Coba klik DOB via JavaScript biar bisa bypass iframe iklan
TestObject dobInput = findTestObject('WebUI/Forms/input_DOB')
// Optional: hapus semua iframe dulu
WebUI.executeJavaScript("document.querySelectorAll('iframe').forEach(el => el.remove())", null)
WebUI.delay(1)
WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(WebUiCommonHelper.findWebElement(dobInput, 5)))

// Lanjut pilih bulan, tahun, dan tanggal
WebUI.click(findTestObject('WebUI/Forms/select_Month_April'))
WebUI.click(findTestObject('WebUI/Forms/select_Year_1996'))
WebUI.click(findTestObject('WebUI/Forms/day_20'))


WebUI.setText(findTestObject('WebUI/Forms/input_Subjects'), 'Computer Science')
WebUI.sendKeys(findTestObject('WebUI/Forms/input_Subjects'), Keys.chord(Keys.ENTER))

WebUI.click(findTestObject('WebUI/Forms/checkbox_Hobbies_Reading'))

WebUI.uploadFile(findTestObject('WebUI/Forms/upload_Picture'), 'C:\\Users\\AZKADINA\\Pictures\\foto.jpg')

WebUI.setText(findTestObject('WebUI/Forms/textarea_CurrentAddress'), 'Jl. Belajar Automation No. 3')

// State and City
// State
// Step 1: Klik dropdown State
WebUI.click(findTestObject('WebUI/Forms/dropdown_State'))

// Step 2: Tunggu opsi muncul
WebUI.waitForElementVisible(findTestObject('WebUI/Forms/dropdown_State_Option_NCR'), 10)

// Step 3: Klik opsi NCR
WebUI.click(findTestObject('WebUI/Forms/dropdown_State_Option_NCR'))

//City

// Klik dropdown City
WebUI.click(findTestObject('WebUI/Forms/dropdown_City'))

// Pilih opsi 'Delhi'
WebUI.click(findTestObject('WebUI/Forms/dropdown_City_Option_Delhi'))




WebUI.click(findTestObject('WebUI/Forms/button_Submit'))

// ❗ Verifikasi modal tidak muncul (karena email tidak valid)
boolean isModalVisible = WebUI.verifyElementNotPresent(findTestObject('WebUI/Forms/modal_title'), 5, FailureHandling.OPTIONAL)

assert isModalVisible == true

WebUI.closeBrowser()
