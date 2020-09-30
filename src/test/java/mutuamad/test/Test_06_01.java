package mutuamad.test;

import com.atsistemas.appium.CreateExtetReport;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import mutuamad.Utilities;
import mutuamad.process.CP0;
import mutuamad.process.CP1;
import mutuamad.screen.InsuranceScreen;
import mutuamad.screen.WelcomeScreen;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Test_06_01 extends CreateExtetReport {

    @Test
    public void Recibo_Coche() throws Exception {

        //Test user
        String User_Standars= "AutoInsurance";

        //Initialize variables
        CP0 cp0 = new CP0(driverManager);
        CP1 cp1 = new CP1 (driverManager);
        WelcomeScreen welcomeScreen = new WelcomeScreen(driverManager);
        InsuranceScreen insuranceScreen = new InsuranceScreen(driverManager);

        //Initialize report
        test1 = extent.createTest(this.getClass().getSimpleName(), "Ver recibos");
        test1.log(Status.INFO, "Starting test");

        //Cancel notifications and access to Login
        cp0.execute(test1);

        //Login
        cp1.execute(User_Standars, test1);

        //Create Node for Reports
        ExtentTest node2 = test1.createNode("Recibos - Detalles");

        //TEST START .- Insurances. View payments
        welcomeScreen.clickTextWelcomeUser();
        Utilities.sleep(5000);
        insuranceScreen.clickButtonViewPayments();
        Utilities.sleep(8000);

        //Verify Recibo screen is shown
        node2.log(Status.INFO, "Ventana de Tus Recibos");
        CreateExtetReport.stepsVerifications(insuranceScreen.getTitlePayment().contains("TUS RECIBOS"), node2, "Mostrar Ventana de Recibos");
        Assert.assertTrue(insuranceScreen.getTitlePayment().contains("TUS RECIBOS"),"Mostrar Ventana de Recibos");

        Utilities.sleep(2000);
        insuranceScreen.clickViewFirstPayment();
        Utilities.sleep(5000);

        //Verify first Recibo screen is shown
        node2.log(Status.INFO, "Ventana de Detalles Recibos");
        CreateExtetReport.stepsVerifications(insuranceScreen.getTitlePayment().contains("DETALLE DEL RECIBO"), node2, "Mostrar Ventana de Recibos");
        Assert.assertTrue(insuranceScreen.getTitlePayment().contains("DETALLE DEL RECIBO"),"Mostrar Ventana de Recibos");

    }
}
