package robotdreams.automation.base;

import org.openqa.selenium.WebDriver;
import robotdreams.automation.Session;

public class BasePage {
    protected WebDriver wd() {
        return Session.get().webdriver();
    }
}
