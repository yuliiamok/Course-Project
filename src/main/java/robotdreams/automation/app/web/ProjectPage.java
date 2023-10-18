package robotdreams.automation.app.web;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import robotdreams.automation.base.BaseSelenidePage;

public class ProjectPage extends BaseSelenidePage {
    @Override
    protected SelenideElement readyElement() {
        return Selenide.$x("//div[@class='sidebar-content']");
    }

    final public SelenideElement actionsDropdown = Selenide.$x("//*[@id='main']/div/div[1]/div/a");



    public SubmenuDropdown openSubmenuDropdown() {
        this.actionsDropdown.click();
        return new SubmenuDropdown();
    }

}
