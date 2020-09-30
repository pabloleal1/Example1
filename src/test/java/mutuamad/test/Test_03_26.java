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


public class Test_03_26 extends CreateExtetReport {

    @Test
    public void Dar_Parte_Verificar_Datos_Guardado() throws Exception {

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
        Utilities.sleep(5000);
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
        Utilities.sleep(2000);
        implicityScreen.clickAddFrontImage();
        reportsScreen.clickCarReportOptionsAddImages();
        reportsScreen.clickAllowDeviceAccessImagesPopup();
        Utilities.sleep(3000);
        reportsScreen.clickSelectFirstImage();
        //reportsScreen.clickAcceptAddImages();
        implicityScreen.clickbuttonContinue();

        //Details of the opposite
        Utilities.sleep(2000);
        implicityScreen.selectYesVehiclePlateOptionDropDownMenu();
        implicityScreen.insertVehiclePlateText("1234asd");
        implicityScreen.selectYesInsuranceOptionDropDownMenu();
        Utilities.sleep(4000);
        implicityScreen.selectMutuaInsuranceDropDownMenu();
        implicityScreen.clickbuttonContinue();

        //Others were involved
        implicityScreen.clickbuttonContinue();
        node3.log(Status.PASS, "Steps were completly suyccessfully");

        //Save report
        reportsScreen.clickButtonSaveReport();
        reportsScreen.clickButtonSavedReportAceptar();

        //Return give part Saved Previously
        welcomeScreen.clickButtonReports();
        //VERIFY that the saved part is displayed
        CreateExtetReport.stepsVerifications(reportsScreen.verifyListReportsSavedIsShown(), node3, "save report");
        Assert.assertTrue(reportsScreen.verifyListReportsSavedIsShown(), "El parte no se ha guardado correctamente");

        reportsScreen.clickButtonReportSavedPreviously();

        //VERIFY that the part has been updated
        CreateExtetReport.stepsVerifications(reportsScreen.verifyReportOptionInformedIsShown(), node3, "update report");
        Assert.assertTrue(reportsScreen.verifyReportOptionInformedIsShown(), "Los datos del parte no se han actualizado");

        node3.log(Status.INFO, "Click on when and where section");
        Utilities.sleep(2000);
        reportsScreen.clickReportWhenAndWhere();
        reportsScreen.clickButtonContinue();
        reportsScreen.insertLocationWhereTextOnlyAndroidEmulator();
        Utilities.sleep(2000);
        reportsScreen.clickContinueButtonFromImplicityScreen();

        //Details of involved
        implicityScreen.clickAddPostImage();
        reportsScreen.clickCarReportOptionsAddImages();
        reportsScreen.clickAllowDeviceAccessImagesPopup();
        reportsScreen.clickSelectSecondImage();
        //reportsScreen.clickAcceptAddImages();

        implicityScreen.clickbuttonContinue();

        //Details of the opposite
        implicityScreen.clickbuttonContinue();

        //Others were involved
        implicityScreen.clickbuttonContinue();
        node3.log(Status.PASS, "Steps were completly suyccessfully");

        //Save report
        reportsScreen.clickButtonSaveReport();
        reportsScreen.clickButtonSavedReportAceptar();

        //Return give part Saved Previously
        welcomeScreen.clickButtonReports();
        //VERIFY that the saved part is displayed
        CreateExtetReport.stepsVerifications(reportsScreen.verifyListReportsSavedIsShown(), node3, "save report");
        Assert.assertTrue(reportsScreen.verifyListReportsSavedIsShown(), "El parte no se ha guardado correctamente");

        reportsScreen.clickButtonReportSavedPreviously();

        //VERIFY that the part has been updated
        CreateExtetReport.stepsVerifications(reportsScreen.verifyReportOptionInformedIsShown(), node3, "update report");
        Assert.assertTrue(reportsScreen.verifyReportOptionInformedIsShown(), "Los datos del parte no se han actualizado");

        node3.log(Status.INFO, "Click on when and where section");
        Utilities.sleep(2000);
        reportsScreen.clickReportWhenAndWhere();
        Utilities.sleep(2000);
        reportsScreen.clickButtonContinue();
        reportsScreen.insertLocationWhereTextOnlyAndroidEmulator();
        Utilities.sleep(2000);
        reportsScreen.clickContinueButtonFromImplicityScreen();

        //Details of involved
        implicityScreen.clickDeleteFrontImage();
        implicityScreen.clickDeletePostImage();
        implicityScreen.clickNoFriendlyReportDropDownMenu();
        implicityScreen.clickbuttonContinue();

        //Details of the opposite
        implicityScreen.clickbuttonContinue();

        //Others were involved
        implicityScreen.clickbuttonContinue();
        node3.log(Status.PASS, "Steps were completly suyccessfully");

        //Save report
        reportsScreen.clickButtonSaveReport();
        reportsScreen.clickButtonSavedReportAceptar();

        //Return give part Saved Previously
        welcomeScreen.clickButtonReports();
        //VERIFY that the saved part is displayed
        CreateExtetReport.stepsVerifications(reportsScreen.verifyListReportsSavedIsShown(), node3, "save report");
        Assert.assertTrue(reportsScreen.verifyListReportsSavedIsShown(), "El parte no se ha guardado correctamente");

        reportsScreen.clickButtonReportSavedPreviously();

        //VERIFY that the part has been updated
        CreateExtetReport.stepsVerifications(reportsScreen.verifyReportOptionInformedIsShown(), node3, "update report");
        Assert.assertTrue(reportsScreen.verifyReportOptionInformedIsShown(), "Los datos del parte no se han actualizado");


        node3.log(Status.INFO, "Click on when and where section");
        Utilities.sleep(2000);
        reportsScreen.clickReportWhenAndWhere();
        Utilities.sleep(2000);
        reportsScreen.clickButtonContinue();
        reportsScreen.insertLocationWhereTextOnlyAndroidEmulator();
        Utilities.sleep(2000);
        reportsScreen.clickContinueButtonFromImplicityScreen();

        //Details of involved
        implicityScreen.clickYesFriendlyReportDropDownMenu();

        implicityScreen.clickAddFrontImage();
        reportsScreen.clickCarReportOptionsAddImages();
        reportsScreen.clickAllowDeviceAccessImagesPopup();
        Utilities.sleep(3000);
        reportsScreen.clickSelectFirstImage();
        //reportsScreen.clickAcceptAddImages();

        implicityScreen.clickAddPostImage();
        reportsScreen.clickCarReportOptionsAddImages();
        reportsScreen.clickAllowDeviceAccessImagesPopup();
        reportsScreen.clickSelectSecondImage();
        //reportsScreen.clickAcceptAddImages();

        implicityScreen.clickbuttonContinue();

        //Details of the opposite
        implicityScreen.clickbuttonContinue();

        //Others were involved
        implicityScreen.clickbuttonContinue();
        node3.log(Status.PASS, "Steps were completly suyccessfully");


    }
}

