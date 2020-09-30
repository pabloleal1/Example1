package mutuamad.test;

import com.atsistemas.appium.CreateExtetReport;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import mutuamad.Utilities;
import mutuamad.process.CP0;
import mutuamad.process.CP1;
import mutuamad.screen.MyCardScreen;
import mutuamad.screen.WelcomeScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_08_02 extends CreateExtetReport {

    @Test
    public void Europuntos() throws Exception{

        //Test user
        String User_Standars= "AutoInsurance";

        //Initialize variables
        CP0 cp0 = new CP0(driverManager);
        CP1 cp1 = new CP1 (driverManager);
        WelcomeScreen welcomeScreen = new WelcomeScreen(driverManager);
        MyCardScreen myCardScreen = new MyCardScreen(driverManager);

        //Initialize report
        test1 = extent.createTest(this.getClass().getSimpleName(), "Acceso a europuntos desde las tarjetas de la home");
        test1.log(Status.INFO, "Starting test");

        //Cancel notifications and access to Login
        cp0.execute(test1);

        //Login
        cp1.execute(User_Standars, test1);

        //Create Node for Reports
        ExtentTest node2 = test1.createNode("Repsol - Europuntos");

        //TEST START .- User acces to the card screen
        welcomeScreen.clickButtonMyCards();
        Utilities.sleep(5000);
        CreateExtetReport.stepsVerifications(myCardScreen.isGRCodeImageVisible(), node2, "Showing the europuntos");
        Assert.assertTrue(myCardScreen.isGRCodeImageVisible(), "Showing the europuntos");
        Utilities.sleep(2000);
        myCardScreen.clickqrCodeImage();
        Utilities.sleep(2000);
        myCardScreen.verifyGRCodeImageVisible();
        //User close the card screen
        myCardScreen.clickButtonClose();

    }
}
