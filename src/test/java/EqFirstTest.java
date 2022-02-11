import com.codeborne.selenide.logevents.SelenideLogger;
import com.easyqa.qa.pages.*;
import com.easyqa.qa.pages.util.CardData;
import com.easyqa.qa.pages.util.PageAddressData;
import com.easyqa.qa.pages.util.UserData;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;

public class EqFirstTest {
    PageAddressData pageAddressData = new PageAddressData("https://app.qase.io/login");
    UserData theUser = new UserData("molodikm@gmail.com", "1234567m");
    CardData issue = new CardData("test2", "issue description", 1);

    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        browser = "chrome";
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
    }

    @Test
    public void createNewDefect() {
        LoginPage loginPage = open(pageAddressData.getPageAddress(), LoginPage.class);
        loginPage.enterLogin(theUser.getUserEmail());
        loginPage.enterPassword(theUser.getUserPassword());
        ProjectsPage projectsPage = loginPage.clickLoginBtn();
        projectsPage.checkUserAuthorized();
        ProjectDashboardPage projectDashboardPage = projectsPage.openProject();
        projectDashboardPage.checkProjectDashboardPage();
        IssuesPage issuesPage = projectDashboardPage.openDefectsPage();
        issuesPage.checkIssuesPage();
        NewDefectPage newDefectPage = issuesPage.createNewDefect();
        newDefectPage.checkNewDefectPage();
        newDefectPage.addNewIssue(issue.getCardName(), issue.getCardDescription(), issue.getIssuePriority());
        issuesPage.checkIssueAdded(issue.getCardName());
    }

    @Test
    public void deleteCard() {
        LoginPage loginPage = open(pageAddressData.getPageAddress(), LoginPage.class);
        loginPage.enterLogin(theUser.getUserEmail());
        loginPage.enterPassword(theUser.getUserPassword());
        ProjectsPage projectsPage = loginPage.clickLoginBtn();
        projectsPage.checkUserAuthorized();
        ProjectDashboardPage projectDashboardPage = projectsPage.openProject();
        projectDashboardPage.checkProjectDashboardPage();
        IssuesPage issuesPage = projectDashboardPage.openDefectsPage();
        issuesPage.checkIssuesPage();
        issuesPage.deleteCard(issue.getCardName());
    }

    @Test
    public void loginAsRegisteredUser() {
        LoginPage loginPage = open(pageAddressData.getPageAddress(), LoginPage.class);
        loginPage.enterLogin(theUser.getUserEmail());
        loginPage.enterPassword(theUser.getUserPassword());
        ProjectsPage projectsPage = loginPage.clickLoginBtn();
        projectsPage.checkUserAuthorized();
    }

    @Test
    public void openProject() {
        LoginPage loginPage = open(pageAddressData.getPageAddress(), LoginPage.class);
        loginPage.enterLogin(theUser.getUserEmail());
        loginPage.enterPassword(theUser.getUserPassword());
        ProjectsPage projectsPage = loginPage.clickLoginBtn();
        projectsPage.checkUserAuthorized();
        ProjectDashboardPage projectDashboardPage = projectsPage.openProject();
        projectDashboardPage.checkProjectDashboardPage();
    }

    @Test
    public void openIssuesPage() {
        LoginPage loginPage = open(pageAddressData.getPageAddress(), LoginPage.class);
        loginPage.enterLogin(theUser.getUserEmail());
        loginPage.enterPassword(theUser.getUserPassword());
        ProjectsPage projectsPage = loginPage.clickLoginBtn();
        projectsPage.checkUserAuthorized();
        ProjectDashboardPage projectDashboardPage = projectsPage.openProject();
        projectDashboardPage.checkProjectDashboardPage();
        IssuesPage issuesPage = projectDashboardPage.openDefectsPage();
        issuesPage.checkIssuesPage();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        closeWebDriver();
    }

}