import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.model.FailureHandling as FailureHandling

import org.openqa.selenium.Keys



// Open browser
WebUI.openBrowser('')
WebUI.navigateToUrl('https://demoqa.com/automation-practice-form')
WebUI.maximizeWindow()

// Input text fields
WebUI.setText(findTestObject('WebUI/Forms/input_FirstName'), 'Irma')
WebUI.setText(findTestObject('WebUI/Forms/input_LastName'), 'Widy')
WebUI.setText(findTestObject('WebUI/Forms/input_Email'), 'irma@widy.com')

// Pilih gender menggunakan safeClick
CustomKeywords.'custom.Reusable.safeClick'(findTestObject('WebUI/Forms/radio_Gender_Female'))

// Input mobile number
WebUI.setText(findTestObject('WebUI/Forms/input_MobileNumber'), '081234567890')

// Set date of birth
CustomKeywords.'custom.Reusable.safeClick'(findTestObject('WebUI/Forms/input_DOB'))
CustomKeywords.'custom.Reusable.safeClick'(findTestObject('WebUI/Forms/select_Month_April'))
CustomKeywords.'custom.Reusable.safeClick'(findTestObject('WebUI/Forms/select_Year_1996'))
CustomKeywords.'custom.Reusable.safeClick'(findTestObject('WebUI/Forms/day_20'))

// Subjects
WebUI.setText(findTestObject('WebUI/Forms/input_Subjects'), 'Computer Science')
WebUI.sendKeys(findTestObject('WebUI/Forms/input_Subjects'), Keys.chord(Keys.ENTER))

// Hobbies
CustomKeywords.'custom.Reusable.safeClick'(findTestObject('WebUI/Forms/checkbox_Hobbies_Reading'))

// Upload file (jika kamu punya file path)
WebUI.uploadFile(findTestObject('WebUI/Forms/upload_Picture'), 'C:\\Users\\AZKADINA\\Pictures\\foto.jpg')

// Current Address
WebUI.setText(findTestObject('WebUI/Forms/textarea_CurrentAddress'), 'Jl. Niwas No. 9')


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



// Submit
CustomKeywords.'custom.Reusable.safeClick'(findTestObject('WebUI/Forms/button_Submit'))

// Verify hasil
WebUI.verifyElementText(findTestObject('WebUI/Forms/modal_Title'), 'Thanks for submitting the form')

// Close browser
WebUI.closeBrowser()
