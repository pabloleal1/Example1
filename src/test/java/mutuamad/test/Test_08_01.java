package mutuamad.test;

import com.atsistemas.appium.CreateExtetReport;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import mutuamad.Utilities;
import mutuamad.process.CP0;
import mutuamad.process.CP1;
import mutuamad.screen.AdvantageScreen;
import mutuamad.screen.PrincipalScreen;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Test_08_01 extends CreateExtetReport {

    @Test
    public void Puntos_Repsol() throws Exception {

        //Test user
        String User_Standars= "AutoInsurance";

        //Initialize variables
        CP0 cp0 = new CP0(driverManager);
        CP1 cp1 = new CP1 (driverManager);
        PrincipalScreen principalScreen = new PrincipalScreen(driverManager);
        AdvantageScreen advantageScreen = new AdvantageScreen(driverManager);

        //Initialize report
        test1 = extent.createTest(this.getClass().getSimpleName(), "Ver los puntos de repsol desde mis ventajas");
        test1.log(Status.INFO, "Starting test");

        //Cancel notifications and access to Login
        cp0.execute(test1);

        //Login
        cp1.execute(User_Standars, test1);

        //Create Node for Reports
        ExtentTest node2 = test1.createNode("Repsol - Detalles");

        //TEST START .- Click fisrt discount
        if(principalScreen.verificShowsMoreThanOne())
        {
            principalScreen.clickRepsolAdvantage();
            // return home
            Utilities.sleep(8000);
            advantageScreen.clickAllowDeviceLocationPopup();
            Utilities.sleep(5000);
            Assert.assertNotEquals("", advantageScreen.getTextTitleAdvantage());
            Utilities.sleep(8000);
            advantageScreen.clickButtonBack();
            // Click second discount
            principalScreen.clickSecondAdvantage();
            advantageScreen.clickAllowDeviceLocationPopup();
            // return home
            Utilities.sleep(8000);
            //Assert.assertNotEquals("No se muestran correctamente los europuntos","", advantageScreen.getTextTitleAdvantage());
            node2.log(Status.PASS, "Todo correcto sobre dicha ventaja");

        }
        else
        {
            node2.log(Status.FAIL, "El usuario no dispone de ventajas");
            Assert.fail("[ERROR] [El usuario no dispone de ventajas]");
        }

    }

}
