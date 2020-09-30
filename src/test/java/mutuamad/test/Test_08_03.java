package mutuamad.test;

import com.atsistemas.appium.CreateExtetReport;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import mutuamad.process.CP0;
import mutuamad.process.CP1;
import mutuamad.screen.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_08_03 extends CreateExtetReport {

    @Test
    public void Ventajas_Buscar() throws Exception {

        //Test user
        String User_Standars= "AutoInsurance";

        //Initialize variables
        CP0 cp0 = new CP0(driverManager);
        CP1 cp1 = new CP1 (driverManager);
        CustomerSupportScreen customerSupportScreen = new CustomerSupportScreen(driverManager);
        PrincipalScreen principalScreen = new PrincipalScreen(driverManager);
        AdvantageScreen advantageScreen = new AdvantageScreen(driverManager);

        //Initialize report
        test1 = extent.createTest(this.getClass().getSimpleName(), "Ventajas, Buscar/Filtrar ventajas");
        test1.log(Status.INFO, "Starting test");

        //Cancel notifications and access to Login
        cp0.execute(test1);

        //Login
        cp1.execute(User_Standars, test1);

        //Create Node for Reports
        ExtentTest node2 = test1.createNode("Buscar Ventajas");

        //TEST START .- Set Multas
        String keyWordFilter = "Gestion";
        //User goes to the advantage screen
        principalScreen.clickAdvantageLink();
        advantageScreen.clickAllowDeviceLocationPopup();
        //User set 'Multa' on the search fields
        advantageScreen.searchAdvantage(keyWordFilter);
        //Verifying the advantage required is shown
        node2.log (Status.INFO, MarkupHelper.createLabel("Busqueda primera ventaja", ExtentColor.BLUE));
        CreateExtetReport.stepsVerifications(!advantageScreen.verifyLoSentimosScreenisShown(), node2, "showing the requerid advantage");
        Assert.assertTrue(!advantageScreen.verifyLoSentimosScreenisShown(),"Advantage is not Shown");
        //User clicks on the first result shown
        advantageScreen.clickFirstResult();
        customerSupportScreen.clickButtonPopupAlertAllow();
        //User clicks on the More Info button from the advantage screen
        advantageScreen.clickMoreInfo();
        //User clicks on the back button from the advantage screen
        advantageScreen.clickButtonBack();
        //User set 'Mul' on the search fields
        keyWordFilter = "Mul";
        advantageScreen.searchAdvantage(keyWordFilter);
        //Verifying the advantage required is shown
        node2.log (Status.INFO, MarkupHelper.createLabel("Busqueda segunda ventaja", ExtentColor.BLUE));
        CreateExtetReport.stepsVerifications(!advantageScreen.verifyLoSentimosScreenisShown(), node2, "showing the requerid advantage");
        Assert.assertTrue(!advantageScreen.verifyLoSentimosScreenisShown(),"Advantage is not Shown");
        //User clicks on the first result shown
        advantageScreen.clickFirstResult();
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
