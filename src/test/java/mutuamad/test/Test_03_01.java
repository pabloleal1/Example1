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


public class Test_03_01 extends CreateExtetReport {

    @Test
    public void Dar_Parte_Coche_Golpe_Con_Un_Vehiculo() throws Exception {

        //Test user
        String User_Standars= "AutoInsurance";

        //Initialize variables
        CP0 cp0 = new CP0(driverManager);
        CP1 cp1 = new CP1 (driverManager);
        WelcomeScreen welcomeScreen = new WelcomeScreen(driverManager);
        ReportsScreen reportsScreen = new ReportsScreen(driverManager);
        ImplicityScreen implicityScreen = new ImplicityScreen(driverManager);

        //Initialize report
        test1 = extent.createTest(this.getClass().getSimpleName(), "Dar parte, coche, tiene un golpe roce o impacto, con un vehiculo");
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
                CreateExtetReport.stepsVerifications(x-1 == verifyNumberOfPolicy, node2, "NO report available search");
                Assert.assertNotEquals(verifyNumberOfPolicy, x - 1, "NO report available search");

                //Reload the policies
                reportsScreen.closeReportScreen();
                Utilities.sleep(2000);
                welcomeScreen.clickButtonReports();
            }
        }
        node2.log(Status.PASS,"Report available");

        Utilities.sleep(2000);
        ExtentTest node3 = test1.createNode("Steps - Create Report");
        CreateExtetReport.stepsVerifications(reportsScreen.verifyVehicleHitOptionIsShown(), node3, "Choosing the correct claim from a range of options");
        Assert.assertTrue(reportsScreen.verifyVehicleHitOptionIsShown(), "Este usuario no tiene permisos para dar este tipo de partes");
        reportsScreen.clickVehicleHit();
        Utilities.sleep(2000);
        reportsScreen.clickwithAVehicle();

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
        reportsScreen.clickContinueButtonFromImplicityScreen();

        //Details of involved
        implicityScreen.clickGuiltyDropDownMenu();
        implicityScreen.clickYesFriendlyReportDropDownMenu();

        implicityScreen.clickAddFrontImage();
        reportsScreen.clickCarReportOptionsAddImages();
        reportsScreen.clickAllowDeviceAccessImagesPopup();

        Utilities.sleep(5000);
        reportsScreen.clickSelectFirstImage();
        reportsScreen.clickAcceptAddImages();

        implicityScreen.clickAddPostImage();
        reportsScreen.clickCarReportOptionsAddImages();
        reportsScreen.clickAllowDeviceAccessImagesPopup();
        reportsScreen.clickSelectSecondImage();
        reportsScreen.clickAcceptAddImages();
        implicityScreen.clickbuttonContinue();

        //Details of the opposite
        Utilities.sleep(2000);
        implicityScreen.selectYesVehiclePlateOptionDropDownMenu();
        implicityScreen.insertVehiclePlateText("1234asd");
        implicityScreen.selectYesInsuranceOptionDropDownMenu();
        Utilities.sleep(2000);
        implicityScreen.selectMutuaInsuranceDropDownMenu();
        implicityScreen.clickbuttonContinue();

        //Others were involved
        implicityScreen.clickbuttonContinue();
        node3.log(Status.PASS, "Steps were completly suyccessfully");


        //Click on the what happened section
        node3.log(Status.INFO, "Click on what happened section");
        Utilities.sleep(5000);
        reportsScreen.clickOnWhatHappenedSection();
        Utilities.sleep(2000);
        reportsScreen.clickCarReportDamageFrontPoint();
        Utilities.sleep(2000);
        reportsScreen.clickButtonNext();
        Utilities.sleep(2000);
        reportsScreen.clickCarReportDamageRightPoint();
        Utilities.sleep(2000);
        reportsScreen.clickButtonContinue();
        Utilities.sleep(2000);
        reportsScreen.sendOtherDamageText();
        //Add images
        reportsScreen.clickCarReportAddImages();
        reportsScreen.clickCarReportOptionsAddImages();
        reportsScreen.clickAllowDeviceAccessImagesPopup();
        reportsScreen.clickSelectFirstImage();
        reportsScreen.clickAcceptAddImages();
        Utilities.sleep(2000);
        CreateExtetReport.stepsVerifications(reportsScreen.verifyImageIsLoad(), node3, "La imagen no se ha cargado correctamente");
        Assert.assertTrue(reportsScreen.verifyImageIsLoad(), "La imagen no se ha cargado correctamente");

        reportsScreen.clickDeleteFirstImage();
        reportsScreen.clickAcceptDeleteImages();
        CreateExtetReport.stepsVerifications(!reportsScreen.verifyImageIsLoad(), node3, "La imagen no se ha eliminado correctamente");
        Assert.assertFalse(reportsScreen.verifyImageIsLoad(), "La imagen no se ha eliminado correctamente");

        reportsScreen.clickCarReportAddImages();
        reportsScreen.clickCarReportOptionsAddImages();
        reportsScreen.clickAllowDeviceAccessImagesPopup();
        reportsScreen.clickSelectFirstImage();
        reportsScreen.clickAcceptAddImages();
        reportsScreen.clickCarReportAddImages();
        reportsScreen.clickCarReportOptionsAddImages();
        reportsScreen.clickSelectSecondImage();
        reportsScreen.clickAcceptAddImages();

        Utilities.sleep(2000);
        CreateExtetReport.stepsVerifications(reportsScreen.verifyImageIsLoad(), node3, "Las imagenes no se han cargado correctamente");
        Assert.assertTrue(reportsScreen.verifyImageIsLoad(), "Las imagenes no se han cargado correctamente");

        reportsScreen.clickDeleteAllImages();
        reportsScreen.clickAcceptDeleteImages();
        CreateExtetReport.stepsVerifications(!reportsScreen.verifyImageIsLoad(), node3, "Las imagenes no se han eliminado correctamente");
        Assert.assertFalse(reportsScreen.verifyImageIsLoad(), "Las imagenes no se han eliminado correctamente");

        reportsScreen.clickCarReportAddImages();
        reportsScreen.clickCarReportOptionsAddImages();
        reportsScreen.clickAllowDeviceAccessImagesPopup();
        reportsScreen.clickSelectFirstImage();
        reportsScreen.clickAcceptAddImages();

        reportsScreen.clickCarReportAddImages();
        reportsScreen.clickCarReportOptionsAddImages();
        reportsScreen.clickSelectSecondImage();
        reportsScreen.clickAcceptAddImages();

        reportsScreen.clickCarReportAddImages();
        reportsScreen.clickCarReportOptionsAddImages();
        reportsScreen.clickSelectThirdImage();
        reportsScreen.clickAcceptAddImages();

        Utilities.sleep(2000);
        CreateExtetReport.stepsVerifications(reportsScreen.verifyImageIsLoad(), node3, "Las imagenes no se han cargado correctamente");
        Assert.assertTrue(reportsScreen.verifyImageIsLoad(), "Las imagenes no se han cargado correctamente");
        Utilities.sleep(2000);
        reportsScreen.clickButtonContinue();

        node3.log(Status.INFO, "Click on What Happened To It section");
        reportsScreen.clickCarReportWhatHappenedToIt();
        Utilities.sleep(2000);
        reportsScreen.clickCarReportDamageFrontPoint();
        Utilities.sleep(2000);
        reportsScreen.clickButtonNext();
        Utilities.sleep(2000);
        reportsScreen.clickCarReportDamageRightPoint();
        Utilities.sleep(2000);
        reportsScreen.clickButtonContinue();
        //Images
        Utilities.sleep(2000);
        reportsScreen.clickButtonContinue();
        node3.log(Status.PASS, "Steps were completly suyccessfully");


        node3.log(Status.INFO, "Click on how it happened section");
        Utilities.sleep(3000);
        reportsScreen.clickCarReportHowHappened();
        Utilities.sleep(8000);
        reportsScreen.clickAllowDeviceMicrophonePopup();
        reportsScreen.sendHowHappenedText();
        Utilities.sleep(2000);
        reportsScreen.clickButtonContinue();
        node3.log(Status.PASS, "Steps were completly suyccessfully");

/*
        node3.log(Status.INFO, "Click on the Sent Report button");
        Utilities.sleep(2000);
        reportsScreen.clickButtonSendReport();
        Utilities.sleep(8000);
        CreateExtetReport.stepsVerifications(reportsScreen.verifyOKReportReceived(), node3, "report sent");
        Assert.assertTrue(reportsScreen.verifyOKReportReceived(), "El parte no se ha enviado correctamente");
        reportsScreen.closeReportScreen();
        Utilities.sleep(8000);
        reportsScreen.clickButtonRatingNoAskMore();
*/

    }
}

