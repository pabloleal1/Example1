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

public class Test_05_04 extends CreateExtetReport {

    @Test
    public void Modificar_Propietario_Vehiculo() throws Exception {

        //Test user
        String User_Standars= "AutoInsurance";

        //Initialize variables
        CP0 cp0 = new CP0(driverManager);
        CP1 cp1 = new CP1 (driverManager);
        WelcomeScreen welcomeScreen = new WelcomeScreen(driverManager);
        InsuranceScreen insuranceScreen = new InsuranceScreen(driverManager);

        //Initialize report
        test1 = extent.createTest(this.getClass().getSimpleName(), "Mis seguros coche , ver y gestionar poliza, personas, modifica propiertario del vehiculo");
        test1.log(Status.INFO, "Starting test");

        //Cancel notifications and access to Login
        cp0.execute(test1);

        //Login
        cp1.execute(User_Standars, test1);

        //Create Node for Reports
        ExtentTest node2 = test1.createNode("Modificar Datos");

        //TEST START .- Insurances. Insurance People. Car Owner.
        welcomeScreen.clickTextWelcomeUser();
        Utilities.sleep(5000);
        insuranceScreen.clickButtonViewInsuranceDetails();
        Utilities.sleep(2000);
        insuranceScreen.clickButtonOptionDetailsPeople();
        Utilities.sleep(2000);
        insuranceScreen.clickbuttonPeopleInsuranceCarOwner();
        Utilities.sleep(2000);
        insuranceScreen.scrollDown();
        Utilities.sleep(2000);
        insuranceScreen.clickButtonModifyCarOwner();
        CreateExtetReport.stepsVerifications(insuranceScreen.getCallCenterText().contains("Para poder realizar"), node2, "modificar propiertario del vehiculo");
        Assert.assertTrue(insuranceScreen.getCallCenterText().contains("Para poder realizar"));

    }
}

