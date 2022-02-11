package com.easyqa.qa.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;


public class ProjectDashboardPage {

    @FindBy(xpath = "//h1[@class='style_title-319J6']")
    public SelenideElement projectOverview;

    @FindBy(xpath = "//a[@id='menu-link-test-defects']")
    public SelenideElement issuesLink;

    @Step
    public void checkProjectDashboardPage() {
        projectOverview.shouldBe(Condition.visible);
    }

    @Step
    public IssuesPage openDefectsPage() {
        issuesLink.click();
        return page(IssuesPage.class);
    }

}
