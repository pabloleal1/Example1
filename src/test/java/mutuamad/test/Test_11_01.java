package mutuamad.test;

import com.atsistemas.appium.CreateExtetReport;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import mutuamad.Utilities;
import mutuamad.screen.EcoMutuaScreen;
import mutuamad.process.CP0;
import mutuamad.process.CP1;
import mutuamad.screen.AdvantageScreen;
import mutuamad.screen.PrincipalScreen;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Test_11_01 extends CreateExtetReport {

    @Test
    public void EcoMutua() throws Exception {

        //Test user
        String User_Ecomutua= "Ecomutua";

        //Initialize variables
        CP0 cp0 = new CP0(driverManager);
        CP1 cp1 = new CP1 (driverManager);
        AdvantageScreen advantageScreen = new AdvantageScreen(driverManager);
        PrincipalScreen principalScreen = new PrincipalScreen(driverManager);
        EcoMutuaScreen ecoMutuaScreen = new EcoMutuaScreen(driverManager);

        //Initialize report
        test1 = extent.createTest(this.getClass().getSimpleName(), "Eco Mutua - Usuario con solo una matricula, + matricula ECO");
        test1.log(Status.INFO, "Starting test");

        //Cancel notifications and access to Login
        cp0.execute(test1);

        //Login
        cp1.execute(User_Ecomutua, test1);

        //Create Node for Reports
        ExtentTest node2 = test1.createNode("Steps - Ventaja - Ecomtua");

        //TEST START .- Eco Mutua
        String keyWordFilter = "ecomutua";
        String vehiclePlate = "6717GTM";
        //User goes to the advantage screen
        principalScreen.clickAdvantageLink();
        advantageScreen.clickAllowDeviceLocationPopup();

        //User set 'EcoMutua' on the search fields
        advantageScreen.searchAdvantage(keyWordFilter);
        CreateExtetReport.stepsVerifications(!advantageScreen.verifyLoSentimosScreenisShown(), node2, "Shows Eco Mutua advantage");
        Assert.assertTrue(!advantageScreen.verifyLoSentimosScreenisShown(), "EcoMutua Advantage is not Shown");

        advantageScreen.clickActionAdvantage();

        if (ecoMutuaScreen.verifySelectorTitlePresents()) {
            ecoMutuaScreen.clickFirstPolicy();
        }

        //ecoMutuaScreen.insertAnotherPlate(vehiclePlate);
        //ecoMutuaScreen.clickAcpetarBtnPopUP();
        //Utilities.sleep(7000);

        //User selects Eco Mutua
        Utilities.sleep(5000);

        CreateExtetReport.stepsVerifications(advantageScreen.verifyEcoMutuaPlateAdvantageIsShown(), test1, "Shows the correct Eco Mutua advantage");
        Assert.assertTrue(advantageScreen.verifyEcoMutuaPlateAdvantageIsShown(),"Correct EcoMutua advantage is NOT shown ");

        //advantageScreen.selectEcoMutuaPlateAdvantage();
        Utilities.sleep(7000);


        CreateExtetReport.stepsVerifications(ecoMutuaScreen.verifyEcoMutuaLogoPresents(), node2, "Shows logo from the Eco mutua screen");
        Assert.assertTrue(ecoMutuaScreen.verifyEcoMutuaLogoPresents(), "Logo is NOT shown");

        CreateExtetReport.stepsVerifications(ecoMutuaScreen.verifyVehiclePlatePresents(), node2, "Shows plate from the Eco mutua screen");
        Assert.assertTrue(ecoMutuaScreen.verifyVehiclePlatePresents(), "Plate is NOT shown");

        CreateExtetReport.stepsVerifications(ecoMutuaScreen.verifyVehicleTypeLogoPresents(), node2, "Shows type of vehicle from the Eco mutua screen");
        Assert.assertTrue(ecoMutuaScreen.verifyVehicleTypeLogoPresents(), "Type of Vehicle is NOT shown");

        CreateExtetReport.stepsVerifications(ecoMutuaScreen.verifyVehicleLogoPresents(), node2, "Shows logo vehicle from the Eco mutua screen");
        Assert.assertTrue(ecoMutuaScreen.verifyVehicleLogoPresents(), "Logo Vehicle is NOT shown");

        CreateExtetReport.stepsVerifications(ecoMutuaScreen.verifyEcoMutuaInfoPresents(), node2, "Shows info about Eco mutua");
        Assert.assertTrue(ecoMutuaScreen.verifyEcoMutuaInfoPresents(), "Info about Ecomutua is NOT shown");

        if (ecoMutuaScreen.verifySearchAnotherPlateBtn()) {
            ecoMutuaScreen.clickSearchAnotherPlateBtn();
        } else
        {
            ecoMutuaScreen.clickButtonBack();
            ecoMutuaScreen.clickSearchAnotherPlatePolicyListing();
        }

        ecoMutuaScreen.insertAnotherPlate(vehiclePlate);
        ecoMutuaScreen.clickAcpetarBtnPopUP();
        Utilities.sleep(7000);

        node2.log (Status.INFO, MarkupHelper.createLabel("Insertar Otra Matricula", ExtentColor.BLUE));

        CreateExtetReport.stepsVerifications(!ecoMutuaScreen.verifyEcoMutuaLogoPresents(), node2, "Shows logo from the Eco mutua screen");
        Assert.assertTrue(ecoMutuaScreen.verifyEcoMutuaLogoPresents(),"Logo is shown");

        CreateExtetReport.stepsVerifications(ecoMutuaScreen.verifyVehiclePlatePresents(), node2, "Shows plate from the Eco mutua screen");
        Assert.assertTrue(ecoMutuaScreen.verifyVehiclePlatePresents(),"Plate is shown");

        CreateExtetReport.stepsVerifications(!ecoMutuaScreen.verifyVehicleTypeLogoPresents(), node2, "Shows type of vehicle from the Eco mutua screen");
        Assert.assertFalse(ecoMutuaScreen.verifyVehicleTypeLogoPresents(), "Type of Vehicle is shown" );

        CreateExtetReport.stepsVerifications(!ecoMutuaScreen.verifyVehicleLogoPresents(), node2, "Shows logo vehicle from the Eco mutua screen");
        Assert.assertFalse(ecoMutuaScreen.verifyVehicleLogoPresents(),"Logo Vehicle is shown");

        CreateExtetReport.stepsVerifications(ecoMutuaScreen.verifyEcoMutuaInfoPresents(), node2, "Shows info about Eco mutua");
        Assert.assertTrue(ecoMutuaScreen.verifyEcoMutuaInfoPresents(),"Info about Ecomutua is NOT shown");

        CreateExtetReport.stepsVerifications(ecoMutuaScreen.verifyEcoMutuaBannerISShown(), node2, "Shows banner fomr Eco mutua screen");
        Assert.assertTrue(ecoMutuaScreen.verifyEcoMutuaBannerISShown(),"Banner EcoMutua is NOT shown");

    }
}
