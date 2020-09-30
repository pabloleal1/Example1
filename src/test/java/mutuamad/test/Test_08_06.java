package mutuamad.test;

import com.atsistemas.appium.CreateExtetReport;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import mutuamad.Utilities;
import mutuamad.process.CP0;
import mutuamad.process.CP1;
import mutuamad.screen.AdvantageScreen;
import mutuamad.screen.InsuranceScreen;
import mutuamad.screen.PrincipalScreen;
import mutuamad.screen.RegalosScreen;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Test_08_06 extends CreateExtetReport {

    @Test
    public void Ventaja_Home_Regalos() throws Exception {

        //Test user
        String User_Standars= "Regalos";

        //Initialize variables
        CP0 cp0 = new CP0(driverManager);
        CP1 cp1 = new CP1 (driverManager);
        PrincipalScreen principalScreen = new PrincipalScreen(driverManager);
        InsuranceScreen insuranceScreen = new InsuranceScreen(driverManager);
        RegalosScreen regalosScreen = new RegalosScreen(driverManager);

        //Initialize report
        test1 = extent.createTest(this.getClass().getSimpleName(), "Ventaja HOME - Regalos");
        test1.log(Status.INFO, "Starting test");

        //Cancel notifications and access to Login
        cp0.execute(test1);

        //Login
        cp1.execute(User_Standars, test1);

        //Create Node for Reports
        ExtentTest node2 = test1.createNode("Regalos - Detalles");

        //TEST START .- Click on the present home advantage discount
        CreateExtetReport.stepsVerifications(principalScreen.verify_Repsol_Advantage_Is_Shown(), node2, "Regalos Advantage is NOT shown from home screen");
        Assert.assertTrue(principalScreen.verify_Repsol_Advantage_Is_Shown(), "Regalos is NOT shown from home screen");

        principalScreen.clickRegalosAdvantage();
        Utilities.sleep(2000);
        //Verify regalos advanges is shown on the home screen
        CreateExtetReport.stepsVerifications(regalosScreen.ventaja_Tittle_Text().equals("MUTUA TE AYUDA"), node2, "Mostrar - Ventaja");
        Assert.assertTrue(regalosScreen.ventaja_Tittle_Text().equals("MUTUA TE AYUDA"), "Error - Mostrar Ventajas");

        regalosScreen.click_Btn_Ventaja();
        Utilities.sleep(2000);
       //Verify cintillo is shown
        CreateExtetReport.stepsVerifications(regalosScreen.verify_cintillo_Is_Shown(), node2, "Mostrar - Cintillo en Mis Seguros");
        Assert.assertTrue(regalosScreen.verify_cintillo_Is_Shown(), "Error - Mostrar Cintillo en Mis Seguros");
        Utilities.sleep(5000);

    }

}
