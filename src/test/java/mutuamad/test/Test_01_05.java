package mutuamad.test;

import com.atsistemas.appium.CreateExtetReport;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import mutuamad.Utilities;
import mutuamad.process.CP1;
import mutuamad.process.CPQuitTutorial;
import mutuamad.screen.ConfigurationScreen;
import mutuamad.screen.WelcomeScreen;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Test_01_05 extends CreateExtetReport {

    @Test
    public void Login_Menu_Ajustes() throws Exception {

        //Test user
        String User_Standars= "AutoInsurance";

        //Initialize variables
        CP1 cp1 = new CP1 (driverManager);
        CPQuitTutorial cpQuitTutorial = new CPQuitTutorial(driverManager);
        WelcomeScreen welcomeScreen = new WelcomeScreen(driverManager);
        ConfigurationScreen configurationScreen = new ConfigurationScreen(driverManager);

        //Initialize report
        test1 = extent.createTest(this.getClass().getSimpleName(), "Login desde Ajustes tras pulsar en el menu");
        test1.log(Status.INFO, "Starting test");

        //Cancel notifications and access to Login
        cpQuitTutorial.execute(test1);

        //User click on the card from home screen
        Utilities.sleep(5000);

        //Click on the menu button from the home page
        welcomeScreen.clickButtonMenu();

        // Going to the options setting
        welcomeScreen.clickOptionSettings();

        //Login
        cp1.execute(User_Standars, test1);

        //Verify card screen is shown after login
        ExtentTest node2 = test1.createNode("Showing correct Screen");
        CreateExtetReport.stepsVerifications(configurationScreen.verifyButtonContactDataFromSettingScreenIsShown(), node2, "Verify Dar parte screen is shown");
        Assert.assertTrue(configurationScreen.verifyButtonContactDataFromSettingScreenIsShown(),"La ventana de AJUSTES NO es mostrada, tras iniciar sesion desde AJUSTES");

    }
}
