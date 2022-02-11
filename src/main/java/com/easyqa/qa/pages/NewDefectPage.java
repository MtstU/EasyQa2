package com.easyqa.qa.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class NewDefectPage {
    @FindBy(xpath = "//h1[normalize-space()='Create defect']")
    public SelenideElement createLabel;

    @FindBy(id = "title")
    public SelenideElement defectTitle;

    @FindBy(xpath = "//p[@class='empty-node']")
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
    public IssuesPage addNewIssue(String issueName, String issueDesc, int issuePriority) {
        defectTitle.click();
        defectTitle.sendKeys(issueName);
        actualResult.click();
        actualResult.setValue(issueDesc);                           //                 sendKeys(issueDesc);
        setPriority(issuePriority);
        defectSaveBtn.click();

        return page(IssuesPage.class);
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
        defectSeveritySelector.click();
        defectSeverityNotSet.click();
    }

    @Step
    public void setDefectSeverityBlocker() {
        defectSeveritySelector.click();
        defectSeverityBlocker.click();
    }

    @Step
    public void setDefectSeverityCritical() {
        defectSeveritySelector.click();
        defectSeverityCritical.click();
    }

    @Step
    public void setDefectSeverityMajor() {
        defectSeveritySelector.click();
        defectSeverityMajor.click();
    }

    @Step
    public void setDefectSeverityNormal() {
        defectSeveritySelector.click();
        defectSeverityNormal.click();
    }

    @Step
    public void setDefectSeverityMinor() {
        defectSeveritySelector.click();
        defectSeverityMinor.click();
    }

    @Step
    public void setDefectSeverityTrivial() {
        defectSeveritySelector.click();
        defectSeverityTrivial.click();
    }
}

