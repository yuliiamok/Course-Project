package robotdreams.automation.app.web;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import robotdreams.automation.base.BaseSelenidePage;

public class NewProjectBox extends BaseSelenidePage {

    @Override
    protected SelenideElement readyElement() {
        return Selenide.$x("//div[@id='modal-box']");
    }
    final public SelenideElement closeBtn = Selenide.$x("//a[@id='modal-close-button']");

    final public SelenideElement name = Selenide.$x("//input[@id='form-name']");
    final public SelenideElement identifier = Selenide.$x("//input[@id='form-identifier']");
    final public SelenideElement applyLimitsCheckbox = Selenide.$x("//input[@type='checkbox']");
    final public SelenideElement limitField = Selenide.$x("//input[@id='form-task_limit']");
    final public SelenideElement submitBtn = Selenide.$x("//button[@type='submit']");
    final public SelenideElement cancelBtn = Selenide.$x("//*[@id='project-creation-form']/div[2]/div/a");


    public ProjectPage addedProjectPage(String name) {
        this.name.val(name);
        this.submitBtn.click();

        return new ProjectPage();
    }
}
