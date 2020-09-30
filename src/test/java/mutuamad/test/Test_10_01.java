package mutuamad.test;

import com.atsistemas.appium.CreateExtetReport;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import mutuamad.Utilities;
import mutuamad.process.CP0;
import mutuamad.process.CP1;
import mutuamad.screen.EmmeScreen;
import mutuamad.screen.WelcomeScreen;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Test_10_01 extends CreateExtetReport {

    @Test
    public void Chatbox_Menu() throws Exception {

        //Test user
        String User_Standars= "AutoInsurance";

        //Initialize variables
        CP0 cp0 = new CP0(driverManager);
        CP1 cp1 = new CP1 (driverManager);
        WelcomeScreen welcomeScreen = new WelcomeScreen(driverManager);
        EmmeScreen emmeScreen = new EmmeScreen(driverManager);

        //Initialize report
        test1 = extent.createTest(this.getClass().getSimpleName(), "Revisar chatbot(simple)");
        test1.log(Status.INFO, "Starting test");

        //Cancel notifications and access to Login
        cp0.execute(test1);

        //Login
        cp1.execute(User_Standars, test1);

        //TEST START .-
        // Going to the menu screen
        welcomeScreen.clickButtonMenu();
        //User clicks on the emme option button
        welcomeScreen.clickEmmeButton();

        //Create Node for Reports
        ExtentTest node2 = test1.createNode("Chatbox - Eme");

        Utilities.sleep(2000);
        emmeScreen.clickOKDeviceLocationPopup();
        Utilities.sleep(8000);

        //CLick on the burgen icon
        emmeScreen.clickBurgerIcon();
        Utilities.sleep(2000);
        //User selects assistance from the menu displayed
        emmeScreen.clickaAssistanceOption();
        Utilities.sleep(6000);
        //Verify assistance option was choosen
        emmeScreen.verifyAssistanceExpected();
        Utilities.sleep(6000);

        //CLick on the burgen icon
        emmeScreen.clickBurgerIcon();

        //User selects accident parts from the menu displayed
        emmeScreen.clickaAccidentPartsOption();
        Utilities.sleep(6000);
        //Verify Partes option was choosen
        CreateExtetReport.stepsVerifications(emmeScreen.verifyPartesExpected(), node2, "Partes option shown");
        Assert.assertTrue(emmeScreen.verifyPartesExpected(), "Partes option shown");

    }
}
