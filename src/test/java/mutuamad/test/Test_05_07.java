package mutuamad.test;

import com.atsistemas.appium.CreateExtetReport;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import mutuamad.Utilities;
import mutuamad.process.CP0;
import mutuamad.process.CP1;
import mutuamad.screen.InsuranceScreen;
import mutuamad.screen.ReportsScreen;
import mutuamad.screen.WelcomeScreen;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Test_05_07 extends CreateExtetReport {

    @Test
    public void Mis_Seguros_Gestiones_Mas_Frecuentes() throws Exception {

        //Test user
        String User_Standars= "AutoInsurance";

        //Initialize variables
        CP0 cp0 = new CP0(driverManager);
        CP1 cp1 = new CP1 (driverManager);
        WelcomeScreen welcomeScreen = new WelcomeScreen(driverManager);
        InsuranceScreen insuranceScreen = new InsuranceScreen(driverManager);
        ReportsScreen reportsScreen = new ReportsScreen(driverManager);

        //Initialize report
        test1 = extent.createTest(this.getClass().getSimpleName(), "Mis seguros coche , ver y gestionar poliza, Gestiones mas frecuentes, todas las opciones");
        test1.log(Status.INFO, "Starting test");

        //Cancel notifications and access to Login
        cp0.execute(test1);

        //Login
        cp1.execute(User_Standars, test1);

        //Create Node for Reports
        ExtentTest node2 = test1.createNode("Modificar Datos");


        //TEST START .- Insurances. Frequently actions
        welcomeScreen.clickTextWelcomeUser();
        Utilities.sleep(5000);
        insuranceScreen.clickButtonViewInsuranceDetails();
        Utilities.sleep(2000);

        // Transfer insurance policy
        insuranceScreen.clickButtonFrecuencyManages();
        Utilities.sleep(2000);
        insuranceScreen.clickOptionTransferInsurancePolicy();
        Utilities.sleep(10000);
        CreateExtetReport.stepsVerifications(reportsScreen.verifyshownSSO(), node2, "showing the the webview");
        Assert.assertTrue(reportsScreen.verifyshownSSO(), "No se muestra el contenido del Webview");

    }
}

