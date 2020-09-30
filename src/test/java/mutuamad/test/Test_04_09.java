package mutuamad.test;

import com.atsistemas.appium.CreateExtetReport;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import mutuamad.Utilities;
import mutuamad.process.CP0;
import mutuamad.process.CP1;
import mutuamad.screen.AssistanceScreen;
import mutuamad.screen.WelcomeScreen;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Test_04_09 extends CreateExtetReport {

    @Test
    public void Asistencia_Hogar() throws Exception {

        //Test user
        String User_Standars= "HomeInsurance";

        //Initialize variables
        CP0 cp0 = new CP0(driverManager);
        CP1 cp1 = new CP1 (driverManager);
        WelcomeScreen welcomeScreen = new WelcomeScreen(driverManager);
        AssistanceScreen assistanceScreen = new AssistanceScreen(driverManager);

        //Initialize report
        test1 = extent.createTest(this.getClass().getSimpleName(), "Asistencia para hogar");
        test1.log(Status.INFO, "Starting test");

        //Cancel notifications and access to Login
        cp0.execute(test1);

        //Login
        cp1.execute(User_Standars, test1);

        //TEST START .- Assistance Home
        welcomeScreen.clickButtonAssistance();
        Utilities.sleep(5000);

        //Create Node for Reports
        ExtentTest node2 = test1.createNode("Home Reports");

        if(assistanceScreen.verifyHomeInsurance())
        {
            assistanceScreen.clickFirstHomeInsurance();
        }
        Utilities.sleep(4000);
        CreateExtetReport.stepsVerifications(assistanceScreen.getAsistanceHomeText().contains("Estamos trabajando"), node2, "messages shown for the current insurance selected");
        Assert.assertTrue(assistanceScreen.getAsistanceHomeText().contains("Estamos trabajando"), "The message shown was not correct for the insurance" );

    }
}

