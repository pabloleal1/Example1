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
import org.openqa.selenium.Platform;

public class Test_05_09 extends CreateExtetReport{

    @Test
    public void Editar_Datos_Tomador_Contacto_CodigoPostal() throws Exception {

        //Test user
        String User_Standars= "AutoInsurance";

        //Initialize variables
        CP0 cp0 = new CP0(driverManager);
        CP1 cp1 = new CP1 (driverManager);
        WelcomeScreen welcomeScreen = new WelcomeScreen(driverManager);
        InsuranceScreen insuranceScreen = new InsuranceScreen(driverManager);

        //Initialize report
        test1 = extent.createTest(this.getClass().getSimpleName(), "Editar datos del Tomador - Código postal");
        test1.log(Status.INFO, "Starting test");

        //Cancel notifications and access to Login
        cp0.execute(test1);

        //Login
        cp1.execute(User_Standars, test1);

        //Create Node for Reports
        ExtentTest node2 = test1.createNode("Modificar Datos");


        //TEST START .- Insurances. Insurance People. Insurance Owner.
        // Edit Dates - Postal Code
        welcomeScreen.clickTextWelcomeUser();
        insuranceScreen.clickButtonViewInsuranceDetails();
        insuranceScreen.clickButtonOptionDetailsPeople();
        insuranceScreen.clickButtonPeopleInsuranceOwner();
        Utilities.sleep(2000);
        insuranceScreen.scrollDown();
        insuranceScreen.clickButtonModifyInfo();
        String reset = insuranceScreen.getPersonCP();
        insuranceScreen.setPersonCP("11630");
        Utilities.sleep(2000);
        insuranceScreen.scrollDown();
        insuranceScreen.clicButtonSaveData();
        Utilities.sleep(10000);
        //Verify datas were updated
        CreateExtetReport.stepsVerifications(insuranceScreen.getTextSaveDates().contains("correctamente"), node2, "Editar datos del Tomador - Código postal");
        Assert.assertTrue(insuranceScreen.getTextSaveDates().contains("correctamente"),"Error al editar los datos del tomador");
        insuranceScreen.clickButtonAccept();
        Utilities.sleep(2000);
        insuranceScreen.tapEndScreen();

        if(driverManager.getDriver().getCapabilities().getPlatform().is(Platform.LINUX))
        {

            insuranceScreen.clickButtonPeopleInsuranceOwner();
        }
        //Restart
        Utilities.sleep(2000);
        insuranceScreen.scrollDown();
        insuranceScreen.clickButtonModifyInfo();
        insuranceScreen.setPersonCP(reset);
        Utilities.sleep(2000);
        insuranceScreen.scrollDown();
        insuranceScreen.clicButtonSaveData();
        Utilities.sleep(5000);
        //Verify datas were restored
        CreateExtetReport.stepsVerifications(insuranceScreen.getTextSaveDates().contains("correctamente"), node2, "Restaurar .- datos del Tomador - Código postal");
        Assert.assertTrue(insuranceScreen.getTextSaveDates().contains("correctamente"),"Error al restaurar los datos del tomador");
        insuranceScreen.clickButtonAccept();

    }
}

