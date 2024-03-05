package theInternet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class JavaScriptAlertsPage extends BasePage{

    public JavaScriptAlertsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[onclick='jsAlert()']")
    WebElement javaScriptAlertButton;
    public JavaScriptAlertsPage clickByJavaScriptAlert() {
        click(javaScriptAlertButton);
        return this;
    }
    /*public JavaScriptAlertsPage clickByJavaScriptAlert() {
            click(javaScriptAlertButton);
            new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.alertIsPresent()).accept();
            return this;
        }*/

    @FindBy (css = "[onclick='jsConfirm()']")
    WebElement javaScriptConfirmButton;
    public JavaScriptAlertsPage clickByJavaScriptConfirm(String confirm) {
        click(javaScriptConfirmButton);
        if (confirm != null && confirm.equals("OK")) {
            driver.switchTo().alert().accept();
        } else if (confirm != null && confirm.equals("Cancel")) {
            driver.switchTo().alert().dismiss();
        }
        return this;
    }

    @FindBy (id = "result")
    WebElement confirmResult;
    public JavaScriptAlertsPage verifyResult(String result) {
        Assert.assertTrue(confirmResult.getText().contains(result));
        return this;
    }


    @FindBy (css = "[onclick='jsPrompt()']")
    WebElement javaScriptPromptButton;
    public JavaScriptAlertsPage clickByJavaScriptPrompt(String message) {
        click(javaScriptPromptButton);
        if (message != null) {
            driver.switchTo().alert().sendKeys(message);
            driver.switchTo().alert().accept();
        }
        return this;
    }

    @FindBy (id = "result")
    WebElement promptResult;
    public JavaScriptAlertsPage verifyMessage(String text) {
        Assert.assertTrue(promptResult.getText().contains(text));
        return this;
    }
}

















