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


public class Test_05_15 extends CreateExtetReport {

    @Test
    public void Editar_Contacto_DatosTomador_CamposVacios() throws Exception {

        //Test user
        String User_Standars= "AutoInsurance";

        //Initialize variables
        CP0 cp0 = new CP0(driverManager);
        CP1 cp1 = new CP1 (driverManager);
        WelcomeScreen welcomeScreen = new WelcomeScreen(driverManager);
        InsuranceScreen insuranceScreen = new InsuranceScreen(driverManager);

        //Initialize report
        test1 = extent.createTest(this.getClass().getSimpleName(), "Editar datos del Tomador - Campos vacios");
        test1.log(Status.INFO, "Starting test");


        //Cancel notifications and access to Login
        cp0.execute(test1);

        //Login
        cp1.execute(User_Standars, test1);

        //Create Node for Reports
        ExtentTest node2 = test1.createNode("Modificar Datos");

        //TEST START .- Insurances. Insurance People. Insurance Owner.
        // Edit Dates - Empty value
        welcomeScreen.clickTextWelcomeUser();

        insuranceScreen.clickButtonViewInsuranceDetails();
        insuranceScreen.clickButtonOptionDetailsPeople();
        insuranceScreen.clickButtonPeopleInsuranceOwner();

        Utilities.sleep(2000);
        insuranceScreen.scrollDown();
        insuranceScreen.clickButtonModifyInfo();

        insuranceScreen.setPersonStreet("");
        Utilities.sleep(2000);
        insuranceScreen.scrollDown();
        CreateExtetReport.stepsVerifications(!insuranceScreen.checkButtonModifyInfo(), node2, "Editar datos del Tomador - Campos vacios");
        Assert.assertTrue(!insuranceScreen.checkButtonModifyInfo(),"Error al modificar los datos del tomador");

    }

}

