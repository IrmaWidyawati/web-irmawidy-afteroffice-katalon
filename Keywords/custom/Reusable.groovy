package custom

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import org.openqa.selenium.WebElement

class Reusable {

	@Keyword
	def safeClick(TestObject testObject) {
		try {
			// Scroll to top to avoid fixed ads
			WebUI.executeJavaScript("window.scrollTo(0, 0)", null)
			WebUI.delay(1)

			// Try to click normally
			WebUI.click(testObject)
		} catch (Exception e) {
			// If failed, use JavaScript click
			WebElement element = WebUiCommonHelper.findWebElement(testObject, 10)
			WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(element))
		}
	}
}
