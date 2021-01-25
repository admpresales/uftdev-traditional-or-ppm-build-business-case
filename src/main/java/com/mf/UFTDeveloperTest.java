package com.mf;

import com.hp.lft.report.ReportException;
import com.hp.lft.report.Reporter;
import com.hp.lft.report.Status;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.hp.lft.sdk.*;
import com.hp.lft.verifications.*;
import com.hp.lft.sdk.web.*;

import unittesting.*;

import java.time.Year;

public class UFTDeveloperTest extends UnitTestClassBase {
Browser browser;
Browser browser2;
    public UFTDeveloperTest() {
        //Change this constructor to private if you supply your own public constructor
    }

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        instance = new UFTDeveloperTest();
        globalSetup(UFTDeveloperTest.class);
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        globalTearDown();
    }

    @Before
    public void setUp() throws Exception {
        browser = BrowserFactory.launch(BrowserType.CHROME);
        browser.clearCache();
        browser.deleteCookies();

    }

    @After
    public void tearDown() throws Exception {
        browser.closeAllTabs();
        if (browser2.exists()){
            browser2.closeAllTabs();
        }
    }

    @Test
    public void test() throws GeneralLeanFtException {
        int NextYear;
        NextYear = (Year.now().getValue() + 1);
        int counter;

        browser.navigate("http://nimbusserver.aos.com:8088");
        browser.sync();

        Link SignOutLink = browser.describe(Link.class, new LinkDescription.Builder()
                .innerText(new RegExpProperty("Sign Out.*")).build());
        WebElement MenuUserIconWebElement = browser.describe(WebElement.class, new WebElementDescription.Builder()
                .id("menuUserIcon").build());
        Image StrategicPortfolioImage = browser.describe(Image.class, new ImageDescription.Builder()
                .href("http://nimbusserver.aos.com:8088/PFM.300.html")
                .type(com.hp.lft.sdk.web.ImageType.LINK).build());
        StrategicPortfolioImage.click();
        browser.sync();
        Area BarbaryGettyImage = browser.describe(Area.class, new AreaDescription.Builder()
                .href(new RegExpProperty(".*bgetty.*")).build());
        BarbaryGettyImage.click();
        browser.sync();
        Link SearchLink = browser.describe(Link.class, new LinkDescription.Builder()
                .innerText("SEARCH").build());
        SearchLink.click();
        Link RequestsLink = browser.describe(Link.class, new LinkDescription.Builder()
                .innerText("Requests").build());
        RequestsLink.click();
        browser.sync();
        //PFM - Proposal
        EditField RequestTypeEditField = browser.describe(EditField.class, new EditFieldDescription.Builder()
                .name("REQUEST_TYPE_ID").build());
        RequestTypeEditField.setValue("PFM - Proposal");
        WebElement StatusWebElement = browser.describe(WebElement.class, new WebElementDescription.Builder()
                .innerText("Status:").build());
        StatusWebElement.click();
        browser.sync();
        EditField StatusEditField = browser.describe(EditField.class, new EditFieldDescription.Builder()
                .title("Status").build());
        StatusEditField.setValue("New");
        WebElement TopSearchWebElement = browser.describe(WebElement.class, new WebElementDescription.Builder()
                .tagName("SPAN")
                .innerText("Search")
                .index(0).build());
        TopSearchWebElement.click();
        browser.sync();
        Link FirstResultLink = browser.describe(Table.class, new TableDescription.Builder()
                .id("searchResultTable")
                .tagName("TABLE").build())
                .describe(Link.class, new LinkDescription.Builder()
                        .tagName("A")
                        .index(0).build());
        FirstResultLink.click();
        browser.sync();
        WebElement ApprovedWebElement = browser.describe(WebElement.class, new WebElementDescription.Builder()
                .tagName("DIV")
                .innerText("Approved").build());
        ApprovedWebElement.click();
        browser.sync();
        WebElement ContinueWorkflowActionWebElement = browser.describe(WebElement.class, new WebElementDescription.Builder()
                .tagName("SPAN")
                .innerText("Continue Workflow Action").build());
        ContinueWorkflowActionWebElement.click();
        browser.sync();
        //US
        EditField RegionEditField = browser.describe(EditField.class, new EditFieldDescription.Builder()
                .title("Region:")
                .type("text").build());
        RegionEditField.setValue("US");
        browser.sync();
        WebElement CompletedWebElement = browser.describe(WebElement.class, new WebElementDescription.Builder()
                .tagName("DIV")
                .innerText("Completed")
                .index(0).build());
        CompletedWebElement.click();
        browser.sync();
        ContinueWorkflowActionWebElement.exists();
        ListBox ProjectClassListBox = browser.describe(ListBox.class, new ListBoxDescription.Builder()
                .title(new RegExpProperty("Project Class:.*")).build());
        counter = 0;
        do {
            counter++;
            ProjectClassListBox.select("Innovation");
            if (counter >= 5){
                try {
                    Reporter.reportEvent("Set Project Class Value","The Project Class value never got set within " + counter + " attempts, aborting run", Status.Failed);
                } catch (ReportException e) {
                    e.printStackTrace();
                }
                MenuUserIconWebElement.click();
                SignOutLink.click();
                browser.sync();
                return;
            }
        }
        while (!ProjectClassListBox.getValue().equals("Innovation"));
        ListBox AssetClassListBox = browser.describe(ListBox.class, new ListBoxDescription.Builder()
                .title(new RegExpProperty("Asset Class:.*")).build());
        counter = 0;
        do {
            counter++;
            AssetClassListBox.select("Infrastructure");
            if (counter >= 5){
                try {
                    Reporter.reportEvent("Set Asset Class Value","The Asset Class value never got set within " + counter + " attempts, aborting run", Status.Failed);
                } catch (ReportException e) {
                    e.printStackTrace();
                }
                MenuUserIconWebElement.click();
                SignOutLink.click();
                browser.sync();
                return;
            }
        }
        while (!AssetClassListBox.getValue().equals("Infrastructure"));
        ContinueWorkflowActionWebElement.click();
        browser.sync();
        ApprovedWebElement.click();
        browser.sync();
        ContinueWorkflowActionWebElement.exists();
        EditField ExpectedStartPeriodEditField = browser.describe(EditField.class, new EditFieldDescription.Builder()
                .title(new RegExpProperty("Expected Start Period.*")).build());
        counter = 0;
        do {
            counter++;
            ExpectedStartPeriodEditField.setValue("June " + NextYear);
            if (counter >= 5){
                try {
                    Reporter.reportEvent("Set Expected Start Period Value","The Expected Start Period value never got set within " + counter + " attempts, aborting run", Status.Failed);
                } catch (ReportException e) {
                    e.printStackTrace();
                }
                MenuUserIconWebElement.click();
                SignOutLink.click();
                browser.sync();
                return;
            }
        }
        while (!ExpectedStartPeriodEditField.getValue().equals("June " + NextYear));
        EditField ExpectedFinishPeriodEditField = browser.describe(EditField.class, new EditFieldDescription.Builder()
                .title(new RegExpProperty("Expected Finish Period.*")).build());
        counter = 0;
        do {
            counter++;
            ExpectedFinishPeriodEditField.setValue("December " + NextYear);
            if (counter >= 5){
                try {
                    Reporter.reportEvent("Set Expected Start Period Value","The Expected Start Period value never got set within " + counter + " attempts, aborting run", Status.Failed);
                } catch (ReportException e) {
                    e.printStackTrace();
                }
                MenuUserIconWebElement.click();
                SignOutLink.click();
                browser.sync();
                return;
            }
        }
        while (!ExpectedFinishPeriodEditField.getValue().equals("December " + NextYear));
        ContinueWorkflowActionWebElement.click();
        browser.sync();
        CompletedWebElement.click();
        browser.sync();
        WebElement CreateWebElement = browser.describe(WebElement.class, new WebElementDescription.Builder()
                .tagName("DIV")
                .className("middle-btn")
                .innerText("Create").build());
        CreateWebElement.click();
        browser.sync();
        BrowserDescription browserDescription = new BrowserDescription();
        browserDescription.setOpenTitle("Create a Blank Staffing Profile");
        browserDescription.setType(BrowserType.CHROME);
        browser2 = BrowserFactory.attach(browserDescription);

        WebElement CreateWebElement2 = browser2.describe(WebElement.class, new WebElementDescription.Builder()
                .tagName("DIV")
                .innerText("Create ")
                .index(0).build());


        CreateWebElement2.click();
        browser2.sync();
        Link SelectTheStaffingProfileLink = browser2.describe(Link.class, new LinkDescription.Builder()
                .tagName("A")
                .innerText("Select the Staffing Profile").build());
        SelectTheStaffingProfileLink.click();
        browser2.sync();
        //A/R Billing Upgrade
        EditField CopySourceEditField = browser2.describe(Frame.class, new FrameDescription.Builder()
                .name("copyPositionsDialogIF").build())
                .describe(EditField.class, new EditFieldDescription.Builder()
                        .title("Staffing Profile:").build());
        CopySourceEditField.setValue("A/R Billing Upgrade");
        WebElement StaffingProfileWebElement = browser2.describe(Frame.class, new FrameDescription.Builder()
                .name("copyPositionsDialogIF").build())
                .describe(WebElement.class, new WebElementDescription.Builder()
                        .innerText("* Staffing Profile:").build());
        StaffingProfileWebElement.click();
        WebElement ImportWebElement = browser2.describe(Frame.class, new FrameDescription.Builder()
                .name("copyPositionsDialogIF").build())
                .describe(WebElement.class, new WebElementDescription.Builder()
                        .tagName("SPAN")
                        .innerText("Import")
                        .index(1).build());
        ImportWebElement.click();
        browser2.sync();
        WebElement DoneWebElement = browser2.describe(WebElement.class, new WebElementDescription.Builder()
                .tagName("SPAN")
                .innerText("Done").build());
        DoneWebElement.click();
        browser.sync();
        ContinueWorkflowActionWebElement.click();
        browser.sync();
        WebElement StatusFinanceReviewWebElement = browser.describe(WebElement.class, new WebElementDescription.Builder()
                .tagName("SPAN")
                .innerText("Status: Finance Review ").build());
        if (StatusFinanceReviewWebElement.exists()){
            try {
                Reporter.reportEvent("Final Status of Finance Review","The final status of Finance Review showed up correctly.", Status.Passed);
            } catch (ReportException e) {
                e.printStackTrace();
            }

        }
        else {
            try {
                Reporter.reportEvent("Final Status of Finance Review","The final status of Finance Review did not show up correctly, Jason talk to Alan.", Status.Failed);
            } catch (ReportException e) {
                e.printStackTrace();
            }

        }
        MenuUserIconWebElement.click();
        SignOutLink.click();
        browser.sync();


    }

}