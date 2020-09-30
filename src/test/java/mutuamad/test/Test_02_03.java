package mutuamad.test;

import com.atsistemas.appium.CreateExtetReport;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import mutuamad.process.CP0;
import mutuamad.process.CP1;
import mutuamad.screen.WelcomeScreen;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Test_02_03 extends CreateExtetReport {

    @Test
    public void Solo_poliza_Accidentes () throws Exception {

        //Test user
        String User_Only_Accidents = "Accidentes";

        //Initialize variables
        CP0 cp0 = new CP0(driverManager);
        CP1 cp1 = new CP1(driverManager);
        WelcomeScreen welcomeScreen = new WelcomeScreen(driverManager);


        //Initialize report
        test1 = extent.createTest(this.getClass().getSimpleName(), "Usuario solo poliza Accidentes");
        test1.log(Status.INFO, "Starting test");

        //Cancel notifications and access to Login
        cp0.execute(test1);

        //Login using a correct user
        cp1.execute(User_Only_Accidents, test1);

        //TEST START .-
        ExtentTest node2 = test1.createNode("Home, Only Policy - Accidentes");
        // Verifying Buscador talleres is not shown
        CreateExtetReport.stepsVerifications(!welcomeScreen.verifyCarWorkShopIsShown(), node2, "Car work shop is shown from home screen");
        Assert.assertFalse(welcomeScreen.verifyCarWorkShopIsShown(), "Car work shop is shown from home screen");

        // Verifying Assistance is not shown
        CreateExtetReport.stepsVerifications(!welcomeScreen.verifyButtonAssistanceIsShown(), node2, "Assistance is shown from home screen");
        Assert.assertFalse(welcomeScreen.verifyButtonAssistanceIsShown(), "Assistance is shown from home screen");

        // Verifying Send Report is not shown
        CreateExtetReport.stepsVerifications(!welcomeScreen.verifyButtonReportsIsShown(), node2, "Send report is shown from home screen");
        Assert.assertFalse(welcomeScreen.verifyButtonReportsIsShown(), "Send report shop is shown from home screen");

        //Goign to the menu
        ExtentTest node3 = test1.createNode("Menu, Only Policy - Accidentes");
        welcomeScreen.clickButtonMenu();

        // Verifying Assistance is not shown on the Menu screen
        CreateExtetReport.stepsVerifications(!welcomeScreen.verifyMenuAssistanceIsShown(), node3, "Assistance is shown from menu screen");
        Assert.assertFalse(welcomeScreen.verifyMenuAssistanceIsShown(), "Assistance is shown from menu screen");

        // Verifying send report is not shown on the Menu screen
        CreateExtetReport.stepsVerifications(!welcomeScreen.verifyMenuSendReportIsShown(), node3, "Send report shop is shown from menu screen");
        Assert.assertFalse(welcomeScreen.verifyMenuSendReportIsShown(), "Send report shop is shown from menu screen");

        // Verifying Buscador talleres is not shown on the Menu screen
        CreateExtetReport.stepsVerifications(!welcomeScreen.verifyMenuookingForCarShopIsShown(), node3, "Car work shop is shown from menu screen");
        Assert.assertFalse(welcomeScreen.verifyMenuookingForCarShopIsShown(), "Car work shop is shown from menu screen");

    }
}
