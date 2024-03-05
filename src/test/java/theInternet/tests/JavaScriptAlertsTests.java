package theInternet.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import theInternet.pages.HomePage;
import theInternet.pages.JavaScriptAlertsPage;


public class JavaScriptAlertsTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getJavaScriptAlerts();
    }

    @Test
    public void javaScriptAlertTest() {
        new JavaScriptAlertsPage(driver).clickByJavaScriptAlert();
    }

    @Test
    public void javaScriptConfirmTest() {
        new JavaScriptAlertsPage(driver)
                .clickByJavaScriptConfirm("Cancel")
                .verifyResult("Cancel");
    }

    @Test
    public void javaScriptPromptTest() {
        new JavaScriptAlertsPage(driver)
                .clickByJavaScriptPrompt("Hello Natalie!")
                .verifyMessage("Hello Natalie");
    }
}


















