package mutuamad.test;

import com.atsistemas.appium.CreateExtetReport;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import mutuamad.Utilities;
import mutuamad.process.CP1;
import mutuamad.process.CPQuitTutorial;
import mutuamad.screen.WelcomeScreen;
import mutuamad.screen.ReportsScreen;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Test_01_03 extends CreateExtetReport {

    @Test
    public void Login_Dar_Parte() throws Exception {

        //Test user
        String User_Standars= "AutoInsurance";

        //Initialize variables
        CPQuitTutorial cpQuitTutorial = new CPQuitTutorial(driverManager);
        CP1 cp1 = new CP1(driverManager);
        WelcomeScreen welcomeScreen = new WelcomeScreen(driverManager);
        ReportsScreen reportsScreen = new ReportsScreen(driverManager);

        //Initialize report
        test1 = extent.createTest(this.getClass().getSimpleName(), "Login desde Dar Partes");
        test1.log(Status.INFO, "Starting test");

        //Cancel notifications and access to Login
        cpQuitTutorial.execute(test1);

        //User click on the card from home screen
        Utilities.sleep(5000);
        welcomeScreen.clickButtonReports();

        //Login
        cp1.execute(User_Standars, test1);

        //Verify Dar parte screen is shown
        ExtentTest node2 = test1.createNode("Showing correct Screen");
        CreateExtetReport.stepsVerifications(reportsScreen.verify_Dar_Parte_ScreenIsShown(), node2, "Showing the correct screen after login");
        Assert.assertTrue(reportsScreen.verify_Dar_Parte_ScreenIsShown(), "La ventana de DAR PARTE NO es mostrada, tras iniciar sesion desde DAR PARTE");

    }
}
