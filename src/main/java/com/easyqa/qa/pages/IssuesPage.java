package com.easyqa.qa.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class IssuesPage {

    @FindBy(xpath = "(//h1[normalize-space()='Defects'])[1]")
    public SelenideElement defectsHeader;

    @FindBy(xpath = "(//a[normalize-space()='Create new defect'])[1]")
    public SelenideElement createDefectBtn;

    @FindBy(xpath = "//tbody/tr[1]/td[2]")
    public SelenideElement cardName;

    @Step
    public void checkIssuesPage() {
        defectsHeader.shouldBe(Condition.visible);
        createDefectBtn.shouldBe(Condition.visible);
    }

    @Step
    public NewDefectPage createNewDefect() {
        createDefectBtn.click();
        return page(NewDefectPage.class);
    }

    @Step
    public void checkIssueAdded(String issueName) {
        cardName.shouldBe(Condition.text(issueName));
    }

}
