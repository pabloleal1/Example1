package mutuamad.test;

import com.atsistemas.appium.CreateExtetReport;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import mutuamad.Utilities;
import mutuamad.process.CPQuitTutorial;
import mutuamad.process.CP1;
import mutuamad.screen.WelcomeScreen;
import org.testng.Assert;
import org.testng.annotations.*;


public class Test_01_02  extends CreateExtetReport {

    @Test
    public void Login_tarjetas() throws Exception {

        //Test user
        String User_Standars= "Tarjetas";

        //Initialize variables
        CPQuitTutorial cpQuitTutorial = new CPQuitTutorial(driverManager);
        CP1 cp1 = new CP1 (driverManager);
        WelcomeScreen welcomeScreen = new WelcomeScreen(driverManager);

        //Initialize report
        test1 = extent.createTest( this.getClass().getSimpleName(), "Login desde tarjetas");
        test1.log(Status.INFO, "Starting test");

        //Cancel notifications and access to Login
        cpQuitTutorial.execute(test1);

        //User click on the card from home screen
        Utilities.sleep(5000);
        welcomeScreen.clickButtonMyCards();
        Utilities.sleep(5000);
//        welcomeScreen.clickButtonMyCards();
        //Login
        cp1.execute(User_Standars, test1);

        //Verify card screen is shown after login
        Utilities.sleep(5000);
        ExtentTest node2 = test1.createNode("Showing the correct screen after login");
        CreateExtetReport.stepsVerifications(welcomeScreen.verifyQRCodeIsShown(), node2, "Showing the correct screen after login");
        Assert.assertTrue(welcomeScreen.verifyQRCodeIsShown(),"La ventana de la tarjeta NO es mostrada, tras iniciar sesion desde la tarjeta" );

    }
}
