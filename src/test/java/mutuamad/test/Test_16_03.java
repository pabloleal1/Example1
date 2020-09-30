package mutuamad.test;

import com.atsistemas.appium.CreateExtetReport;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import mutuamad.Utilities;
import mutuamad.process.CP0;
import mutuamad.process.CP1;
import mutuamad.screen.WelcomeScreen;
import org.testng.annotations.Test;


public class Test_16_03 extends CreateExtetReport {

    @Test
    public void Politicas_De_Privacidad() throws Exception {

        //Test user
        String User_Standars= "AutoInsurance";

        //Initialize variables
        CP0 cp0 = new CP0(driverManager);
        CP1 cp1 = new CP1 (driverManager);
        WelcomeScreen welcomeScreen = new WelcomeScreen(driverManager);

        //Initialize report
        test1 = extent.createTest(this.getClass().getSimpleName(), "Ajustes, politica de privacidad");
        test1.log(Status.INFO, "Starting test");

        //Cancel notifications and access to Login
        cp0.execute(test1);

        //Login
        cp1.execute(User_Standars, test1);

        //Create Node for Reports
        ExtentTest node2 = test1.createNode("Steps - Politicas Privacidad");

        //TEST START .- Privacity Politics
        welcomeScreen.clickButtonMenu();
        Utilities.sleep(5000);
        welcomeScreen.clickOptionSettings();
        Utilities.sleep(5000);
        welcomeScreen.clickOptionPrivacityPolitics();

        node2.log(Status.INFO, "Steps completely successfully");
    }
}

