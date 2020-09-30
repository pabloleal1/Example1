package mutuamad.test;

import com.atsistemas.appium.CreateExtetReport;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import mutuamad.Utilities;
import mutuamad.process.CP0;
import mutuamad.process.CP1;
import mutuamad.screen.ImplicityScreen;
import mutuamad.screen.ReportsScreen;
import mutuamad.screen.WelcomeScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_03_06 extends CreateExtetReport {

    @Test
    public void Dar_Parte_Coche_Robo_Coche_Aparicion() throws Exception {

        //Test user
        String User_Standars= "AutoInsurance";

        //Initialize variables
        CP0 cp0 = new CP0(driverManager);
        CP1 cp1 = new CP1 (driverManager);
        WelcomeScreen welcomeScreen = new WelcomeScreen(driverManager);
        ReportsScreen reportsScreen = new ReportsScreen(driverManager);
        ImplicityScreen implicityScreen = new ImplicityScreen(driverManager);

        //Initialize report
        test1 = extent.createTest(this.getClass().getSimpleName(), "Dar parte, coche, me han robado, me han robado mi coche, SI ha aparecido");
        test1.log(Status.INFO, "Starting test");

        //Cancel notifications and access to Login
        cp0.execute(test1);

        //Login
        cp1.execute(User_Standars, test1);

        // Open new Car report Stolen Showed Up
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
        CreateExtetReport.stepsVerifications(reportsScreen.verifyVehicleStoleOptionIsShown(), node3, "Choosing the correct claim from a range of options");
        Assert.assertTrue(reportsScreen.verifyVehicleStoleOptionIsShown(), "Este usuario no tiene permisos para dar parte de robo");
        reportsScreen.clickVehicleStolen();
        Utilities.sleep(2000);
        reportsScreen.clickMyVehicleWasStolen();
        Utilities.sleep(2000);
        reportsScreen.clickMyVehicleShowedUp();
        Utilities.sleep(2000);
        CreateExtetReport.stepsVerifications(reportsScreen.verify_Dar_Parte_ScreenIsShown(), node3, "showing the claim for stolen car screen");
        Assert.assertTrue(reportsScreen.verify_Dar_Parte_ScreenIsShown(),"No se accede correctamente al alta de parte Robo");

        node3.log(Status.INFO, "Click on when and where section");
        Utilities.sleep(2000);
        reportsScreen.clickReportWhenAndWhere();
        Utilities.sleep(2000);
        reportsScreen.clickButtonContinue();
        Utilities.sleep(2000);
        reportsScreen.clickAllowDeviceLocationPopup();
        Utilities.sleep(2000);
        reportsScreen.clickLocationSendWhereText();
        Utilities.sleep(2000);
        reportsScreen.sendLocationSendAssistanceAddress();
        Utilities.sleep(2000);
        reportsScreen.selectLocationSendAssistanceAutoSuggest();
        Utilities.sleep(2000);
        reportsScreen.clickButtonContinue();
        Utilities.sleep(2000);
        CreateExtetReport.stepsVerifications(implicityScreen.verify_Yes_Option_Is_Shown_For_Vehicle_Closed().equals("Sí"), node3, "La opcion para vehiculo cerrado");
        Assert.assertTrue(reportsScreen.verify_Dar_Parte_ScreenIsShown(),"Vehicle option");
        implicityScreen.clickbuttonContinueRobo();

        //Click on the what happened section
        node3.log(Status.INFO, "Click on How it happened section");
        Utilities.sleep(5000);
        reportsScreen.clickOnWhatHappenedSection();
        reportsScreen.clickAllowDeviceMicrophonePopup();
        reportsScreen.sendHowHappenedText();
        Utilities.sleep(2000);
        reportsScreen.clickButtonContinue();
        node3.log(Status.PASS, "Steps were completly suyccessfully");


        node3.log(Status.INFO, "Click on How has it appeared");
        reportsScreen.clickCarReportWhatHappenedToIt();
        Utilities.sleep(2000);
        reportsScreen.clickButtonContinue();
        Utilities.sleep(2000);
        reportsScreen.clickAllowDeviceLocationPopup();
        Utilities.sleep(2000);
        reportsScreen.clickLocationSendWhereText();
        Utilities.sleep(2000);
        reportsScreen.sendLocationSendAssistanceAddress();
        Utilities.sleep(2000);
        reportsScreen.selectLocationSendAssistanceAutoSuggest();
        Utilities.sleep(2000);
        reportsScreen.clickButtonContinue();

        CreateExtetReport.stepsVerifications(reportsScreen.verifySendReportIsShown(), node3, "Mostrar Boton Enviar Parte");
        Assert.assertTrue(reportsScreen.verifySendReportIsShown(),"Mostrar Boton Enviar PArte");

    }

}

