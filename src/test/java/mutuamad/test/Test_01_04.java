package mutuamad.test;

import com.atsistemas.appium.CreateExtetReport;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import mutuamad.Utilities;
import mutuamad.process.CP1;
import mutuamad.process.CPQuitTutorial;
import mutuamad.screen.AssistanceScreen;
import mutuamad.screen.WelcomeScreen;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Test_01_04 extends CreateExtetReport {

    @Test
    public void Login_Asistencia() throws Exception {

        //Test user
        String User_Standars= "AutoInsurance";

        //Initialize variables
        CPQuitTutorial cpQuitTutorial = new CPQuitTutorial(driverManager);
        CP1 cp1 = new CP1(driverManager);
        WelcomeScreen welcomeScreen = new WelcomeScreen(driverManager);
        AssistanceScreen assistanceScreen = new AssistanceScreen(driverManager);

        //Initialize report
        test1 = extent.createTest(this.getClass().getSimpleName(), "Login desde Asistencia");
        test1.log(Status.INFO, "Starting test");

        //Cancel notifications and access to Login
        cpQuitTutorial.execute(test1);

        //User click on the card from home screen
        Utilities.sleep(5000);
        welcomeScreen.clickButtonAssistance();

        //Login
        cp1.execute(User_Standars, test1);

        //Verify card screen is shown after login
        ExtentTest node2 = test1.createNode("Showing correct Screen");
        CreateExtetReport.stepsVerifications(assistanceScreen.verifyAssistanceTittleIsShown(), node2, "Verify Dar parte screen is shown");
        Assert.assertTrue(assistanceScreen.verifyAssistanceTittleIsShown(),"La ventana de ASISTENCIA NO es mostrada, tras iniciar sesion desde DAR PARTE");

    }
}
