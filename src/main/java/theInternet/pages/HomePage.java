package theInternet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[href='/javascript_alerts']")
    WebElement javaScriptAlerts;

    public HomePage getJavaScriptAlerts() {
        click(javaScriptAlerts);
        return new HomePage(driver);
    }
}

















