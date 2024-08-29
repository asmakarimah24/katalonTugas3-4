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

WebUI.selectOptionByValue(findTestObject('Object Repository/Make Appointment Page/select_Facility'), facility, true)

//WebUI.click(findTestObject('Make Appointment Page/input_Apply hospital readmission'))
if (hospital_redmission == true) {
    WebUI.check(findTestObject('Make Appointment Page/input_Apply hospital readmission'))
}

//WebUI.verifyElementPresent(findTestObject('Make Appointment Page/input_Apply hospital readmission'), 0)
/*if (hospital_redmission == true) {
	WebUI.verifyElementText(findTestObject('Make Appointment Page/input_Apply hospital readmission'), "Yes")
} else {
	WebUI.verifyElementText(findTestObject('Make Appointment Page/input_Apply hospital readmission'), "No")
}*/
WebUI.click(findTestObject('Object Repository/Make Appointment Page/input_Healthcare_programs'))

WebUI.setText(findTestObject('Object Repository/Make Appointment Page/input_Visit Date'), date)

WebUI.setText(findTestObject('Object Repository/Make Appointment Page/textarea_Comment'), comment)

WebUI.click(findTestObject('Object Repository/Make Appointment Page/button_Booking'))

WebUI.waitForElementPresent(findTestObject('Confirmation Page/h2_Label Appointment Confirm'), 0)

WebUI.verifyElementPresent(findTestObject('Confirmation Page/h2_Label Appointment Confirm'), 0)

//WebUI.verifyElementText(findTestObject('Confirmation Page/p_Label Redmission'), 'No')
'verify redmission'
if (hospital_redmission == true) {
    WebUI.verifyElementText(findTestObject('Confirmation Page/p_Label Redmission'), 'Yes')
} else {
    WebUI.verifyElementText(findTestObject('Confirmation Page/p_Label Redmission'), 'No')
}

//WebUI.verifyElementText(findTestObject('Confirmation Page/p_Label Health Center'), facility)
'verify facility'
switch (facility) {
    case facility = 'Tokyo CURA Healthcare Center':
        WebUI.verifyElementText(findTestObject('Confirmation Page/p_Label Health Center'), 'Tokyo CURA Healthcare Center')

        break
    case facility = 'Hongkong CURA Healthcare Center':
        WebUI.verifyElementText(findTestObject('Confirmation Page/p_Label Health Center'), 'Hongkong CURA Healthcare Center')

        break
    case facility = 'Seoul CURA Healthcare Center':
        WebUI.verifyElementText(findTestObject('Confirmation Page/p_Label Health Center'), 'Seoul CURA Healthcare Center')

        break
    default:
        WebUI.verifyElementText(findTestObject('Confirmation Page/p_Label Health Center'), 'Tokyo CURA Healthcare Center')

        break
}

CustomKeywords.'com.keyword.homepage.keywordtask.GoToHomePage'()

