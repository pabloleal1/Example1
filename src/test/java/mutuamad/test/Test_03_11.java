package mutuamad.test;

import com.atsistemas.appium.CreateExtetReport;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import mutuamad.Utilities;
import mutuamad.process.CP0;
import mutuamad.process.CP1;
import mutuamad.screen.ReportsScreen;
import mutuamad.screen.ServicesScreen;
import mutuamad.screen.WelcomeScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_03_11 extends CreateExtetReport {

    @Test
    public void Dar_Parte_Coche_Sin_Danyos() throws Exception {

        //Test user
        String User_Standars= "AutoInsurance";

        //Initialize variables
        CP0 cp0 = new CP0(driverManager);
        CP1 cp1 = new CP1 (driverManager);
        WelcomeScreen welcomeScreen = new WelcomeScreen(driverManager);
        ReportsScreen reportsScreen = new ReportsScreen(driverManager);
        ServicesScreen servicesScreen = new ServicesScreen(driverManager);

        //Initialize report
        test1 = extent.createTest(this.getClass().getSimpleName(), "Dar parte, coche, mi coche no ha sifrido daños");
        test1.log(Status.INFO, "Starting test");

        //Cancel notifications and access to Login
        cp0.execute(test1);

        //Login
        cp1.execute(User_Standars, test1);

        // Open new Car report no damage
        welcomeScreen.clickButtonReports();
        Utilities.sleep(2000);

        //Verify that you have policies to register parts
        int verifyNumberOfPolicy = reportsScreen.allInsuranceXSize("COCHE");

        //Create Node for Reports
        ExtentTest node2 = test1.createNode("Available Reports");

        if(reportsScreen.verifyTeHaOcurridoScreenISShown() && verifyNumberOfPolicy<=0)
            node2.log(Status.FATAL,"NO report available");
        Assert.assertFalse(reportsScreen.verifyTeHaOcurridoScreenISShown() && verifyNumberOfPolicy<=0, "NO report available");

        if(verifyNumberOfPolicy>0) {
            for (int x = 1; x <= verifyNumberOfPolicy; x++) {
                //Select first policy
                reportsScreen.clickPolicyX("COCHE", x);
                if (!reportsScreen.verifyTeHaOcurridoScreenISShown()) {
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
        CreateExtetReport.stepsVerifications(reportsScreen.verifyVehicleWasNotDamageOptionIsShown(), node3, "Choosing the correct claim from a range of options");
        Assert.assertTrue(reportsScreen.verifyVehicleWasNotDamageOptionIsShown(),"Este usuario no tiene permisos para dar parte sobre Mi coche NO ha sufrido daños");
        reportsScreen.clickVehicleWasNotDamage();
        Utilities.sleep(2000);

        //Verify Call center screen Shown
        if(reportsScreen.verifyImprovingExperienceScreenISShown())
        {
            CreateExtetReport.stepsVerifications(reportsScreen.verifyImprovingExperienceScreenISShown(), node3, "showing the improve your experience screen");
            reportsScreen.clickcontinueButtonfromImprovingExperienceScreen();

        }

        Utilities.sleep(9000);
        CreateExtetReport.stepsVerifications(reportsScreen.verifyTextWebviewGivePart(), node3, "showing the the webview");
        Assert.assertTrue(reportsScreen.verifyTextWebviewGivePart(), "No se muestra el contenido del Webview");
    }

}

