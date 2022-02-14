package com.easyqa.qa.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.sleep;

public class NewDefectPage {
    @FindBy(xpath = "//h1[normalize-space()='Create defect']")
    public SelenideElement createLabel;

    @FindBy(id = "title")
    public SelenideElement defectTitle;

    @FindBy(xpath = "//div[@class='ProseMirror toastui-editor-contents']")  //  //p[@class='empty-node']
    public SelenideElement actualResult;

    @FindBy(xpath = "//*[@id=\"severityGroup\"]/div[1]") ////input[@id='react-select-3-input']
    public SelenideElement defectSeveritySelector;

    @FindBy(xpath = "//div[@id='react-select-3-option-6']")
    public SelenideElement defectSeverityTrivial;

    @FindBy(xpath = "//div[@id='react-select-3-option-5']")
    public SelenideElement defectSeverityMinor;

    @FindBy(xpath = "//div[@id='react-select-3-option-4']")
    public SelenideElement defectSeverityNormal;

    @FindBy(xpath = "//div[@id='react-select-3-option-3']")
    public SelenideElement defectSeverityMajor;

    @FindBy(xpath = "//div[@id='react-select-3-option-2']")
    public SelenideElement defectSeverityCritical;

    @FindBy(xpath = "//div[@id='react-select-3-option-1']")
    public SelenideElement defectSeverityBlocker;

    @FindBy(xpath = "//div[@id='react-select-3-option-0']")
    public SelenideElement defectSeverityNotSet;

    @FindBy(xpath = "//button[@type='submit']")
    public SelenideElement defectSaveBtn;

    @Step
    public void checkNewDefectPage() {
        createLabel.should(Condition.visible);
    }

    @Step
    public void addNewIssue(String issueName, String issueDesc, int issuePriority) {
        //TODO непонятно почему вылазит алерт, при первом внесении данных в поля текстового ввода,
        // но если подождать, он обрабатывается нормально.
        defectTitle.shouldBe(Condition.visible).setValue(issueName);
        sleep(1000);
        actualResult.shouldBe(Condition.visible).setValue(issueDesc); //TODO другой локатор от 12.01.22 16:59
        setPriority(issuePriority);
        defectSaveBtn.click();

    }

    @Step
    public void setPriority(int priority) {
        switch (priority) {
            case 0:
                setDefectSeverityNotSet();
                break;
            case 1:
                setDefectSeverityBlocker();
                break;
            case 2:
                setDefectSeverityCritical();
                break;
            case 3:
                setDefectSeverityMajor();
                break;
            case 4:
                setDefectSeverityNormal();
                break;
            case 5:
                setDefectSeverityMinor();
                break;
            case 6:
                setDefectSeverityTrivial();
                break;
        }
    }

    @Step
    public void setDefectSeverityNotSet() {
        defectSeveritySelector.shouldBe(Condition.visible).click();
        defectSeverityNotSet.shouldBe(Condition.visible).click();
    }

    @Step
    public void setDefectSeverityBlocker() {
        defectSeveritySelector.shouldBe(Condition.visible).click();
        defectSeverityBlocker.shouldBe(Condition.visible).click();
    }

    @Step
    public void setDefectSeverityCritical() {
        defectSeveritySelector.shouldBe(Condition.visible).click();
        defectSeverityCritical.shouldBe(Condition.visible).click();
    }

    @Step
    public void setDefectSeverityMajor() {
        defectSeveritySelector.shouldBe(Condition.visible).click();
        defectSeverityMajor.shouldBe(Condition.visible).click();
    }

    @Step
    public void setDefectSeverityNormal() {
        defectSeveritySelector.shouldBe(Condition.visible).click();
        defectSeverityNormal.shouldBe(Condition.visible).click();
    }

    @Step
    public void setDefectSeverityMinor() {
        defectSeveritySelector.shouldBe(Condition.visible).click();
        defectSeverityMinor.shouldBe(Condition.visible).click();
    }

    @Step
    public void setDefectSeverityTrivial() {
        defectSeveritySelector.shouldBe(Condition.visible).click();
        defectSeverityTrivial.shouldBe(Condition.visible).click();
    }
}

