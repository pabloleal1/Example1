package mutuamad.test;

import com.atsistemas.appium.CreateExtetReport;
import com.aventstack.extentreports.Status;
import mutuamad.Utilities;
import mutuamad.process.CP0;
import mutuamad.process.CP1;
import mutuamad.screen.EmmeScreen;
import mutuamad.screen.WelcomeScreen;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Test_10_02 extends CreateExtetReport {

    @Test
    public void Chatbox_Home() throws Exception {

        //Test user
        String User_Standars= "AutoInsurance";

        //Initialize variables
        CP0 cp0 = new CP0(driverManager);
        CP1 cp1 = new CP1 (driverManager);
        WelcomeScreen welcomeScreen = new WelcomeScreen(driverManager);
        EmmeScreen emmeScreen = new EmmeScreen(driverManager);

        //Initialize report
        test1 = extent.createTest(this.getClass().getSimpleName(), "Eme Aparece en la home");
        test1.log(Status.INFO, "Starting test");

        //Cancel notifications and access to Login
        cp0.execute(test1);

        //Login
        cp1.execute(User_Standars, test1);

        //TEST START .-
        String searchEmme = "Como ceder Poliza";
        //Verify the Emme button is shown
        CreateExtetReport.stepsVerifications(welcomeScreen.verifyEmeButtonIsShowOnHomeScreen(), test1, "Showing EME button on the home screen");
        Assert.assertTrue( welcomeScreen.verifyEmeButtonIsShowOnHomeScreen(),"Eme Button is NOT shown on home screen");
        //Click on the Emme button to show Emme screen
        welcomeScreen.clickOnEmeButtonFromHomeScreen();
        Utilities.sleep(5000);
        emmeScreen.clickAcceptEmmeRecording();
        Utilities.sleep(8000);
        //Set search parameters
        emmeScreen.setSearchEmeField(searchEmme);
        Utilities.sleep(5000);
        //Close the Emme screen
        emmeScreen.clickCloseEmmeScreen();
        // Open Emme Screen again
        welcomeScreen.clickOnEmeButtonFromHomeScreen();
        Utilities.sleep(5000);
        //Verify the paremeters set before is correct
        CreateExtetReport.stepsVerifications(emmeScreen.latestSameMessage(searchEmme), test1, "Showing paremeters set previously");
        Assert.assertTrue(emmeScreen.latestSameMessage(searchEmme),"Emme doesn't work properly");

    }
}
