package com.easyqa.qa.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;


public class ProjectsPage {

    @FindBy(xpath = "//img[@id='user-menu']")
    public SelenideElement profileLink;

    @FindBy(xpath = "//a[@href='https://app.qase.io/projects']")
    public SelenideElement myProjectsLink;

    @FindBy(xpath = "//h1[.='Projects']")
    public SelenideElement projectsHeader;

    @FindBy(xpath = "//a[@href='/project/DEMO']")
    public SelenideElement projectName;

    @Step
    public void checkProjectsPage() {
        projectsHeader.shouldBe(Condition.visible);
    }

    @Step
    public void checkUserAuthorized() {
        profileLink.shouldBe(Condition.visible);
    }

    @Step
    public ProjectDashboardPage openProject() {
        projectName.click();
        return page(ProjectDashboardPage.class);
    }

}
