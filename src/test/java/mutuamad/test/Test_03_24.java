package mutuamad.test;

import com.atsistemas.appium.CreateExtetReport;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import mutuamad.Utilities;
import mutuamad.process.CP0;
import mutuamad.process.CP1;
import mutuamad.screen.ReportsScreen;
import mutuamad.screen.WelcomeScreen;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Test_03_24 extends CreateExtetReport {

    @Test
    public void Dar_Parte_Hogar() throws Exception {

        //Test user
        String User_Poliza_Hogar= "HomeInsurance";

        //Initialize variables
        CP0 cp0 = new CP0(driverManager);
        CP1 cp1 = new CP1 (driverManager);
        WelcomeScreen welcomeScreen = new WelcomeScreen(driverManager);
        ReportsScreen reportsScreen = new ReportsScreen(driverManager);

        //Initialize report
        test1 = extent.createTest(this.getClass().getSimpleName(), "Dar parte de Hogar");
        test1.log(Status.INFO, "Starting test");

        //Cancel notifications and access to Login
        cp0.execute(test1);

        //Login using a correct user
        cp1.execute(User_Poliza_Hogar, test1);

        //Open new Home report
        welcomeScreen.clickButtonReports();

        Utilities.sleep(2000);

        //Verify that you have policies to register parts
        int verifyNumberOfPolicy = reportsScreen.allInsuranceXSize("HOGAR");
        ExtentTest node2 = test1.createNode("Available Reports");

        if(verifyNumberOfPolicy>0) {
            for (int x = 1; x <= verifyNumberOfPolicy; x++) {
                //Select first policy
                reportsScreen.clickPolicyX("HOGAR", x);
                if (reportsScreen.verifyTeHaOcurridoScreenISShown()) {
                    break;
                }

                //Verify that with any of the policies you can give parts
                CreateExtetReport.stepsVerifications(x-1 == verifyNumberOfPolicy, node2, "NO report available");
                Assert.assertNotEquals(verifyNumberOfPolicy, x - 1, "NO report available");

                //Reload the policies
                reportsScreen.closeReportScreen();
                Utilities.sleep(2000);
                welcomeScreen.clickButtonReports();
            }
        }

        node2.log(Status.PASS,"Report available");

        Utilities.sleep(2000);
        ExtentTest node3 = test1.createNode("Steps - Create Report");
        //Verify that the view of home policy is in construction
        CreateExtetReport.stepsVerifications(reportsScreen.verifyHighPartHomeScreen(), node3, "showing the view of home policy is in construction screen");
        Assert.assertTrue(reportsScreen.verifyHighPartHomeScreen(),"No se muestra la vista de aviso de alta de parte Hogar" );

    }
}

