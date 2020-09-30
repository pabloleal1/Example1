package mutuamad.test;

import com.atsistemas.appium.CreateExtetReport;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import mutuamad.Utilities;
import mutuamad.process.CP0;
import mutuamad.process.CP1;
import mutuamad.screen.ConfigurationScreen;
import mutuamad.screen.WelcomeScreen;
import org.testng.annotations.Test;

public class Test_13_01 extends CreateExtetReport {

    @Test
    public void Notificaciones_AccesoHuella() throws Exception {

        //Test user
        String User_Standars= "AutoInsurance";

        //Initialize variables
        CP0 cp0 = new CP0(driverManager);
        CP1 cp1 = new CP1 (driverManager);
        WelcomeScreen welcomeScreen = new WelcomeScreen(driverManager);
        ConfigurationScreen configurationScreen = new ConfigurationScreen(driverManager);

        //Initialize report
        test1 = extent.createTest(this.getClass().getSimpleName(), "Ajustes, habilitar notificaciones y acceso con huella");
        test1.log(Status.INFO, "Starting test");

        //Cancel notifications and access to Login
        cp0.execute(test1);

        //Login
        cp1.execute(User_Standars, test1);

        //Create Node for Reports
        ExtentTest node2 = test1.createNode("Options - Notificaciones");

        //TEST START .- Setting
        Utilities.sleep(5000);
        welcomeScreen.clickButtonMenu();
        Utilities.sleep(5000);
        welcomeScreen.clickOptionSettings();
        Utilities.sleep(5000);

        if (configurationScreen.isEnabledFirngerPrint())
        {
            node2.log(Status.INFO, "Finger print checked");
            configurationScreen.clickButtonFingerPrint();
            configurationScreen.clickAllowDeviceLocationPopup();
            Utilities.sleep(5000);
            configurationScreen.clickButtonFingerPrint();
        }

        if (configurationScreen.isEnabledNotifications())
        {
            node2.log(Status.INFO, "Notifications checked");
            configurationScreen.clickButtonNotifications();
            configurationScreen.clickAllowDeviceLocationPopup();
            Utilities.sleep(5000);
            configurationScreen.clickButtonNotifications();
        }

    }
}

