package mutuamad.test;

import com.atsistemas.appium.CreateExtetReport;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import mutuamad.Utilities;
import mutuamad.process.CP0;
import mutuamad.process.CP1;
import mutuamad.screen.EditFormOfPayment;
import mutuamad.screen.InsuranceScreen;
import mutuamad.screen.PrincipalScreen;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Test_17_01 extends CreateExtetReport {

    @Test
    public void Editar_Cuenta_Corriente_Preguntas_Mas_Frecuentes() throws Exception {

        //Test user
        String User_Standars= "ModificarCuentaCorriente";

        //Initialize variables
        PrincipalScreen principalScreen = new PrincipalScreen(driverManager);
        InsuranceScreen insuranceScreen = new InsuranceScreen(driverManager);
        EditFormOfPayment editFormOfPayment = new EditFormOfPayment(driverManager);
        CP0 cp0 = new CP0(driverManager);
        CP1 cp1 = new CP1 (driverManager);
        String bankAccount;

        //Initialize report
        test1 = extent.createTest(this.getClass().getSimpleName(), "Editar cuenta corriente desde ' Preguntas mas frecuentes '");
        test1.log(Status.INFO, "Starting test");

        //Cancel notifications and access to Login
        cp0.execute(test1);

        //Login
        cp1.execute(User_Standars, test1);

        //Create Node for Reports
        ExtentTest node2 = test1.createNode("sTpes - Editar Cuenta Corriente");

        //TEST START .- User goes to the my insurance link
        principalScreen.clickMyInsuranceLink();
        //User goes to the see and manage my policy
        insuranceScreen.clickButtonViewInsuranceDetails();
        Utilities.sleep(2000);
        // Click on the frecuently questions
        insuranceScreen.clickButtonFrecuencyManages();
        //Select modify bank account option from the drop down menu
        insuranceScreen.clickOptionFrecuencyModifyBankAccount();

        //Modify bank account with an incorret IBAN
        bankAccount = "1234";
        editFormOfPayment.clickModifyBankAccount(bankAccount);
        //Click on the accept bank account
        editFormOfPayment.clicksaveButtonField();

        //Modify bank account with a corret IBAN
        bankAccount = "ES6621000418401234567891";
        editFormOfPayment.clickModifyBankAccount(bankAccount);
        //Click on the accept bank account
        editFormOfPayment.clicksaveButtonField();
        Utilities.sleep(5000);

        //Verify checking account modification
        CreateExtetReport.stepsVerifications(editFormOfPayment.isEnabledImageEdition(), node2, "The checking account has not been modified");
        Assert.assertTrue(editFormOfPayment.isEnabledImageEdition(), "No se ha podido modificar la cuenta corriente." );

    }
}
