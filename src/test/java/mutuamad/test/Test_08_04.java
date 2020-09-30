package mutuamad.test;

import com.atsistemas.appium.CreateExtetReport;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import mutuamad.Utilities;
import mutuamad.process.CP0;
import mutuamad.process.CP1;
import mutuamad.screen.*;
import org.testng.annotations.Test;

public class Test_08_04 extends CreateExtetReport {

    @Test
    public void Ventajas_Existentes() throws Exception {

        //Test user
        String User_Standars= "AutoInsurance";

        //Initialize variables
        CP0 cp0 = new CP0(driverManager);
        CP1 cp1 = new CP1 (driverManager);
        PrincipalScreen principalScreen = new PrincipalScreen(driverManager);
        AdvantageScreen advantageScreen = new AdvantageScreen(driverManager);

        //Initialize report
        test1 = extent.createTest(this.getClass().getSimpleName(), "Checkea que existen y son accesibles las diferentes ventajas");
        test1.log(Status.INFO, "Starting test");

        //Cancel notifications and access to Login
        cp0.execute(test1);

        //Login
        cp1.execute(User_Standars, test1);

        //Create Node for Reports
        ExtentTest node2 = test1.createNode("Listado de Ventajas existentes");

        //TEST START .-
        //User goes to the advantage screen
        principalScreen.clickAdvantageLink();
        advantageScreen.clickAllowDeviceLocationPopup();

        /* DESCOMENTAR CUANDO ESTE SORTEO
        //User goes to the month's draw screen
        advantageScreen.clickMonthsDrawAdvantage();
        //click on back
        advantageScreen.clickButtonBack();
        Utilities.sleep(6000);
        */


        //User goes to the services screen
        advantageScreen.clickservicesAdvantage();
        advantageScreen.clickAllowDeviceLocationPopup();
        //click on back
        advantageScreen.clickButtonBack();

        //User goes to the Other mutua product screen
        advantageScreen.clickOtherMutuaProductsAdvantage();
        advantageScreen.clickAllowDeviceLocationPopup();
        //click on back
        advantageScreen.clickButtonBack();

        //User goes to the Online screen
        advantageScreen.clickOnlineAdvantage();
        advantageScreen.clickAllowDeviceLocationPopup();
        //click on back
        advantageScreen.clickButtonBack();

        //User goes to the Life style screen
        advantageScreen.clickLifeStyleAdvantage();
        advantageScreen.clickAllowDeviceLocationPopup();
        //click on back
        advantageScreen.clickButtonBack();

        //User goes to the travel product screen
        advantageScreen.clickTravelAdvantage();
        advantageScreen.clickAllowDeviceLocationPopup();
        //click on back
        advantageScreen.clickButtonBack();

        //User goes to the Ocio screen
        advantageScreen.clickOcioAdvantage();
        advantageScreen.clickAllowDeviceLocationPopup();
        //click on back
        advantageScreen.clickButtonBack();
    }
}
