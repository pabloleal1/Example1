package mutuamad.test;

import com.atsistemas.appium.CreateExtetReport;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import mutuamad.Utilities;
import mutuamad.process.CP0;
import mutuamad.process.CP1;
import mutuamad.screen.EditFormOfPayment;
import mutuamad.screen.InsuranceScreen;
import mutuamad.screen.PrincipalScreen;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Test_06_03 extends CreateExtetReport {

    @Test
    public void Pago_con_Tarjeta() throws Exception {

        //Initialize variables
        CP0 cp0 = new CP0(driverManager);
        CP1 cp1 = new CP1 (driverManager);
        PrincipalScreen principalScreen = new PrincipalScreen(driverManager);
        InsuranceScreen insuranceScreen = new InsuranceScreen(driverManager);
        EditFormOfPayment editFormOfPayment = new EditFormOfPayment(driverManager);


        //Initialize report
        test1 = extent.createTest(this.getClass().getSimpleName(), "Editar PAgo con Tarjetas");
        test1.log(Status.INFO, "Starting test");

        //Test user
        String User_Standars= "PagoTarjetas";

        //Cancel notifications and access to Login
        cp0.execute(test1);

        //Login
        cp1.execute(User_Standars, test1);

        //Create Node for Reports
        ExtentTest node2 = test1.createNode("Pago con Tarjetas - Detalles");

        //TEST START .-
        //User goes to the my insurance link
        principalScreen.clickMyInsuranceLink();
        Utilities.sleep(8000);
        //User goes to the insurance screen
        insuranceScreen.clickButtonViewPayments();
        //user goes to the modify bank account screen and expand the dropdown menu
        editFormOfPayment.clickDropDownMenu();

        //Verify edit credit card number is shown
        Utilities.sleep(3000);
        CreateExtetReport.stepsVerifications(editFormOfPayment.verifyEditCreditCard(), node2, "Credit card number option is enable");
        Assert.assertTrue(editFormOfPayment.verifyEditCreditCard(), "No existe la posibilidad de modificar la cuenta corriente" );

        //Click on edit credit card number
        Utilities.sleep(3000);
        editFormOfPayment.clickEditCreditCard();
        //Verify pop-up is shown
        CreateExtetReport.stepsVerifications(editFormOfPayment.verifyPopUpEditCreditCard(), node2, "Pop Up after clicking on modify credit Card is shown");
        Assert.assertTrue(editFormOfPayment.verifyPopUpEditCreditCard(), "NO se muestra el pop-up Tras modificar en pago con tarjeta" );
    }
}
