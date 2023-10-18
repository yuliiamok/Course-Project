package robotdreams.automation.base;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Attachment;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import robotdreams.automation.Config;
import robotdreams.automation.Session;

public class BaseGUITest extends BaseTestNG{

    @BeforeMethod(alwaysRun = true)
    public void beforeGUIMethod() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(false)
                .includeSelenideSteps(true)
        );
        System.out.println("BEFORE METHOD");
        this.wd().get(String.format("http://%s:%s",
                Config.HTTP_BASE_URL.value,
                Config.HTTP_BASE_PORT.value
        ));
        WebDriverRunner.setWebDriver(this.wd());
    }
    @AfterMethod(alwaysRun = true)
    public void afterGUIMethod(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE || result.getStatus() == ITestResult.CREATED) {
            this.takeScreenshot();
        }

        Session.get().close();
    }

    protected WebDriver wd() {
        return Session.get().webdriver();
    }
    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] takeScreenshot(){
        return ((TakesScreenshot) this.wd()).getScreenshotAs(OutputType.BYTES);
    }

}
