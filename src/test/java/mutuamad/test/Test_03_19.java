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


public class Test_03_19  extends CreateExtetReport {

    @Test
    public void Dar_Parte_Moto_Robo_Coche_Elementos() throws Exception {

        //Test user
        String User_Poliza_Moto= "MotoInsurance";

        //Initialize variables
        CP0 cp0 = new CP0(driverManager);
        CP1 cp1 = new CP1 (driverManager);
        WelcomeScreen welcomeScreen = new WelcomeScreen(driverManager);
        ReportsScreen reportsScreen = new ReportsScreen(driverManager);

        //Initialize report
        test1 = extent.createTest(this.getClass().getSimpleName(), "Dar parte, moto, me han robado, me han robado elementos de mi coche");
        test1.log(Status.INFO, "Starting test");

        //Cancel notifications and access to Login
        cp0.execute(test1);

        //Login using a correct user
        cp1.execute(User_Poliza_Moto, test1);

        // Open new MotorBike report Stole Elements
        welcomeScreen.clickButtonReports();
        Utilities.sleep(5000);

        //Verify that you have policies to register parts
        int verifyNumberOfPolicy = reportsScreen.allInsuranceXSize("MOTO");

        //Create Node for Reports
        ExtentTest node2 = test1.createNode("Available Reports");

        if(reportsScreen.verifyTeHaOcurridoScreenISShown() && verifyNumberOfPolicy<=0)
            node2.log(Status.FATAL,"NO report available");
        Assert.assertFalse(reportsScreen.verifyTeHaOcurridoScreenISShown() && verifyNumberOfPolicy<=0,"Este usuario no tiene permisos para dar parte de robo");

        if(verifyNumberOfPolicy>0) {
            for (int x = 1; x <= verifyNumberOfPolicy; x++) {
                //Select first policy
                reportsScreen.clickPolicyX("MOTO", x);
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
        CreateExtetReport.stepsVerifications(reportsScreen.verifyVehicleStoleOptionIsShown(), node3, "Choosing the correct claim from a range of options");
        Assert.assertTrue(reportsScreen.verifyVehicleStoleOptionIsShown(),"Este usuario no tiene permisos para dar parte de robo");
        reportsScreen.clickVehicleStolen();
        Utilities.sleep(2000);
        reportsScreen.clickelementsFromMyVehicleWereStolen();
        Utilities.sleep(2000);

        // Verify the text of not cover this accident
        CreateExtetReport.stepsVerifications(reportsScreen.verifyNotCoverThisAccident(), node3, "Mostrar el texto de tipo de parte no permitido");
        Assert.assertTrue(reportsScreen.verifyNotCoverThisAccident(),"No se muestra el texto de tipo de parte no permitido");

    }
}

