package mutuamad.test;

import com.atsistemas.appium.CreateExtetReport;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import mutuamad.Utilities;
import mutuamad.process.CP0;
import mutuamad.process.CP1;
import mutuamad.screen.AssistanceScreen;
import mutuamad.screen.CarWorkshopScreen;
import mutuamad.screen.GenericScreen;
import mutuamad.screen.WelcomeScreen;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Test_09_03 extends CreateExtetReport {

    @Test
    public void Buscar_Taller_Coche_Garantia_Mecanica() throws Exception {

        //Test user
        String User_Standars= "AutoInsurance";

        //Initialize variables
        CP0 cp0 = new CP0(driverManager);
        CP1 cp1 = new CP1 (driverManager);
        WelcomeScreen welcomeScreen = new WelcomeScreen(driverManager);
        CarWorkshopScreen carWorkshopScreen = new CarWorkshopScreen(driverManager);
        AssistanceScreen assistanceScreen = new AssistanceScreen(driverManager);
        GenericScreen genericScreen = new GenericScreen(driverManager);

        //Initialize report
        test1 = extent.createTest(this.getClass().getSimpleName(), "Buscar taler coche, garantia mecanica");
        test1.log(Status.INFO, "Starting test");

        //Cancel notifications and access to Login
        cp0.execute(test1);

        //Login
        cp1.execute(User_Standars, test1);

        //Create Node for Reports
        ExtentTest node2 = test1.createNode("Steps - Buscar Taller - Coche, Garantia Mecanica");

        //TEST START .-  Search Car Workshop by Garantie
        welcomeScreen.clickButtonSearchCarchWorkShop();
        //In case the google service pop up is shown, close it
        if(genericScreen.verifyPopUpIsShown()){
            genericScreen.clickUpdateButton();
        }
        Utilities.sleep(5000);

        Assert.assertTrue(!welcomeScreen.verifyGoogleServiceUpdate(),"El dispositivo no dispone de las funcionalidades de Google Services para realizar esta accion" );

        assistanceScreen.clickAllowDeviceLocationPopup();
        Utilities.sleep(5000);
        carWorkshopScreen.clickVehicleType();
        Utilities.sleep(2000);
        carWorkshopScreen.clickOptionCar();
        Utilities.sleep(2000);
        carWorkshopScreen.clickEnableCarFilters();
        Utilities.sleep(2000);
        carWorkshopScreen.clickCarGarantieFilter();
        Utilities.sleep(2000);
        carWorkshopScreen.clickLocationSendAssistanceText();
        Utilities.sleep(5000);
        carWorkshopScreen.sendLocationSendAssistanceAddress();
        Utilities.sleep(5000);
        carWorkshopScreen.selectLocationSendAssistanceAutoSuggest();

        CreateExtetReport.stepsVerifications(!carWorkshopScreen.verifyAlertIsShown(), node2, "mostrar talleres para este usuario y/o version");
        Assert.assertTrue(!carWorkshopScreen.verifyAlertIsShown(),"No se pueden mostrar talleres para este usuario y/o version");

        //Verify at least one auto shop is shown
        CreateExtetReport.stepsVerifications(!carWorkshopScreen.verify_Number_Of_Shops().equals("Sin resultados cercanos a esta dirección"), node2, "No existen talleres para esa direccion");
        Assert.assertTrue(!carWorkshopScreen.verify_Number_Of_Shops().equals("Sin resultados cercanos a esta dirección"),"No existen talleres para esa direccion");

        Utilities.sleep(5000);
        carWorkshopScreen.clickCarWorkshopsListButton();
        Utilities.sleep(5000);
        carWorkshopScreen.clickFirstCarWorkshopFromList();

    }
}

