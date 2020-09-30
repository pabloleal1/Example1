package mutuamad.test;

import com.atsistemas.appium.CreateExtetReport;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import mutuamad.Utilities;
import mutuamad.process.CP0;
import mutuamad.process.CP1;
import mutuamad.screen.*;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Test_06_02 extends CreateExtetReport {

    @Test
    public void Editar_Cuenta_Corriente_TusRecibos() throws Exception {

        //Initialize variables
        CP0 cp0 = new CP0(driverManager);
        CP1 cp1 = new CP1 (driverManager);
        PrincipalScreen principalScreen = new PrincipalScreen(driverManager);
        InsuranceScreen insuranceScreen = new InsuranceScreen(driverManager);
        EditFormOfPayment editFormOfPayment = new EditFormOfPayment(driverManager);
        String bankAccount = "1234";
        String bankAccount2 = "ES6621000418401234567891";

        //Initialize report
        test1 = extent.createTest(this.getClass().getSimpleName(), "Editar cuenta corriente desde tus Recibos");
        test1.log(Status.INFO, "Starting test");

        //Test user
        String User_Standars= "ModificarCuentaCorriente";

        //Cancel notifications and access to Login
        cp0.execute(test1);

        //Login
        cp1.execute(User_Standars, test1);

        //Create Node for Reports
        ExtentTest node2 = test1.createNode("Cuentas Corrientes - Detalles");

        //TEST START .-
        //User goes to the my insurance link
        principalScreen.clickMyInsuranceLink();
        Utilities.sleep(8000);
        //User goes to the insurance screen
        insuranceScreen.clickButtonViewPayments();
        Utilities.sleep(8000);
        //user goes to the modify bank account screen and expand the dropdown menu
        editFormOfPayment.clickDropDownMenu();
        test1.log(Status.INFO, "Click on modify bank account button");
        insuranceScreen.clickModifyBankAccount();

        //Modified bank account with uncorret IBAN
        editFormOfPayment.clickModifyBankAccount(bankAccount);
        //Verify the acept button was not enable
        node2.log (Status.INFO, MarkupHelper.createLabel("Modificar cuenta bancaria para IBAN In-correcto", ExtentColor.BLUE));
        CreateExtetReport.stepsVerifications(!editFormOfPayment.verifyButtonIsEnable(), node2, "El boton esta habilitado");
        Assert.assertTrue(!editFormOfPayment.verifyButtonIsEnable(),"El boton esta habilitado");

        //Modified bank account with corret IBAN
        editFormOfPayment.clickModifyBankAccount(bankAccount2);
        //Verify the acept button was enable
        node2.log (Status.INFO, MarkupHelper.createLabel("Modificar cuenta bancaria para IBAN correcto", ExtentColor.BLUE));

        CreateExtetReport.stepsVerifications(editFormOfPayment.verifyButtonIsEnable(), node2, "El boton esta habilitado");
        Assert.assertTrue(editFormOfPayment.verifyButtonIsEnable(),"El boton esta habilitado");
        //Click on the accept bank account
        editFormOfPayment.clicksaveButtonField();

        //Verify checking account modification
        CreateExtetReport.stepsVerifications(editFormOfPayment.isEnabledImageEdition(), node2, "The checking account has not been modified");
        Assert.assertTrue(editFormOfPayment.isEnabledImageEdition(), "No se ha podido modificar la cuenta corriente." );

    }
}
