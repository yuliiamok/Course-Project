package robotdreams.automation.app.web;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import robotdreams.automation.base.BaseSelenidePage;

public class NewTaskBox extends BaseSelenidePage {
    @Override
    protected SelenideElement readyElement() {
        return Selenide.$x("//div[@id='modal-box']");
    }
    final public SelenideElement closeBtn = Selenide.$x("//a[@id='modal-close-button']");
    final public SelenideElement title = Selenide.$x("//input[@id='form-title']");
    final public SelenideElement textarea = Selenide.$x("//*[@id='modal-content']/form/div/div[1]/div/div/div[2]/textarea");
    final public SelenideElement tagsField = Selenide.$x("//ul[@class='select2-selection__rendered']");

    // Other fields
    final public SelenideElement submitBtn = Selenide.$x("//button[@type='submit']");
    final public SelenideElement cancelBtn = Selenide.$x("//*[@id='modal-content']/form/div/div[4]/div/div/a");

    public ProjectPage addTask(String title) {
        this.title.val(title);
        this.submitBtn.click();

        return new ProjectPage();
    }

}
