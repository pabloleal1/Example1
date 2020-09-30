package mutuamad.test;

import com.atsistemas.appium.CreateExtetReport;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import mutuamad.Utilities;
import mutuamad.process.CP0;
import mutuamad.process.CP1;
import mutuamad.screen.CarWorkshopScreen;
import mutuamad.screen.GenericScreen;
import mutuamad.screen.WelcomeScreen;
import mutuamad.screen.AssistanceScreen;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Test_09_01 extends CreateExtetReport {

    @Test
    public void Buscar_Taller_Coche_Lunas() throws Exception {

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
        test1 = extent.createTest(this.getClass().getSimpleName(), "Buscar taller para coche, lunas");
        test1.log(Status.INFO, "Starting test");

        //Cancel notifications and access to Login
        cp0.execute(test1);

        //Login
        cp1.execute(User_Standars, test1);

        //Create Node for Reports
        ExtentTest node2 = test1.createNode("Steps - Buscar Taller");

        //TEST START .- Search Car Workshop by Lunas
        welcomeScreen.clickButtonSearchCarchWorkShop();
        //In case the google service pop up is shown, close it
        if(genericScreen.verifyPopUpIsShown()){
            genericScreen.clickUpdateButton();
        }
        Assert.assertTrue(!welcomeScreen.verifyGoogleServiceUpdate(),"El dispositivo no dispone de las funcionalidades de Google Services para realizar esta accion" );

        Utilities.sleep(5000);
        assistanceScreen.clickAllowDeviceLocationPopup();
        Utilities.sleep(5000);
        carWorkshopScreen.clickVehicleType();
        Utilities.sleep(2000);
        carWorkshopScreen.clickOptionCar();
        Utilities.sleep(2000);
        carWorkshopScreen.clickEnableCarFilters();
        Utilities.sleep(2000);
        carWorkshopScreen.clickCarLunasFilter();
        Utilities.sleep(2000);
        carWorkshopScreen.clickLocationSendAssistanceText();
        Utilities.sleep(5000);
        carWorkshopScreen.sendLocationSendAssistanceAddress();
        Utilities.sleep(5000);
        carWorkshopScreen.selectLocationSendAssistanceAutoSuggest();
        Utilities.sleep(5000);

        CreateExtetReport.stepsVerifications(!carWorkshopScreen.verifyAlertIsShown(), node2, "mostrar talleres para este usuario y/o version");
        Assert.assertTrue(!carWorkshopScreen.verifyAlertIsShown(),"No se pueden mostrar talleres para este usuario y/o version");

        carWorkshopScreen.clickCarWorkshopsListButton();
        Utilities.sleep(8000);
        carWorkshopScreen.clickFirstCarWorkshopFromList();

    }
}

