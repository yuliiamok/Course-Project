package robotdreams.automation.app.web;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import robotdreams.automation.base.BaseSelenidePage;

public class ManageProjectsPage extends BaseSelenidePage {


    @Override
    protected SelenideElement readyElement() {
        return Selenide.$x("//div[@class='table-list-header-menu']");
    }
}
