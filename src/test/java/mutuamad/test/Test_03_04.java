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

public class Test_03_04 extends CreateExtetReport {

    @Test
    public void Dar_Parte_Coche_Golpe_Sin_Contrarios_Lunas() throws Exception {

        //Test user
        String User_Standars= "AutoInsurance";

        //Initialize variables
        CP0 cp0 = new CP0(driverManager);
        CP1 cp1 = new CP1 (driverManager);
        WelcomeScreen welcomeScreen = new WelcomeScreen(driverManager);
        ReportsScreen reportsScreen = new ReportsScreen(driverManager);

        //Initialize report
        test1 = extent.createTest(this.getClass().getSimpleName(), "Dar parte, coche, tiene un golpe roce o impacto, sin contrarios, Rotura de una o varias lunas");
        test1.log(Status.INFO, "Starting test");

        //Cancel notifications and access to Login
        cp0.execute(test1);

        //Login
        cp1.execute(User_Standars, test1);

        //TEST START .- Open new Car report
        welcomeScreen.clickButtonReports();

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

        Utilities.sleep(5000);
        ExtentTest node3 = test1.createNode("Steps - Create Report");
        CreateExtetReport.stepsVerifications(reportsScreen.verifyVehicleHitOptionIsShown(), node3, "Choosing the correct claim from a range of options");
        Assert.assertTrue(reportsScreen.verifyVehicleHitOptionIsShown(), "Este usuario no tiene permisos para dar este tipo de partes");
        reportsScreen.clickVehicleHit();
        Utilities.sleep(2000);
        reportsScreen.clickNoContraries();
        Utilities.sleep(2000);
        reportsScreen.clickbreakageOfPanes();
        Utilities.sleep(2000);

        if(reportsScreen.verifyTeHaOcurridoScreenISShown())
            node2.log(Status.FATAL,"NO report available");
        Assert.assertFalse(reportsScreen.verifyTeHaOcurridoScreenISShown(), "NO report available");

        node3.log(Status.INFO, "Click on when and where section");
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
        node3.log(Status.PASS, "Steps were completly suyccessfully");

        node3.log(Status.INFO, "Click on what happened section");
        reportsScreen.clickOnWhatHappenedSection();
        Utilities.sleep(2000);
        reportsScreen.clickButtonTheCarHasNoDamage();
        Utilities.sleep(2000);
        //reportsScreen.sendOtherDamageText();
        Utilities.sleep(2000);
        reportsScreen.clickButtonTheCarHasNoDamage();
        Utilities.sleep(2000);
        node3.log(Status.PASS, "Steps were completly suyccessfully");

        node3.log(Status.INFO, "Click on how it happened section");
        Utilities.sleep(3000);
        reportsScreen.clickCarReportHowHappened();
        Utilities.sleep(2000);
        reportsScreen.clickButtonOtherSituations();
        Utilities.sleep(2000);
        reportsScreen.clickAllowDeviceMicrophonePopup();
        Utilities.sleep(2000);
        reportsScreen.sendHowHappenedText();
        Utilities.sleep(2000);
        reportsScreen.clickButtonContinue();
        node3.log(Status.PASS, "Steps were completly suyccessfully");

        /*
        node3.log(Status.INFO, "Click on the Sent Report button");
        reportsScreen.clickButtonSendReport();
        Utilities.sleep(8000);
        Assert.assertTrue(reportsScreen.verifyOKReportReceived(), "El parte no se ha enviado correctamente");
        node3.log(Status.PASS, "Report was sent successfully");
        reportsScreen.closeReportScreen();
        Utilities.sleep(8000);
        reportsScreen.clickButtonRatingNoAskMore();
    */
    }
}

