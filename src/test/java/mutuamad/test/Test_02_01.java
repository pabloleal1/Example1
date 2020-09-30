package mutuamad.test;

import com.atsistemas.appium.CreateExtetReport;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import mutuamad.process.CP0;
import mutuamad.process.CP1;
import mutuamad.screen.InsuranceScreen;
import mutuamad.screen.PrincipalScreen;
import mutuamad.screen.ViewAndManageInsurance;
import mutuamad.screen.WelcomeScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_02_01 extends CreateExtetReport {


    @Test
    public void Globalis_usuario_Puro() throws Exception {

        //Test user
        String User_Puro_Globalis= "PuroGlobalis";

        //Initialize variables
        CP0 cp0 = new CP0(driverManager);
        CP1 cp1 = new CP1 (driverManager);
        WelcomeScreen welcomeScreen = new WelcomeScreen(driverManager);
        PrincipalScreen principalScreen = new PrincipalScreen(driverManager);
        InsuranceScreen insuranceScreen = new InsuranceScreen(driverManager);
        ViewAndManageInsurance viewAndManageInsurance = new ViewAndManageInsurance(driverManager);

        //Initialize report
        test1 = extent.createTest(this.getClass().getSimpleName(), "Globalis usuario puro");
        test1.log(Status.INFO, "Starting test");


        //Cancel notifications and access to Login
        cp0.execute(test1);

        //Login using a globalis user
        cp1.execute(User_Puro_Globalis, test1);

        //TEST START .-
        // Verifying mailbox button from home is NOT shown
        ExtentTest node2 = test1.createNode("Globalis Steps - Verifications");
        CreateExtetReport.stepsVerifications(!welcomeScreen.verifyMailButonFromHomeIsShown(), node2, "Mailbox is NOT shown from home screen");
        Assert.assertFalse(welcomeScreen.verifyMailButonFromHomeIsShown(), "Mailbox is shown from home screen" );

        // Verifying mailbox button from menu is NOT shown
        welcomeScreen.clickButtonMenu();
        CreateExtetReport.stepsVerifications(!welcomeScreen.verifyMailButonFromMenuIsShown(), node2, "Mailbox is NOT shown from menu screen");
        Assert.assertFalse(welcomeScreen.verifyMailButonFromMenuIsShown(),"Mailbox is shown from menu screen" );

        // Verifying EME button from menu is NOT shown
        CreateExtetReport.stepsVerifications(!welcomeScreen.verifyEmmeButtonisShown(), node2, "EME button from menu screen is NOT shown");
        Assert.assertFalse(welcomeScreen.verifyEmmeButtonisShown(), "EME button from menu screen is shown");

        // Verifying calcula tu seguro button from menu is NOT shown
        if (welcomeScreen.verifyDropDownMyInsuranceFromMenuIsShown())
        {
            CreateExtetReport.stepsVerifications(!welcomeScreen.verifyPriceCalculateIsShown(), node2, "Calcula tu seguro is shown");
            Assert.assertFalse(welcomeScreen.verifyPriceCalculateIsShown(), "Calcula tu seguro is NOT shown" );
        }

        //Close the menu
        welcomeScreen.clickIconCloseMenu();

        //Going to the insurance link
        principalScreen.clickMyInsuranceLink();

        //Going to the view and manage my insurance screen
        insuranceScreen.clickButtonViewInsuranceDetails();

        // Verify banner of the globalis is shown
        CreateExtetReport.stepsVerifications(viewAndManageInsurance.verifyBannerGlobalisIsPresent(), node2, "El banner NO es mostrado");
        Assert.assertTrue(viewAndManageInsurance.verifyBannerGlobalisIsPresent(), "El banner NO es mostrado" );

    }
}
