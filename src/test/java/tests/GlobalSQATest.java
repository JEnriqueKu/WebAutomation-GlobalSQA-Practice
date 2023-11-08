package tests;

import org.testng.annotations.Test;
import pages.AlertsPage;
import pages.HomePage;
import pages.HomePage2;
import pages.HomePage3;
import utils.BaseTest;

import static org.testng.AssertJUnit.*;

public class GlobalSQATest extends BaseTest {

    @Test
    public void iFramesTest() throws InterruptedException {
        HomePage homePage = loadFirstPage();
        homePage.clickOnOpenNewTab();
        HomePage2 homePage2 = homePage.clickOnClickHere();
        homePage.switchToPage2();
        homePage2.clickOnIFrame();
        homePage2.enterIFrame();
        homePage2.clickOnTrainingButton();
        homePage2.clickOnSoftwarwTestingButton();
        homePage2.scrollDownInPage();
        homePage2.clickOnManualTesting();
        homePage2.waitForTrainingsButtonToBeInvisible();
        assertEquals(homePage2.pageHeadingText(),"Manual Testing Training");
        assertEquals(homePage2.subHeader1(),"About Testing");
        assertEquals(homePage2.subHeader2(),"Manual Testing Training Overview");
        homePage2.exitIFrame();
        homePage2.scrollDownInPage();
        HomePage3 homePage3 = homePage2.clickOnAlertBox();
        homePage3.closeCurrentPage();
        /*homePage.switchToPage1();
        homePage.closeAdAlert();
        AlertsPage alertsPage = homePage.navigateToAlerts();
        alertsPage.clickOnAlertWithOkButton();
        alertsPage.acceptAlert();

         */
    }
}
