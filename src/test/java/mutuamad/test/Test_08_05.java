package mutuamad.test;

import com.atsistemas.appium.CreateExtetReport;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import mutuamad.process.CP0;
import mutuamad.process.CP1;
import mutuamad.screen.*;
import org.testng.annotations.Test;

public class Test_08_05 extends CreateExtetReport {

    @Test
    public void Ver_Ofertas_Para_Mi() throws Exception {

        //Test user
        String User_Standars= "AutoInsurance";

        //Initialize variables
        CP0 cp0 = new CP0(driverManager);
        CP1 cp1 = new CP1 (driverManager);
        PrincipalScreen principalScreen = new PrincipalScreen(driverManager);
        AdvantageScreen advantageScreen = new AdvantageScreen(driverManager);
        CustomerSupportScreen customerSupportScreen = new CustomerSupportScreen(driverManager);

        //Initialize report
        test1 = extent.createTest(this.getClass().getSimpleName(), "Ver ofertas para mi (Filtros)");
        test1.log(Status.INFO, "Starting test");

        //Cancel notifications and access to Login
        cp0.execute(test1);

        //Login
        cp1.execute(User_Standars, test1);

        //Create Node for Reports
        ExtentTest node2 = test1.createNode("Detalles ofertas para mi");

        //TEST START .-
        String keyWordFilter = "masco";
        //User goes to the advantage screen
        principalScreen.clickDealsForMe();
        advantageScreen.clickAllowDeviceLocationPopup();
        //User set 'vips' on the search fields
        advantageScreen.searchAdvantage(keyWordFilter);
        //User clicks on the first result shown
        //advantageScreen.clickFirstResult();
        customerSupportScreen.clickButtonPopupAlertAllow();
        //User clicks on the More Info button from the advantage screen
        advantageScreen.clickMoreInfo();
        //User clicks on the back button from the advantage screen
        advantageScreen.clickButtonBack();
        //User set 'Mul' on the search fields
        keyWordFilter = "masco";
        advantageScreen.searchAdvantage(keyWordFilter);
        //User clicks on the first result shown
        //advantageScreen.clickFirstResult();
        customerSupportScreen.clickButtonPopupAlertAllow();
        //User clicks on the More Info button from the advantage screen
        advantageScreen.clickMoreInfo();
        //User clicks on the back button from the advantage screen
        advantageScreen.clickButtonBack();
        //User set 'milkk' on the search fields
        keyWordFilter = "milkk";
        advantageScreen.searchAdvantage(keyWordFilter);
        //User verify
        advantageScreen.verifyErrorMessageIsShown();
        //User set 'Chófer' on the search fields
        keyWordFilter = "Chófer";
        advantageScreen.searchAdvantage(keyWordFilter);

    }
}
