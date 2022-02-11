package com.easyqa.qa.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.refresh;

public class IssuesPage {

    @FindBy(xpath = "(//h1[normalize-space()='Defects'])[1]")
    public SelenideElement defectsHeader;

    @FindBy(xpath = "(//a[normalize-space()='Create new defect'])[1]")
    public SelenideElement createDefectBtn;

    @FindBy(xpath = "//tbody/tr[1]/td[2]")
    public SelenideElement cardName;

    @FindBy(xpath = "//a[@class='btn btn-dropdown']")
    // //tbody/tr[1]/td[8]//a[@class='btn btn-dropdown']  //*[contains(concat(' ',@class,' '), ' projects-table ')]//tr[2]/preceding-sibling::*//td[8]//a[@class="btn btn-dropdown"]
    public SelenideElement actionsDropdownMenuButton;

    @FindBy(xpath = "//tbody/tr[1]/td[8]//div[@class='dropdown-item'][5]") // (//div[@class='dropdown-item'])[5]
    public SelenideElement deleteBtn;

    @FindBy(xpath = "//div[@role='dialog']//div[@class='modal-footer']/button[normalize-space()='Delete']")
    public SelenideElement confirmDeleteBtn;

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
        cardName.shouldBe(text(issueName));
    }

    @Step
    public void deleteCard(String issueName) {
        checkIssueAdded(issueName);
        actionsDropdownMenuButton.shouldBe(Condition.visible).click();
        deleteBtn.shouldBe(Condition.visible).click();
        confirmDeleteBtn.shouldBe(Condition.visible).click();
        refresh();
        defectsHeader.shouldBe(Condition.visible);
        createDefectBtn.shouldBe(Condition.visible);
        cardName.shouldNotBe(Condition.visible);
    }

}
